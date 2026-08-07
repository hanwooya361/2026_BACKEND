DROP DATABASE IF EXISTS MYDB0807;
CREATE DATABASE MYDB0807;
USE MYDB0807;       -- ctrl+shift+enter : 전체실행 , ctrl+enter : 한줄 실행
CREATE TABLE TEST(  -- CREATE TABLE 테이블명(속성명 타입, 속성명 타입, 제약조건);
    번호 INT AUTO_INCREMENT,
    CONSTRAINT PRIMARY KEY(번호),
    이름 VARCHAR(30) NOT NULL UNIQUE,
    개수 INT DEFAULT 2
);
-- DML : 조작어 , 1) INSERT 레코드삽입 2) SELECT 레코드조회 3) UPDATE 레코드수정 4) DELETE 레코드삭제
-- 레코드란? 테이블내 행/가로 단위
# [1] INSERT : INSERT INTO 테이블명(속성명, 속성명)VALUES(값1, 값2)
INSERT INTO TEST( 호,이름,개수)VALUES(1,"유재석",10);
INSERT INTO TEST(이름, 개수 ) VALUES("강호동", 20);

