package com.likelion.lol.repository;

import com.likelion.lol.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {

  // 1. 메서드 이름 기반 쿼리 (findByName)
  Player findByName(String name);

  // 2. @Query 애노테이션 기반 쿼리 (question1)
  @Query("select p from Player p where p.name = :name")
  Player question1(@Param("name") String name);
}
