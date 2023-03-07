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

		Fighter f1 = new Fighter(1L, "Conor", "McGregor", "The Notorious", 33, 22, 6, 0, WeightClass.LEVE, 9.5, 8.5,
				7.5, 8.0, 7.5, 6.0, 5.5, 7.0, 9.0, 7.5, 8.0, 8.5, 7.0, 9.0, 8.5, 7.5, 8.0, 7.0, 9.0);

		Fighter f2 = new Fighter(2L, "Khabib", "Nurmagomedov", "The Eagle", 33, 29, 0, 0, WeightClass.LEVE, 6.5, 6.0,
				5.5, 9.0, 9.5, 9.0, 8.5, 8.5, 9.5, 9.5, 9.0, 9.0, 8.5, 8.5, 9.5, 9.0, 9.0, 8.0, 8.2);

		Fighter f3 = new Fighter(3L, "Jon", "Jones", "Bones", 34, 26, 1, 0, WeightClass.MEIO_PESADO, 7.5, 8.0, 7.5, 7.0,
				8.5, 7.5, 7.0, 8.0, 9.0, 8.5, 8.5, 8.5, 7.5, 8.0, 8.0, 7.5, 8.0, 7.2, 8.1);

		Fighter f4 = new Fighter(4L, "Israel", "Adesanya", "The Last Stylebender", 32, 21, 1, 0, WeightClass.MEIO_MEDIO,
				8.5, 7.5, 8.0, 7.0, 7.5, 6.0, 6.5, 7.5, 8.5, 7.5, 8.0, 8.0, 7.5, 8.0, 8.0, 7.5, 8.0, 5.8, 8.2);

		fighterRepository.saveAll(Arrays.asList(f1, f2, f3, f4));

		Fight fht1 = new Fight(5L, "MMALIGA #1", 3, WeightClass.MEIO_PESADO, "N/A", "N/A", false, f3, f4);

		Fight fht2 = new Fight(6L, "MMALIGA #1", 3, WeightClass.LEVE, "N/A", "N/A", true, f1, f2);

		fightRepository.saveAll(Arrays.asList(fht1, fht2));

	}

}
