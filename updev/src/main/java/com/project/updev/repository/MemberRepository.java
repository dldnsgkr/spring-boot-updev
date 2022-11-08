package com.project.updev.repository;

import com.project.updev.dto.MemberDTO;
import com.project.updev.entity.MemberEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    @Query(value = "select p from MemberEntity p where p.m_id = :m_id and p.m_pw = :m_pw", nativeQuery = true )
    MemberDTO login_checking(@Param("m_id")String m_id, @Param("m_pw")String m_pw);


    @Transactional
    @Query(value = "select count(*) from alarm where springboot.m_id = :m_id and springboot.alarm_chk = 1", nativeQuery = true )
    int alarmcount(@Param("id") String id);
}
