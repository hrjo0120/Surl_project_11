package com.koreait.surl_project_11;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Article {

    @Id // 이거 Primary Key로 사용할거라고 알려주는 것
    @GeneratedValue(strategy = IDENTITY)    // 기본키(Primary Key) 값을 자동으로 생성할 때 사용됨
    private long id;    // 필드들은 컬럼명이 됨
    private String title;
    private String body;

    // 테이블 만들려면 @Entity Primary Key는 @ID
}
