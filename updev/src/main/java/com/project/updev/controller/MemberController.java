package com.project.updev.controller;

import com.project.updev.dto.MemberDTO;
import com.project.updev.entity.MemberEntity;
import com.project.updev.service.MemberService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;
    @GetMapping("/")
    public String ko1()
    {
        return "input";
    }

    @PostMapping("/member_signup")
    public String member_signup(MemberDTO memberDTO){
        memberDTO.setM_jdate(LocalDate.now());
        memberDTO.setM_outtime(LocalDate.now());
        System.out.println(memberDTO.toString());
            MemberEntity memberEntity= memberDTO.MembertoEntity();
        System.out.println(memberEntity.toString());
            memberService.member_signup(memberEntity);
            return "redirect:/";

    }
}
