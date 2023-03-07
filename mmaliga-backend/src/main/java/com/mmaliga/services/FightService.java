package com.mmaliga.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmaliga.dto.FightDTO;
import com.mmaliga.entities.Fight;
import com.mmaliga.repositories.FightRepository;

@Service
public class FightService {

	@Autowired
	private FightRepository fightRepository;

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

}
