package com.mmaliga.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mmaliga.enums.WeightClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Fighter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String firstName;
	private String lastName;
	private String nickname;
	private Integer age;
	private Integer win;
	private Integer loss;
	private Integer draw;
	private WeightClass weightClass;

	// Habilidaddes
	// Luta em pé
	private Double punching;
	private Double kicking;
	private Double clinchStriking;
	private Double clinchGrappling;
	private Double takedowns;

	// Luta no Chão
	private Double gnp;
	private Double submission;
	private Double groundGame;

	// Defesa
	private Double dodging;
	private Double subDefense;
	private Double takedownsDef;

	// Mental
	private Double aggressiveness;
	private Double control;
	private Double motivation;

	// Fisicas
	private Double strength;
	private Double agility;
	private Double conditioning;
	private Double koResistance;
	private Double toughness;

	// Strategia

	// General
	private Integer stratPunching;
	private Integer stratKicking;
	private Integer stratClinching;
	private Integer stratTakedowns;

	// Clinch
	private Integer stratDirtyBoxing;
	private Integer stratThaiClinch;
	private Integer stratClinchTakedowns;
	private Integer stratAvoidClinch;

	// Chão
	private Integer stratGNP;
	private Integer stratSub;
	private Integer stratPositioning;
	private Integer stratLNP;
	private Integer stratStandUp;

	// Estilos
	private Integer fancyPunches = 0;
	private Integer fightingStyle;
	private Integer tacticalStyle;
	private Integer fancyKicks = 0;
	private Integer fancySubmissions = 0;
	private Integer dirtyFighting = 0;
	private boolean easySubs;
	private boolean techSubs;
	private boolean useKneesGround = false;
	private boolean useStomps = false;
	private boolean useSoccerKicks = false;
	private boolean pullsGuard;
	
	//Criacao
	private boolean dirtyBoxing;
	private boolean thaiClinch;

	// Atributos do lutadores na luta
	private Double damageMod = 0.0;
	private Double strengthMod = 0.0;
	private Double punchingMod = 0.0;
	private Double controlMod = 0.0;
	private Double agilityMod = 0.0;
	private Double dodgingMod = 0.0;
	private Double kickingMod = 0.0;

	private Double faceInjury = 0.0;
	private Double leftArmInjury = 0.0;
	private Double rightArmInjury = 0.0;
	private Double backInjury = 0.0;
	private Double rightLegInjury = 0.0;
	private Double leftLegInjury = 0.0;
	private Double torsoInjury = 0.0;

	private Double aggPower = 0.0;
	private Double defense = 0.0;
	private Integer careerStatus = 2;
	private Double currentHP = 0.0;
	private Double currentStamina = 0.0;
	private Double accuracy = 0.0;
	private boolean onTheGround = false;
	private boolean dazed = false;
	private boolean useElbows;
	private Integer dirtyMoveMalus = 0;
	private Integer rush = 0;
	private Integer actionsInGround = 0;
	private Integer actionsInClinch = 0;
	private Integer actionsInStandUp = 0;
	private Double tempDamageGround = 0.0;
	private Double tempDamageClinch = 0.0;
	private Integer roundsInTheGround;
	private Double trainingStatus = 0.0;
	private Double koResistanceMod = 0.0;
	private Integer injuryResistance = 0;
	private Integer cutResistance = 0;
	private Integer cuts = 0;
	private Double moral = 0.0;

	public Fighter(Long id, String firstName, String lastName, String nickname, Integer age, Integer win, Integer loss,
			Integer draw, WeightClass weightClass, Double punching, Double kicking, Double clinchStriking,
			Double clinchGrappling, Double takedowns, Double gnp, Double submission, Double groundGame, Double dodging,
			Double subDefense, Double takedownsDef, Double aggressiveness, Double control, Double motivation,
			Double strength, Double agility, Double conditioning, Double koResistance, Double toughness) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.age = age;
		this.win = win;
		this.loss = loss;
		this.draw = draw;
		this.weightClass = weightClass;
		this.punching = punching;
		this.kicking = kicking;
		this.clinchStriking = clinchStriking;
		this.clinchGrappling = clinchGrappling;
		this.takedowns = takedowns;
		this.gnp = gnp;
		this.submission = submission;
		this.groundGame = groundGame;
		this.dodging = dodging;
		this.subDefense = subDefense;
		this.takedownsDef = takedownsDef;
		this.aggressiveness = aggressiveness;
		this.control = control;
		this.motivation = motivation;
		this.strength = strength;
		this.agility = agility;
		this.conditioning = conditioning;
		this.koResistance = koResistance;
		this.toughness = toughness;
		// Strats Geral
		stratPunching = 50;
		stratKicking = 30;
		stratClinching = 20;
		stratTakedowns = 0;
		// Strats Clinch
		stratDirtyBoxing = 25;
		stratThaiClinch = 25;
		stratClinchTakedowns = 25;
		stratAvoidClinch = 25;
		// Strats Chão
		stratGNP = 20;
		stratSub = 20;
		stratPositioning = 20;
		stratLNP = 20;
		stratStandUp = 20;
	}

	// Metodos de luta

	public String getName() {
		return firstName + " " + lastName;
	}

	public void maxHPandStamina() {
		this.setCurrentHP((toughness * 5 * 100) / 100);
		this.setCurrentStamina((conditioning * 5 * 100) / 100);
	}

	public void recoverHP(double HPRecovered) {
		currentHP += HPRecovered;
		if (currentHP > toughness * 5) {
			currentHP = toughness * 5;
		}
	}

	public double getKORes() {
		return koResistance + koResistanceMod;
	}

	public double getRanking() {
		double statsRanking = punching + kicking + clinchStriking + takedowns + clinchGrappling + aggressiveness
				+ control + motivation + dodging + takedownsDef + subDefense + strength + toughness + agility
				+ koResistance + conditioning + groundGame + submission + gnp;
		return statsRanking;
	}

	public boolean checkDirtyMove() {
		final int MAX_RANDOM = 120;
		int modifiers = 0;

		if (getCurrentHP() < 50) {
			modifiers += 1;
		} else if (getCurrentHP() < 20) {
			modifiers += 2;
		}

		if (getCurrentStamina() < 50) {
			modifiers += 1;
		} else if (getCurrentStamina() < 20) {
			modifiers += 2;
		}

		modifiers += Math.round(getAggressiveness() / 7);

		modifiers *= getDirtyFighting();

		return (Math.random() * MAX_RANDOM <= modifiers);
	}

	public double getAttackBonus() {
		double bonus = accuracy + (agility / 4) + (aggressiveness / 5) - dirtyMoveMalus;
		bonus *= getTrainingStatus() / 100.0;
		return bonus;
	}

	public double getDefenseBonus() {
		final double DAZED_MALUS = 7;
		double bonus = defense + (getAgility() / 4) + (getControl() / 5) - (getAggressiveness() / 6) - dirtyMoveMalus;
		bonus *= getTrainingStatus() / 100.0;
		if (dazed) {
			bonus -= DAZED_MALUS;
		}
		return bonus;
	}

	private void calculateTrainingStatus() {
		int minTraining = 0;
		int increment = 0;
		switch (careerStatus) {
		case 0: // Rookie
			minTraining = 50;
			increment = 5;
			break;
		case 1: // Prospect
			minTraining = 60;
			increment = 5;
			break;
		case 2: // Prime
			minTraining = 65;
			increment = 5;
			break;
		case 3: // Aging
			minTraining = 60;
			increment = 5;
			break;
		case 4: // Washed
			minTraining = 50;
			increment = 5;
			break;
		}
		double result = minTraining;
		for (int i = 0; i <= Math.round(motivation + control / 2); i++) {
			result += Math.random() * increment;
		}
		if (result > 100) {
			result = 100;
		}
		trainingStatus = result;
	}

	public double getTrainingStatus() {
		if (trainingStatus == 0) {
			calculateTrainingStatus();
		}
		return trainingStatus;
	}

	public double getDamageBonus() {
		double result = (getStrength() / 2) + getDamageMod() + Math.round(getAggressiveness() / 8) - getDirtyMoveMalus()
				+ getAggPower();
		result *= getTrainingStatus() / 100;

		if (result < 1) {
			result = 1;
		} else if (result > 100) {
			result = 100;
		}

		return result;
	}

	public double getInitiativeBonus() {
		double result = (getAgility() / 4) + (getAggressiveness() / 6) + getRush();
		result = result * 100 / 100;
		return result;
	}

	public double getMean() {
		double result = (getDefenseMean() + getFitnessMean() + getGroundMean() + getMentalMean() + getStrikingMean())
				/ 5;
		return result;
	}

	public double getGroundMean() {
		double result = (getGroundGame() + getSubmission() + getGnp()) * 100 / 60;
		return result;
	}

	public double getMentalMean() {
		double result = (getAggressiveness() + getControl() + getMotivation()) * 100 / 60;
		return result;
	}

	public double getStrikingMean() {
		double result = (getPunching() + getKicking() + getClinchStriking() + getClinchGrappling() + getTakedowns())
				* 100 / 100;
		return result;
	}

	public double getFitnessMean() {
		double result = getStrength() + getToughness() + getAgility() + getKoResistance() + getConditioning();
		return result;
	}

	public double getDefenseMean() {
		double result = (getDodging() + getTakedownsDef() + getSubDefense()) * 100 / 60;
		return result;
	}
}
