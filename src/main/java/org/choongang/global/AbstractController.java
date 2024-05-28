package org.choongang.global;

import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;

import java.util.Scanner;

public abstract class AbstractController implements Controller{
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
        Menu menu = null;
        switch (menuNo){
            case 1: menu = Menu.JOIN; break;
            case 2: menu = Menu.LOGIN; break;
            case 3: menu = Menu.GAME; break;
            case 4: menu = Menu.RESULT; break;
        }
        MainRouter.getInstance().change(menu);
    }
}
