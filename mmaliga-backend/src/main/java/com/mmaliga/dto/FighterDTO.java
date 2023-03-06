package com.mmaliga.dto;

import java.io.Serializable;

import com.mmaliga.entities.Fighter;

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

	public FighterDTO(Long id, String firstName, String lastName, String nickname, Integer age, Integer win,
			Integer loss, Integer draw, Integer boxing, Integer clinch, Integer bjj, Integer kicking, Integer wrestling,
			Integer strength, Integer agility, Integer conditioning, Integer toughness, Integer koResistance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.age = age;
		this.win = win;
		this.loss = loss;
		this.draw = draw;
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
		boxing = entity.getBoxing();
		clinch = entity.getClinch();
		bjj = entity.getBjj();
		kicking = entity.getKicking();
		wrestling = entity.getWrestling();
		strength = entity.getStrength();
		agility = entity.getAgility();
		conditioning = entity.getConditioning();
		toughness = entity.getToughness();
		koResistance = entity.getKoResistance();
	}

}
