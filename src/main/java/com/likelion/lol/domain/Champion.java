package com.likelion.lol.domain;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor // 기본 생성자를 만들어주는 어노테이션
public class Champion {
    @Id
    @Column(name = "champion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String type;

    @OneToMany(mappedBy = "champion", cascade = {PERSIST, REMOVE}) //
    private List<Skin> skins = new ArrayList<>();

    @ManyToMany(mappedBy = "champions")
    private List<Player> players = new ArrayList<>();

    // 스킨을 추가하는 메소드
    public void addSkin(Skin skin) {
        this.skins.add(skin);
    }
    // 플레이어를 추가하는 메소드
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    // 챔피언의 이름과 타입을 설정하는 생성자
    public Champion(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
