package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MemberRepository;
import com.example.Restful_Demo.Modul.Member;
import com.example.Restful_Demo.Service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MemberServiceImplements implements MemberService {
    private static final Logger LOGGER = Logger.getLogger(MemberServiceImplements.class.getName());
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(Member member) {
        if(getUserByName(member.getEmail()) != null || getUserById(member.getId()) != null) {
            LOGGER.warning("Registering member's id or Email is Exist!");
            throw new IllegalArgumentException("Registering member's id or Email is Exist");
        }
        LOGGER.info("Registering member: " + member.getEmail());
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
        return member.getEmail();
    }

    @Override
    public Member getUserByName(String username){
        return memberRepository.findByEmail(username).orElse(null);
    }
    @Override
    public Member getUserById(String id){
        return memberRepository.findById(id).orElse(null);
    }
}
