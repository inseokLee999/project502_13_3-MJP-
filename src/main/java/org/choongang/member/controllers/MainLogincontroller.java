package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.Templates;

public class MainLogincontroller extends AbstractController {
    public void show(){
        Templates.getInstance().render(MainMenu.MAINLOGINPAGE);
    }

    public void prompt(){
        public String getUserNumber() {
            // 사용자 번호를 얻어오는 로직
            return userNo;
        }
        MainLogincontroller controller = new MainLogincontroller();
        String userNo = controller.getUserNumber(); // 사용자 번호 얻어오기
    }
}
