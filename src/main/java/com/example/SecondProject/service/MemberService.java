package com.example.SecondProject.service;

import com.example.SecondProject.domain.Member;
import com.example.SecondProject.dto.MemberDto;
import com.example.SecondProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member create(MemberDto memberDto){
        Member save = memberRepository.save(memberDto.toEntity());
        return save;
    }

    public List<Member> lookupMembers(){
        List<Member> members = memberRepository.findAll();
        return members;
    }
}
