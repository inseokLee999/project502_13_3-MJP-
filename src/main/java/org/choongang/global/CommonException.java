package org.choongang.global;
// 커스텀 예외 클래스, RuntimeException을 상속하며, 특정 에러 코드를 포함할 수 있는 기능을 추가
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private int code; // 에러 코드

    public CommonException(String message, int code) {
        //부모 클래스(RuntimeException)의 생성자를 호출하여 예외 메시지를 초기화합니다.
        super(message);
        //전달된 에러 코드를 code 필드에 저장합니다.
        this.code = code;
    }
}