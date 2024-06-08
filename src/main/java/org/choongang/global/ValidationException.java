package org.choongang.global;

public class ValidationException extends CommonException{
    // 유효성 검사 실패 오류 코드는 400으로 정함
    //부모 클래스 CommonException의 생성자를 호출하여 예외 메시지와 에러 코드를 초기화합니다. 여기서 에러 코드는 항상 400으로 설정됩니다. 이는 HTTP 상태 코드 400 (Bad Request)에 해당하며, 일반적으로 클라이언트의 잘못된 요청을 나타냅니다.
    //생성자
    public ValidationException(String message) {
        super(message, 400);
    }
}
