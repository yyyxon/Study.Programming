--alias 사용

--사원테이블에서 사원번호, 사원명, 직무, 부서번호 검색
--단, 사원번호는 emp_no로, 사원명은 emp_name으로, 부서번호는 dept_no
--로 출력할 것.

SELECT  empno as emp_no, ename emp_name, job, deptno dept_no
FROM  emp;


-----------------------연산자-------------------------------
--문자열 붙임 : ||
--사원테이블에서 사원명, 연봉을 조회
--단, 출력은 xxx님의 연봉은 xxx입니다.

SELECT  ename || '님의 연봉은 ' || sal || '입니다.' "output"
FROM  emp;

SELECT   empno || ename || sal || mgr
FROM    emp;


--산술 : + , - , * , /

--사원 테이블에서 사원 번호, 사원명, 연봉을 조회
--단, 사원번호는 현재 번호에서 1 증가한 값으로 조회할 것.
SELECT empno, empno +1 increment_num, ename, sal
FROM  EMP;

-- 사원 테이블에서 사원번호, 사원명, 매니저 번호, 연봉, 세금을 조회
--단, 세금은 연봉의 3.3%로 연산한 값을 출력
SELECT  empno,ename, mgr, sal, sal *0.033 tax
FROM  EMP;

-- null은 연산하면 결과가 null로 나온다.
-- 사원 테이블에서 사원명, 연봉, 보너스, 총 수령액 조회
-- 단, 총 수령액은 연봉과 보너스를 합산한 금액
SELECT ename, sal, comm, sal+comm as total
FROM emp;

-- 사원 테이블에서 사원번호, 매니저번호, 사원명, 연봉, 월급을 조회
-- 단, 월급은 연봉을 12로 나눈 값
SELECT *
FROM emp;

SELECT empno, mgr, ename, sal, ROUND(sal/12) as mon_sal
FROM emp;

-- 나머지 값은 mod함수를 사용하여 연산한다.
-- 사용법) MOD(컬럼명,나눌값)

-- 사원 테이블에서 사원번호, 사원번호를 2로 나눈 나머지를 조회
SELECT empno, MOD(empno,2)
FROM emp;

-- 산술 연산자가 아닌 다른 연산자를 조회 컬럼에 사용하면 error
SELECT sal
FROM emp
WHERE sal > 2000;

-- 관계 연산자
-- 사원 테이블에서 사원 번호가 7844인 사원의 사원번호, 사원명,
-- 직무, 연봉, 입사일
SELECT empno, ename, job, sal, hiredate
FROM emp
WHERE empno = 7844;

-- 사원 테이블에서 연봉이 1250을 초과하는 사원들의
-- 사원번호, 사원명, 연봉, 입사일, 부서번호, 보너스
SELECT empno, ename, sal, hiredate, deptno, comm
FROM emp
WHERE sal >= 1250;

-- 사원 테이블에서 연봉이 3000 미만인 사원들의
-- 사원번호, 사원명, 연봉, 입사일, 부서번호, 보너스
SELECT empno, ename, sal, hiredate, deptno, comm
FROM emp
WHERE sal < 3000;

-- 사원 테이블에서 10번 부서가 아닌 모든 부서 사원의
-- 부서번호, 사원번호, 사원명, 연봉을 조회
SELECT deptno, empno, ename, sal
FROM emp
WHERE deptno <> 10;
-- WHERE deptno != 10;
-- !=는 <>로 사용가능

SELECT deptno, empno, ename, sal
FROM emp
WHERE deptno not in 10;

-- 사원 테이블에서 연봉이 2450~3000 사이인 모든 사원의
-- 사원번호, 사원명, 연봉, 매니저번호, 입사일을 조회
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal BETWEEN 2450 AND 3000;
-- WHERE sal >= 2450 AND sal <= 3000;

-- BETWEEN은 작은값이 먼저 나와야한다.
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal BETWEEN 3000 AND 2450;

-- 연산자를 사용하면 조건만 맞으면 검색이 된다.
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal <= 3000 AND sal >= 2450;

-- 사원테이블에서 사원 번호가 7521, 7566, 7788인 사원들의
-- 사원번호, 사원명, 직무, 연봉을 조회
SELECT empno, ename, job, sal
FROM emp
WHERE empno = 7521 OR empno = 7566 OR empno = 7788;

SELECT empno, ename, job, sal
FROM emp
WHERE empno IN (7521, 7566, 7788);

-- 사원테이블에서 사원명이 KING, ADAMS, FORD인 사원의 사원번호,
-- 사원명, 입사일, 연봉을 조회
SELECT '사원명 [' || ename || '] 입사정보 [' || hiredate || '] 연봉 [' || sal || ']' as output
FROM emp
WHERE ename IN ('KING', 'ADAMS', 'FORD');
