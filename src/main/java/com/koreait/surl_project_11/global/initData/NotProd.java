package com.koreait.surl_project_11.global.initData;

import com.koreait.surl_project_11.domain.article.article.entity.Article;
import com.koreait.surl_project_11.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!prod")   // !prod == dev or test , 운영모드가 아닐 때 실행됨
@Configuration
@RequiredArgsConstructor
public class NotProd {
    public final ArticleRepository articleRepository;

    @Bean   // 스프링부트에 등록: 개발자가 new 하지 않아도 스프링부트가 직접 관리하는 객체(실행될 때 자동 생성)
    public ApplicationRunner initNotProd() {
        return args -> {
            if (articleRepository.count() > 0) return;

            //articleRepository.deleteAll();

            Article article1 = Article.builder().
                    title("제목1")
                    .body("내용1").build();

            Article article2 = Article.builder().
                    title("제목2")
                    .body("내용2").build();

            articleRepository.save(article1);
            articleRepository.save(article2);

        };
    }
}