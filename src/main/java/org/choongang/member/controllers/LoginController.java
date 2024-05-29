package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

public class LoginController extends AbstractController {



    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.LOGIN);
    }

    @Override
    public void prompt() {
        /**
         * 아이디 :
         * 비밀번호 :
         * userId, userPw toString
         */
        String userId = promptWithValidation("아이디 : ",s->!s.isBlank());
        String userPw = promptWithValidation("비밀번호 : ",
                s->!s.isBlank());
        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build();

        System.out.println(form);


        Router router = MainRouter.getInstance();

        try{

            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);
            System.out.println("로그인 성공!");
            router.change(MainMenu.MAIN);

        }catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}
