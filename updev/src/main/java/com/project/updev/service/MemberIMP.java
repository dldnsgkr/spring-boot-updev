package com.project.updev.service;

import com.project.updev.entity.MemberEntity;
import com.project.updev.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberIMP implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Override
    public MemberEntity member_signup(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }
}
