package org.choongang.member.controllers;

import org.choongang.global.AbstractController;

import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.JOIN);
    }


    @Override
    public void prompt() {
        Router router = MainRouter.getInstance();
        while(true) {
            /**
             * 아이디 :
             * 비밀번호 :
             * 비밀번호 확인 :
             * 사용자 이름 :
             * userId, userPw toString
             */


            String userId = promptWithValidation( "아이디 : ", s -> { if (s.equals("main")) {
                router.change(MainMenu.MAIN);
                return false; // break the validation loop
            }
                return s.length() >= 6;
            });
            String userPw = promptWithValidation("비밀번호 : ",
                    s -> !s.isBlank());
            String confirmPw = promptWithValidation("비밀번호 확인 : ", s -> {
                boolean match = s.equals(userPw);
                if (!match) System.err.println("\n비밀번호가 일치하지 않습니다");
                return match;
            });
            String userNm = promptWithValidation("사용자 이름 : ", s -> !s.isBlank());
            RequestJoin form = RequestJoin.builder()
                    .userId(userId)
                    .userPw(userPw)
                    .confirmPw(confirmPw)
                    .userNm(userNm)
                    .build();
            System.out.println(form);
            System.out.println(router);
            //회원가입 처리..
            try {

                Service service = MemberServiceLocator.getInstance().find(MainMenu.JOIN);
                service.process(form);

                //회원가입 성공시 -> 로그인화면 이동
                System.out.println("회원가입 성공");
                router.change(MainMenu.LOGIN);

                break; // 성공시 반복 멈춤
            } catch (RuntimeException e) {
                //회원가입 실패시
                System.err.println(e.getMessage());
                System.out.println("회원가입 실패");
                System.out.println();
                // router.change(MainMenu.MAIN);
                // 실패시에는 입력 다시 시작
            }
        }

    }
}
