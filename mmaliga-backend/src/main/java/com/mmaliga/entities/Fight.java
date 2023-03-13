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
					 actPunch(fighterActiveOrPassive(fighterActive),
					 fighterActiveOrPassive(fighterPasive));
					break;
				case Moves.ACT_KICKS:
					actKick(fighterActiveOrPassive(fighterActive),
					fighterActiveOrPassive(fighterPasive));
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

			}

		}
	}

	
	

}
