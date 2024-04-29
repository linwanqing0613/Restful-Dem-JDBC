package com.example.Restful_Demo.Controller;


import com.example.Restful_Demo.Modul.Member;
import com.example.Restful_Demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Member> register(@RequestBody Member member) {
        String username = memberService.register(member);
        Member after_member = memberService.getUserByName(username);
        return after_member != null? ResponseEntity.ok(after_member): ResponseEntity.notFound().build();
    }
    @GetMapping("/hello")
    public ResponseEntity<Authentication> hello(Authentication authentication) {
        return ResponseEntity.ok(authentication);
    }
}