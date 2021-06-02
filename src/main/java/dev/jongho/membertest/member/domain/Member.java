package dev.jongho.membertest.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int age;

    public Member(Long id, String name, int age) {
        if (age < 1) {
            throw new RuntimeException("1살 보다 어릴 수 없습니다.");
        }

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Member(String name, int age) {
        if (age < 0) {
            throw new RuntimeException("1살 보다 어릴 수 없습니다.");
        }

        this.name = name;
        this.age = age;
    }
}
