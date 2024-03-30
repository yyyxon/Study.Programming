-- 문자열 함수
-- replace(컬럼명, 찾을값, 치환할값)

SELECT replace('ABCDE','C','KK')
FROM dual;

SELECT replace('키보 드',' ','')
FROM dual;

-- Primary key
-- 컬럼에서 null을 허용하지 않으면서 값이 유일해야할 때 사용
-- 컬럼 단위 - 아이디, 이름, 주소를 저장하는 테이블 생성
-- 테이블의 컬럼은 기본속성으로 null을 허용하면서 중복값도 허용한다.
CREATE TABLE primary_column(
-- id varchar(20) CONSTRAINT PRIMARY KEY /* 제약사항명이 자동으로 부여 */
	id varchar2(20) CONSTRAINT PK_primary_column PRIMARY KEY,
	name varchar2(30) NULL,
	addr varchar2(300)
);

-- DD에서 확인
SELECT *
FROM user_constraints
WHERE CONSTRAINT_TYPE = 'P';

-- 제약사항명이 설정되어있는 테이블
INSERT INTO dept(deptno, dname, loc) VALUES (10, '개발부', '서울');

-- 제약사항명이 설정되어있지 않는 테이블
INSERT INTO primary_column(id,name,ADDR) VALUES ('park','박상준','서울');

---------------- INSERT 성공 ----------------
-- 최초 데이터 입력
INSERT INTO PRIMARY_COLUMN(id, name, addr) VALUES ('kim','김주민','서울시');

-- ID컬럼에 중복되지 않는 데이터 입력
INSERT INTO PRIMARY_COLUMN(id, name, addr) VALUES ('kim1','김선경','인천시');

-- 다른 컬럼에는 PK컬럼과 같은 값이 들어있어도된다.
INSERT INTO PRIMARY_COLUMN(id, name, addr) VALUES ('park','kim1','인천시');

---------------- INSERT 실패 ----------------
-- 중복데이터 입력 : park은 이미 존재하므로 err
INSERT INTO PRIMARY_COLUMN(id, name, addr) VALUES ('park','홍찬영','경기도');

-- NULL이 입력
-- number, date => 컬럼명을 생략하면 null
-- varchar2, char => 컬럼명을 생략하거나, insert할 때 ''를 넣으면 null

-- 컬럼명을 생략하는 경우
INSERT INTO PRIMARY_COLUMN(name, addr) VALUES ('홍찬영','경기도');

-- ''를 입력하는 경우
INSERT INTO PRIMARY_COLUMN(id, name) VALUES ('','경기도');

SELECT * FROM PRIMARY_COLUMN;
------------------------------------------------------------------------------------
-- 테이블단위 제약사항
CREATE TABLE PRIMARY_TABLE (
id varchar2(20),
name varchar2(30),
addr varchar2(300),
CONSTRAINT PK_PRIMARY_TABLE PRIMARY KEY (id)
);

SELECT * FROM PRIMARY_TABLE;

-- PRIMARY_TABLE의 constraint 조회
SELECT * FROM user_constraints WHERE table_name = 'PRIMARY_TABLE';

-- 제약사항이 설정된 컬럼 조회 
-- DD : user_cons_columns
SELECT * FROM user_cons_columns;

-- PK생성시 인덱스도 같이 생성됨
-- DD : user_indexes
SELECT * FROM user_indexes;

-- 테이블의 컬럼 정보 (컬럼명, 데이터형, 크기 등)
-- DD : user_tab_cols
SELECT * FROM user_tab_cols WHERE table_name = 'EMP';
