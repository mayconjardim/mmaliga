package com.mmaliga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmaliga.entities.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
