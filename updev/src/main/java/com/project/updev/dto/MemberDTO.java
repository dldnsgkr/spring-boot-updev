package com.project.updev.dto;

import com.project.updev.entity.MemberEntity;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    Long id;
    String m_id;
    String m_pw;
    String m_nick;
    String m_name;
    String m_mail;
    String m_tel;
    String m_field;
    LocalDate m_jdate;
    String m_grade;
    LocalDate m_outtime;

    public MemberEntity MembertoEntity(){
        return new MemberEntity(id,m_id,m_pw,m_nick,m_name,m_mail,m_tel,m_field,m_jdate,m_grade,m_outtime);
    }

    /*public MemberEntity toEntity() {
        return MemberEntity.builder().id(id).m_id(m_id).m_pw(m_pw).m_nick(m_nick).m_name(m_name).m_mail(m_mail).m_tel(m_tel).
                m_field(m_field).m_jdate(m_jdate).m_grade(m_grade).m_outtime(m_outtime).build();
    }*/

    public MemberEntity toEntity(){
        return new MemberEntity(id,m_id,m_pw,m_nick,m_name,m_mail,m_tel,m_field,m_jdate,m_grade,m_outtime);
    }
}
