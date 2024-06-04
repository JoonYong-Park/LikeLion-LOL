package com.likelion.lol.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString(exclude = {"champion"}) //순환 참조를 방지, 출력 내용을 간결하게 유지
@NoArgsConstructor
public class Skin {

    @Id
    @Column(name = "skin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String grade;

    private int price;

    @ManyToOne(fetch = LAZY)
    private Champion champion;

    // 챔피언 설정 메서드
    public void setChampion(Champion champion) {
        this.champion = champion;

        if(!champion.getSkins().contains(this)) {
            champion.addSkin(this);
        }
    }
    // 필드 초기화 생성자
    public Skin(String name, String grade, int price) {
        this.name = name;
        this.grade = grade;
        this.price = price;
    }
}
