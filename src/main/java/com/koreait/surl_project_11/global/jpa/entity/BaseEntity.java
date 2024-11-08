package com.koreait.surl_project_11.global.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass   // 객체의 입장에서 공통 매핑 정보가 필요할 때, 부모 클래스에 선언해주는 어노테이션(이 클래스를 부모 클래스로 쓸거야)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    public String getModelName() {
        String simpleName = this.getClass().getSimpleName();
        return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    }
}
