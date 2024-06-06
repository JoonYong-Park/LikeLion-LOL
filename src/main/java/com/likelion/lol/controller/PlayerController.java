package com.likelion.lol.controller;

import com.likelion.lol.service.PlayerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  /**
   * 문제1
   * "Faker" 선수의 챔피언 조회하여 반환하기
   * return List<String>
   */
  @GetMapping("/champions/{name}")
  public List<String> question1(@PathVariable("name") String name) {
    return playerService.question1(name);
  }

}
