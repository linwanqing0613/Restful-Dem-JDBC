package com.example.Restful_Demo.Service;

import com.example.Restful_Demo.Modul.Member;
import com.example.Restful_Demo.Modul.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MemberDetailsService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(MemberDetailsService.class.getName());

    @Autowired
    private MemberService memberService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.getUserByName(username);
        if(member == null){
            throw new UsernameNotFoundException("Username not Found!");
        }
        String email = member.getEmail();
        String password = member.getPassword();

        List<GrantedAuthority> list =convertToGrantedAuthority(member);
        return new User(email, password, list);
    }
    private List<GrantedAuthority> convertToGrantedAuthority(Member member){
        List<GrantedAuthority> list =new ArrayList<>();
        for(Role role: member.getRoles())
            list.add(new SimpleGrantedAuthority(role.getRole_name()));
        return list;
    }
}
