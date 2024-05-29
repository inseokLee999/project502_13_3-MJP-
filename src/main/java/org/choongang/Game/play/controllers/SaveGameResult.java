package org.choongang.Game.play.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveGameResult {

    public void saveGameResult(String userNo, String result, String ptocPtop) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 데이터베이스 URL
        String user = "PROJECT2_1"; // 데이터베이스 사용자 이름
        String password = "oracle"; // 데이터베이스 비밀번호

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // 데이터베이스 연결

            // 쿼리 작성
            String query = "INSERT INTO SCORE_BOARD (userNo, result, ptocPtop) VALUES (USER_NO, WIN, PTOC_PTOP)";

            // 준비된 쿼리 실행
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userNo); // 사용자 번호 설정
                stmt.setString(2, result); // 게임 결과 설정
                stmt.setString(3, ptocPtop); // 게임 종류 설정
                stmt.executeUpdate(); // 쿼리 실행
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리
        }
    }
}