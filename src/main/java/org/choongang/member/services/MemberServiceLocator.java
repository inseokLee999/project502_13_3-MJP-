package org.choongang.member.services;

import org.choongang.Game.Services.GameService;
import org.choongang.Game.Services.ResultService;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.Menu;

public class MemberServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }

        return instance;
    }


/** km추가 S */
    // 회원가입 유효성 검사 Validator
    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    // MemberMapper 인터페이스 구현체
    public MemberMapper memberMapper() {
        return DBConn.getSession().getMapper(MemberMapper.class);
    }
/** km추가 E */


    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }switch (menu) {
            case JOIN: service = new JoinService();break;
            case LOGIN: service = new LoginService(); break;
            case GAME: service = new GameService(); break;
            case RESULT: service = new ResultService();break;
        }

        return service;
    }
}
