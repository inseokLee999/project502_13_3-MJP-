package org.choongang.global;

import org.choongang.main.MainRouter;
import org.choongang.member.MemberSession;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller {
    protected Scanner sc;
    public AbstractController() {sc = new Scanner(System.in);}

    public void common(){
        System.out.println("묵찌빠 게임!!!!");
    }
    public void prompt(){
        System.out.println("(종료시 q를입력) 메뉴 선택:");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("종료 합니다.");
            System.exit(0); // 0 - 정상 종료, 1 - 비정상 종료
        }
        try {
            int m = Integer.parseInt(menu);
            change(m); // 메뉴 변경
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    @Override
    public void run() {
        common();
        show();
        prompt();
    }
    private void change(int menuNo) {
        MainMenu mainMenu = null;
        if(MemberSession.isLogin()){//로그인 상태인 경우
            switch (menuNo){
                case 1:
                    mainMenu = MainMenu.GAME; break;
                case 2:
                    MemberSession.logout();//로그아웃
                    mainMenu = MainMenu.MAIN;//로그아웃 이후에 다시 메인메뉴로 이동
                    break;
            }
        }else {//미로그인 상태
            switch (menuNo) {
                case 1:
                    mainMenu = MainMenu.JOIN;
                    break;//회원가입
                case 2:
                    mainMenu = MainMenu.LOGIN;
                    break;//로그인
                case 3:
                    mainMenu = MainMenu.GAME;
                    break;//게임
                case 4:
                    mainMenu = MainMenu.RESULT;
                    break;
            }
        }
        // 메뉴 컨트롤러 변경 처리 - Router
        MainRouter.getInstance().change(mainMenu);
    }


    /**
     *
     * @param message : 항목 메세지
     * @param predicate : 판별식
     * @return
     */
    protected String promptWithValidation(String message, Predicate<String> predicate){
        String str = null;
        do{
            System.out.print(message);
            str = sc.nextLine();
        }while (!predicate.test(str));
        return str;







    }
}
