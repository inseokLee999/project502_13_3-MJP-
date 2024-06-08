package org.choongang.member;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;
import org.choongang.template.UserSession;

public class LoginController extends AbstractController {
    Router router = MainRouter.getInstance();

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
         * promptWithValidation("아이디 : ",s->!s.isBlank());
         */
        String userId = promptWithValidation( "아이디 : ", s -> { if (s.equals("main")) {
            router.change(MainMenu.MAIN);
            return false; // break the validation loop
        }
            return !s.isBlank();
        });
        String userPw = promptWithValidation("비밀번호 : ",
                s->!s.isBlank());
        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build();

        System.out.println(form);




        try{

            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);
            System.out.println("로그인 성공!");
            UserSession.getInstance().setUserId(userId);
            router.change(MainMenu.GAME);

        }catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}
