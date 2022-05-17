package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // SpringApplication.run : 내장 WAS를 실행한다.
        // APP을 실행할때, 내부에서 WAS를 실행하여, 서버에 톰캣을 설치할 필요가 없게되고, Jar파일로 실행하면 된다.
        // 언제 어디서나 같은 환경에서 스프링부트를 배포하기 위해, 내장 WAS를 권장한다.
        SpringApplication.run(DemoApplication.class, args);
    }

}
