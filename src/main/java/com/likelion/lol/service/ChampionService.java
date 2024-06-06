package com.likelion.lol.service;

import com.likelion.lol.domain.Skin;
import com.likelion.lol.repository.ChampionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ChampionService {

  private final ChampionRepository championRepository;

  public List<String> question2(String name) {
    List<Skin> skins = championRepository.question2(name).getSkins();

    return skins.stream()
                .map(skin -> skin.getName())
                .toList();
  }
}
