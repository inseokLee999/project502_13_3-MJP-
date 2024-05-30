package org.choongang.template.game;

import org.choongang.member.controllers.LoginController;
import org.choongang.template.Template;
import org.choongang.template.member.UserSession;

public class GameTpl implements Template {
    @Override
    public String getTpl() {
        LoginController loginController= new LoginController();
        String userId = UserSession.getInstance().getUserId();
        StringBuffer sb = new StringBuffer(1000);
        sb.append("★묵찌빠의신"+" "+userId+" "+"님 두두등장★")
                .append("\n대전 상대 선택\n")
                .append("1. vsPlayer\n")
                .append("2. vsComputer\n")
                .append("3. 랭킹보기\n")
                .append("4 메인화면으로 돌아가기");


        return sb.toString();
    }
}
