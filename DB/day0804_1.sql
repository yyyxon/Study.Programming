-- c + f2
-- create subquery 사용
-- cp_emp1 테이블을 생성하고
-- 사원테이블에서 모든 사원의 사원번호, 사원명, 부서번호, 입사일, 연봉을 조회하여
-- 추가하세요.

CREATE TABLE cp_emp1 as
(SELECT empno, ename, deptno, hiredate, sal
FROM emp);

-- user_constraints : 제약사항을 조회하는 DD (Data Dictionary)
SELECT *
FROM USER_CONSTRAINTS;

SELECT * FROM CP_EMP1;

-- cp_emp2 테이블을 생성하고
-- 사원테이블에서 부서번호가 10, 30번 부서의 
-- 사원번호, 사원명, 직무, 부서번호, 입사일, 연봉을 조회하여 추가
CREATE TABLE cp_emp2 AS (SELECT EMPNO, ENAME, JOB, DEPTNO, HIREDATE, SAL 
FROM EMP
WHERE DEPTNO IN (10,30));

SELECT *
FROM cp_emp2;

ALTER TABLE test_null MODIFY email varchar2(50) NOT NULL;

SELECT * FROM user_constraints WHERE table_name = 'TEST_NULL';

CREATE TABLE test_null2 AS (SELECT email FROM TEST_NULL);

SELECT * FROM user_constraints WHERE table_name in ('TEST_NULL2','TEST_NULL');

-- EMP테이블에 구조만 복사하여 CP_EMP3 테이블을 생성
-- 레코드가 검색되지 않도록 조회 : where절에 false가 나오도록
CREATE TABLE cp_emp3 AS (SELECT *
FROM EMP
WHERE 1=0);

SELECT *
FROM EMP 
WHERE 1=0; -- 항상 거짓(레코드 검색X)

SELECT *
FROM EMP
WHERE 1=1; -- 항상 참(전체 레코드)

SELECT * FROM CP_EMP3;

-- insert subquery 사용
-- 다른 컬럼의 값으로 추가해야할 때
-- cp_emp1 테이블에 사원 정보를 추가
-- 사원번호 : 1111, 사원명 : 김선경, 부서번호 : 10, 입사일 : 오늘, 
-- 연봉 : 사원번호가 7788인 사원의 연봉과 동일한 연봉으로 추가
-- 단수행 서브쿼리
INSERT INTO CP_EMP1 (EMPNO, ENAME, DEPTNO, HIREDATE, SAL) VALUES
(1111,'김선경',10,sysdate,(SELECT sal FROM emp WHERE empno = 7788));
COMMIT;
SELECT *
FROM CP_EMP1;

-- 사원번호 : 1112, 사원명 : 장용석, 부서번호 : cp_emp1 테이블의 김선경사원과 같은 부서
-- 입사일 : 내일, 연봉 : 김선경 사원과 같은 연봉
INSERT INTO CP_EMP1 (EMPNO, ENAME, DEPTNO, HIREDATE, SAL) VALUES
(1112, '장용석',(SELECT DEPTNO FROM CP_EMP1 WHERE ENAME='김선경'), SYSDATE+1,
(SELECT SAL FROM CP_EMP1 WHERE ENAME='김선경'));
COMMIT;

SELECT *
FROM CP_EMP1;

-- emp 테이블의 10번 부서의 모든 사원 정보를 cp_emp3 테이블에 추가
-- VALUES 생략
-- 복수행 서브쿼리
INSERT INTO CP_EMP3
(SELECT *
FROM EMP
WHERE DEPTNO = 10);

SELECT *
FROM CP_EMP3;

CREATE TABLE emp_sal(
	deptno number(2),
	total_sal NUMBER,
	input_date date
);

SELECT * FROM emp_sal;

-- emp테이블에 부서별 연봉 합을 조회하여 emp_sal 테이블에 추가
-- input_date는 추가하는 시점의 날짜 정보
INSERT INTO emp_sal(
SELECT DEPTNO, SUM(SAL), SYSDATE
FROM EMP
GROUP BY DEPTNO);

SELECT *
FROM EMP_SAL;