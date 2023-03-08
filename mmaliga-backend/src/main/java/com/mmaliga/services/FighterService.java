package com.mmaliga.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmaliga.entities.Fighter;
import com.mmaliga.repositories.FighterRepository;

@RestController
@RequestMapping(value = "/fighters")
public class FighterService {
	
	@Autowired
	private FighterRepository fighterRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Fighter> findById(@PathVariable Long id) {
		Optional<Fighter> fight = fighterRepository.findById(id);
		if (!fight.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			return new ResponseEntity<Fighter>(fight.get(), HttpStatus.OK);
		}
	}
}
