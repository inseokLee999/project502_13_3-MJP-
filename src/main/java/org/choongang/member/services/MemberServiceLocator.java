package org.choongang.member.services;

import org.choongang.Game.Services.GameService;
import org.choongang.Game.Services.ResultService;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.MainMenu;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.LoginValidator;

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
    public LoginValidator loginValidator(){
        return new LoginValidator((memberMapper()));
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }
        MainMenu mainMenu = (MainMenu) menu;
        switch (mainMenu) {
            case JOIN: service = new JoinService(memberMapper(), joinValidator());break;
            case LOGIN: service = new LoginService(memberMapper(), loginValidator()); break;
            case GAME: service = new GameService(); break;
            case RESULT: service = new ResultService();break;
        }

        return service;
    }
}
