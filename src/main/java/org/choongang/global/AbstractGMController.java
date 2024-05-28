package org.choongang.global;

import org.choongang.Game.GameRouter;
import org.choongang.global.constants.GameMenu;

import java.util.Scanner;

public class AbstractGMController implements GMController{
    protected Scanner sc;
    public void common(){
        System.out.println("게임모드를 선택하세요");
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
            changeGM(m); // 메뉴 변경
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }
    @Override
    public void show() {

    }
    private void changeGM(int menuNo){
        GameMenu gameMenu = null;
        switch(menuNo){
            case 1: gameMenu = GameMenu.GAMEPVC; break;
            case 2: gameMenu = GameMenu.GAMEPVP; break;
        }
        GameRouter.getInstance().changeGM(gameMenu);
    }
    @Override
    public void run() {
        common();
        show();
        prompt();
    }
}
