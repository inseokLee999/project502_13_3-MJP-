package org.choongang.template.main;

import org.choongang.template.Template;

public class MainTpl implements Template {
    public int Logout = 1;
    @Override

    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("메뉴를 선택하세요\n")
                .append("1.회원가입\n")
                .append("2.로그인\n")
                .append("3.게임시작\n");
        return sb.toString();
    }
}