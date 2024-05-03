package com.example.Restful_Demo.Controller;


import com.example.Restful_Demo.Dao.MovieRepository;
import com.example.Restful_Demo.Modul.Movie;
import com.example.Restful_Demo.Service.MovieService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @BeforeEach
    void init(){
        Mockito.when(movieService.getMovie(any(Integer.class))).thenReturn(new Movie());
        Mockito.doNothing().when(movieService).updateMovies(any(Movie.class));
        Mockito.when(movieService.postMovies(any(Movie.class))).thenReturn(new Movie());
        Mockito.when(movieService.deleteMovies(any(Integer.class))).thenReturn(new Movie());
    }

    @Test
    @WithMockUser("GUEST")
    void getMovies_Guest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/Movie/{movie_id}",2))
                .andDo(print())
                .andExpect(status().is(403))
                .andReturn();
    }
    @Test
    @WithMockUser(roles = "NORMAL_MEMBER")
    void getMovies_NormalMember() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/Movie/{movie_id}",1);



        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    @WithMockUser(roles ="ADMIN")
    void getMovies_ADMIN() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.GET,"/Movie/2");


        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    @WithMockUser(roles ="GUEST")
    void postMovies_Guest() throws Exception {
        String request = "{ \"title\": \"TEST\","+
                "\"director\": \"JPA_TEST\","+
                "\"release_year\": 2024 }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/Movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);


        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(403))
                .andReturn();
    }
    @Test
    @WithMockUser(roles = "NORMAL_MEMBER")
    void postMovies_NormalMember() throws Exception {
        String request = "{ \"title\": \"TEST\","+
                "\"director\": \"JPA_TEST\","+
                "\"release_year\": 2024 }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/Movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(403))
                .andReturn();
    }

    @Test
    @WithMockUser(roles ="ADMIN")
    void postMovies_ADMIN() throws Exception {
        String request = "{ \"title\": \"TEST\","+
                "\"director\": \"JPA_TEST\","+
                "\"release_year\": 2024 }";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.POST,"/Movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);



        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    void updateMovies() {
    }

    @Test
    @WithMockUser("GUEST")
    void deleteMovies_Guest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.DELETE,"/Movie/2");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(403))
                .andReturn();
    }
    @Test
    @WithMockUser(roles = "NORMAL_MEMBER")
    void deleteMovies_NormalMember() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.DELETE,"/Movie/2");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(403))
                .andReturn();
    }

    @Test
    @WithMockUser(roles ="ADMIN")
    void deleteMovies_ADMIN() throws Exception {
       RequestBuilder requestBuilder = MockMvcRequestBuilders
                .request(HttpMethod.DELETE,"/Movie/1");


        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
    }
}