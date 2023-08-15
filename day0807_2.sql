-- 여러개의 컬럼이 하나의 PK로 구성
CREATE TABLE primary_multi(
	id varchar2(20),
	num number(6),
	name varchar2(30),
	hiredate DATE,
	
	CONSTRAINT PK_primary_multi PRIMARY KEY(id,num)
);

SELECT * FROM user_constraints WHERE table_name = 'PRIMARY_MULTI';

SELECT * FROM user_cons_columns WHERE table_name = 'PRIMARY_MULTI';

---------------- INSERT 성공 ----------------
-- 최초 데이터 입력
INSERT INTO primary_multi (id, num, name, hiredate)
VALUES ('kim',1,'김주민',sysdate);

-- PK컬럼에 다른 값이 들어가는 경우
INSERT INTO primary_multi (id, num, name, hiredate)
VALUES ('kim',2,'김주민',sysdate);

INSERT INTO primary_multi (id, num, name, hiredate)
VALUES ('park',2,'김주민',sysdate);

---------------- INSERT 실패 ----------------
-- 이전 레코드와 동일한 값이 입력되는 경우
INSERT INTO primary_multi (id, num, name, hiredate)
VALUES ('kim',1,'홍찬영',sysdate+1);

-- NULL이 입력
-- id에 null 입력 => 컬럼명 생략, '' 입력
INSERT INTO primary_multi (name, hiredate)
VALUES ('홍찬영',sysdate+1);

INSERT INTO primary_multi (id, num, name, hiredate)
VALUES ('',0,'홍찬영',sysdate+1);

-- num에 null 입력 => 컬럼명 생략
INSERT INTO primary_multi (id, name, hiredate)
VALUES ('hong','홍찬영',sysdate+1);

SELECT * FROM primary_multi;

-- Foreign key
-- 자식 테이블의 컬럼명은 부모테이블의 컬럼명과 같은 필요는 없으나 대부분 같게 설정한다.
-- 데이터형은 반드시 같아야한다.
-- 컬럼 단위 제약
CREATE TABLE FOREIGN_COLUMN (
	id varchar2(20) CONSTRAINT FK_FOREIGN_COLUMN_ID REFERENCES PRIMARY_COLUMN(id),
	age number(3)
);

-------------------------------- INSERT 성공 --------------------------------
-- 부모테이블에 존재하는 값 또는 null일 때 성공
-- 부모 테이블의 PK 컬럼 값으로만 추가될 때
SELECT *
FROM PRIMARY_COLUMN;

INSERT INTO FOREIGN_COLUMN (id,age) VALUES('kim',20);
INSERT INTO FOREIGN_COLUMN (id,age) VALUES('kim',21);
INSERT INTO FOREIGN_COLUMN (id,age) VALUES('kim',22);
INSERT INTO FOREIGN_COLUMN (id,age) VALUES('park',22);

-- null이 입력될 때
INSERT INTO FOREIGN_COLUMN (id,age) VALUES('',22);
INSERT INTO FOREIGN_COLUMN (age) VALUES(32);

SELECT *
FROM FOREIGN_COLUMN;
-------------------------------- INSERT 실패 --------------------------------
-- 부모 테이블에 존재하지 않는 값으로 레코드를 추가할 때
INSERT INTO FOREIGN_COLUMN (id,age) VALUES('hong',22);

-- 테이블 단위 제약사항
-- 참조 컬럼명을 다르게 설정
CREATE TABLE FOREIGN_TABLE(
	r_id VARCHAR2(20),
	age NUMBER(3),
	CONSTRAINT FK_FOREIGN_TABLE_R_ID FOREIGN KEY(r_id) REFERENCES PRIMARY_TABLE(id)
);

SELECT *
FROM user_constraints
WHERE constraint_type = 'R';

-- 일반 컬럼은 Foreign key로 참조할 수 없다.
CREATE TABLE cp_emp_test (
empno number(4) CONSTRAINT fk_cp_emp_empno REFERENCES cp_emp1(empno),
zipcode char(7)
);