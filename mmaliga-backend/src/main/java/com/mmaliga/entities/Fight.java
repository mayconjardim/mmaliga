package com.mmaliga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mmaliga.enums.WeightClass;
import com.mmaliga.utils.Comments;
import com.mmaliga.utils.Moves;
import com.mmaliga.utils.Sim;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Fight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String eventName;
	private Integer rounds;
	private WeightClass weightClass;
	private String fightResult;
	private String fightResultType;
	private Boolean titleBout;
	private Boolean generatePBP;
	private Boolean happened;

	@ManyToOne
	@JoinColumn(name = "fighter1_id")
	private Fighter fighter1;

	@ManyToOne
	@JoinColumn(name = "fighter2_id")
	private Fighter fighter2;

	@ElementCollection
	@CollectionTable(name = "fight_pbp", joinColumns = @JoinColumn(name = "fight_id"))
	@Column(name = "pbp", length = 2048)
	private List<String> pbp = new ArrayList<>();

	/// Atributos de luta
	private boolean boutFinished;
	private boolean inTheClinch;
	private Integer timeCurrent = 0;
	private Integer guardType = 0;
	private Integer fighterOnTop = 0;
	private Integer counterProb = 0;
	private Integer injuryProb = 0;
	private Integer kOSubProb = 0;
	private Integer cutProb = 0;
	private Integer randomnes = 0;
	private Integer kOFreq = 0;
	private Integer finishMode = 0;
	private boolean elbows = false;
	private boolean stomps = false;
	private boolean soccerKicks = false;
	private boolean isCounter;
	private Integer hitLocation = 0;
	private String finishedType;
	private String finishedDescription;
	private Integer fighterWinner;
	private String moveName;
	private String fullComment;
	private String side;
	private String location;
	private String injuryComment;
	private Integer injuryFreq = 0;
	private Integer numHooks = 0;

	public Fight(Long id, String eventName, Integer rounds, WeightClass WeightClass, String fightResult,
			String fightResultType, Boolean titleBout, Fighter fighter1, Fighter fighter2, Boolean generatePBP,
			Boolean happened) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.rounds = rounds;
		this.weightClass = WeightClass;
		this.fightResult = fightResult;
		this.fightResultType = fightResultType;
		this.titleBout = titleBout;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.generatePBP = generatePBP;
		this.happened = happened;
	}

	public void setPbp(String pbp) {
		if (this.pbp == null) {
			this.pbp = new ArrayList<String>();
		}
		this.pbp.add(pbp);
	}

	// Metodos de luta

	public void FightApresentation() {

		int fightType = getTitleBout() ? 1 : 0;

		String presentation = String.format(Comments.apresentation.get(fightType), getRounds(),
				getWeightClass().getName(), fighter1.getWin(), fighter1.getLoss(), fighter1.getDraw(),
				fighter1.getFirstName(), fighter2.getWin(), fighter2.getLoss(), fighter2.getDraw(),
				fighter2.getFirstName());

		setPbp(presentation);
	}

	public void prepareFight() {
		this.fighter1.setOnTheGround(false);
		this.fighter2.setOnTheGround(false);
		this.fighter1.setRush(0);
		this.fighter2.setRush(0);
		this.fighter1.maxHPandStamina();
		this.fighter2.maxHPandStamina();
		setInTheClinch(false);
		FightApresentation();
	}

	/* Execução da luta */

	public void fightController() {

		for (int i = 1; i <= rounds; i++) {

			setPbp("-------- ROUND " + i + " --------");

			for (int j = 0; j <= 300; j += 10) {

				int fighterActive, fighterPasive;
				int fighterAction1, fighterAction2, fighterAction;
				int timeInc;
				boolean tempInTheClinch;
				boolean fighter1OnTheGround, fighter2OnTheGround;
				boolean f1Ground, f2Ground;
				tempInTheClinch = inTheClinch;

				fighter1OnTheGround = fighter1.isOnTheGround();
				fighter2OnTheGround = fighter2.isOnTheGround();

				fighterAction1 = fightAction(fighter1, fighter2);
				fighterAction2 = fightAction(fighter2, fighter1);

				if (fighter1.isDazed() == fighter2.isDazed()) {
					if ((!fighter1.isOnTheGround()) && (!fighter2.isOnTheGround())) {
						fighterActive = standUpInitiative(fighter1, fighter2, actionBonus(fighterAction1),
								actionBonus(fighterAction2));
					} else {
						fighterActive = groundInitiative(fighter1, fighter2, actionBonus(fighterAction1),
								actionBonus(fighterAction2));
					}
				} else {
					fighterActive = fighter1.isDazed() ? 1 : 0;
				}

				if (fighterActive == 1) {
					fighterPasive = 0;
					fighterAction = fighterAction2;
				} else {
					fighterPasive = 1;
					fighterAction = fighterAction1;
				}

				if (checkPunchesExchange(fighterActiveOrPassive(fighterActive),
						fighterActiveOrPassive(fighterPasive))) {
					fighterAction = Moves.ACT_PUNCHEXCHANGE;
				}

				f1Ground = fighterActiveOrPassive(fighterActive).isOnTheGround();
				f2Ground = fighterActiveOrPassive(fighterPasive).isOnTheGround();

				switch (fightAction(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive))) {
				case Moves.ACT_PUNCHES:
					actPunch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_KICKS:
					// actKick(fighterActiveOrPassive(fighterActive),
					// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CLINCH:
					setPbp("ACT_CLINCH");// ActClinch(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_TAKEDOWNS:
					setPbp("ACT_TAKEDOWNS");// ActTakedown(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_DIRTYBOXING:
					setPbp("ACT_DIRTYBOXING");// ActPunchClinch(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive),
					// DIRTY_BOXING);
					break;
				case Moves.ACT_TAKEDOWNCLINCH:
					setPbp("ACT_TAKEDOWNCLINCH");// ActClinchTakedown(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_BREAKCLINCH:
					setPbp("ACT_BREAKCLINCH");// ActBreakClinch(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GNP:
					setPbp("ACT_GNP");// ActGnP(fighterActiveOrPassive(fighterActive),
										// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_POSITIONING:
					setPbp("ACT_POSITIONING");// ActPositioning(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SUBMISSION:
					setPbp("ACT_SUBMISSION");// ActSubmission(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STANDUP:
					setPbp("ACT_STANDUP");// ActStandUp(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_LNP:
					setPbp("ACT_LNP");// ActLnP(fighterActiveOrPassive(fighterActive),
										// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYPUNCH:
					setPbp("ACT_FANCYPUNCH");// ActFancyPunch(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYKICK:
					setPbp("ACT_FANCYKICK");// ActFancyKick(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_HEADBUTT:
					setPbp("ACT_HEADBUTT");// ActHeadButt(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_POKE:
					setPbp("ACT_POKE");// ActPoke(fighterActiveOrPassive(fighterActive),
										// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_REST:
					setPbp("ACT_REST");// ActRest(fighterActiveOrPassive(fighterActive),
										// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GROINKICK:
					setPbp("ACT_GROINKICK");// ActGroinKick(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SLAM:
					setPbp("ACT_SLAM");// ActSlam(fighterActiveOrPassive(fighterActive),
										// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SUPPLEX:
					setPbp("ACT_SUPPLEX");// ActSupplex(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SOCCERKICKS:
					setPbp("ACT_SOCCERKICKS");// ActSoccerKicks(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STOMPS:
					setPbp("ACT_STOMPS");// ActStomps(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STANDKICK:
					setPbp("ACT_STANDKICK");// ActStandKickToGround(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_MOVETOGROUND:
					setPbp("ACT_MOVETOGROUND");// ActMoveToGround(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STRIKESFROMGUARD:
					setPbp("ACT_STRIKESFROMGUARD");// ActStrikesFromGuard(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GROUNDKICK:
					setPbp("ACT_GROUNDKICK");// ActGroundKicksToStand(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_RESTCLINCH:
					setPbp("ACT_RESTCLINCH");// ActRestInClinch(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_NOACTION:
					setPbp("ACT_NOACTION");// ActNoAction(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_ALLOWSTAND:
					setPbp("ACT_ALLOWSTAND");// ActAllowToStand(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_PUNCHEXCHANGE:
					setPbp("ACT_PUNCHEXCHANGE");// ActPunchesExchange(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_PULLGUARD:
					setPbp("ACT_PULLGUARD");// ActPullGuard(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GNPELBOWS:
					setPbp("ACT_GNPELBOWS");// ActGnPElbows(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CAPITALIZESTAND:
					setPbp("ACT_CAPITALIZESTAND");// ActCapitalizeStanding(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CAPITALIZEGROUND:
					setPbp("ACT_CAPITALIZEGROUND");// ActCapitalizeGround(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_KNEESONGROUND:
					setPbp("ACT_KNEESONGROUND");// ActKneesOnGround(fighterActiveOrPassive(fighterActive),
												// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYSUB:
					setPbp("ACT_FANCYSUB");// ActFancySubmission(fighterActiveOrPassive(fighterActive),
											// fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_THAICLINCH_PUNCHES:
					setPbp("ACT_THAICLINCH_PUNCHES");// ActPunchClinch(fighterActiveOrPassive(fighterActive),
														// fighterActiveOrPassive(fighterPasive),
					// THAI_ATTACK);
					break;
				case Moves.ACT_THAICLINCH_KNEES:
					setPbp("ACT_THAICLINCH_KNEES");// ActKickClinch(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive),
					// THAI_ATTACK);
					break;
				case Moves.ACT_GRAPPLING_PUNCH:
					setPbp("ACT_GRAPPLING_PUNCH");// ActPunchClinch(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive),
					// GRAPPLING_ATTACK);
					break;
				case Moves.ACT_GRAPPLING_KNEE:
					setPbp("ACT_GRAPPLING_KNEE");// ActKickClinch(fighterActiveOrPassive(fighterActive),
													// fighterActiveOrPassive(fighterPasive),
					// GRAPPLING_ATTACK);
					break;
				}

				/*
				 * if (boutFinished == false) { RefStandFighters(Fighters[FighterActive],
				 * Fighters[FighterPasive]); ActKeepClinch(Fighters[FighterActive],
				 * Fighters[FighterPasive]); MakeStaggeredComment(Fighters[FighterActive],
				 * Fighters[FighterPasive]); MakeStandUpComment(Fighters[FighterActive],
				 * Fighters[FighterPasive], !f1Ground, !f2Ground); }
				 * 
				 * ProcessStaminaLoss(Fighters[FighterActive], true);
				 * ProcessStaminaLoss(Fighters[FighterPasive], false);
				 * 
				 * // Recueprar de atordoamento RecoverForDazed(Fighters[FighterActive]);
				 * RecoverForDazed(Fighters[FighterPasive]);
				 * 
				 * CheckFightPerformance(Fighters[FighterActive], Fighters[FighterPasive]);
				 * CheckFightPerformance(Fighters[FighterPasive], Fighters[FighterActive]);
				 * CheckPainAndTiredness(Fighters[FighterActive]);
				 * CheckPainAndTiredness(Fighters[FighterPasive]);
				 * CheckMoral(Fighters[FighterActive]); CheckMoral(Fighters[FighterPasive]); if
				 * (BoutFinished == false) { ProcessTowelThrow(Fighters[FighterPasive],
				 * Fighters[FighterActive]); RefRestartCentreRing(Fighters[FighterPasive],
				 * Fighters[FighterActive]); }
				 */

				// Adicionar esquema de pontuação!

			}

		}
	}

	/* Fim execução da luta */

	/* Execução ação de luta */

	public int fightAction(Fighter act, Fighter pas) {

		Random random = new Random();
		int randomNumber = random.nextInt(19);
		int result = 0;

		if ((randomNumber < act.getAggressiveness() + act.getRush()) || act.isOnTheGround() || pas.isOnTheGround()
				|| isInTheClinch()) {
			if (act.isOnTheGround() && pas.isOnTheGround()) {

				/* GroundAction */

				int prob, gnPProb, subProb, posProb, lnPProb, standProb;

				prob = (int) (Math.random() * 100) + 1;

				gnPProb = act.getStratGNP();

				if (isSubmissionAvailable(act)) {
					subProb = gnPProb + getSubmissionProbByPosition(act);
				} else {
					subProb = 0;
				}

				if (act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& (guardType == 0 || guardType == 1)) {
					posProb = 0;
				} else {
					posProb = subProb + act.getStratPositioning();
				}

				lnPProb = posProb + act.getStratLNP();

				if (((guardType == 3 || guardType == 4)
						|| (act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
								&& (guardType == 2 || guardType == 4)))
						&& (act.getRoundsInTheGround() <= 0)) {
					standProb = lnPProb + act.getStratStandUp();
				} else {
					standProb = 0;
					posProb += act.getStratStandUp();
					lnPProb = posProb + act.getStratLNP();
				}

				if (prob <= gnPProb) {
					result = Moves.ACT_GNP;
				} else if (prob <= subProb) {
					result = Moves.ACT_SUBMISSION;
				} else if (prob <= posProb) {
					result = Moves.ACT_POSITIONING;
				} else if (prob <= lnPProb) {
					result = Moves.ACT_LNP;
				} else if ((prob <= standProb) && (standProb > 0)) {
					result = Moves.ACT_STANDUP;
				} else {
					result = Moves.ACT_POSITIONING;

				}

				if (act.getFancySubmissions() > 0 && result == Moves.ACT_SUBMISSION) {
					if (randomGenerator() < act.getAgility() && randomGenerator() < act.getSubmission()
							&& randomGenerator() < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYSUB;
					}
				}

				if (result == Moves.ACT_GNP
						&& act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& (guardType == 2 || guardType == 3 || guardType == 7 || guardType == 8)
						&& act.isUseKneesGround()) {
					if ((fixedRandomInt(act.getAggressiveness()) + Sim.KNEESFREQUENCY > 20)) {
						result = Moves.ACT_KNEESONGROUND;
					}
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_POKE;
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_HEADBUTT;
				}

				if (act.getActionsInGround() > 0 && act.getActionsInGround() < Sim.MINACTIONSFORSWITCHING
						&& result == Moves.ACT_STANDUP) {
					result = Moves.ACT_LNP;
					if (act.getActionsInGround() >= Sim.MINACTIONSFORSWITCHING) {
						act.setActionsInGround(-1);
					}
				}

				act.setActionsInGround(act.getActionsInGround() + 1);

				if (!act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& result == Moves.ACT_GNP) {
					result = Moves.ACT_STRIKESFROMGUARD;
				}

				if (result == Moves.ACT_GNP && act.isUseElbows() && isElbows()) {
					if (randomGenerator() < act.getAggressiveness()) {
						result = Moves.ACT_GNPELBOWS;
					}
				}

				if (act.getTempDamageGround() > act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) {
					if (randomGenerator() < act.getControl()) {
						result = Moves.ACT_STANDUP;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				int actions = Sim.setLimits(act.getActionsInGround() - 1, Sim.MINSROUNDSINTHEGROUND, 0);

				/* Fim GroundAction */

			} else if (!act.isOnTheGround() && pas.isOnTheGround()) {

				/* StandToGroundAction */

				int goToGroundProb = fixedRandomInt(act.getStratTakedowns());
				int kickProb = fixedRandomInt((act.getStratKicking() + act.getStratStandUp() / 2));

				if (goToGroundProb > kickProb) {
					result = Moves.ACT_MOVETOGROUND;
				} else {
					result = Moves.ACT_STANDKICK;
				}

				if (randomGenerator() > act.getAggressiveness()) {
					result = Moves.ACT_ALLOWSTAND;
				}

				int soccerKickProb = 0;
				if (result == Moves.ACT_STANDKICK && isSoccerKicks() && act.isUseSoccerKicks()
						&& fixedRandomInt(act.getAggressiveness()) + Sim.SOCCERKICKSFREQUENCY > 20) {
					soccerKickProb = fixedRandomInt(act.getKicking());
				}

				int stompProb = 0;
				if (result == Moves.ACT_STANDKICK && isStomps() && act.isUseStomps()
						&& fixedRandomInt(act.getAggressiveness()) + Sim.STOPMSFREQUENCY > 20) {
					stompProb = fixedRandomInt(act.getKicking());
				}

				if (result == Moves.ACT_STANDKICK) {
					if (soccerKickProb > stompProb) {
						result = Moves.ACT_SOCCERKICKS;
					} else if (stompProb > soccerKickProb) {
						result = Moves.ACT_STOMPS;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				/* Fim StandToGroundAction */

			} else if (act.isOnTheGround() && !pas.isOnTheGround()) {

				/* getGroundToStandAction */

				int standupProb = fixedRandomInt(act.getStratStandUp());
				int kickProb = fixedRandomInt((act.getStratKicking()) / 2);

				if (standupProb > kickProb) {
					result = Moves.ACT_STANDUP;
				} else {
					result = Moves.ACT_GROUNDKICK;
				}

				/* Fim getGroundToStandAction */

			} else if (isInTheClinch()) {

				/* getClinchAction */
				int prob = ThreadLocalRandom.current().nextInt(1, 101);

				int dirtyBoxing = act.getStratDirtyBoxing();
				int thai = dirtyBoxing + act.getStratThaiClinch();
				int avoidProb = thai + act.getStratAvoidClinch();

				if (prob <= dirtyBoxing) {
					result = dirtyBoxingAction(act);
				} else if (prob <= thai) {
					result = thaiAction(act);
				} else if (prob <= avoidProb) {
					result = Moves.ACT_BREAKCLINCH;
				} else {
					result = Moves.ACT_TAKEDOWNCLINCH;
				}

				if (act.getActionsInClinch() > 0 && act.getActionsInClinch() < Sim.MINACTIONSFORSWITCHING
						&& result == Moves.ACT_BREAKCLINCH) {
					result = Moves.ACT_DIRTYBOXING;
					if (act.getActionsInClinch() >= Sim.MINACTIONSFORSWITCHING) {
						act.setActionsInClinch(-1);
					}
				}

				act.setActionsInClinch(act.getActionsInClinch() + 1);

				if (act.checkDirtyMove()) {
					result = Moves.ACT_GROINKICK;
				}

				if (result == Moves.ACT_TAKEDOWNCLINCH && act.isPullsGuard()) {
					if (randomGenerator() < ((act.getAgility() + act.getTakedowns()) / Sim.PULLGUARDCUT)) {
						result = Moves.ACT_PULLGUARD;
					}
				}

				/*
				 * if (Bout.getStatistics()[getFighterNumber(act)].getTempDamageClinch() >
				 * act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) { if
				 * (randomGenerator() < act.getControl()) { result = Moves.ACT_BREAKCLINCH; } }
				 */

				if (ThreadLocalRandom.current().nextInt(1, 101) < Sim.RESTFREQUENCY) {
					if (randomGenerator() > act.getControl() && randomGenerator() * 5 > act.getCurrentStamina()) {
						result = Moves.ACT_RESTCLINCH;
					}
				}

				if ((result == Moves.ACT_THAICLINCH_PUNCHES && !act.isThaiClinch())
						|| (result == Moves.ACT_THAICLINCH_KNEES && !act.isThaiClinch())
						|| (result == Moves.ACT_DIRTYBOXING && !act.isDirtyBoxing())) {
					result = Moves.ACT_GRAPPLING_PUNCH;
				}

				/* Fim getClinchAction */

			} else {

				/* getStandUpAction */

				Random randomico = new Random();
				int Prob = randomico.nextInt(100) + 1;

				int PunchProb = act.getStratPunching();
				int KickProb = PunchProb + act.getStratKicking();
				int ClinchProb = KickProb + act.getStratClinching();

				if (Prob <= PunchProb) {
					result = Moves.ACT_PUNCHES;

				} else if (Prob <= KickProb) {
					result = Moves.ACT_KICKS;
				} else if (Prob <= ClinchProb) {
					result = Moves.ACT_CLINCH;
				} else {
					result = Moves.ACT_TAKEDOWNS;
					setPbp("valor " + act.getStratTakedowns() + " - prob " + Prob);
				}

				if (act.checkDirtyMove()) {
					result = Moves.ACT_POKE;
				}

				if (act.getFancyPunches() > 0 && result == Moves.ACT_PUNCHES) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getPunching()
							&& rand < act.getFancyPunches() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYPUNCH;
					}
				} else if (act.getFancyKicks() > 0 && result == Moves.ACT_KICKS) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getKicking()
							&& rand < act.getFancyKicks() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYKICK;
					}
				} else if (act.getFancySubmissions() > 0) {
					double rand = Math.random();
					if (rand < act.getAgility() && rand < act.getSubmission()
							&& rand < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYSUB;
					}
				} else if (result == Moves.ACT_TAKEDOWNS) {
					if (act.getStrength() > Sim.SLAMSTRENGTH && Math.random() < Sim.SLAMPROB) {
						result = Moves.ACT_SLAM;
					} else if (act.getStrength() > Sim.SUPPLEXSTRENGHT && Math.random() < Sim.SUPPLEXPROB) {
						result = Moves.ACT_SUPPLEX;
					}
				}

				if (Math.random() * 100 < Sim.RESTFREQUENCY) {
					if (Math.random() > act.getControl() && Math.random() * 5 > act.getCurrentStamina()
							&& getTimeCurrent() > 100) {
						result = Moves.ACT_REST;
					}
				}

				if (pas.isDazed()) {
					if (fixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZESTAND;
					}
				}

				/* Fim getStandUpAction */

			}
		} else {

			return Moves.ACT_NOACTION;
		}
		return result;
	}

	/* Fim Execução da ação de luta */

	/* Realizar ações de luta */

	public void actPunch(Fighter act, Fighter pas) {
		double at, def, damageDone;
		int attackLevel, injuryType;

		attackLevel = attackLevel(act, pas, act.getPunching(), pas.getDodging());

		switch (attackLevel) {
		case 1:
			generateComment(Comments.punch1);
			break;
		case 2:
			generateComment(Comments.punch1);
			break;
		case 3:
			generateComment(Comments.punch1);
			break;
		}

		// Attacking value
		int rndatk = new Random().nextInt(4);
		at = fixedRandomInt(act.getPunching()) + act.getAttackBonus();
		switch (rndatk) {
		case 0:
			at += fixedRandomInt(act.getStrength() / 2);
			break;
		case 1:
			at += fixedRandomInt(act.getAgility() / 2);
			break;
		case 2:
			at += fixedRandomInt(act.getDodging() / 2);
			break;
		case 3:
			at += fixedRandomInt(act.getClinchStriking() / 2);
			break;
		}

		at += smallRandom();
		at = gasTankFactor(act, at);
		at -= hurtFactor(act);

		// Defensive value
		int rnddfs = new Random().nextInt(4);
		def = fixedRandomInt(pas.getDodging()) + pas.getDefenseBonus();
		switch (rnddfs) {
		case 0:
			def += fixedRandomInt(pas.getStrength() / 2);
			break;
		case 1:
			def += fixedRandomInt(pas.getAgility() / 2);
			break;
		case 2:
			def += fixedRandomInt(pas.getPunching() / 2);
			break;
		case 3:
			def += fixedRandomInt(pas.getClinchStriking() / 2);
			break;
		}
		def += smallRandom();
		def = gasTankFactor(pas, def);
		def -= hurtFactor(pas);

		if (def >= at) {
			doComment(act, pas, extractFailureComment(fullComment));

			// Counter attack
			if (!isCounter) {
				isCounter = checkCounterAttack(act, pas, counterProb);
				if (isCounter) {
					doCounterAttack(pas, act);
				} else {
					processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
				}
			} else {
				isCounter = false;
				processAfterMovePosition(act, pas, extractFinalFailurePosition(fullComment));
			}
		} else {
			// Do comments
			switch (attackLevel) {
			case 1:
			case 2:
			case 3:
				doComment(act, pas, extractComment(fullComment));
				break;
			}

			// Damage
			damageDone = (at - def) * act.getDamageBonus() * attackLevel;
			damageFighter(act, pas, damageDone);

			processAfterMovePosition(act, pas, extractFinalSuccessPosition(fullComment));

			// Check KO
			if (checkKO(act, pas, damageDone, kOSubProb)) {
				processKO(act, pas);
			}

			// Check Injury
			injuryType = checkInjury(act, pas, damageDone, injuryProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processInjury(act, pas, injuryType);
			}

			// Check Cut
			injuryType = checkCut(act, pas, damageDone, cutProb);
			if (injuryType != Sim.INJURYORCUTFALSE) {
				processCut(act, pas, injuryType);
			}

			// Statistics
			// Bout.UpdateStatistic(getFighterNumber(act), stPunches, 0,
			// ExtractHitsLanded(FullComment));
		}

	}

	public int dirtyBoxingAction(Fighter act) {
		final double PUNCH_PROB = 1.25;
		double kneeProb = act.getStratKicking() + randomGenerator();
		double punchProb = (act.getStratPunching() + randomGenerator()) * PUNCH_PROB;

		if (kneeProb > punchProb) {
			return Moves.ACT_GRAPPLING_KNEE;
		} else {
			return Moves.ACT_DIRTYBOXING;
		}
	}

	public int thaiAction(Fighter act) {
		final double KNEE_PROB = 1.25;
		double kneeProb = (act.getStratKicking() + randomGenerator()) * KNEE_PROB;
		double punchProb = act.getStratPunching() + randomGenerator();

		if (kneeProb > punchProb) {
			return Moves.ACT_THAICLINCH_KNEES;
		} else {
			return Moves.ACT_THAICLINCH_PUNCHES;
		}
	}

	public void doCounterAttack(Fighter act, Fighter pas) {

		int counter1 = extractCounterMove1(fullComment);
		int counter2 = extractCounterMove2(fullComment);
		int counterProb1 = getCounterMoveProb(act, counter1);
		int counterProb2 = getCounterMoveProb(act, counter2);
		int finalMove = counterProb1 > counterProb2 ? counter1 : counter2;

		doComment(act, pas, returnComment(Comments.counter));

		switch (finalMove) {
		case 1:
			actPunch(act, pas);
			break;
		case 2:
			// actKick(act, pas);
			break;
		case 3:
			if (inTheClinch) {
				int clinchMove = 1;// GetClinchAction(act, pas);
				switch (clinchMove) {
				case Moves.ACT_DIRTYBOXING:
					// ActPunchClinch(act, pas, DIRTY_BOXING);
					break;
				case Moves.ACT_THAICLINCH_KNEES:
					// ActKickClinch(act, pas, THAI_ATTACK);
					break;
				case Moves.ACT_THAICLINCH_PUNCHES:
					// ActPunchClinch(act, pas, THAI_ATTACK);
					break;
				case Moves.ACT_TAKEDOWNCLINCH:
					// ActClinchTakedown(act, pas);
					break;
				case Moves.ACT_BREAKCLINCH:
					// ActBreakClinch(act, pas);
					break;
				default:
					// ActPunchClinch(act, pas, -1);
					break;
				}
			} else {
				// ActClinch(act, pas);
			}
			break;
		case 4:
			// ActTakedown(act, pas);
			break;
		case 5:
			// ActSubmission(act, pas);
			break;
		case 6:
			// ActSubmission(act, pas);
			break;
		case 7:
			// ActSubmission(act, pas);
			break;
		case 8:
			if (fighterOnTop == fighterNumber(act)) {
				// ActGnP(act, pas);
			} else {
				// ActStrikesFromGuard(act, pas);
			}
			break;
		case 9:
			// ActSubmission(act, pas);
			break;
		case 10:
			// ActPositioning(act, pas);
			break;
		case 11:
			// ActStandKickToGround(act, pas);
			break;
		case 12:
			// ActGroundKicksToStand(act, pas);
			break;
		case 13:
			// ActStrikesFromGuard(act, pas);
			break;
		case 14:
			// ActMoveToGround(act, pas);
			break;
		case 15:
			// ActStandUp(act, pas);
			break;
		default:
			break;
		}
	}

	/* Fim realizar ações de luta */

	/* Iniciativas de luta */

	public int standUpInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {

		// Get Fighter1 Initiative
		double fighter1Ini = balancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += balancedRandom(act.getAgility() / 2);
		fighter1Ini += balancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += randomGenerator() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini += act.getMean() / 8;
		fighter1Ini -= hurtFactor(act);

		// Get Fighter2 Initiative
		double fighter2Ini = balancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += balancedRandom(pas.getAgility() / 2);
		fighter2Ini += balancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += randomGenerator() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini += pas.getMean() / 8;
		fighter2Ini -= hurtFactor(pas);

		if (fighter1Ini > fighter2Ini) {
			if (act.getRush() < Sim.MAXRUSH) {
				act.setRush(act.getRush() + 1);
			}
			pas.setRush(0);
			return 0;
		} else {
			if (pas.getRush() < Sim.MAXRUSH) {
				pas.setRush(pas.getRush() + 1);
			}
			act.setRush(0);
			return 1;
		}
	}

	public int groundInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {
		double fighter1Ini = balancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += balancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += balancedRandom(act.getGroundGame() / 2);
		fighter1Ini += randomGenerator() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini -= hurtFactor(act);

		double fighter2Ini = balancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += balancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += balancedRandom(pas.getGroundGame() / 2);
		fighter2Ini += randomGenerator() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini -= hurtFactor(pas);

		if (fighter1Ini > fighter2Ini) {
			if (act.getRush() < Sim.MAXRUSH) {
				act.setRush(act.getRush() + 1);
			}
			pas.setRush(0);
			return 0;
		} else {
			if (pas.getRush() < Sim.MAXRUSH) {
				pas.setRush(pas.getRush() + 1);
			}
			act.setRush(0);
			return 1;
		}

	}

	public void processKO(Fighter act, Fighter pas) {

		if (boutFinished) {
			return;
		}

		// KO
		if (finishMode == Sim.RES_KO) {
			if (hitLocation <= 8) {
				finishedType = Comments.misc.get(Sim.KO);
				finishMode = Sim.RES_KO;
				// This is needed for unusual comments structures, like punches exchange
				if (finishedDescription.equals("")) {
					finishedDescription = extractMoveName(fullComment);
				}
				if (pas.isOnTheGround()) {
					doComment(act, pas, returnComment(Comments.groundKO));
				} else {
					doComment(act, pas, returnComment(Comments.standingKO));
				}
				boutFinished = true;
				fighterWinner = fighterNumber(act);
			} else {
				pas.setDazed(true);
			}
		}
		// TKO
		else {
			boutFinished = true;
			finishedType = Comments.misc.get(Sim.TKO);
			finishMode = Sim.RES_TKO;
			finishedDescription = extractMoveName(fullComment);
			doComment(act, pas, returnComment(Comments.tkoRef));
			boutFinished = true;
			fighterWinner = fighterNumber(act);
		}
	}

	/* Fim iniciativas de luta */

	/* Checar ações de luta */

	public boolean checkPunchesExchange(Fighter act, Fighter pas) {
		final int PUNCHES_EXC_PROB = 8;
		boolean result = false;
		if (!act.isOnTheGround() && !pas.isOnTheGround() && !inTheClinch) {
			if (randomGenerator() < PUNCHES_EXC_PROB) {
				if (randomGenerator() < Math.round(act.getAggressiveness() - act.getControl() / 2)
						|| randomGenerator() < Math.round(pas.getAggressiveness() - pas.getControl() / 2)) {
					result = true;
				}
			}
		}
		return result;
	}

	public boolean isSubmissionAvailable(Fighter act) {
		if (act.isTechSubs()) {
			return true;
		} else if (act.isEasySubs() && (fighterNumber(act) == fighterOnTop)
				&& (guardType == Sim.FULL_MOUNT || guardType == Sim.REAR_MOUNT)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCounterAttack(Fighter act, Fighter pas, double prob) {
		int counter1 = extractCounterMove1(Comments.counter.get(1));
		int counter2 = extractCounterMove2(Comments.counter.get(2));

		if (counter1 == 0 && counter2 == 0) {
			return false;
		}

		double at = fixedRandomInt(act.getControl()) - prob - fixedRandomInt(act.getAggressiveness()) + smallRandom();

		double def = (fixedRandomInt(pas.getAggressiveness()) + fixedRandomInt(pas.getControl() / 2))
				/ Sim.COUNTERATTACKCUT;

		return fixedRandomInt(def) > at;
	}

	public int checkCut(Fighter act, Fighter pas, double damageDone, int cutProb) {
		final int MAX_CUT = 20;
		Random rand = new Random();
		int prob = (int) (Math.round(damageDone / injuryFrequency()) + cutProb + randomGenerator());
		int value = rand.nextInt(MAX_CUT) * (act.getCutResistance() + 2);
		int injuryLimitB = balancedRandom(value + Sim.BIGINJURIES);
		int injuryLimitS = balancedRandom(value + Sim.SMALLINJURIES);

		if (prob >= injuryLimitB) {
			return Sim.BIGINJURYORCUTTRUE;
		} else if (prob >= injuryLimitS) {
			return Sim.SMALLINJURYORCUTTRUE;
		} else {
			return Sim.INJURYORCUTFALSE;
		}
	}

	public boolean checkKO(Fighter act, Fighter pas, double DamageDone, int Prob) {
		final double DAZED_PROB = 1.5;

		boolean result = false;

		DamageDone = upsetSystem(act, pas, DamageDone);

		double At = DamageDone / koFrequency() + Prob;
		double Def = (pas.getKORes() + fixedRandomInt(pas.getCurrentHP() / 5.0)) / Sim.KOFREQUENCY;

		if (At > Def) {
			if (fixedRandomInt(At) > fixedRandomInt(Def)) {
				result = true;
				finishMode = Sim.RES_KO;
				// checkKOTN(DamageDone);
			}
		} else if (At * DAZED_PROB > Def) {
			pas.setKoResistanceMod(pas.getKoResistanceMod() - 1);
			result = false;
			pas.setDazed(true);
		}

		if (!result) {
			result = checkTKO(act, pas, DamageDone, Prob);
			finishMode = Sim.RES_TKO;
		}

		return result;
	}

	public boolean checkTKO(Fighter act, Fighter pas, double damageDone, int prob) {
		boolean result = false;

		if (pas.isDazed() && act.getRush() > Sim.TKORUSHMINIMUN && pas.getCurrentHP() < Sim.TKOMINHITPOINTS) {
			if (balancedRandom(Sim.TKOFREQUENCY) < 7) { // 7 = Referee.TKOAwareness
				result = true;
			}
		}

		return result;
	}

	public int checkInjury(Fighter act, Fighter pas, double damageDone, int injuryProb) {
		final int MAX_INJURY = 20;
		int prob;
		int value;
		int injuryLimitB;
		int injuryLimitS;

		prob = (int) (Math.round(damageDone / injuryFrequency()) + injuryProb + randomGenerator());

		value = new Random().nextInt(MAX_INJURY) * (act.getInjuryResistance() + 2);
		injuryLimitB = balancedRandom(value + Sim.BIGINJURIES);
		injuryLimitS = balancedRandom(value + Sim.SMALLINJURIES);

		if (prob >= injuryLimitB) {
			return Sim.BIGINJURYORCUTTRUE;
		} else if (prob >= injuryLimitS) {
			return Sim.SMALLINJURYORCUTTRUE;
		} else {
			return Sim.INJURYORCUTFALSE;
		}
	}

	public void processInjury(Fighter act, Fighter pas, int injuryType) {
		String injuryComment;
		boolean finishedByInj = false;
		int hitLocation = extractHitLocation(fullComment);

		if (injuryType == Sim.BIGINJURYORCUTTRUE) {
			// Prevents a finished fight to be changed from KO to Injury win
			if (!boutFinished) {
				boutFinished = true;
				finishedType = Comments.misc.get(Sim.INJ);
				finishMode = Sim.RES_INJURY;
				fighterWinner = fighterNumber(act);
				finishedByInj = true;
			}

			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				injuryComment = returnComment(Comments.faceInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				//pas.addInjuryToList(ReplaceTokkens(act, pas, extractInjuryCutName(injuryComment)));
			  	pas.setFaceInjury(pas.getFaceInjury() + 4);
				break;
			case 9:
			case 10:
			case 11:
			case 12:
				injuryComment = returnComment(Comments.bodyInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				//pas.addInjuryToList(ReplaceTokkens(act, pas, extractInjuryCutName(injuryComment)));
				if (hitLocation == 9 || hitLocation == 10) {
					pas.setTorsoInjury(pas.getTorsoInjury() + 4);
				} else {
					 pas.setBackInjury(pas.getBackInjury() + 4);
				}
				break;
			case 13:
			case 14:
				injuryComment = returnComment(Comments.armInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				//pas.addInjuryToList(ReplaceTokkens(act, pas, extractInjuryCutName(injuryComment)));
				if (hitLocation == 13) {
					pas.setLeftArmInjury(pas.getLeftArmInjury() + 4);
				} else {
					pas.setRightArmInjury(pas.getRightArmInjury() + 4);
				}
				break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				injuryComment = returnComment(Comments.legInjuries1);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				//pas.addInjuryToList(ReplaceTokkens(act, pas, extractInjuryCutName(injuryComment)));
				if (hitLocation == 15 || hitLocation == 17 || hitLocation == 19) {
					pas.setLeftLegInjury(pas.getLeftLegInjury() + 4); 
				} else {
					pas.setRightLegInjury(pas.getRightLegInjury() + 4) ;
				}
				break;
			}

			if (finishedByInj) {
				//finishedDescription = ReplaceTokkens(act, pas, extractInjuryCutName(injuryComment));
			}

			else {
				switch (hitLocation) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8: {
					 injuryComment = returnComment(Comments.faceInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setControlMod(pas.getControlMod() - 0.5);
					pas.setMoral(pas.getMoral() - 0.5);
					//pas.addInjuryToList(ReplaceTokens(act, pas, extractInjuryCutName(injuryComment)));
					pas.setFaceInjury(pas.getFaceInjury() + 1);
				}
					break;
				case 9:
				case 10:
				case 11:
				case 12: {
					 injuryComment = returnComment(Comments.bodyInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setAgilityMod(pas.getAgilityMod() - 0.5);
					pas.setStrengthMod(pas.getStrengthMod() - 0.5);
					pas.setDodgingMod(pas.getDodgingMod() - 0.5);
					//pas.addInjuryToList(ReplaceTokens(act, pas, extractInjuryCutName(injuryComment)));
					if (hitLocation == 9 || hitLocation == 10) {
						pas.setTorsoInjury(pas.getTorsoInjury() + 1);
					} else {
						pas.setBackInjury(pas.getBackInjury() + 1);
					}
				}
					break;
				case 13:
				case 14: {
					injuryComment = returnComment(Comments.armInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					
					pas.setPunchingMod(pas.getPunchingMod() - 0.5);
					pas.setStrengthMod(pas.getStrengthMod() - 0.5);
					//pas.addInjuryToList(ReplaceTokens(act, pas, extractInjuryCutName(injuryComment)));
					if (hitLocation == 13) {
						pas.setLeftArmInjury(pas.getLeftArmInjury() + 1);
					} else {
						pas.setRightArmInjury(pas.getRightArmInjury() + 1);
					}
				}
					break;
				case 15:
				case 16:
				case 17:
				case 18:
				case 19:
				case 20: {
				 injuryComment = returnComment(Comments.legInjuries0);
					doComment(act, pas, extractInjuryCutComment(injuryComment));
					pas.setKickingMod(pas.getKicking() - 0.5);
					pas.setAgilityMod(pas.getAgility() - 0.5);
					//pas.addInjuryToList(ReplaceTokens(act, pas, extractInjuryCutName(injuryComment)));
					if (hitLocation == 15 || hitLocation == 17 || hitLocation == 19) {
						pas.setLeftLegInjury(pas.getLeftLegInjury() + 1);
					} else {
						pas.setRightLegInjury(pas.getRightLegInjury() + 1);

					}
				}
					break;
				}
			}

		}

	}

	public void damageFighter(Fighter act, Fighter pas, double damageDone) {

		if (damageDone < 0) {
			damageDone = 1;
		}

		// checkMoreDamageOneHit(act, pas, DamageDone);

		// Increase stats
		// Bout.UpdateDamageDone(getFighterNumber(Act), DamageDone, InTheClinch,
		// Act.OnTheGround);
		// Bout.UpdateDamageReceived(getFighterNumber(Pas), DamageDone, InTheClinch,
		// Pas.OnTheGround);

		damageDone = damageDone;
		pas.setCurrentHP(pas.getCurrentHP() - damageDone / Sim.DAMAGECUT);

		if (pas.getCurrentHP() < 0) {
			pas.setCurrentHP(1.0);
		}

		// Increase points
		// Act.increasePoints(Bout.CurrentRound, DamageDone /
		// ApplicationUtils.DAMAGECUTPOINTS);
	}

	public double upsetSystem(Fighter act, Fighter pas, double value) {
		final int UPSET_POWER = 100;
		if (act.getRanking() < pas.getRanking() && (Math.random() * 1000 <= Sim.UPSET_FREQUENCY + randomnes)) {
			return value * UPSET_POWER;
		} else {
			return value;
		}
	}

	public int koFrequency() {
		return Sim.KOPROBCUT + kOFreq;
	}

	public int injuryFrequency() {
		return Sim.INJURYCUT + injuryFreq;
	}

	public void processCut(Fighter act, Fighter pas, int cutType) {

		boolean finishedByCut = false;

		if (hitLocation < 0 || hitLocation > 8) {
			return;
		}

		// hitLocation = extractHitLocation(fullComment);

		if (cutType == Sim.BIGINJURYORCUTTRUE) {

			// Prevents a finished fight change from KO to Cut
			if (!boutFinished) {
				boutFinished = true;
				finishedType = Comments.misc.get(Sim.INJ);
				finishMode = Sim.RES_INJURY;
				fighterWinner = fighterNumber(act);
				finishedByCut = true;
			}

			// Comment for injury
			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				String injuryComment = returnComment(Comments.faceCut0);
				doComment(act, pas, extractInjuryCutComment(injuryComment));
				// pas.addInjuryToList(replaceTokens(act, pas,
				// extractInjuryCutName(injuryComment)));
				pas.setCuts(pas.getCuts() + 4);
				break;
			default:
				break;
			}

			if (finishedByCut) {
				finishedDescription = injuryComment;
			}
		} else {
			switch (hitLocation) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				String injuryComment = returnComment(Comments.faceCut0);
				doComment(act, pas, injuryComment);
				pas.setControlMod(pas.getControlMod() - 0.5);
				pas.setMoral(pas.getMoral() - 0.5);
				// pas.addInjuryToList(replaceTokens(act, pas,
				// extractInjuryCutName(injuryComment)));
				pas.setCuts(pas.getCuts() + 1);
				break;
			default:
				break;
			}
		}
	}

	/* Fim checar ações de luta */

	/* Processar movimentos */

	public void processAfterMovePosition(Fighter Act, Fighter Pas, int Position) {

		if (Position != 0) {
			guardType = -1;
			inTheClinch = false;
		}

		switch (Position) {
		case 1:
			Act.setOnTheGround(false);
			Pas.setOnTheGround(false);
			numHooks = -1;
			break;
		case 2:
			Act.setOnTheGround(false);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = -1;
			numHooks = -1;
			break;
		case 3:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(false);
			fighterOnTop = fighterNumber(Pas);
			guardType = -1;
			numHooks = -1;
			break;
		case 4:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = 1;
			numHooks = -1;
			break;
		case 5:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = 4;
			numHooks = -1;
			break;
		case 6:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = 5;
			numHooks = -1;
			break;
		case 7:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = 0;
			numHooks += 1;
			setLimits(numHooks, 2, 0);
			break;
		case 8:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 1;
			numHooks = -1;
			break;
		case 9:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 4;
			numHooks = -1;
			break;
		case 10:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 5;
			numHooks = -1;
			break;
		case 11:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 0;
			numHooks = -1;
			break;
		case 12:
			Act.setOnTheGround(false);
			Pas.setOnTheGround(false);
			guardType = -1;
			inTheClinch = true;
			numHooks = -1;
			break;
		case 13:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Act);
			guardType = 2;
			numHooks = -1;
			break;
		case 14:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 2;
			numHooks = -1;
			break;
		case 15:
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
		case 16:

			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			fighterOnTop = fighterNumber(Pas);
			guardType = 3;
			numHooks = -1;
			break;
		case 17:

			Act.setOnTheGround(false);
			guardType = -1;
			numHooks = -1;
			break;
		case 18:

			numHooks--;
			Act.setOnTheGround(true);
			Pas.setOnTheGround(true);
			setLimits(numHooks, 2, 0);
			break;
		}
	}

	/* Fim processar movimentos */

	/* Retorna Lutadores */

	public Fighter fighterActiveOrPassive(int number) {
		if (number == 0) {
			return fighter1;
		} else {
			return fighter2;
		}
	}

	public int fighterNumber(Fighter act) {
		int result = -1;
		if (act == fighter1) {
			result = 0;
		} else if (act == fighter2) {
			result = 1;
		}
		return result;
	}

	/* Fim retorna lutadores */

	/* Gerar probabilidade de ação */

	public double setLimits(double actual, double max, double min) {
		if (actual > max) {
			actual = max;
		} else if (actual < min) {
			actual = min;
		}
		return actual;
	}

	public int getSubmissionProbByPosition(Fighter act) {
		double FULL_MOUNT = 1.15;
		double CLOSED_GUARD = 0.7;
		double SIDE_MOUNT = 0.9;
		double OPEN_GUARD = 0.75;
		double HALF_GUARD = 0.75;

		double prob = act.getStratSub();
		switch (guardType) {
		case 1 -> prob *= FULL_MOUNT;
		case 2 -> prob *= SIDE_MOUNT;
		case 3 -> prob *= HALF_GUARD;
		case 4 -> prob *= OPEN_GUARD;
		case 5 -> prob *= CLOSED_GUARD;
		}
		return (int) Math.round(prob);
	}

	public int getCounterMoveProb(Fighter act, int counterMove) {
		/* Return a prob value for a counter move based on fighter's strats */
		int result = 0;
		switch (counterMove) {
		case 1:
			result = fixedRandomInt(act.getStratPunching());
			break;
		case 2:
			result = fixedRandomInt(act.getStratKicking());
			break;
		case 3:
			result = fixedRandomInt(act.getStratClinching());
			break;
		case 4:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 5:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 6:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 7:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 8:
			result = fixedRandomInt(act.getStratGNP());
			break;
		case 9:
			result = fixedRandomInt(act.getStratSub());
			break;
		case 10:
			result = fixedRandomInt(act.getStratPositioning());
			break;
		case 11:
			result = fixedRandomInt(act.getStratStandUp());
			break;
		case 12:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 13:
			result = fixedRandomInt(act.getStratGNP());
			break;
		case 14:
			result = fixedRandomInt(act.getStratTakedowns());
			break;
		case 15:
			result = fixedRandomInt(act.getStratStandUp());
			break;
		}
		return result;
	}

	/* Fim gerar probabilidade de ação */

	/* Gerar fatores para luta */

	public int hurtFactor(Fighter act) {
		double hurtFactor = act.getCurrentHP() / act.getToughness();
		if (hurtFactor <= 0.1) {
			return 10;
		} else if (hurtFactor <= 0.15) {
			return 5;
		} else if (hurtFactor <= 0.2) {
			return 4;
		} else if (hurtFactor <= 0.25) {
			return 3;
		} else if (hurtFactor <= 0.3) {
			return 2;
		} else if (hurtFactor <= 0.45) {
			return 1;
		} else {
			return 0;
		}
	}

	public int gasTankFactor(Fighter act, double value) {
		// Reduce the fighter's skills if he's tired
		double reducingFactor = act.getCurrentStamina() * Sim.FATIGUECUT / (act.getConditioning() * 5);
		return (int) Math.round(value * reducingFactor);
	}

	/* Fim gerar fatores para luta */

	/* Gera bonus por ação. */

	public int actionBonus(int action) {
		final int PUNCHES_BONUS = 5;
		final int KICK_BONUS = -1;
		final int CLINCH_BONUS = -2;

		int result = 0;
		if (action == Moves.ACT_PUNCHES) {
			result = PUNCHES_BONUS;
		} else if (action == Moves.ACT_KICKS) {
			result = KICK_BONUS;
		} else if (action == Moves.ACT_CLINCH) {
			result = CLINCH_BONUS;
		}
		return result;
	}

	/* Fim gerar bonus por ação. */

	/* Level de ataque */

	public int attackLevel(Fighter act, Fighter pas, double atSkill, double pasSkill) {
		final double DAZED_BONUS = 10.0;
		double at, def;

		// Attacking value
		at = fixedRandomInt(act.getAggressiveness());
		at += fixedRandomInt(act.getControl() / 2.0);
		at += fixedRandomInt(act.getConditioning() / 2.0);
		at += smallRandom() + act.getAttackBonus();
		at += fixedRandomInt(act.getAgility() / 2.0);
		at += fixedRandomInt(atSkill);

		// Defense value
		def = fixedRandomInt(pas.getControl());
		def += fixedRandomInt(pas.getConditioning() / 2.0);
		def -= fixedRandomInt(pas.getAggressiveness() / 2.0);
		def += smallRandom() + pas.getDefenseBonus();
		def += fixedRandomInt(act.getAgility() / 2.0);
		def += fixedRandomInt(pasSkill);

		// Resolving attack level
		if (pas.isDazed()) {
			at += DAZED_BONUS;
		}

		int result;
		if (Math.round(at - def) >= 19.0) {
			result = 3;
		} else if (Math.round(at - def) >= 6.0) {
			result = 2;
		} else {
			result = 1;
		}

		// Skill limits
		if (result == 2 && atSkill < Sim.LEVEL2SKILL) {
			result = 1;
		} else if (result == 3 && atSkill < Sim.LEVEL3SKILL) {
			result = 2;
		}

		// Increase points for technic skills
		// act.increasePoints(Bout.getCurrentRound(), result *
		// ApplicationUtils.ATTACKLEVELPOINTS);

		return result;
	}

	/* Level de ataque */

	/* Gera numeros randomicos */

	/* Fim geração de Bonus */

	/* Gera numeros randomicos */

	public int randomGenerator() {
		final int BIGRANDOM = 1000;
		final int Randomness = 1000;
		return (int) (Math.random() * (BIGRANDOM + Randomness)) + 1;
	}

	public int fixedRandomInt(double value) {
		if (value < 0) {
			return 0;
		}

		int aux = (int) value;
		double doubleValue = value - aux;

		return (int) (aux / 2 + (Math.random() * (aux / 2)) + 1 + doubleValue);
	}

	public int balancedRandom(double value) {
		if (value < 0) {
			return 0;
		}

		final int NUM_ROUNDS = rounds;
		int sum = 0;
		int roundValue = (int) Math.round(value);

		for (int i = 0; i < NUM_ROUNDS; i++) {
			sum += (int) (Math.random() * roundValue);
		}

		return sum / NUM_ROUNDS;
	}

	public int smallRandom() {
		final int SMALL_RANDOM = 10;
		return new Random().nextInt(SMALL_RANDOM) + 1;
	}

	/* Fim gera numeros randomicos */

	/* Geração de comentarios */

	public String extractComment(String comment) {
		String[] splitFullString = comment.split(";");
		String unknownStr = "unknown";
		String result = unknownStr;

		if (splitFullString.length > 1) {
			result = splitFullString[1];
		}

		return result;
	}

	public String extractMoveName(String comment) {
		String[] splitFullString = comment.split(";");
		String unknownStr = "unknown";
		String result = unknownStr;

		if (splitFullString.length > 7) {
			result = splitFullString[7];
		}

		return result;
	}

	public int extractCounterMove1(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 5) {
			result = Integer.parseInt(splitFullString.get(5));
		}
		return result;
	}

	public int extractCounterMove2(String comment) {
		int result = 0;
		List<String> splitFullString = Arrays.asList(comment.split(";"));
		if (splitFullString.size() > 6) {
			result = Integer.parseInt(splitFullString.get(6));
		}
		return result;
	}

	public String extractFailureComment(String comment) {
		// Split the comment using the ';' separator and return the third part
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 2) {
			return splitFullString.get(2);
		} else {
			return Sim.UNKNOWN_STR;
		}
	}

	public int extractFinalFailurePosition(String comment) {
		// Split the comment using the ';' separator and try to extract the 15th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 14) {
			try {
				return Integer.parseInt(splitFullString.get(14));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int extractFinalSuccessPosition(String comment) {
		// Split the comment using the ';' separator and try to extract the 14th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 13) {
			try {
				return Integer.parseInt(splitFullString.get(13));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public String extractInjuryCutComment(String comment) {
		// Split the comment using the ';' separator and return the first part
		List<String> splitFullString = splitString(comment);
		return splitFullString.get(0);
	}

	public String extractInjuryCutName(String comment) {
		// Split the comment using the ';' separator and return the second part
		List<String> splitFullString = splitString(comment);
		return splitFullString.get(1);
	}

	public int extractInjuryProb(String comment) {
		// Split the comment using the ';' separator and try to extract the 12th part as
		// an integer
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 11) {
			try {
				return Integer.parseInt(splitFullString.get(11));
			} catch (NumberFormatException e) {
				// Handle the exception, e.g. log an error message
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static String returnComment(List<String> commentList) {
		String comment = "";
		int listSize = commentList.size();

		// If commentList has more than 0 elements
		if (listSize > 0) {
			// Get a random comment from the list
			while (comment.isEmpty()) {
				comment = commentList.get((int) (Math.random() * listSize));
			}
		}

		return comment;
	}

	public List<String> splitString(String comment) {
		List<String> splitFullComment = new ArrayList<>();

		try {
			// Split the comment using the ';' separator
			String[] parts = comment.split(";");
			// Add each part to the list
			for (String part : parts) {
				splitFullComment.add(part);
			}
		} catch (Exception e) {
			// Handle the exception, e.g. log an error message
			e.printStackTrace();
		}

		return splitFullComment;
	}

	public void generateComment(List<String> CommentList) {
		int listSize = CommentList.size();
		fullComment = "";

		// If CommentList has more than 0 elements
		if (listSize > 0) {
			while (fullComment.equals("")) {
				Random random = new Random();
				fullComment = CommentList.get(random.nextInt(listSize));
			}
		}

		// Extract necessary values
		side = leftRight(fullComment);
		location = locationName(extractHitLocation(fullComment));
	}

	public String locationName(int location) {
		String result = "";
		// Location 0 is Head, so we get a random part of the head
		if (location == 0) {
			location = (int) (Math.random() * 8) + 1;
		}
		switch (location) {
		case 1:
			result = Comments.misc.get(Sim.FOREHEAD);
			break;
		case 2:
			result = Comments.misc.get(Sim.LEFT_EYE);
			break;
		case 3:
			result = Comments.misc.get(Sim.RIGHT_EYE);
			break;
		case 4:
			result = Comments.misc.get(Sim.LEFT_CHEEK);
			break;
		case 5:
			result = Comments.misc.get(Sim.RIGHT_CHEEK);
			break;
		case 6:
			result = Comments.misc.get(Sim.NOSE);
			break;
		case 7:
			result = Comments.misc.get(Sim.MOUTH);
			break;
		case 8:
			result = Comments.misc.get(Sim.CHIN);
			break;
		}
		return result;
	}

	public String leftRight(String comment) {
		String result = "";
		if (!comment.isEmpty()) {
			int loc = extractHitLocation(comment);
			if (Arrays.asList(2, 4, 13, 15, 17, 19).contains(loc)) {
				result = Sim.LEFT;
			} else if (!Arrays.asList(2, 4, 13, 15, 17, 19).contains(loc)) {
				result = Sim.RIGHT;
			}
		}
		return result;
	}

	public int extractHitLocation(String comment) {
		int result = 0;
		List<String> splitFullString = splitString(comment);
		if (splitFullString.size() > 3) {
			result = Integer.parseInt(splitFullString.get(3));
		}
		return result;
	}

	public void doComment(Fighter act, Fighter pas, String comment) {

		String updated1 = comment.replaceAll("%act", act.getName()).replaceAll("%pas", pas.getName());
		String updated2 = updated1.replaceAll("%location", location);

		setPbp(updated2);
	}

	/* Fim geração de comentarios */

}
