package com.mmaliga;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mmaliga.entities.Fight;
import com.mmaliga.entities.Fighter;
import com.mmaliga.enums.WeightClass;
import com.mmaliga.repositories.FightRepository;
import com.mmaliga.repositories.FighterRepository;

@SpringBootApplication
public class MmaligaBackendApplication implements CommandLineRunner {

	@Autowired
	private FighterRepository fighterRepository;

	@Autowired
	private FightRepository fightRepository;

	public static void main(String[] args) {
		SpringApplication.run(MmaligaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		


		Fighter f1 = new Fighter(1L, "Georges", "St. Pierre", "Rush", 21, 50, 0, 1, WeightClass.MEDIO, 14.0, 14.0, 16.0, 17.0, 14.0, 
				18.0, 15.0, 15.0, 18.0, 17.0, 15.0, 15.0, 13.0, 14.0, 15.0, 14.0, 18.0, 14.0, 13.0);
		
		Fighter f2 = new Fighter(2L, "Anderson", "Silva", "The Spider", 26, 40, 5, 0, WeightClass.MEDIO, 18.0, 18.0, 18.0, 14.0, 13.0, 18.0, 18.0, 16.0, 13.0,
				12.0, 15.0, 14.0, 14.0, 16.0, 17.0, 16.0, 18.0, 15.0, 17.0);

		fighterRepository.saveAll(Arrays.asList(f1, f2));

		Fight fht1 = new Fight(5L, "MMALIGA #1", 3, WeightClass.MEIO_PESADO, "N/A", "N/A", false, f1, f2, false, false);


		fightRepository.saveAll(Arrays.asList(fht1));

	}

}
