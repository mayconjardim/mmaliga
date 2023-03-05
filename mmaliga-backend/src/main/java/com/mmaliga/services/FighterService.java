package com.mmaliga.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmaliga.dto.FighterDTO;
import com.mmaliga.entities.Fighter;
import com.mmaliga.repositories.FighterRepository;

@Service
public class FighterService {
	
	private FighterRepository fighterRepository;

    @Transactional(readOnly = true)
    public List<FighterDTO> findAll(){
        List<Fighter> list = fighterRepository.findAll();
        return list.stream().map(x-> new FighterDTO(x)).collect(Collectors.toList());
    }

}
