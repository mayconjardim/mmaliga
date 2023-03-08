package com.mmaliga.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmaliga.entities.Fight;
import com.mmaliga.repositories.FightRepository;

@RestController
@RequestMapping(value = "/fight")
public class FightService {

	@Autowired
	private FightRepository fightRepository;

	@PostMapping
	public ResponseEntity<Fight> saveFight(@RequestBody Fight fight) {
		return new ResponseEntity<Fight>(fightRepository.save(fight), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fight> findById(@PathVariable Long id) {
		Optional<Fight> fight = fightRepository.findById(id);
		if (!fight.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {

			return new ResponseEntity<Fight>(fight.get(), HttpStatus.OK);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fight> updateFight(@PathVariable Long id, @RequestBody Fight fightBody) {
		Optional<Fight> fight = fightRepository.findById(id);
		if (!fight.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			fightBody.setId(fight.get().getId());

			if (fightBody.getHappened()) {
				if (fightBody.getGeneratePBP()) {
					bout(fightBody);
				}
			}
			return new ResponseEntity<Fight>(fightRepository.save(fightBody), HttpStatus.OK);
		}
	}

	private void bout(Fight obj) {
		obj.setGeneratePBP(false);
		obj.prepareFight();
		obj.FightMethod();

	}
}
