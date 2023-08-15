-- UNIQUE
-- 컬럼 단위
CREATE TABLE unique_column (
	name varchar2(30),
	email varchar2(50) CONSTRAINT uk_unique_column_email unique
);

-------------------------------- INSERT 성공 --------------------------------
-- 최초 입력
INSERT INTO UNIQUE_COLUMN (name, email)
VALUES ('박상준','park@test.com');

-- 다른 값으로 추가
INSERT INTO UNIQUE_COLUMN (name, email)
VALUES('박상준','kim@test.com');

-- null 입력
INSERT INTO UNIQUE_COLUMN (name, email)
VALUES('박상준','');

INSERT INTO UNIQUE_COLUMN (name, email)
VALUES('송지하','');

INSERT INTO UNIQUE_COLUMN (name)
VALUES('송지상');

SELECT *
FROM UNIQUE_COLUMN;
-------------------------------- INSERT 실패 --------------------------------
-- 중복값 입력
INSERT INTO UNIQUE_COLUMN (name, email)
VALUES('홍찬영','kim@test.com');
------------------------------------------------------------------------------

-- 테이블 단위
CREATE TABLE UNIQUE_TABLE (
name varchar2(30),
phone varchar2(13),
CONSTRAINT uk_unique_table_phone UNIQUE(phone)
);

SELECT *
FROM UNIQUE_TABLE;

-- UNIQUE로 FK 설정
CREATE TABLE FOREIGN_UNIQUE(
email varchar2(50) CONSTRAINT fk_foreign_unique_email REFERENCES unique_column(email)
);

-------------------------------- INSERT 성공 --------------------------------
-- 부모 테이블에 존재하는 값 추가
INSERT INTO FOREIGN_UNIQUE (email)
VALUES ('park@test.com');

INSERT INTO FOREIGN_UNIQUE (email)
VALUES ('kim@test.com');

-- null 입력
INSERT INTO FOREIGN_UNIQUE (email)
VALUES('');

SELECT *
FROM FOREIGN_UNIQUE;
-------------------------------- INSERT 실패 --------------------------------
-- 중복값 입력
INSERT INTO UNIQUE_COLUMN (email)
VALUES('park@test.com');

-- 부모 테이블에 존재하지 않는 값으로 추가
INSERT INTO FOREIGN_UNIQUE (email)
VALUES ('park1@test.com');

------------------------ check, not null, default ------------------------
-- 나이 : 20~30대까지만 입력가능
-- 이름 : 반드시 입력
-- 입력일 : 컬럼이 생략되면 현재 날짜로 입력
CREATE TABLE other_constraints(
age number(2) check(age >= 20 AND age < 40), -- age BETWEEN 20 AND 39
name varchar2(30) NOT NULL,
input_date DATE DEFAULT sysdate
);

SELECT *
FROM USER_CONSTRAINTS
WHERE CONSTRAINT_type = 'C';

SELECT *
FROM USER_TAB_COLS
WHERE table_name = 'OTHER_CONSTRAINTS';

SELECT *
FROM OTHER_CONSTRAINTS;
-------------------------------- INSERT 성공 --------------------------------
-- 나이가 20~30대이고, 이름이 있고, 입력일이 있는 경우
INSERT INTO OTHER_CONSTRAINTS(age, name, input_date)
VALUES(25, '홍찬영', '2023-08-06'); 

-- 나이가 20~30대이고, 이름이 있고, 입력일이 생략된 경우
INSERT INTO OTHER_CONSTRAINTS(age, name)
VALUES(25, '홍찬영'); 

-------------------------------- INSERT 실패 --------------------------------
-- 나이가 20~30대가 아닌 경우
INSERT INTO OTHER_CONSTRAINTS(age, name)
VALUES(19,'홍찬영');

INSERT INTO OTHER_CONSTRAINTS(age, name)
VALUES(40,'홍찬영');

-- 이름에 NULL이 추가되는 경우
INSERT INTO OTHER_CONSTRAINTS(age, name)
VALUES(25,'');

INSERT INTO OTHER_CONSTRAINTS(age)
VALUES(40);

-- 일반 컬럼은 Foreign key로 참조할 수 없다.
CREATE TABLE cp_emp_fk_test(
empno number(4) CONSTRAINT fk_cp_
);