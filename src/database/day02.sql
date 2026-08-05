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