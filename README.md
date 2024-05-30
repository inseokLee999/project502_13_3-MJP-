"# project502_13_3-MJP-"
** 팀전일 때
 0. PvP/PvC 선택
 1. n:n 데스 매치 (팀 인원을 정해주세요 : (최대 4명)) 4 (전체 인원이 홀수 인 경우 ai 플레이어 만들기?)
 2. 팀 선택 (Red,Blue)
 3. 팀 배정 완료
 4. 팀 내 대진 순서 정하기
 5.0 남은 팀원이 존재할 때 -> 5 않으면 8

  =============== 묵찌빠 게임 큰 틀 =================
  플레이어 객체 생성
0. PvP(Player verses Player) /PvC(Player verses Computer) 선택

5. --대결 시작 --
   5.0 모든 경우 db에 저장
   
   5.1 묵찌빠 고르기 (Scanner) ({묵,주먹,바위},{찌,가위},{빠,보자기,보}
   
   5.1.1 입력이 다른것 들어왔을 때 -> 예외 처리
   
   5.2 상대 것과 비교 ?
   
   5.2.1 처음 일 때 ->5.3
   
   5.2.2 5.3에서 왔을 때 무승부(상대 것 == 내 것) : 승부 결정->5.4 / not 무승부 -> 5.3
   
   5.3.0 타임아웃 설정 초과시 패배
   
   5.3 공격/수비 표시 묵찌빠 대결 -> 5.2     if {player1.hand,player2.hand} Win
   
   5.4 승부 완료 {$team1}Plyaer01 승++ /{$team2}Plyaer02 패++
   
** 팀전 일 때
 7. 팀원 out
 8. 다음 팀원이랑 매치 ->5.0
 9. 팀원이 존재하지 않음 -> 패배 / 반대 : 승리 (index == n)

     8.1 결과 창 띄우기
     ex) 				RedTeam Win!!
     RedTeamPlayer01 2승 1패 BlueTeamPlayer01 0승 1패
     RedTeamPlayer02 1승 0패 BlueTeamPlayer02 1승 1패
     RedTeamPlayer03 0승 0패 BlueTeamPlayer03 0승 1패
     8.2 DataBase 로 정보 전송
10. 다시 하기/ 게임 종료
   ============구현 해야할 기능 ==========
1. 컴퓨터와 묵찌빠 기능 :  랜덤 사용해서 0~1 묵 1~2찌 2~3빠
2. DB 에 기반한 랭킹 기능 (기준 :  제일많이한 사람의 절반 게임 수 이상 한 사람중 승률이 제일 높은 사람)

============사용자 관점에서 애플리케이션 이용 시나리오 작성해 보기==============

1. 처음에 시작시에 1p 2p 선택
   1.1 몇판 선승 결정
2. 대결시작
3. 가위바위보 선택
   3.1 잘못 입력시 다시 입력
4. 경우에 따라 묵찌빠 진행
5. 묵찌빠의 승부결정 시 종료
6. 결과 출력
7. 다시 하기/ 게임 종료
   ==== 일정 ====
   27 - 공통 구조
   28~30 개발
   31~6/4 개발
### 게임 메인
> 게임 서브 메뉴
> 1. 혼자하기
> 2. 같이하기
> 3. 순위보기

## 만들어야할 TABLE
### 멤버 테이블
CREATE SEQUENCE SEQ_MEMBER
CREATE TABLE MEMBER (
    USER_NO NUMBER(10) PRIMARY KEY, 
    USER_ID VARCHAR2(30) UNIQUE NOT NULL,
    USER_PW VARCHAR2(65) NOT NULL,
    USER_NM VARCHAR2(40) NOT NULL,
    REG_DT DATE DEFAULT SYSDATE,
    MOD_DT DATE
);
### 포인트 로그
CREATE SEQUENCE SEQ_POINT_LOG
CREATE TABLE POINT_LOG(
SEQ NUMBER(10) PRIMARY KEY,
USER_NO NUMBER(10) REFERENCES MEMBER(USER_NO),
POINT NUMBER(10),
MESSAGE VARCHAR2(20)
);
### 랭킹 
CREATE SEQUENCE SEQ_SCORE_BOARD
CREATE TABLE SCORE_BOARD(--매번 게임실행후 게임결과기록
   SCORENO NUMBER(10) PRIMARY KEY,-- 게임1회당 번호부여
   USER_NO NUMBER(10) UNIQUE NOT NULL,-- 회원아이디
   PTOC_PTOP  VARCHAR2(65 BYTE) NOT NULL, -- PTOC 인지 PTOP 인지 
   WIN NUMBER(4) DEFAULT 0 NOT NULL,--해당회차 우승하면 기록1
   LST NUMBER(4) DEFAULT 0 NOT NULL,--해당회차 패하면 기록1
   SCORE_REG_DT DATE DEFAULT SYSDATE
);
