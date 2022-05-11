package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
// Web(Spring MVC)에 집중, Controller 어노테이션 사용가능
// @Service, @Component, @Repository등은 사용 불가능
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired // Spring이 관리하는 Bean을 주입받는다.
    private MockMvc mvc; // 이 클래스를 통해 GET/POST API테스트가 가능하다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 GET요청
                .andExpect(status().isOk()) // 결과(HTTP Status)를 검증, 200 OK
                .andExpect(content().string(hello)); // 본문의 내용을 검증, Controller의 Return값 검증.
    }
}
