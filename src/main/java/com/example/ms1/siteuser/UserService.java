package com.example.ms1.siteuser;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void create(String loginId ,String password , String email ,String nickname ){
        SiteUser siteUser = new SiteUser();
        siteUser.setLoginId(loginId);
        siteUser.setEmail(email);
        siteUser.setNickname(nickname);
        siteUser.setPassword(password);
        siteUser.setCreateDate(LocalDateTime.now());
        userRepository.save(siteUser);


    }
}
