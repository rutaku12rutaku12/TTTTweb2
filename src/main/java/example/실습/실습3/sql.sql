DROP DATABASE IF EXISTS springweb2;
CREATE DATABASE springweb2;
USE springweb2;


-- --------------------------------------- 실습1 ----------------------------------------
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT, -- 상품 ID (자동 증가)
    product_name VARCHAR(255) NOT NULL,        -- 상품명
    stock_quantity INT NOT NULL                -- 재고 수량
);

INSERT INTO products (product_name, stock_quantity) VALUES
('무선 이어폰', 25),
('스마트워치', 12),
('게이밍 키보드', 30),
('기계식 마우스', 8),
('휴대용 충전기', 15);


-- --------------------------------------- day06 example ----------------------------------------
-- 학생 테이블
CREATE TABLE student (
    sno INT AUTO_INCREMENT,              -- 학생 번호 (자동 증가)
    name VARCHAR(50) NOT NULL,           -- 이름
    kor INT NOT NULL,                    -- 국어 점수
    math INT NOT NULL,                    -- 수학 점수
    CONSTRAINT  PRIMARY KEY (sno)  -- 기본키 제약 조건 추가
);

INSERT INTO student (name, kor, math) VALUES ('홍길동', 85, 90);
INSERT INTO student (name, kor, math) VALUES ('김철수', 78, 88);
INSERT INTO student (name, kor, math) VALUES ('이영희', 92, 95);
INSERT INTO student (name, kor, math) VALUES ('박지민', 70, 65);
INSERT INTO student (name, kor, math) VALUES ('최유리', 88, 82);

-- --------------------------------------- day07 boardService13 ----------------------------------------
create table board(
    bno int auto_increment ,
    bcontent longtext not null ,
    bwriter varchar(30) not null ,
    constraint primary key(bno)
);

# 샘플
INSERT INTO board (bcontent, bwriter) VALUES ('안녕하세요', '유재석');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘도 좋은 하루 되세요!', '김태호');
INSERT INTO board (bcontent, bwriter) VALUES ('점심 뭐 드셨나요?', '박명수');
INSERT INTO board (bcontent, bwriter) VALUES ('날씨가 참 좋네요', '정준하');
INSERT INTO board (bcontent, bwriter) VALUES ('이번 주말 계획은?', '하하');
INSERT INTO board (bcontent, bwriter) VALUES ('파이팅입니다!', '이광수');
INSERT INTO board (bcontent, bwriter) VALUES ('다들 행복하세요', '송지효');
INSERT INTO board (bcontent, bwriter) VALUES ('무한도전 그립다', '노홍철');
INSERT INTO board (bcontent, bwriter) VALUES ('커피 한 잔의 여유', '길');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘은 집에서 푹 쉬어요', '정형돈');
INSERT INTO board (bcontent, bwriter) VALUES ('운동은 하셨나요?', '김종국');
INSERT INTO board (bcontent, bwriter) VALUES ('영화 추천해 주세요', '양세찬');
INSERT INTO board (bcontent, bwriter) VALUES ('책 읽기 좋은 날이네요', '전소민');
INSERT INTO board (bcontent, bwriter) VALUES ('비가 와서 기분이 우울해요', '유희열');
INSERT INTO board (bcontent, bwriter) VALUES ('점심 메뉴 고민중...', '이효리');
INSERT INTO board (bcontent, bwriter) VALUES ('졸려요...', '강호동');
INSERT INTO board (bcontent, bwriter) VALUES ('주말까지 며칠 남았죠?', '이수근');
INSERT INTO board (bcontent, bwriter) VALUES ('야근은 너무 싫어요', '서장훈');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘 기온이 몇 도일까요?', '장도연');
INSERT INTO board (bcontent, bwriter) VALUES ('여름엔 역시 냉면', '홍진경');
INSERT INTO board (bcontent, bwriter) VALUES ('지금 듣는 노래는?', '장성규');
INSERT INTO board (bcontent, bwriter) VALUES ('퇴근하고 싶다', '이상민');
INSERT INTO board (bcontent, bwriter) VALUES ('다이어트는 내일부터', '박나래');
INSERT INTO board (bcontent, bwriter) VALUES ('버스 기다리는 중', '김숙');
INSERT INTO board (bcontent, bwriter) VALUES ('늦잠 잤어요', '이영자');
INSERT INTO board (bcontent, bwriter) VALUES ('스트레스 풀고 싶다', '유세윤');
INSERT INTO board (bcontent, bwriter) VALUES ('아이스 아메리카노 최고', '김신영');
INSERT INTO board (bcontent, bwriter) VALUES ('게임 하다 왔어요', '이홍기');
INSERT INTO board (bcontent, bwriter) VALUES ('일상 공유해요~', '김재중');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘 하루 어땠나요?', '장나라');
INSERT INTO board (bcontent, bwriter) VALUES ('마라탕 먹고 싶다', '현아');
INSERT INTO board (bcontent, bwriter) VALUES ('퇴근길 너무 막혀요', '정은지');
INSERT INTO board (bcontent, bwriter) VALUES ('곧 여행 가요!', '수지');
INSERT INTO board (bcontent, bwriter) VALUES ('카페에서 힐링 중', '아이유');
INSERT INTO board (bcontent, bwriter) VALUES ('노래 추천해 주세요~', '로제');
INSERT INTO board (bcontent, bwriter) VALUES ('배가 너무 고파요', '지수');
INSERT INTO board (bcontent, bwriter) VALUES ('헬스장 다녀왔어요', '제니');
INSERT INTO board (bcontent, bwriter) VALUES ('오늘도 화이팅!', '리사');
INSERT INTO board (bcontent, bwriter) VALUES ('운전 조심하세요~', '태연');

select * from board;

-- --------------------------------------- day09 boardService13 ----------------------------------------
CREATE TABLE trans(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    money INT UNSIGNED DEFAULT 0
);
-- 데이터 삽입
INSERT INTO trans (name, money) VALUES
('신동엽', 200000),
('서장훈', 200000);

select * from trans;
   -- 1. 책 테이블
    CREATE TABLE books (
        id INT NOT NULL AUTO_INCREMENT ,    -- 도서번호
        title VARCHAR(255) NOT NULL,        -- 도서 명
        stock INT NOT NULL DEFAULT 0,       -- 도서 재고
        PRIMARY KEY (id)
    );

    -- 2. 대출 기록 테이블
    CREATE TABLE rentals (
        id INT NOT NULL AUTO_INCREMENT ,            -- 대출기록 번호
        book_id INT NOT NULL,                       -- **참조**하는 도서번호
        member VARCHAR(100) NOT NULL,               -- 대출 한 사람
        rent_date DATETIME DEFAULT NOW(),           -- 대출 일
        return_date DATETIME NULL, -- 반납 일
        PRIMARY KEY (id),
        FOREIGN KEY (book_id) REFERENCES books(id)
    );

    -- 3. 샘플 데이터 (책 목록)
    INSERT INTO books (id, title, stock) VALUES (1, '자바의 정석', 3);
    INSERT INTO books (id, title, stock) VALUES (2, '스프링 인 액션', 2);
    INSERT INTO books (id, title, stock) VALUES (3, '토비의 스프링', 1);
    INSERT INTO books (id, title, stock) VALUES (4, '리액트 교과서', 5);

    -- 4. 샘플 데이터 (대출 기록)
    INSERT INTO rentals (id, book_id, member) VALUES (1, 1, '홍길동');

    -- 5. 확인용 조회 쿼리
    SELECT * FROM books;
    SELECT * FROM rentals;

