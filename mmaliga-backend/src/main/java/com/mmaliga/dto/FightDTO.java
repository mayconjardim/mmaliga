package com.mmaliga.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.mmaliga.entities.Fighter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class FightDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private Integer rounds;
	private String fightResult;
	private String fightResultType;
	private Fighter fighter1;
	private Fighter fighter2;
	private List<String> pbp = new ArrayList<>();
	
	public FightDTO(Long id, String eventName, Integer rounds, String fightResult, String fightResultType,
			Fighter fighter1, Fighter fighter2) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.rounds = rounds;
		this.fightResult = fightResult;
		this.fightResultType = fightResultType;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
	}
	
	public void setPbp(String pbp) {
		if (this.pbp == null) {
			this.pbp = new ArrayList<String>();
		}
		this.pbp.add(pbp);
	}
}
