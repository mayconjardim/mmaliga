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

		
		int fighterAction1 = getStandUpInitiative(fighter1, fighter2, 0, 0);
		int fighterAction2 = getStandUpInitiative(fighter2, fighter2, 0, 0);
		;

		int fighterActive, fighterPassive;

		for (int i = 1; i <= rounds; i++) {

			setPbp("------- Round " + i + " -------");

			for (int j = 0; j <= 300; j += 15) {

				if (fighterAction1 > fighterAction2) {
					fighterActive = 0;
					fighterPassive = 1;
				} else {
					fighterActive = 1;
					fighterPassive = 0;
				}

				setPbp("Acao " + fighterActive);

			}

		}

	}

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

	/*
	 * public int getDeltaTime() { int rushSum = fighters[0].getRush() +
	 * fighters[1].getRush(); int timeAdvance = getFixedRandomInt(Sim.TIMEADVANCE);
	 * int result = timeAdvance - rushSum / 2; if (result < 1) { result = 1; }
	 * return result; }
	 */

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

	public int fighterAction(Fighter act, Fighter pas) {
		Random random = new Random();
		int randomNumber = random.nextInt(19);

		if ((randomNumber < act.getAggressiveness() + act.getRush()) || (inTheClinch) || (act.isOnTheGround())
				|| (pas.isOnTheGround())) {
			if (act.isOnTheGround() && pas.isOnTheGround()) {

				return getGroundAction(act, pas);

			} else if ((!act.isOnTheGround()) && pas.isOnTheGround()) {

				return getStandToGroundAction(act, pas);

			} else if (act.isOnTheGround() && (!pas.isOnTheGround())) {

				return getGroundToStandAction(act, pas);

			} else if (inTheClinch) {

				return getClinchAction(act, pas);

			} else {

				return getStandUpAction(act, pas);
			}

		} else {

			return Moves.ACT_NOACTION;
		}
	}

	public int getStandUpInitiative(Fighter act, Fighter pas, Integer bonus1, Integer bonus2) {

		// Fighter1 Iniciativa
		double fighter1Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += getBalancedRandom(act.getAgility() / 2);
		fighter1Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += getRandom() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini += act.getMean() / 8;
		fighter1Ini -= getHurtFactor(act);

		// Fighter2 Iniciativa
		double fighter2Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter2Ini += getBalancedRandom(act.getAgility() / 2);
		fighter2Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter2Ini += getRandom() * 1.5;
		fighter2Ini += pas.getInitiativeBonus();
		fighter2Ini += pas.getMean() / 8;
		fighter2Ini -= getHurtFactor(pas);

		int result;
		if (fighter1Ini > fighter2Ini) {
			result = 0;
			if (act.getRush() < 6) {
				act.setRush(act.getRush() + 1);
			}
			pas.setRush(0);
		} else {
			result = 1;
			if (pas.getRush() < 6) {
				pas.setRush(pas.getRush() + 1);
			}
			act.setRush(0);
		}

		return result;
	}

	public int getGroundInitiative(Fighter act, Fighter pas, int bonus1, int bonus2) {
		double fighter1Ini, fighter2Ini;

		// Get Fighter 1 initiative
		fighter1Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += getBalancedRandom(act.getGroundGame() / 2);
		fighter1Ini += getRandom() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini -= getHurtFactor(act);

		// Get Fighter 2 initiative
		fighter2Ini = getBalancedRandom(pas.getAggressiveness() + pas.getControl() / 4);
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

	public int getGroundAction(Fighter act, Fighter pas) {
		int prob, gnPProb, subProb, posProb, lnPProb, standProb;
		int result = 0;

		prob = (int) (Math.random() * 100) + 1;

		gnPProb = act.getStratGNP();

		if (isSubmissionAvailable(act)) {
			subProb = gnPProb + getSubmissionProbByPosition(act);
		} else {
			subProb = 0;
		}

		if (act.getLastName().equals(fighters[fighterOnTop].getLastName()) && (guardType == 0 || guardType == 1)) {
			posProb = 0;
		} else {
			posProb = subProb + act.getStratPositioning();
		}

		lnPProb = posProb + act.getStratLNP();

		if (((guardType == 3 || guardType == 4) || (act.getLastName().equals(fighters[fighterOnTop].getLastName())
				&& (guardType == 2 || guardType == 4))) && (act.getRoundsInTheGround() <= 0)) {
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

		if (result == Moves.ACT_GNP && act.getLastName().equals(fighters[fighterOnTop].getLastName())
				&& (guardType == 2 || guardType == 3 || guardType == 7 || guardType == 8) && act.isUseKneesGround()) {
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

		if (!act.getLastName().equals(fighters[fighterOnTop].getLastName()) && result == Moves.ACT_GNP) {
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
		act.setActionsInGround(actions);

		return result;
	}

	public int getStandToGroundAction(Fighter act, Fighter pas) {
		int goToGroundProb = getFixedRandomInt(act.getStratTakedowns());
		int kickProb = getFixedRandomInt((act.getStratKicking() + act.getStratStandUp() / 2));

		int result;
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

		return result;
	}

	public static int getGroundToStandAction(Fighter act, Fighter pas) {
		int standupProb = getFixedRandomInt(act.getStratStandUp());
		int kickProb = getFixedRandomInt((act.getStratKicking()) / 2);

		int result;
		if (standupProb > kickProb) {
			result = Moves.ACT_STANDUP;
		} else {
			result = Moves.ACT_GROUNDKICK;
		}

		return result;
	}

	public int getClinchAction(Fighter act, Fighter pas) {
		int prob = ThreadLocalRandom.current().nextInt(1, 101);

		int dirtyBoxing = act.getStratDirtyBoxing();
		int thai = dirtyBoxing + act.getStratThaiClinch();
		int avoidProb = thai + act.getStratAvoidClinch();

		int result;
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

		return result;
	}

	public int getStandUpAction(Fighter act, Fighter pas) {
		int Prob = (int) (Math.random() * 100) + 1;

		int PunchProb = act.getStratPunching();
		int KickProb = PunchProb + act.getStratKicking();
		int ClinchProb = KickProb + act.getStratClinching();

		int Result;

		if (Prob <= PunchProb) {
			Result = Moves.ACT_PUNCHES;
		} else if (Prob <= KickProb) {
			Result = Moves.ACT_KICKS;
		} else if (Prob <= ClinchProb) {
			Result = Moves.ACT_CLINCH;
		} else {
			Result = Moves.ACT_TAKEDOWNS;
		}

		if (act.checkDirtyMove()) {
			Result = Moves.ACT_POKE;
		}

		if (act.getFancyPunches() > 0 && Result == Moves.ACT_PUNCHES) {
			double rand = Math.random();
			if (rand < act.getAgility() && rand < act.getPunching()
					&& rand < act.getFancyPunches() * Sim.FANCYMOVEPROB) {
				Result = Moves.ACT_FANCYPUNCH;
			}
		} else if (act.getFancyKicks() > 0 && Result == Moves.ACT_KICKS) {
			double rand = Math.random();
			if (rand < act.getAgility() && rand < act.getKicking() && rand < act.getFancyKicks() * Sim.FANCYMOVEPROB) {
				Result = Moves.ACT_FANCYKICK;
			}
		} else if (act.getFancySubmissions() > 0) {
			double rand = Math.random();
			if (rand < act.getAgility() && rand < act.getSubmission()
					&& rand < act.getFancySubmissions() * Sim.FANCYMOVEPROB) {
				Result = Moves.ACT_FANCYSUB;
			}
		} else if (Result == Moves.ACT_TAKEDOWNS) {
			if (act.getStrength() > Sim.SLAMSTRENGTH && Math.random() < Sim.SLAMPROB) {
				Result = Moves.ACT_SLAM;
			} else if (act.getStrength() > Sim.SUPPLEXSTRENGHT && Math.random() < Sim.SUPPLEXPROB) {
				Result = Moves.ACT_SUPPLEX;
			}
		}

		if (Math.random() * 100 < Sim.RESTFREQUENCY) {
			if (Math.random() > act.getControl() && Math.random() * 5 > act.getCurrentStamina()
					&& getTimeCurrent() > 100) {
				Result = Moves.ACT_REST;
			}
		}

		if (pas.isDazed()) {
			if (getFixedRandomInt(act.getAggressiveness()) > Sim.CAPITALIZEPROB) {
				Result = Moves.ACT_CAPITALIZESTAND;
			}
		}

		return Result;
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

	public int getFighterNumber(Fighter act) {
		int result = -1;
		if (act == fighter1) {
			result = 0;
		} else if (act == fighter2) {
			result = 1;
		}
		return result;
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

	// Gerar numeros randomicos

	public int getBalancedRandom(double value) {
		if (value < 0) {
			return 0;
		}

		final int NUM_ROUNDS = 5;
		int sum = 0;
		int roundValue = (int) Math.round(value);

		for (int i = 0; i < NUM_ROUNDS; i++) {
			sum += (int) (Math.random() * roundValue);
		}

		return sum / NUM_ROUNDS;
	}

	public double getFixedRandomDouble(double value) {
		if (value < 0) {
			return 0;
		}
		int aux = (int) value;
		double doubleValue = value - aux;
		return Math.round(aux / 2 + (new Random().nextInt(aux / 2)) + 1 + doubleValue);
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
