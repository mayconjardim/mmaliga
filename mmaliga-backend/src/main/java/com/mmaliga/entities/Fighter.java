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
	// private fightingStyle fightingStyle;

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
		stratPunching = 25;
		stratKicking = 25;
		stratClinching = 25;
		stratTakedowns = 25;
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

}
