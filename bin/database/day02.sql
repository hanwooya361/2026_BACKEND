DROP DATABASE IF EXISTS MYDB0805;  # [1] 데이터베이스 삭제
CREATE DATABASE MYDB0805;          # [2] 데이터베이스 생성
SHOW DATABASES;                    # [3] 데이터베이스 목록
USE MYDB0805;                      # [4] 사용할 데이터베이스 선택
# ----------------------------------------------------------------------- #
# DDL : 데이터베이스/테이블 생성/삭제/수정 질의어 (** 트랜젝션 불가능 / 오토커밋  **)
# 1) 테이블 생성 : 1. 테이블 생성할 데이터베이스 활성화 2) CREATE TABLE 테이블명(속성명 타입, 속성명 타입);
CREATE TABLE TEST1(필드명1 INT , 필드명2 DOUBLE , 필드명3 TEXT);
# 2) 테이블 목록 조회
SHOW TABLES;
# 3) 특정 테이블 속성 확인
DESCRIBE TEST1;
# 4) 특정 테이블 삭제
DROP TABLE TEST1;
# 5) 테이블 수정
# 1) 필드/속성 추가 : ADD
ALTER TABLE TEST1 ADD 필드명4 FLOAT;
# 2) 필드/속성 타입 수정 : MODIFY
ALTER TABLE TEST1 MODIFY 필드명3 LONGTEXT;
# 3) 필드/속성명 , 타입 수정 : CHANGE
ALTER TABLE TEST1 CHANGE 필드명1 필드명5 BIGINT;

# 6) 테이블 이름 변경 : RENAME
RENAME TABLE TEST1 TO NEWTEST1;
# 7) 테이블 모든 레코드(행/데이터) 삭제, 테이블은 유지
TRUNCATE TABLE NEWTEST1;    # VS DELETE 차이점
# ----------------------------------------------------------------------- #
# 테이블의 속성/필드 타입   *DBMS회사마다 차이가 있음*
USE MYDB0805;
/* CREATE TABLE TEST2(필드명 타입, 필드명 타입, 필드명 타입); */
CREATE TABLE TEST2(
    정수필드1 TINYINT, 정수필드2 SMALLINT, 정수필드3 MEDIUMINT, 
    정수필드4 INT    , 정수필드5 BIGINT  , 정수필드6 INT UNSIGNED,  
    -- UNSIGNED 부호없다. TINYINT(1바이트 -128~127) --> 0~255
    실수필드1 FLOAT  , 실수필드2 DOUBLE  , 실수필드3 DECIMAL,
    -- DECIMAL 문자타입이면서 소수점 오차 없음
    날짜필드1 DATE   , 시간필드2 TIME    , 날짜시간필드3 DATETIME,
    문자필드1 CHAR(3)   , 문자필드2 VARCHAR(3) , 문자필드3 TEXT, 문자필드4 LONGTEXT, 
    -- CHAR(문자 고정길이 ~255) VS VARCHAR(문자 가변길이 ~255?) 
    -- 속도 CHAR > VARCHAR
    -- EX) "수박" --> CHAR([수][박][X]) VS VARCHAR([수][박])
    -- 사진이 포함된 게시물내용 저장시 : 4G 가능한 LONGTEXT 권장
    논리필드1 BOOLEAN   -- 마지막 필드 타입 뒤로 , 넣지 말기!
);
DESCRIBE TEST2; -- 테이블 속성 확인

# ----------------------------------------------------------------------- #
# 속성/필드 제약조건
CREATE TABLE TEST3(
    필드명1 TINYINT NOT NULL,    -- 해당 필드/속성에는 NULL 저장할 수 없도록 설정   * NULL이면 오류발생 *
    필드명2 SMALLINT UNIQUE,     -- 해당 필드/속성에는 중복값을 저장할 수 없도록 설정   * 값이 다른 레코드와 같다면 오류발생 *
    필드명3 INT DEFAULT 100,     -- 해당 필드/속성에 레코드 생성시 기본값 100 대입된다
    필드명4 DATETIME DEFAULT NOW(), -- EX) 레코드 삽입시 현재날짜/시간 자동 대입
    필드명5 BIGINT AUTO_INCREMENT,
    CONSTRAINT PRIMARY KEY(필드명5) -- 특정 필드/속성 PK로 설정한다.
    -- AUTO_INCREMENT : 레코드(행) 삽입 시 자동으로 순서번호 설정, 1 2 3 4 5 ~
    -- PRIMARY KEY(PK) : 기본/식별 키 , 식별 가능한 고유한 값을 갖는 필드(NOT NULL + UNIQUE 내장되어있음)
        -- 힉번,            사번,       제품코드/번호 등
    -- FOREIGN KEY(FK) : 참조/외래 키(PK가 다른테이블에 위치한 경우), 다른 테이블의 기본키 참조하는 키 
        -- 수강신청학학번, 급여지급사번, 판매된제품코드 
        -- 참조 옵션 : PK가 삭제/수정된 경우 FK가 어떻게??
            -- ON DELETE/UPDATE CASCADE     : PK가 삭제되면 FK도 같이 삭제/수정
            -- ON DELETE/UPDATE SET NULL    : PK가 삭제/수정되면 FK는 NULL로 수정
            -- ON DELETE/UPDATE RESTRICT    : (생략시 기본값) PK가 FK로부터 참조 중이면 삭제/수정 불가능
);
CREATE TABLE TEST4(
    필드명1 BIGINT, 
    CONSTRAINT FOREIGN KEY(필드명1) REFERENCES TEST3(필드명5) ON DELETE CASCADE ON UPDATE CASCADE  -- REFERENCES 참조
);
-- MYSQL WORKBENCH OR VSCODE에서 DB서버 연동 가능
-- NYSQL WORKBENCH(ERD 다이어그램 자동생성)

# 예제 회원제 게시판 서비스 ----------------------------------------------- #
DROP DATABASE IF EXISTS BOARDSERVICE;   # 1) DB 존재하면 삭제
CREATE DATABASE BOARDSERVICE;           # 2) DB 생성
USE BOARDSERVICE;
CREATE TABLE MEMBER(    -- 4) 회원테이블 생성한다
    MNO INT AUTO_INCREMENT,     -- 자동 회원번호
    CONSTRAINT PRIMARY KEY(MNO),    -- 회원번호 PK 설정
    MID VARCHAR(30) NOT NULL UNIQUE,    -- 회원아이디면서 최대30글자, 공백 불가능, 중복 불가능
    MPWD VARCHAR(20) NOT NULL,  -- 회원비밀번호이면서 최대20글자, 공백 불가능, 중복 가능
    MNAME VARCHAR(10) NOT NULL, -- 회원닉네임
    MDATE DATETIME DEFAULT NOW() -- 회원가입날짜/시간 , 현재날짜/시간 자동으로 기본값 설정
);
CREATE TABLE BOARD(     -- 5) 게시물테이블 생성
    BNO INT AUTO_INCREMENT,
    CONSTRAINT PRIMARY KEY(BNO), -- 게시물번호 PK 설정  *관례적으로 테이블1개당 PK1개 이상 권장*
    BTITLE VARCHAR(255) NOT NULL, -- 게시물제목
    BCONTENT LONGTEXT,  -- 게시물내용, 대용량(사진)포함한 최대 4G
    BDATE DATETIME DEFAULT NOW(), -- 게시물작성날짜/시간
    BVIEW INT DEFAULT 0, -- 게시물조회수
    MNO INT,    -- 작성자(MID/회원아이디가 아니고 MNO/회원번호)
    CONSTRAINT FOREIGN KEY(MNO) REFERENCES MEMBER(MNO) 
        ON DELETE CASCADE    -- 회원이 탈퇴/삭제 하면 그 회원이 작성한 게시물도 같이 삭제   
);