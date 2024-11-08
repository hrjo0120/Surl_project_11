package com.koreait.surl_project_11.domain.article.article.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // 이 클래스로 테이블 만들거야
@Builder
@Getter
public class Article {

    @Id // 이 필드를 PRIMARY KEY로 만들거야
    @GeneratedValue(strategy = IDENTITY)    // 기본키(Primary Key) 값을 자동으로 생성할 때 사용됨(== AUTO_INCREMENT)
    private long id;    // 필드들은 컬럼명이 됨
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    // 테이블 만들려면 @Entity Primary Key는 @ID
}
