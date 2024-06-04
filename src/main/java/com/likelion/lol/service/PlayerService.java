package com.likelion.lol.service;

import com.likelion.lol.domain.Champion;
import com.likelion.lol.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository playerRepository;

  public List<String> question1(String name) {
    List<Champion> champions = playerRepository.question1(name).getChampions();

    return champions.stream()
                    .map(champion -> champion.getName())
                    .toList();
  }
}
