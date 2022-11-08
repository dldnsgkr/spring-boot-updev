package com.project.updev.service;

import com.project.updev.dto.MemberDTO;
import com.project.updev.entity.MemberEntity;
import com.project.updev.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberEntity input(MemberEntity entity) {
        entity.setM_pw(bCryptPasswordEncoder.encode(entity.getM_pw()));
        return userRepository.save(entity);
    }
}
