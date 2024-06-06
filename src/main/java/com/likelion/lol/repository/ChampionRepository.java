package com.likelion.lol.repository;

import com.likelion.lol.domain.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

  // 1. 메서드 이름 기반 쿼리 (findByName)
  Champion findByName(String name);

  // 2. @Query 애노테이션 기반 쿼리 (question2)
  @Query("select c from Champion c where c.name = :name")
  Champion question2(@Param("name") String name);
}
