package com.mmaliga.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String fightResult;
	private String fightResultType;
	
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

	public Fight(Long id, String eventName, Integer rounds, String fightResult, String fightResultType,
			Fighter fighter1, Fighter fighter2, List<String> pbp) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.rounds = rounds;
		this.fightResult = fightResult;
		this.fightResultType = fightResultType;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.pbp = pbp;
	}
		
}

