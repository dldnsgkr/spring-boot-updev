package com.project.updev.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Entity
    @Table(name="member")
    @DynamicUpdate
    @DynamicInsert
    @ToString
public class MemberEntity {
    @SequenceGenerator(name = "member_seq_GENERATOR",sequenceName = "m_seq", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_GENERATOR")
    @Column
    Long id;

        @Column
        String m_id;
        @Column
        String m_pw;
        @Column
        String m_nick;
        @Column
        String m_name;
        @Column
        String m_mail;
        @Column
        String m_tel;
        @Column
        String m_field;
        @Column
        LocalDate m_jdate;
        @Column
        String m_grade;
        @Column
        LocalDate m_outtime;

}
