package org.choongang.template.member;

import org.choongang.template.Template;

import javax.xml.transform.Templates;

public class LoginTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("로그인");
        sb.append("메인화면으로 돌아가려면 main을 입력하세요\n");
        sb.append("다음 로그인 항목을 입력하세요.\n");


        return sb.toString();
    }
}
