package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Service;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.LoginValidator;

@RequiredArgsConstructor
public class LoginService implements Service<RequestLogin> {
    private final MemberMapper mapper;
    private final LoginValidator validator;
    @Override
    public void process(RequestLogin form) {
        System.out.println("로그인 process 실행");

        validator.check(form);


    }
}
