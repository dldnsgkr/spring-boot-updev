package com.project.updev.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
    @NoArgsConstructor
    @Getter
    @Setter
    @Entity
    @Table(name="member")
    @DynamicUpdate
    @DynamicInsert
    @ToString
    @SequenceGenerator(name = "member_seq_GENERATOR",sequenceName = "m_seq", allocationSize = 1, initialValue = 1)
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_seq_GENERATOR")
    @Column(name = "id")
    Long id;

        @Column(name = "m_id")
        private String m_id;
        @Column(name = "m_pw")
        private String m_pw;
        @Column(name = "m_nick")
        private String m_nick;
        @Column(name = "m_name")
        private String m_name;
        @Column(name = "m_mail")
        private String m_mail;
        @Column(name = "m_tel")
        private String m_tel;
        @Column(name = "m_field")
        private String m_field;
        @Column(name = "m_jdate")
        private LocalDate m_jdate;
        @Column(name = "m_grade")
        private String m_grade;
        @Column(name = "m_outtime")
        private LocalDate m_outtime;

        @Builder
        public MemberEntity(Long id, String m_id, String m_pw, String m_nick, String m_name, String m_mail, String m_tel, String m_field, LocalDate m_jdate, String m_grade, LocalDate m_outtime) {
            this.id = id;
            this.m_id = m_id;
            this.m_pw = m_pw;
            this.m_nick = m_nick;
            this.m_name = m_name;
            this.m_mail = m_mail;
            this.m_tel = m_tel;
            this.m_field = m_field;
            this.m_jdate = m_jdate;
            this.m_grade = m_grade;
            this.m_outtime = m_outtime;
        }

}
