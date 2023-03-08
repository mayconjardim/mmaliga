package com.mmaliga.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmaliga.dto.FightDTO;
import com.mmaliga.entities.Fight;
import com.mmaliga.entities.Fighter;
import com.mmaliga.repositories.FightRepository;
import com.mmaliga.repositories.FighterRepository;

@Service
public class FightService {

	@Autowired
	private FightRepository fightRepository;

	@Autowired
	private FighterRepository fighterRepository;

	@Transactional(readOnly = true)
	public List<FightDTO> findAll() {
		List<Fight> list = fightRepository.findAll();
		return list.stream().map(x -> new FightDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public FightDTO findById(Long id) throws Exception {
		Optional<Fight> obj = fightRepository.findById(id);
		Fight entity = obj.orElseThrow(() -> new Exception("Entity not found"));
		return new FightDTO(entity);
	}

	@Transactional
	public FightDTO update(Long id, FightDTO dto) {
		try {
			Fight entity = fightRepository.getReferenceById(id);

			copyDtoToEntity(dto, entity);

			
			System.out.println(dto.getFighter1().getLastName());
		

			entity = fightRepository.save(entity);
			return new FightDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id Not Found " + id);
		}

	}

	

	private void copyDtoToEntity(FightDTO dto, Fight entity) {

		Fighter fighetr1 = fighterRepository.getReferenceById(dto.getFighter1().getId());
		Fighter fighetr2 = fighterRepository.getReferenceById(dto.getFighter2().getId());

		entity.setEventName(dto.getEventName());
		entity.setFighter1(fighetr1);
		entity.setFighter2(fighetr2);
		entity.setFightResult(dto.getFightResult());
		entity.setFightResultType(dto.getFightResultType());
		entity.setGeneratePBP(dto.getGeneratePBP());
		entity.setHappened(dto.getHappened());
		entity.setRounds(dto.getRounds());
		entity.setTitleBout(dto.getTitleBout());
		entity.setWeightClass(dto.getWeightClass());

		entity.getPbp().add("Vasco");

	}

}
