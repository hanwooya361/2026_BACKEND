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
INSERT INTO TEST(번호,이름,개수)VALUES(1,"유재석",10);
INSERT INTO TEST(이름, 개수 ) VALUES("강호동", 20);     -- 번호 제외 , AUTO_INCREMENT 자동번호
INSERT INTO TEST(이름) VALUES("신동엽");                -- 번호(AUTO), 개수(DEFAULT) 제외 삽입
-- INSERT INTO TEST(이름) VALUES("유재석");             -- UNIQUE 때문에 중복 불가
INSERT INTO TEST VALUES(4,"하하", 30);                  -- 모든 속성값 순서대로 값 대입시 속성명 생략
INSERT INTO TEST(이름) VALUES("박명수"),("수박"),("바나나");    -- 3개의 레코드 삽입

# [2] SELECT : SELECT [*전체/속성명] FROM 테이블명 WHERE 조건
SELECT * FROM TEST; -- 테이블내 모든 속성[*] 레코드 조회
SELECT 이름 FROM TEST;
SELECT 이름, 개수 FROM TEST; 
SELECT * FROM TEST WHERE 이름 = "유재석";   -- 이름이 유재석이면 조회
SELECT * FROM TEST WHERE 개수 >= 5;          -- 개수 속성명 값이 5 이상이면 조회

# [3] UPDATE : UPDATE 테이블명 SET 속성명 = 새로운값, 속성명 = 새로운값 WHERE 조건
UPDATE TEST SET 개수 = 10;  -- 조건이 없어서 테이블내 개수 속성들의 값 *모두* 10으로 수정됨
UPDATE TEST SET 개수 = 30 WHERE 이름 = "유재석";    -- 이름 속성값이 유재석이면 개수 속성값을 30으로 수정
UPDATE TEST SET 개수 = 40, 이름 = "강호동2" WHERE 번호 = 2; -- 번호 속성값이 2이면 개수속성값을 40 이름속성값을 강호동2로 수정

# [4] DELETE : DELETE FROM 테이블명 WHERE 조건
-- DELETE FROM TEST;    조건이 없으므로 테이블내 모든 레코드 삭제 <---> TRUNCATE와 비슷
DELETE FROM TEST WHERE 이름 = "바나나";
DELETE FROM TEST WHERE 번호 = 2;    
-- (DML)DELETE : 테이블내 레코드 삭제 [VS] (DDL)TRUNCATE TABLE : 테이블내 레코드 삭제 [VS] DROP TABLE : 테이블 자체 삭제
-- DDL은 취소(ROLLBACK) 불가능, DML 취소(ROLLBACK) 가능

# SQL 연산자
# 1. 회원테이블
create table member(    # 아이돌 그룹
 mid char(8) not null ,   # 식별키   최대 8자리
    mname varchar(10) not null , # 그룹명  최대 10자리
    mnumber int not null ,   # 인원수  정수 +-21억정도
    maddr char(2) not null ,   # 지역  최대 2자리
    mphone1 char(3) ,    # 지역번호 최대 2자리
    mphone2 char(8) ,    # 전화번호  최대 8자리
    mheight smallint ,    # 평균키   정수 +-3만정도
 mdebut date ,     # 데뷔일   yyyy-mm-dd
    constraint primary key ( mid )    # 제약조건
);
# 2. 구매테이블
create table buy(
 bnum int auto_increment ,    # 구매번호 정수  자동번호 부여
    mid char(8),      # 구매자  FK
    bpname char(6) not null ,   # 제품명  최대 6자리
    bgname char(4) ,      # 분류명   최대 4자리
    bprice int not null ,    # 가격   정수
    bamount smallint not null ,   # 구매수량 정수
    constraint primary key(bnum) ,     # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);
# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# [1] as 별칭 키워드 , 조회 결과의 속성명 변경 , as 생략하고 띄어쓰기 사용가능
SELECT MID FROM member; -- member 테이블의 mid 속성 레코드조회
SELECT MID AS 회원아이디 FROM MEMBER;   -- 조회결과 MID속성명을 회원아이디 별칭
SELECT MID AS 회원아이디 FROM member AS 회원테이블; -- SQL내 속성명/테이블명 별칭
SELECT MID 회원아이디 FROM member 회원테이블; -- AS 생략하고 띄어쓰기 별칭 가능

# [2] DISTINCT , 조회 결과의 속성값 중복 제거
SELECT DISTINCT MADDR FROM member;

# [3] 산술연산자 : + - / * DIV(몫) MOD(나머지)
SELECT mnumber 인원수, mnumber+3 더하기, mnumber-3 빼기, mnumber/3 나누기, mnumber*3 곱하기, mnumber DIV 3 몫, mnumber MOD 3 나머지 FROM member;

# [4] 비교연산자 : = != > < >= <=
# [5] 논리연산자 : AND이면서 OR이거나 NOT부정
SELECT * FROM member WHERE mname = "블랙핑크";
SELECT * FROM member WHERE mnumber = 4;
SELECT * FROM member WHERE mname != "블랙핑크";
SELECT * FROM member WHERE NOT mname = "블랙핑크";  -- 블랙핑크가 같으면 반대!
SELECT * FROM member WHERE mheight <= 162;
SELECT * FROM member WHERE mheight >= 165 AND mheight <= 170;
SELECT * FROM member WHERE mheight BETWEEN 165 AND 170; -- 속성명 BETWEEN 시작값 AND 끝값
SELECT * FROM member WHERE maddr = '경기' OR maddr = '전남' OR maddr = '경남';
SELECT * FROM member WHERE maddr IN('경기', '전남', '경남');    -- 속성명 IN(값1, 값2, 값3)
SELECT * FROM member WHERE mphone1 = NULL;    -- DB에서 NULL 처리방법
SELECT * FROM member WHERE mphone1 IS NULL;     -- 주의할점 : =NULL X 대신 IS NULL O
SELECT * FROM member WHERE mphone1 IS NOT NULL; -- 속성값이 NULL이 아니면

-- 문자열 패턴 : 속성명 LIKE "문자패턴" , % : 모든문자대응 , _ : 개수만큼문자대응 
SELECT * FROM member WHERE mname LIKE "에이%";    -- 에이로 시작하는 모든 문자
SELECT * FROM member WHERE mname LIKE "에이_";    -- 에이로 시작하는 3글자 문자
SELECT * FROM member WHERE mname LIKE "%핑크";    -- 핑크로 끝나는 모든 문자
SELECT * FROM member WHERE mname LIKE "%이%";     -- '이'가포함된 모든문자 
SELECT * FROM member WHERE mname LIKE "_이__";    -- 두번째 글자가 '이'인 4글자