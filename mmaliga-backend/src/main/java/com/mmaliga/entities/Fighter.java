package com.mmaliga.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	// private WeightClass weightClass;
	// private fightingStyle fightingStyle;

	// Habilidaddes
	private Integer boxing;
	private Integer clinch;
	private Integer bjj;
	private Integer kicking;
	private Integer wrestling;

	// Fisico
	private Integer strength;
	private Integer agility;
	private Integer conditioning;
	private Integer toughness;
	private Integer koResistance;

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

	public Fighter(Long id, String firstName, String lastName, String nickname, Integer age, Integer boxing,
			Integer clinch, Integer bjj, Integer kicking, Integer wrestling, Integer strength, Integer agility,
			Integer conditioning, Integer toughness, Integer koResistance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.age = age;
		this.boxing = boxing;
		this.clinch = clinch;
		this.bjj = bjj;
		this.kicking = kicking;
		this.wrestling = wrestling;
		this.strength = strength;
		this.agility = agility;
		this.conditioning = conditioning;
		this.toughness = toughness;
		this.koResistance = koResistance;
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
