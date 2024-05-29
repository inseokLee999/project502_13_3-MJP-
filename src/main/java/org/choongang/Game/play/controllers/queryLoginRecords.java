package org.choongang.Game.play.controllers;

import java.sql.*;

public void queryLoginRecords(String username) {
    String query = "SELECT login_time FROM login_log WHERE username = ?";

    try (
            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);
            // PreparedStatement 생성
            PreparedStatement stmt = conn.prepareStatement(query);
    ) {
        // PreparedStatement에 파라미터 설정
        stmt.setString(1, username);

        // 쿼리 실행 및 결과셋 받기
        ResultSet rs = stmt.executeQuery();

        // 결과 처리
        while (rs.next()) {
            // 각 로그인 시간 출력
            System.out.println("로그인 시간: " + rs.getTimestamp("login_time"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
