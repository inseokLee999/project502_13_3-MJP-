package org.choongang.template;

public class MainTpl implements Template {
    public int Logout = 1;
    @Override

    public String getTpl() {
        //StringBuffer는 자바에서 문자열을 효율적으로 다룰 수 있도록 설계된 클래스입니다. String 클래스와 달리 StringBuffer는 가변(mutable) 문자열을 제공합니다. StringBuffer는 java.lang 패키지에 포함되어 있으며, 문자열을 조작할 때 동기화(synchronized)되어 다중 스레드 환경에서도 안전하게 사용할 수 있습니다.
        StringBuffer sb = new StringBuffer(2000);
        sb.append("메뉴를 선택하세요\n")
                .append("1.회원가입\n")
                .append("2.로그인\n")
                .append("3.게임시작\n");
        return sb.toString();
    }
}