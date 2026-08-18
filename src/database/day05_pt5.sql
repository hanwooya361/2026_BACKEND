-- 아래 샘플 SQL 전체 실행 : ctrl+shift+enter
DROP DATABASE IF EXISTS practice5;
CREATE DATABASE practice5;
USE practice5;
-- 1. 카테고리 테이블
CREATE TABLE pcategory(
    카테고리번호_pk INT UNSIGNED AUTO_INCREMENT,
    카테고리명 VARCHAR(10) NOT NULL,
    PRIMARY KEY(카테고리번호_pk)
);
-- 2. 제품 테이블
CREATE TABLE product(
    제품번호_pk INT UNSIGNED AUTO_INCREMENT,
    제품명 VARCHAR(100) NOT NULL,
    제품가격 INT UNSIGNED NOT NULL,
    카테고리번호_fk INT UNSIGNED,
    PRIMARY KEY(제품번호_pk),
    FOREIGN KEY(카테고리번호_fk) REFERENCES pcategory(카테고리번호_pk)
);
-- 3. 재고 테이블
CREATE TABLE stock(
    재고번호_pk INT UNSIGNED AUTO_INCREMENT,
    재고수량 INT,
    재고등록날짜 DATETIME DEFAULT NOW(),
    제품번호_fk INT UNSIGNED,
    PRIMARY KEY(재고번호_pk),
    FOREIGN KEY(제품번호_fk) REFERENCES product(제품번호_pk)
);

-- 샘플 데이터 삽입
INSERT INTO pcategory(카테고리명) VALUES('노트북'), ('스마트폰'), ('의류'), ('도서');
INSERT INTO product(제품명, 제품가격, 카테고리번호_fk) VALUES
('그램 15인치', 1500000, 1), ('맥북 프로 16인치', 3000000, 1),
('갤럭시 S23', 1200000, 2), ('아이폰 14 Pro', 1550000, 2),
('반팔 티셔츠', 30000, 3), ('청바지', 80000, 3),
('혼공 SQL', 22000, 4);
INSERT INTO stock(재고수량, 제품번호_fk) VALUES (10, 1), (5, 2), (20, 3), (15, 4), (100, 5), (50, 6),(5, 1), (2, 3);


-- [문제 1] 모든 제품의 제품명과 해당 제품의 카테고리명을 함께 조회하세요.
SELECT 제품명 FROM product; -- 모든 제품의 제품명
-- SELECT 제품명 , 카테고리명 FROM product; -- 카테고리명은 다른테이블에 위치한다. 해결: 조인하면 된다.
SELECT 제품명, 카테고리명 FROM product p INNER JOIN pcategory pc ON p.카테고리번호_fk = pc.카테고리번호_pk;
-- [문제 2] '노트북' 카테고리에 속하는 모든 제품의 제품명과 제품가격을 조회하세요.
SELECT * FROM pcategory pc WHERE 카테고리명 = '노트북'; -- 카테고리에 '노트북'
SELECT 제품명, 제품가격 FROM pcategory pc 
    INNER JOIN product p ON pc.카테고리번호_pk = p.카테고리번호_fk 
    WHERE pc.카테고리명 = '노트북';
-- [문제 3] 모든 제품의 제품명과 등록된 재고수량을 함께 조회하세요.
SELECT 제품명, 재고수량 FROM product p INNER JOIN stock s ON p.제품번호_pk = s.제품번호_fk;

-- [문제 4] '그램 15인치' 제품의 모든 재고등록날짜와 재고수량을 조회하세요. 
-- 3번 코드 복사.
SELECT 재고등록날짜 , 재고수량  FROM product p 
    INNER JOIN stock s ON p.제품번호_pk = s.제품번호_fk
    WHERE p.제품명 = '그램 15인치';

-- [문제 5] 모든 제품의 제품명, 카테고리명, 재고수량을 한 번에 조회하세요. (3개 테이블 조인) 
SELECT * FROM pcategory pc 
    INNER JOIN product p ON pc.카테고리번호_pk = p.카테고리번호_fk
    INNER JOIN stock s ON p.제품번호_pk = s.제품번호_fk;

-- [문제 6] 모든 카테고리의 카테고리명과 해당 카테고리에 속한 제품명을 조회하세요. 만약 카테고리에 속한 제품이 없더라도 카테고리명은 모두 표시되도록 하세요.
SELECT 카테고리명, 제품명 FROM PCATEGORY PC
    LEFT JOIN PRODUCT P ON PC.카테고리번호_PK = P.카테고리번호_FK;
-- [문제 7] 재고가 한 번도 등록되지 않은 제품의 제품명을 조회하세요.
DESC PRODUCT
--

SELECT P.제품명 FROM PRODUCT P 
    LEFT JOIN STOCK S ON P.제품번호_PK = S.제품번호_FK WHERE S.제품번호_FK IS NULL;
-- [문제 8] 각 카테고리별로 총 재고 수량의 합계를 카테고리명과 함께 조회하세요. 
SELECT PC.카테고리명, SUM(S.재고수량) AS 총재고수량 FROM PCATEGORY PC
    INNER JOIN PRODUCT P ON PC.카테고리번호_PK = P.카테고리번호_FK
    INNER JOIN STOCK S ON P.제품번호_PK = S.제품번호_FK GROUP BY PC.카테고리명;
-- [문제 9] 각 제품별로 총 재고 수량을 조회하고, 총 재고 수량이 많은 순서대로 정렬하여 제품명과 총재고수량을 표시하세요.
SELECT p.제품명, SUM(S.재고수량) AS 총재고수량 FROM PRODUCT P 
    INNER JOIN STOCK S ON P.제품번호_PK = S.제품번호_FK GROUP BY P.제품명 ORDER BY 총재고수량 DESC;