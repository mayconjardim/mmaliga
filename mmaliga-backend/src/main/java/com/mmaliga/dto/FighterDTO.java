package com.mmaliga.dto;

import java.io.Serializable;

import com.mmaliga.entities.Fighter;
import com.mmaliga.enums.WeightClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
public class FighterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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
	private Double punching;
	private Double kicking;
	private Double clinchStriking;
	private Double clinchGrappling;
	private Double takedowns;
	private Double gnp;
	private Double submission;
	private Double groundGame;
	private Double dodging;
	private Double subDefense;
	private Double takedownsDef;
	private Double aggressiveness;
	private Double control;
	private Double motivation;
	private Double strength;
	private Double agility;
	private Double conditioning;
	private Double koResistance;
	private Double toughness;

	public FighterDTO(Long id, String firstName, String lastName, String nickname, Integer age, Integer win,
			Integer loss, Integer draw, WeightClass weightClass, Double punching, Double kicking, Double clinchStriking,
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
	}

	public FighterDTO(Fighter entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		nickname = entity.getNickname();
		age = entity.getAge();
		win = entity.getWin();
		loss = entity.getLoss();
		draw = entity.getDraw();
		weightClass = entity.getWeightClass();
		punching = entity.getPunching();
		kicking = entity.getKicking();
		clinchStriking = entity.getClinchStriking();
		clinchGrappling = entity.getClinchGrappling();
		takedowns = entity.getTakedowns();
		gnp = entity.getGnp();
		submission = entity.getSubmission();
		groundGame = entity.getGroundGame();
		dodging = entity.getDodging();
		subDefense = entity.getSubDefense();
		takedownsDef = entity.getTakedowns();
		aggressiveness = entity.getAggressiveness();
		control = entity.getControl();
		motivation = entity.getMotivation();
		strength = entity.getStrength();
		agility = entity.getAgility();
		conditioning = entity.getConditioning();
		koResistance = entity.getKoResistance();
		toughness = entity.getToughness();
	}

}
