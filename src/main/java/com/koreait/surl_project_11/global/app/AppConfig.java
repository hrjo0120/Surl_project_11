package com.koreait.surl_project_11.global.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
    // 비빌번호 암호화
    // SecurityConfig에서 만들어도 문제되지 않음
    // 보안 관련된 bean을 등록하고 app에 관련된 bean을 등록한다
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
