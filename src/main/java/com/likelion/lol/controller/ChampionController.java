package com.likelion.lol.controller;

import com.likelion.lol.service.ChampionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/champion")
@RequiredArgsConstructor
public class ChampionController {

  private final ChampionService championService;

  /**
   * 문제2
   * "요네" 챔피언이 가진 스킨을 조회하여 반환하기
   * return List<String>
   */
  @GetMapping("/skins")
  public List<String> question2(@RequestParam("name") String name) {
    return championService.question2(name);
  }
}
