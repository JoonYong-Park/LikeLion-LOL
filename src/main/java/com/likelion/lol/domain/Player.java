package com.likelion.lol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Player {
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @ManyToMany
    @JoinTable(name = "player_champion",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "champion_id"))
    private List<Champion> champions = new ArrayList<>();

    // 플레이어가 챔피언을 추가하는 메소드
    public void addChampion(Champion champion) {
        this.champions.add(champion);

        if(!champion.getPlayers().contains(this)) {
            champion.addPlayer(this);
        }
    }

    // 플레이어의 이름을 설정하는 생성자
    public Player(String name) {
        this.name = name;
    }
}
