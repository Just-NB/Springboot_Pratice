package com.example.demo.controller;

import com.example.demo.controller.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// ResponseBody를 메소드마다 선언했던 것을 한번에 사용할 수 있게.
@RestController // 컨트롤러를 JSON 반환하는 컨트롤러로 만든다.
public class HelloController {
    @GetMapping("/hello") // GET Method 요청을 받을 수 있는 API
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
