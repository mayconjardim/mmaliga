package com.mmaliga;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mmaliga.entities.Fighter;
import com.mmaliga.repositories.FighterRepository;

@SpringBootApplication
public class MmaligaBackendApplication implements CommandLineRunner {

	@Autowired
	private FighterRepository fighterRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MmaligaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	        Fighter f1 = new Fighter(1L, "José", "Silva", "Zé", 28, 0, 0, 0, 8, 6, 7, 9, 5, 8, 7, 7, 6, 7);

	        Fighter f2 = new Fighter(2L, "Maria", "Santos", "Mary", 24, 0, 0, 0, 9, 8, 6, 7, 7, 7, 8, 7, 6, 6);
	
	        Fighter f3 = new Fighter(3L, "Carlos", "Ferreira", "Carlão", 31, 0, 0, 0, 7, 8, 9, 6, 7, 6, 6, 9, 8, 6);

	        Fighter f4 = new Fighter(4L, "Ana", "Rodrigues", "Aninha", 27, 0, 0, 0, 6, 7, 7, 8, 8, 6, 8, 7, 7, 6);
	        
	        fighterRepository.saveAll(Arrays.asList(f1,f2,f3,f4));
	}

}
