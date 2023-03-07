package com.mmaliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmaliga.entities.Fight;

public interface FightRepository extends JpaRepository<Fight, Long> {

}
