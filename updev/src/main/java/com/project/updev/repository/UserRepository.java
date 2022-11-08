package com.project.updev.repository;

import com.project.updev.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findOneById(String id);
}