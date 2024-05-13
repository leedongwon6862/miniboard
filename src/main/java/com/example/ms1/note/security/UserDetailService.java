package com.example.ms1.note.security;

import com.example.ms1.siteuser.SiteUser;
import com.example.ms1.siteuser.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser siteuser = userRepository.findByLoginId(username).orElseThrow(()-> new RuntimeException("존재하지 않는 아이디입니다."));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");  //유저권한
        List<SimpleGrantedAuthority> authorities = List.of(authority);


        return new User(siteuser.getLoginId(),siteuser.getPassword(),authorities);
    }
}
