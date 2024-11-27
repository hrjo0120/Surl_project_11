package com.koreait.surl_project_11.domain.member.member.repository;

import com.koreait.surl_project_11.domain.member.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);   // 조회 결과가 최대 1개. 따라서 Optional 을 써줌

    Optional<Member> findByApiKey(String apiKey);
}
