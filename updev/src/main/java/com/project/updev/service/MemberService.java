package com.project.updev.service;

import com.project.updev.dto.MemberDTO;
import com.project.updev.entity.MemberEntity;

public interface MemberService {
    public MemberEntity member_signup(MemberEntity memberEntity);

    public MemberDTO login_checking(String m_id, String m_pw);

    public int alarmcount(String id);
}
