package com.koreait.surl_project_11.domain.article.article.entity;

import com.koreait.surl_project_11.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import static lombok.AccessLevel.PROTECTED;

@Entity // 이 클래스로 테이블 만들거야
@Builder
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class) // @CreatedDate , @LastModifiedDate 을 작동하기 위해 필요한 어노테이션
public class Article extends BaseTime {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
}
