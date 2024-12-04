package com.koreait.surl_project_11.global.webMvc;

import com.koreait.surl_project_11.global.app.AppConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        // "https://cdpn.io",  // 코드펜 테스트용
                        AppConfig.getSiteFrontUrl() // http://localhost:5173 or https://www.surl.abbl.site
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);    // 어떤 요청에 대해서 허용을 해줘야 하는 지
    }
}