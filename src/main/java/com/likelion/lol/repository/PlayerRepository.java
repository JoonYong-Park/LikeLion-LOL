package com.likelion.lol.repository;

import com.likelion.lol.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {

  // @Query 애노테이션을 사용한 쿼리 정의
  @Query("select p from Player p where p.name = :name")
  Player question1(@Param("name") String name);
}
