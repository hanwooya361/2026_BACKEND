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
# ------------------------------------------------------------ #
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
