package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MemberRepository;
import com.example.Restful_Demo.Modul.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberServiceImplementsTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void register() {
        Member member = new Member();
        member.setId("user");
        member.setEmail("user@gmail.com");
        member.setPassword(passwordEncoder.encode("1234"));
        memberRepository.save(member);
        assertNotNull(memberRepository.findById("user"), "register 失敗");
    }

    @Test
    void getUserByName() {
        Member member = memberRepository.findByEmail("guest@gmail.com").orElse(null);
        assertNotNull(member, "getUserByName 失敗");
    }

    @Test
    void getUserById() {
        Member member = memberRepository.findById("guest").orElse(null);
        assertNotNull(member, "getUserById 失敗");
    }
}