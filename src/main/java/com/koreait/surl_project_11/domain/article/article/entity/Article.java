package com.koreait.surl_project_11.domain.article.article.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // 이 클래스로 테이블 만들거야
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // @CreatedDate , @LastModifiedDate 을 작동하기 위해 필요한 어노테이션
public class Article {

    @Id // 이 필드를 PRIMARY KEY로 만들거야
    @GeneratedValue(strategy = IDENTITY)    // 기본키(Primary Key) 값을 자동으로 생성할 때 사용됨(== AUTO_INCREMENT)
    private long id;    // 필드들은 컬럼명이 됨
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;

    // 테이블 만들려면 @Entity Primary Key는 @ID
}
