package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.Templates;

import java.util.Scanner;

public class MainLogincontroller extends AbstractController {
    /*
}
    public void show(){
        Templates.getInstance().render(MainMenu.MAINLOGINPAGE);
    }

    public void prompt(){
        public String getUserNumber() {
            // 사용자 번호를 얻어오는 로직
           // return userNo;
            return null;
        }
        MainLogincontroller controller = new MainLogincontroller();
        String userNo = controller.getUserNumber(); // 사용자 번호 얻어오기
    } */

    private Scanner sc;

    public MainLogincontroller() {
        sc = new Scanner(System.in);
    }

    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.MAINLOGINPAGE);
    }

    @Override
    public void prompt() {
        String userNo = getUserNumber(); // 사용자 번호 얻어오기
        System.out.println("사용자 번호: " + userNo);
    }

    public String getUserNumber() {
        String input;
        while (true) {
            System.out.print("사용자 번호를 입력하세요: ");
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("입력 값이 비어 있습니다. 다시 입력해주세요.");
            } else {
                try {
                    // 사용자 번호가 숫자로 변환 가능한지 확인
                    Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }
        }
        return input;
    }
}