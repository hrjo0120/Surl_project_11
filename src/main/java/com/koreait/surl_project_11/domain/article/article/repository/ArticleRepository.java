package com.koreait.surl_project_11.domain.article.article.repository;

import com.koreait.surl_project_11.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 메서드명을 기반으로한 함수를 만들수 있기 때문에, 직접 짜지 말고 쿼리를 짠다음 GPT한테 JPA로 바꿔달라고 하는 것이 좋다.

    // 메서드 이름을 통한 JPA 쿼리 메서드 생성 -> JPA 학습용
    List<Article> findByIdInOrderByTitleDescIdAsc(List<Long> ids);  // 추상메소드 why? interface니까

    // 메서드 이름을 통한 JPA 쿼리 메서드 생성
    List<Article> findByTitleContaining(String title);

    // 메서드 이름을 통한 JPA 쿼리 메서드 생성
    List<Article> findByTitleAndBody(String title, String body);
}
