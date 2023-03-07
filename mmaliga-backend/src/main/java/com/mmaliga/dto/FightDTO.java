package com.mmaliga.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmaliga.entities.Fight;
import com.mmaliga.entities.Fighter;
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
public class FightDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private Integer rounds;
	private WeightClass weightClass;
	private String fightResult;
	private String fightResultType;
	private Boolean titleBout;
	private Fighter fighter1;
	private Fighter fighter2;
	private List<String> pbp = new ArrayList<>();

	public FightDTO(Long id, String eventName, Integer rounds, WeightClass weightClass, String fightResult,
			String fightResultType, Boolean titleBout, Fighter fighter1, Fighter fighter2) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.rounds = rounds;
		this.weightClass = weightClass;
		this.fightResult = fightResult;
		this.fightResultType = fightResultType;
		this.titleBout = titleBout;
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
	}

	public FightDTO(Fight entity) {
		id = entity.getId();
		eventName = entity.getEventName();
		rounds = entity.getRounds();
		weightClass = entity.getWeightClass();
		fightResult = entity.getFightResult();
		fightResultType = entity.getFightResult();
		titleBout = entity.getTitleBout();
		fighter1 = entity.getFighter1();
		fighter2 = entity.getFighter2();
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

}
