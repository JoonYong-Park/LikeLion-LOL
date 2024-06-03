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

@Getter
@Entity
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

}
