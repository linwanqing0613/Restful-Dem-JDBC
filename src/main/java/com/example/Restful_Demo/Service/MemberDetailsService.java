package com.example.Restful_Demo.Service;

import com.example.Restful_Demo.Modul.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MemberDetailsService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(MemberDetailsService.class.getName());

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.getUserByName(username);
        if(member == null){
            throw new UsernameNotFoundException("Username not Found!");
        }
        String email = member.getEmail();
        String password = member.getPassword();

        List<GrantedAuthority> list =new ArrayList<>();
        return new User(email, password, list);
    }
}
