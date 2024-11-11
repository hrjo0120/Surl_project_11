package com.koreait.surl_project_11.global.initData;

import com.koreait.surl_project_11.domain.article.article.entity.Article;
import com.koreait.surl_project_11.domain.article.article.service.ArticleService;
import com.koreait.surl_project_11.domain.member.member.entity.Member;
import com.koreait.surl_project_11.domain.member.member.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Profile("!prod")   // !prod == dev or test , 운영모드가 아닐 때 실행됨
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Lazy
    @Autowired
    private NotProd self;
    // this를 통한 객체 내부에서의 메서드 호출은 @Transactional을 작동시키지 않고
    // 외부 객체에 의한 메서드 호출은 @Transactional이 작동한다.
    // @Lazy, @Autowired 조합은 this의 외부 호출 모드 버전 self를 얻을 수 있다.
    // 따라서 self를 통한 메서드 호출은 @Transactional을 작동시킬 수 있다.

    private final ArticleService articleService;
    private final MemberService memberService;

    @Bean   // 스프링부트에 등록: 개발자가 new 하지 않아도 스프링부트가 직접 관리하는 객체(실행될 때 자동 생성)
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if (articleService.count() > 0) return;  //(articleRepository.count() > 0) : select

        // All 에서 실행되기 때문에 NotProd 에서 실행될 필요가 없다.
//        Member member1 = memberService.join("user1", "1234", "유저 1").getData();
//        Member member2 = memberService.join("user2", "1234", "유저 2").getData();

        // 멤버는 All 측에서 만든 것을 가져오고, 여기서는 만들 지 않는다.
        Member memberUser1 = memberService.findByUsername("user1").get();
        Member memberUser2 = memberService.findByUsername("user2").get();


//        try {
//            RsData<Member> joinRs = memberService.join("user2", "1234", "유저 2");
//        } catch (GlobalException e) {
//            System.out.println("e.getMsg() : " + e.getRsData().getMsg());
//            System.out.println("e.getStatusCode() : " + e.getRsData().getStatusCode());
//        }

        Article article1 = articleService.write(memberUser1, "제목 1", "내용 1").getData();
        Article article2 = articleService.write(memberUser1, "제목 2", "내용 2").getData();

        Article article3 = articleService.write(memberUser2, "제목 3", "내용 3").getData();
        Article article4 = articleService.write(memberUser2, "제목 4", "내용 4").getData();
    }
}
