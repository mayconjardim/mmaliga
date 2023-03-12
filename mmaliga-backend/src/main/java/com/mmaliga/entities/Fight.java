package com.mmaliga.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
	private boolean inTheClinch;
	private Integer timeCurrent;
	private Integer guardType;
	private Integer fighterOnTop;
	private boolean elbows = false;
	private boolean stomps = false;
	private boolean soccerKicks = false;

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

		String presentation = String.format(Comments.apresentation[fightType], getRounds(), getWeightClass().getName(),
				fighter1.getWin(), fighter1.getLoss(), fighter1.getDraw(), fighter1.getFirstName(), fighter2.getWin(),
				fighter2.getLoss(), fighter2.getDraw(), fighter2.getFirstName());

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
						fighterActive = getStandUpInitiative(fighter1, fighter2, getActionBonus(fighterAction1),
								getActionBonus(fighterAction2));
					} else {
						fighterActive = getGroundInitiative(fighter1, fighter2, getActionBonus(fighterAction1),
								getActionBonus(fighterAction2));
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
					setPbp("ActPunch");//ActPunch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_KICKS:
					setPbp("ActKick");//ActKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CLINCH:
					setPbp("ACT_CLINCH");//ActClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_TAKEDOWNS:
					setPbp("ACT_TAKEDOWNS");//ActTakedown(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_DIRTYBOXING:
					setPbp("ACT_DIRTYBOXING");//ActPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
							//DIRTY_BOXING);
					break;
				case Moves.ACT_TAKEDOWNCLINCH:
					setPbp("ACT_TAKEDOWNCLINCH");//ActClinchTakedown(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_BREAKCLINCH:
					setPbp("ACT_BREAKCLINCH");//ActBreakClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GNP:
					setPbp("ACT_GNP");//	ActGnP(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_POSITIONING:
					setPbp("ACT_POSITIONING");//	ActPositioning(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SUBMISSION:
					setPbp("ACT_SUBMISSION");//	ActSubmission(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STANDUP:
					setPbp("ACT_STANDUP");//	ActStandUp(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_LNP:
					setPbp("ACT_LNP");//	ActLnP(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYPUNCH:
					setPbp("ACT_FANCYPUNCH");//	ActFancyPunch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYKICK:
					setPbp("ACT_FANCYKICK");//	ActFancyKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_HEADBUTT:
					setPbp("ACT_HEADBUTT");//	ActHeadButt(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_POKE:
					setPbp("ACT_POKE");//	ActPoke(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_REST:
					setPbp("ACT_REST");//	ActRest(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GROINKICK:
					setPbp("ACT_GROINKICK");//	ActGroinKick(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SLAM:
					setPbp("ACT_SLAM");//	ActSlam(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SUPPLEX:
					setPbp("ACT_SUPPLEX");//	ActSupplex(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_SOCCERKICKS:
					setPbp("ACT_SOCCERKICKS");//	ActSoccerKicks(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STOMPS:
					setPbp("ACT_STOMPS");//	ActStomps(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STANDKICK:
					setPbp("ACT_STANDKICK");//ActStandKickToGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_MOVETOGROUND:
					setPbp("ACT_MOVETOGROUND");//	ActMoveToGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_STRIKESFROMGUARD:
					setPbp("ACT_STRIKESFROMGUARD");//ActStrikesFromGuard(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GROUNDKICK:
					setPbp("ACT_GROUNDKICK");//ActGroundKicksToStand(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_RESTCLINCH:
					setPbp("ACT_RESTCLINCH");//ActRestInClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_NOACTION:
					setPbp("ACT_NOACTION");//ActNoAction(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_ALLOWSTAND:
					setPbp("ACT_ALLOWSTAND");//	ActAllowToStand(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_PUNCHEXCHANGE:
					setPbp("ACT_PUNCHEXCHANGE");//	ActPunchesExchange(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_PULLGUARD:
					setPbp("ACT_PULLGUARD");//	ActPullGuard(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_GNPELBOWS:
					setPbp("ACT_GNPELBOWS");//ActGnPElbows(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CAPITALIZESTAND:
					setPbp("ACT_CAPITALIZESTAND");//	ActCapitalizeStanding(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_CAPITALIZEGROUND:
					setPbp("ACT_CAPITALIZEGROUND");//	ActCapitalizeGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_KNEESONGROUND:
					setPbp("ACT_KNEESONGROUND");//ActKneesOnGround(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_FANCYSUB:
					setPbp("ACT_FANCYSUB");//ActFancySubmission(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_THAICLINCH_PUNCHES:
					setPbp("ACT_THAICLINCH_PUNCHES");//ActPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
							//THAI_ATTACK);
					break;
				case Moves.ACT_THAICLINCH_KNEES:
					setPbp("ACT_THAICLINCH_KNEES");//ActKickClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
							//THAI_ATTACK);
					break;
				case Moves.ACT_GRAPPLING_PUNCH:
					setPbp("ACT_GRAPPLING_PUNCH");//ActPunchClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
							//GRAPPLING_ATTACK);
					break;
				case Moves.ACT_GRAPPLING_KNEE:
					setPbp("ACT_GRAPPLING_KNEE");//ActKickClinch(fighterActiveOrPassive(fighterActive), fighterActiveOrPassive(fighterPasive),
							//GRAPPLING_ATTACK);
					break;
				}

			}

		}
	}


	//Movimentos
	
	
	
	
	
	//Fim Movimentos
	
	
	
	
	
	
	
	
	
	
	public boolean checkPunchesExchange(Fighter act, Fighter pas) {
		final int PUNCHES_EXC_PROB = 8;
		boolean result = false;
		if (!act.isOnTheGround() && !pas.isOnTheGround() && !inTheClinch) {
			if (getRandom() < PUNCHES_EXC_PROB) {
				if (getRandom() < Math.round(act.getAggressiveness() - act.getControl() / 2)
						|| getRandom() < Math.round(pas.getAggressiveness() - pas.getControl() / 2)) {
					result = true;
				}
			}
		}
		return result;
	}

	public int getGroundInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {
		double fighter1Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += getBalancedRandom(act.getGroundGame() / 2);
		fighter1Ini += getRandom() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini -= getHurtFactor(act);

		double fighter2Ini = getBalancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += getBalancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += getBalancedRandom(pas.getGroundGame() / 2);
		fighter2Ini += getRandom() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini -= getHurtFactor(pas);

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

	public int getStandUpInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {

		// Get Fighter1 Initiative
		double fighter1Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += getBalancedRandom(act.getAgility() / 2);
		fighter1Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += getRandom() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini += act.getMean() / 8;
		fighter1Ini -= getHurtFactor(act);

		// Get Fighter2 Initiative
		double fighter2Ini = getBalancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
		fighter2Ini += getBalancedRandom(pas.getAgility() / 2);
		fighter2Ini += getBalancedRandom(pas.getCurrentStamina() / 10);
		fighter2Ini += getRandom() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini += pas.getMean() / 8;
		fighter2Ini -= getHurtFactor(pas);

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

	public int getHurtFactor(Fighter act) {
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

	public int getBalancedRandom(double value) {
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
					if (getRandom() < act.getAgility() && getRandom() < act.getSubmission()
							&& getRandom() < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
						result = Moves.ACT_FANCYSUB;
					}
				}

				if (result == Moves.ACT_GNP
						&& act.getLastName().equals(fighterActiveOrPassive(fighterOnTop).getLastName())
						&& (guardType == 2 || guardType == 3 || guardType == 7 || guardType == 8)
						&& act.isUseKneesGround()) {
					if ((getFixedRandomInt(act.getAggressiveness()) + Sim.KNEESFREQUENCY > 20)) {
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
					if (getRandom() < act.getAggressiveness()) {
						result = Moves.ACT_GNPELBOWS;
					}
				}

				if (act.getTempDamageGround() > act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) {
					if (getRandom() < act.getControl()) {
						result = Moves.ACT_STANDUP;
					}
				}

				if (pas.isDazed()) {
					if (getFixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				int actions = Sim.setLimits(act.getActionsInGround() - 1, Sim.MINSROUNDSINTHEGROUND, 0);

				//setPbp("getGroundAction " + result + " " + act.getLastName());

				/* Fim GroundAction */

			} else if (!act.isOnTheGround() && pas.isOnTheGround()) {

				/* StandToGroundAction */

				int goToGroundProb = getFixedRandomInt(act.getStratTakedowns());
				int kickProb = getFixedRandomInt((act.getStratKicking() + act.getStratStandUp() / 2));

				if (goToGroundProb > kickProb) {
					result = Moves.ACT_MOVETOGROUND;
				} else {
					result = Moves.ACT_STANDKICK;
				}

				if (getRandom() > act.getAggressiveness()) {
					result = Moves.ACT_ALLOWSTAND;
				}

				int soccerKickProb = 0;
				if (result == Moves.ACT_STANDKICK && isSoccerKicks() && act.isUseSoccerKicks()
						&& getFixedRandomInt(act.getAggressiveness()) + Sim.SOCCERKICKSFREQUENCY > 20) {
					soccerKickProb = getFixedRandomInt(act.getKicking());
				}

				int stompProb = 0;
				if (result == Moves.ACT_STANDKICK && isStomps() && act.isUseStomps()
						&& getFixedRandomInt(act.getAggressiveness()) + Sim.STOPMSFREQUENCY > 20) {
					stompProb = getFixedRandomInt(act.getKicking());
				}

				if (result == Moves.ACT_STANDKICK) {
					if (soccerKickProb > stompProb) {
						result = Moves.ACT_SOCCERKICKS;
					} else if (stompProb > soccerKickProb) {
						result = Moves.ACT_STOMPS;
					}
				}

				if (pas.isDazed()) {
					if (getFixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZEGROUND;
					}
				}

				//setPbp("getStandToGroundAction " + result + " " + act.getLastName());
				/* Fim StandToGroundAction */

			} else if (act.isOnTheGround() && !pas.isOnTheGround()) {

				/* getGroundToStandAction */

				int standupProb = getFixedRandomInt(act.getStratStandUp());
				int kickProb = getFixedRandomInt((act.getStratKicking()) / 2);

				if (standupProb > kickProb) {
					result = Moves.ACT_STANDUP;
				} else {
					result = Moves.ACT_GROUNDKICK;
				}

				//setPbp("getGroundToStandAction " + result + " " + act.getLastName());
				/* Fim getGroundToStandAction */

			} else if (isInTheClinch()) {

				/* getClinchAction */
				int prob = ThreadLocalRandom.current().nextInt(1, 101);

				int dirtyBoxing = act.getStratDirtyBoxing();
				int thai = dirtyBoxing + act.getStratThaiClinch();
				int avoidProb = thai + act.getStratAvoidClinch();

				if (prob <= dirtyBoxing) {
					result = getDirtyBoxingAction(act);
				} else if (prob <= thai) {
					result = getThaiAction(act);
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
					if (getRandom() < ((act.getAgility() + act.getTakedowns()) / Sim.PULLGUARDCUT)) {
						result = Moves.ACT_PULLGUARD;
					}
				}

				/*
				 * if (Bout.getStatistics()[getFighterNumber(act)].getTempDamageClinch() >
				 * act.getToughness() * Sim.MAXDAMAGEFORCHANGINGGAMEPLAN) { if (getRandom() <
				 * act.getControl()) { result = Moves.ACT_BREAKCLINCH; } }
				 */

				if (ThreadLocalRandom.current().nextInt(1, 101) < Sim.RESTFREQUENCY) {
					if (getRandom() > act.getControl() && getRandom() * 5 > act.getCurrentStamina()) {
						result = Moves.ACT_RESTCLINCH;
					}
				}

				if ((result == Moves.ACT_THAICLINCH_PUNCHES && !act.isThaiClinch())
						|| (result == Moves.ACT_THAICLINCH_KNEES && !act.isThaiClinch())
						|| (result == Moves.ACT_DIRTYBOXING && !act.isDirtyBoxing())) {
					result = Moves.ACT_GRAPPLING_PUNCH;
				}

				//setPbp("getClinchAction " + result + " " + act.getLastName());

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
					if (getFixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
						result = Moves.ACT_CAPITALIZESTAND;
					}
				}

			//	setPbp("getStandUpAction " + result + " " + act.getLastName());
				/* Fim getStandUpAction */

			}
		} else {

			//setPbp("ACT_NOACTION");
			return Moves.ACT_NOACTION;
		}
		return result;
	}

	public Fighter fighterActiveOrPassive(int number) {
		if (number == 0) {
			return fighter1;
		} else {
			return fighter2;
		}
	}

	public int getFighterNumber(Fighter act) {
		int result = -1;
		if (act == fighter1) {
			result = 0;
		} else if (act == fighter2) {
			result = 1;
		}
		return result;
	}

	public int getThaiAction(Fighter act) {
		final double KNEE_PROB = 1.25;
		double kneeProb = (act.getStratKicking() + getRandom()) * KNEE_PROB;
		double punchProb = act.getStratPunching() + getRandom();

		if (kneeProb > punchProb) {
			return Moves.ACT_THAICLINCH_KNEES;
		} else {
			return Moves.ACT_THAICLINCH_PUNCHES;
		}
	}

	public int getActionBonus(int action) {
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

	public int getSubmissionProbByPosition(Fighter act) {
		double FULL_MOUNT = 1.15;
		double CLOSED_GUARD = 0.7;
		double SIDE_MOUNT = 0.9;
		double OPEN_GUARD = 0.75;
		double HALF_GUARD = 0.75;

		double prob = act.getStratSub();
		switch (guardType) {
		case 1:
			prob *= FULL_MOUNT;
			break;
		case 2:
			prob *= SIDE_MOUNT;
			break;
		case 3:
			prob *= HALF_GUARD;
			break;
		case 4:
			prob *= OPEN_GUARD;
			break;
		case 5:
			prob *= CLOSED_GUARD;
			break;
		}
		return (int) Math.round(prob);
	}

	public boolean isSubmissionAvailable(Fighter act) {
		if (act.isTechSubs()) {
			return true;
		} else if (act.isEasySubs() && (getFighterNumber(act) == fighterOnTop)
				&& (guardType == Sim.FULL_MOUNT || guardType == Sim.REAR_MOUNT)) {
			return true;
		} else {
			return false;
		}
	}

	public int getDirtyBoxingAction(Fighter act) {
		final double PUNCH_PROB = 1.25;
		double kneeProb = act.getStratKicking() + getRandom();
		double punchProb = (act.getStratPunching() + getRandom()) * PUNCH_PROB;

		if (kneeProb > punchProb) {
			return Moves.ACT_GRAPPLING_KNEE;
		} else {
			return Moves.ACT_DIRTYBOXING;
		}
	}

	public static int getFixedRandomInt(double value) {
		if (value < 0) {
			return 0;
		}

		int aux = (int) value;
		double doubleValue = value - aux;
		int result = (int) (aux / 2 + (Math.random() * (aux / 2)) + 1 + doubleValue);

		return result;
	}

	public int getRandom() {
		final int BIGRANDOM = 1000;
		final int Randomness = 1000;
		return (int) (Math.random() * (BIGRANDOM + Randomness)) + 1;
	}

}
