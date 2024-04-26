package com.example.Restful_Demo.Dao;


import com.example.Restful_Demo.Modul.Member;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, String> {
    Optional<Member> findByEmail(String email);
}