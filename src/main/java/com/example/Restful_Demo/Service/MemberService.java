package com.example.Restful_Demo.Service;

import com.example.Restful_Demo.Modul.Member;

public interface MemberService {
    public String register(Member member);
    public Member getUserByName(String username);
    public Member getUserById(String id);
}
