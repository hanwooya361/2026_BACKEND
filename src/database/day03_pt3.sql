-- 아래 샘플 SQL 전체 실행 : ctrl+shift+enter

DROP DATABASE IF EXISTS practice3;

CREATE DATABASE practice3;

USE practice3;


-- 1. 도서 테이블

CREATE TABLE books (

    book_id      INT NOT NULL,                   -- 도서번호

    title        VARCHAR(50) NOT NULL,           -- 제목

    author       VARCHAR(20) NOT NULL,           -- 저자

    genre        VARCHAR(10) NOT NULL,           -- 장르

    price        INT NOT NULL,                   -- 가격

    stock        INT,                            -- 재고

    pub_date     DATE,                           -- 출판일

    CONSTRAINT PRIMARY KEY (book_id)           -- 기본키 제약조건

);


-- 2. 주문 테이블

CREATE TABLE orders (

    order_id     INT AUTO_INCREMENT,             -- 주문번호

    book_id      INT NOT NULL,                   -- 도서번호 (FK)

    customer     VARCHAR(20) NOT NULL,           -- 고객명

    order_qty    INT NOT NULL,                   -- 주문수량

    order_date   DATE,                           -- 주문일

    CONSTRAINT PRIMARY KEY (order_id),         -- 기본키 제약조건

    CONSTRAINT FOREIGN KEY (book_id) REFERENCES books(book_id) on delete cascade  -- 외래키 제약조건

);


-- 샘플 데이터 삽입

INSERT INTO books VALUES(1001, '혼공 SQL', '우재남', '컴퓨터', 22000, 15, '2020-01-01');

INSERT INTO books VALUES(1002, '이것이 자바다', '신용권', '컴퓨터', 30000, 30, '2018-05-20');

INSERT INTO books VALUES(1003, '불편한 편의점', '김호연', '소설', 14000, 5, '2021-04-20');

INSERT INTO books VALUES(1004, '달러구트 꿈 백화점', '이미예', '소설', 13800, 25, '2020-07-08');

INSERT INTO books VALUES(1005, '트렌드 코리아 2023', '김난도', '경제', 19000, 50, '2022-10-05');

INSERT INTO books VALUES(1006, '원씽(The One Thing)', '게리 켈러', '자기계발', 14000, 12, '2013-08-20');

INSERT INTO books VALUES(1007, '역사의 쓸모', '최태성', '역사', 16000, 0, '2018-11-26');

INSERT INTO books VALUES(1008, '파친코', '이민진', '소설', 15800, 3, '2022-07-14');

INSERT INTO books VALUES(1009, 'Do it! 점프 투 파이썬', '박응용', '컴퓨터', 18800, NULL, '2019-06-20');

INSERT INTO books VALUES(1010, '코스모스', '칼 세이건', '과학', 19500, 8, '2006-12-20');

INSERT INTO books VALUES(1011, '혼공 JAVA', '우재남', '컴퓨터', 24000, 17, '2019-01-01');


INSERT INTO orders VALUES(NULL, 1001, '김민준', 2, '2023-01-15');

INSERT INTO orders VALUES(NULL, 1002, '이서연', 1, '2023-01-18');

INSERT INTO orders VALUES(NULL, 1003, '박지훈', 1, '2023-02-01');

INSERT INTO orders VALUES(NULL, 1004, '김민준', 3, '2023-02-05');

INSERT INTO orders VALUES(NULL, 1005, '최수아', 1, '2023-02-11');

INSERT INTO orders VALUES(NULL, 1001, '박지훈', 1, '2023-02-12');

INSERT INTO orders VALUES(NULL, 1008, '이서연', 2, '2023-03-02');

INSERT INTO orders VALUES(NULL, 1009, '정현우', 5, '2023-03-05');

INSERT INTO orders VALUES(NULL, 1002, '김민준', 2, '2023-03-10');

INSERT INTO orders VALUES(NULL, 1006, '최수아', 1, '2023-04-01');

INSERT INTO orders VALUES(NULL, 1003, '박지훈', 3, '2023-04-02');

INSERT INTO orders VALUES(NULL, 1001, '이서연', 1, '2023-04-08');

INSERT INTO orders VALUES(NULL, 1005, '김민준', 2, '2023-04-15');

INSERT INTO orders VALUES(NULL, 1004, '정현우', 1, '2023-04-20');

INSERT INTO orders VALUES(NULL, 1008, '최수아', 1, '2023-05-01');

INSERT INTO orders VALUES(NULL, 1010, '박지훈', 2, '2023-05-05');

INSERT INTO orders VALUES(NULL, 1002, '최수아', 1, '2023-05-12');

INSERT INTO orders VALUES(NULL, 1006, '이서연', 2, '2023-05-20');

INSERT INTO orders VALUES(NULL, 1009, '김민준', 1, '2023-06-01');

INSERT INTO orders VALUES(NULL, 1001, '정현우', 3, '2023-06-07');

INSERT INTO orders VALUES(NULL, 1003, '이서연', 2, '2023-06-15');

INSERT INTO orders VALUES(NULL, 1005, '박지훈', 1, '2023-07-01');

INSERT INTO orders VALUES(NULL, 1010, '김민준', 1, '2023-07-03');

INSERT INTO orders VALUES(NULL, 1004, '최수아', 2, '2023-07-10');

-- 1.
INSERT INTO books VALUES(1012, 'MYSQL 실습', '김민수', '컴퓨터', 17000, 25, '2023-03-01');
-- 2.
INSERT INTO books VALUES(1013, '데이터베이스 개론', '이영희', '컴퓨터', 22000, NULL, '2023-03-01');
-- 3.
INSERT INTO orders(book_id, customer, order_qty, order_date) VALUES(1002, '최지훈', 1, '2023-08-15');
-- 4.
UPDATE books SET price = 15000 WHERE book_id = 1004; 
-- 5.
UPDATE BOOKS SET PRICE = PRICE + 2000 WHERE GENRE = '소설';
-- 6.
UPDATE books SET stock = 0 WHERE stock IS NULL;
-- 7.
DELETE FROM orders WHERE customer = '이서연';
-- 8.
DELETE FROM books WHERE stock <= 0;
-- 9.
DELETE FROM orders WHERE order_qty >= 3;
-- 10.
SELECT * FROM books;
-- 11.
SELECT title, price FROM books;
-- 12.
SELECT title, price FROM books WHERE price > 20000;
-- 13.
SELECT title, price, stock FROM books WHERE price > 15000 AND stock >= 10;
-- 14.
SELECT TITLE, GENRE FROM BOOKS WHERE GENRE = '컴퓨터' OR GENRE = '경제';
-- 15.
SELECT * FROM BOOKS WHERE NOT GENRE = '소설';
-- 16.
SELECT TITLE, STOCK FROM BOOKS WHERE STOCK IS NULL;
-- 17.
SELECT TITLE, STOCK FROM BOOKS WHERE STOCK IS NOT NULL;
-- 18.
SELECT TITLE, PRICE FROM BOOKS WHERE PRICE BETWEEN 14000 AND 18000;
-- 19.
SELECT TITLE, AUTHOR FROM BOOKS WHERE TITLE LIKE "%자%";
-- 20.
SELECT TITLE, AUTHOR FROM BOOKS WHERE AUTHOR LIKE "김__";