package com.mmaliga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public void FightMethod() {
		int result = getStandUpInitiative(fighter1, fighter2);
		
		if (result == 0) {
			setPbp(fighter1.getNickname() + " tomou a iniciativa ");
		} else {
			setPbp(fighter2.getNickname() + " tomou a iniciativa ");
		}
		
	}
	
	
	public int fighterAction(Fighter act, Fighter pas) {
		Random random = new Random();
		int randomNumber = random.nextInt(19);

		if ((randomNumber < act.getAggressiveness() + act.getRush()) || (inTheClinch) || (act.isOnTheGround())
				|| (pas.isOnTheGround())) {
			if (act.isOnTheGround() && pas.isOnTheGround()) {

				return 1; // getGroundAction(act, pas);

			} else if ((!act.isOnTheGround()) && pas.isOnTheGround()) {

				return 2; // getStandToGroundAction(act, pas);

			} else if (act.isOnTheGround() && (!pas.isOnTheGround())) {

				return 3; // getGroundToStandAction(act, pas);

			} else if (inTheClinch) {

				return 4; // getClinchAction(act, pas);

			} else {

				return 5; // getStandUpAction(act, pas);
			}

		} else {

			return 6; // ACT_NOACTION;
		}
	}

	public int getStandUpInitiative(Fighter act, Fighter pas) {

		//Fighter1 Iniciativa
		double fighter1Ini = getBalancedRandom(act.getAggressiveness() + act.getControl() / 4);
		fighter1Ini += getBalancedRandom(act.getAgility() / 2);
		fighter1Ini += getBalancedRandom(act.getCurrentStamina() / 10);
		fighter1Ini += getRandom() * 1.5;
		fighter1Ini += act.getInitiativeBonus();
		fighter1Ini += act.getMean() / 8;
		fighter1Ini -= getHurtFactor(act);

		//Fighter2 Iniciativa
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

	public int getStandUpAction(Fighter Act, Fighter Pas) {
	    int prob = (int)(Math.random() * 100) + 1;

	    int punchProb = Act.getStratPunching();
	    int kickProb = punchProb + Act.getStratKicking();
	    int clinchProb = kickProb + Act.getStratClinching();

	    if (prob <= punchProb) {
	        return 1; //ACT_PUNCHES;
	    } else if (prob <= kickProb) {
	        return 2; //ACT_KICKS;
	    } else if (prob <= clinchProb) {
	        return 3; //ACT_CLINCH;
	    } else {
	        return 4; //ACT_TAKEDOWNS;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

	public int getRandom() {
		final int BIGRANDOM = 1000;
		final int Randomness = 1000;
		return (int) (Math.random() * (BIGRANDOM + Randomness)) + 1;
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

}
