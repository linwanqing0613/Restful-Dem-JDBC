package com.example.Restful_Demo.Controller;

import com.example.Restful_Demo.Modul.Member;
import com.example.Restful_Demo.Modul.Movie;
import com.example.Restful_Demo.Service.MemberService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberService memberService;

    @BeforeEach
    void init(){
        Member member = new Member();
        member.setId("user");
        member.setEmail("user@gmail.com");
        member.setPassword("1234");
        Mockito.when(memberService.register(any(Member.class))).thenReturn(member.getEmail());
        Mockito.when(memberService.getUserByName(any(String.class))).thenReturn(member);
    }


    @Test
    void register() throws Exception {
        String str ="{ \"id\": \"user\","+
                    " \"email\":\"user@gmail.com\","+
                    " \"password\":\"1234\" }";
        mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(str))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "guest",roles = "GUEST")
    void hello() throws Exception {
        mockMvc.perform(get("/users/hello"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }
}