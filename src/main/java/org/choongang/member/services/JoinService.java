package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.global.exceptions.ValidationException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.template.member.UserSession;
import org.mindrot.jbcrypt.BCrypt;

//org/choongang/member/services/JoinService.java
// 회원가입 기능을 구현하기 위한 의존성 (MemberMapper, JoinValidator)

@RequiredArgsConstructor
public class JoinService implements Service<RequestJoin> {
    private final MemberMapper mapper;
    private final JoinValidator validator;

    @Override
    public void process(RequestJoin form) {
        System.out.println("회원가입 process 실행");
        // 회원 가입 유효성 검사
        validator.check(form);

        // 비밀번호 해시화
        String userPw = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(10));


        // 데이터베이스에 영구 저장
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(userPw)
                .userNm(form.getUserNm())
                .build();
        System.out.println("Member:"+member.toString());
        int affectedRows = mapper.register(member);

        if (affectedRows < 1) { // 회원 가입 처리 실패시
            throw new ValidationException("회원가입 실패하였습니다.");
        }
    }
}