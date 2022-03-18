package com.example.SecondProject.dto;

import com.example.SecondProject.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {
    private Long id;
    private String name;
    private int age;

    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .age(this.age)
                .build();
    }
}
