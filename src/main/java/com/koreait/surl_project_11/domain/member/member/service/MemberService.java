package com.koreait.surl_project_11.domain.member.member.service;

import com.koreait.surl_project_11.domain.member.member.entity.Member;
import com.koreait.surl_project_11.domain.member.member.repository.MemberRepository;
import com.koreait.surl_project_11.global.exceptions.GlobalException;
import com.koreait.surl_project_11.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    private Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Transactional  // @Transactional 붙이는 것이 관례
    // @Transactional(noRollbackFor = GlobalException.class)
    public RsData<Member> join(String username, String password, String nickname) {
//        boolean present = findByUsername(username).isPresent();

//        // 중복체크 표현 여러가지 방법들
//        if (present) {
//            // runtime Exception 계열
//            // 아래처럼 이미 있는 애인 IllegalArgumentException 을 써도 되고 ..
////            throw new IllegalArgumentException("이미 존재하는 아이디야");
//            // 아래처럼 내가 원하는 Exception 을 만들어서 쓸 수도 있다.
//            throw new GlobalException("400-1", "이미 존재하는 아이디야");
//        }

        // 이런 식으로 작성해도 된다.
        findByUsername(username).ifPresent(ignored -> {
            throw new GlobalException("400-1", "이미 존재하는 아이디야");
        });

        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
        memberRepository.save(member);
        return RsData.of("회원가입이 완료되었습니다.", member);
    }

    public Member getReferenceById(long id) {
        return memberRepository.getReferenceById(id);
    }
}
