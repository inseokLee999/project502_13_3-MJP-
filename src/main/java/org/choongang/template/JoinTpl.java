package org.choongang.template;

public class JoinTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("회원가입\n");
        sb.append("다음 가입 항목을 입력하세요.\n");
        sb.append("메인화면으로 돌아가려면 main을 입력하세요\n");
        sb.append("---------------------------------------------\n");

        return sb.toString();
    }
}
