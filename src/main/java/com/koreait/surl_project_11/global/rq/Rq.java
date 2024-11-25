package com.koreait.surl_project_11.global.rq;

import com.koreait.surl_project_11.domain.member.member.entity.Member;
import com.koreait.surl_project_11.domain.member.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@RequiredArgsConstructor
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    private final MemberService memberService;

    @Getter
    @Setter
    private Member member;

//    public Member getMember() {
//        // 개선해야할 부분
//        // 이 부분 때문에 계속 3번으로 요청이 가지만, 요청할 때마다 인증정보나 클라이언트가 누군지 분별할 수 있게 같이 줘야함
//        // 매 요청마다 인증정보를 같이 보내야함
//
//        // 필요한 이유? 내가 만들어 둔 서비스는 하나이지만, 사용자는 다수이기 때문에
//        return memberService.getReferenceById(3L);  // user1
//    }

    public String getCurrentUrlPath() {
        return req.getRequestURI();
    }

    public void setStatusCode(int statusCode) {
        resp.setStatus(statusCode);
    }
}