package com.likelion.lol.repository;

import com.likelion.lol.domain.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

}
