
# 한줄주석
-- 한줄주석
/*여러줄주석*/ 

-- DB란? 여러 데이터들의 집합/공간 
-- DB서버란? 여러 데이터베이스들을 저장한 PC/프로그램 (MYSQL: 3306, ORACLE 등)

-- [1] DB 목록 보기
-- 1. SQL 문법 작성     2. ;세미콜론 마침       3. 실행할 SQL문법에 커서를 두고 컨트롤엔터 OR RUN누르기
SHOW DATABASES;     -- 연결된 DB서버내 모든 데이터베이스 목록 확인
-- [2] DB 로컬 경로 확인 
SHOW VARIABLES LIKE 'datadir';
-- ** [3] DB 생성, 주의할점 : 중복된 데이터베이스명 불가능, SQL문법은 대소문자 구분하지 않는다.
CREATE DATABASE mydb0804;   -- 연결된 DB서버내 특정 DB 생성
-- ** [4] DB 삭제, IF EXISTS 존재하면삭제, 주의할점 : 없는 DB명은 삭제 불가능
DROP DATABASE mydb0804;
DROP DATABASE IF EXISTS mydb0804;
-- [5] DB 활성화 : 연결된 DB서버내 여러개 DB 중 조작할 DB 선택
USE mydb0804;

-- [활용] : 프로젝트 DB 초기화 한다. *초기SQL 상단에 아래 코드 작성*
DROP DATABASE IF EXISTS TEST0804;
CREATE DATABASE TEST0804;
USE TEST0804;
