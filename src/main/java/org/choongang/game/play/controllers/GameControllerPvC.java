package org.choongang.game.play.controllers;

import org.choongang.global.AbstractController;

public class GameControllerPvC extends AbstractController {
    @Override
    public void show() {
        System.out.println("===== User vs Computer =====\n");
    }

    @Override
    public void prompt() {

        // 게임 루프
        while (true) {
            // 사용자 입력 받기
            System.out.print("Enter '바위', '가위', or '보', or '종료' to quit: ");
            String input = sc.nextLine();

            // 종료 확인
            if (input.equalsIgnoreCase("종료")) {
                System.out.println("게임 종료.");
                break; // 게임 종료
            }

            // 유효성 검사
            if (!(input.equals("바위") || input.equals("가위") || input.equals("보"))) {
                System.out.println("Error: Invalid input. Please enter '바위', '가위', '보', or '종료'.");
                continue; // 잘못된 입력이면 다시 반복
            }

            // 시스템 랜덤으로 가위바위보 설정
            int randomInt = (int) (Math.random() * 3);
            String computerChoice;
            if (randomInt == 0) {
                computerChoice = "바위";
            } else if (randomInt == 1) {
                computerChoice = "가위";
            } else {
                computerChoice = "보";
            }
            System.out.println("컴퓨터가 선택한 가위바위보: " + computerChoice);

            // 가위바위보 대결 및 승부 결정
            String winner;
            if (input.equals(computerChoice)) {
                System.out.println("비겼습니다! 가위바위보를 다시 시작합니다.");
                continue;
            } else {
                if ((input.equals("바위") && computerChoice.equals("가위")) ||
                        (input.equals("가위") && computerChoice.equals("보")) ||
                        (input.equals("보") && computerChoice.equals("바위"))) {
                    System.out.println("사용자 승! 사용자가 공격자가 됩니다.");
                    winner = "사용자";
                } else {
                    System.out.println("컴퓨터 승! 컴퓨터가 공격자가 됩니다.");
                    winner = "컴퓨터";
                }
            }

            // 묵찌빠 게임 시작
            while (true) {
                // 사용자 입력 받기
                System.out.print("Enter '묵', '찌', '빠': ");
                input = sc.nextLine();

                // 유효성 검사
                if (!(input.equals("묵") || input.equals("찌") || input.equals("빠"))) {
                    System.out.println("Error: Invalid input. Please enter '묵', '찌', or '빠'.");
                    continue; // 잘못된 입력이면 다시 반복
                }

                // 시스템 랜덤으로 묵찌빠 설정
                randomInt = (int) (Math.random() * 3);
                if (randomInt == 0) {
                    computerChoice = "묵";
                } else if (randomInt == 1) {
                    computerChoice = "찌";
                } else {
                    computerChoice = "빠";
                }
                System.out.println("컴퓨터가 선택한 묵찌빠: " + computerChoice);

                // 묵찌빠 대결 및 승부 결정
                if (input.equals(computerChoice)) {
                    System.out.println(winner + " 승!");
                    break;
                } else {
                    if ((input.equals("묵") && computerChoice.equals("찌")) ||
                            (input.equals("찌") && computerChoice.equals("빠")) ||
                            (input.equals("빠") && computerChoice.equals("묵"))) {
                        System.out.println("사용자가 이겼습니다! 사용자가 공격자가 됩니다.");
                        winner = "사용자";
                    } else {
                        System.out.println("컴퓨터가 이겼습니다! 컴퓨터가 공격자가 됩니다.");
                        winner = "컴퓨터";
                    }
                }
            }
        }
    }
}
