-- 사원테이블에서 사원명이 'scott' 인 사원보다 연봉을 많이 받는 사원의 
-- 사원 번호, 사원명, 입사일, 연봉
SELECT empno, ename, hiredate, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

SELECT e.empno, e.ename, e.hiredate, e.sal, e1.empno, e1.ename
FROM emp e, emp e1
WHERE e.sal >= e1.sal AND e1.ename = 'SCOTT';

-----------------------------------------------------------------------------
-- sequence
-- 1~99999까지 1씩 증가하는 시퀀스 생성
CREATE SEQUENCE test_seq
START WITH 1 -- 시작값
MAXVALUE 99999 -- 끝값
INCREMENT BY 1; -- 증가값

SELECT * FROM user_sequences;

-- currval : 현재 번호, 시퀀스를 메모리에 올리는 일은 할 수 없다. (시퀀스가 메모리에 존재하지 않으면 실행 불가)
-- 접속자 세션이 종료되면 사라짐
SELECT test_seq.currval
FROM dual;

-- nextval : 다음 번호, 시퀀스가 메모리에 존재하지 않으면 메모리에 올리고 다음 번호를 얻음
SELECT test_seq.nextval
FROM dual;

DROP SEQUENCE test_seq;

SELECT * FROM user_sequences;

-- 10~9999990까지 10씩 증가하는 시퀀스, 메모리에는 100씩, 수가 모두 사용되면 반복
CREATE SEQUENCE test_seq
START WITH 10
MAXVALUE 9999990
INCREMENT BY 10
cache 100
CYCLE;

SELECT test_seq.nextval
FROM dual;

SELECT test_seq.currval
FROM dual;

-- insert 할 때 주로 사용
CREATE TABLE use_sequence (
	num NUMBER,
	name varchar2(30),
	CONSTRAINT PK_use_sequence PRIMARY KEY(num)
);

-- insert할 때 사용하는 sequence를 생성
CREATE SEQUENCE use_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999999
CYCLE;

-- sequnce를 사용한 INSERT 
-- 시퀀스는 oracle 11g부터 insert문에서 select 없이 바로 사용할 수 있다.
INSERT INTO use_sequence (num, name) VALUES (use_seq.nextval, '강다연');
INSERT INTO use_sequence (num, name) VALUES (use_seq.nextval, '김다영');
INSERT INTO use_sequence (num, name) VALUES (use_seq.nextval, '김인영');

SELECT * FROM use_sequence;

CREATE TABLE use_sequence2(
num char(8),
name varchar2(30),
CONSTRAINT pk_use_sequence2 PRIMARY KEY(num)
);

-- use_sequence2 테이블에 아래와 같은 형태의 증가하는 문자열을 추가
-- 번호 : S_000001, 이름 : 김주민, 다음 번호 박상준, 다음 번호 박서현
INSERT INTO use_sequence2 (num, name) VALUES ('S_' || lpad(use_seq2.nextval, 6, 0), '김주민');
INSERT INTO use_sequence2 (num, name) VALUES ('S_' || lpad(use_seq2.nextval, 6, 0), '박상준');
INSERT INTO use_sequence2 (num, name) VALUES (concat('S_', lpad(use_seq2.nextval, 6, 0)), '박서현');

CREATE SEQUENCE use_seq2
START WITH 1
MAXVALUE 99999999
INCREMENT BY 1;

SELECT *
FROM use_sequence2;