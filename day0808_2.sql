-- cp_emp1 테이블에서 모든 사원의 이름을 소문자로 변경
UPDATE cp_emp1
SET ename = lower(ename);

UPDATE cp_emp1
SET ename = upper(ename)
WHERE empno IN (7698, 7521, 7788, 7900, 7902)

-- emp : 본사, cp_emp : 지사
-- 모든 본사 사원과 지사사원을 조회
-- 조회 컬럼 : 사원번호, 사원명, 부서번호, 입사일, 연봉
-- 대소문자 구별함
-- union : 중복 데이터를 보여주지 않는다.
-- union all : 중복 데이터를 보여준다.
SELECT empno, ename, deptno, hiredate, sal
FROM emp
UNION 
SELECT empno, ename, deptno, hiredate, sal
FROM cp_emp1;

SELECT empno, ename, deptno, hiredate, sal
FROM emp
UNION ALL
SELECT empno, ename, deptno, hiredate, sal
FROM cp_emp1;

-- 본사 사원과 지사 사원 조회
-- 단, 같은 레코드는 하나만 출력
SELECT empno, ename, deptno, hiredate, sal
FROM emp
UNION 
SELECT empno, ename, deptno, hiredate, sal
FROM cp_emp1;

-- 에러
-- 컬럼의 수가 맞지 않는 경우
SELECT empno, ename, deptno, hiredate, sal
FROM emp
UNION 
SELECT empno, ename, deptno, hiredate
FROM cp_emp1;
-- 컬럼의 데이터형이 맞지 않는 경우
SELECT empno, ename
FROM emp
UNION 
SELECT ename, empno
FROM cp_emp1;
-- 컬럼명이 다른 경우에는 에러가 발생하지 않는다.
-- 데이터형만 맞으면 됨
SELECT empno, ename, deptno, hiredate, sal
FROM cp_emp2
UNION 
SELECT deptno, ename, empno, hiredate, sal
FROM emp;

SELECT *
FROM tab;

-- 우편번호 테이블에서 동 이름이 '마계동'인 우편번호, 시도, 구군, 동, 번지를 조회
-- 접속 계정이 생성한 테이블명을 함께 조회
SELECT ZIPCODE, SIDO, GUGUN, DONG, BUNJI
FROM ZIPCODE
WHERE INSTR(DONG, '마계동') <> 0
UNION
SELECT tname, '0', '0', '0', '0'
FROM tab;

