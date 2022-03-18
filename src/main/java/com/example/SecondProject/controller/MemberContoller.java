package com.example.SecondProject.controller;

import com.example.SecondProject.domain.Member;
import com.example.SecondProject.dto.MemberDto;
import com.example.SecondProject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class MemberContoller {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/join")
    public String memberForm(){
        return "loginForm";
    }

    @PostMapping("/member/join")
    public String memberJoin(@ModelAttribute(name = "member") MemberDto memberDto){
      log.info("Dto :name = {} , age = {}",memberDto.getName(),memberDto.getAge());
        Member member1 = memberService.create(memberDto);
        log.info("Entity :name = {} , age = {}, id = {}",member1.getName(),member1.getAge(),member1.getId());
      return "sign-up-success";
    }

    @GetMapping("/members")
    public String members(Model model){
        List<Member> members = memberService.lookupMembers();
        model.addAttribute("memberList",members);
        return "memberList";
    }

}
