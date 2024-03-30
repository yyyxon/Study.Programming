-- update subquery
-- 다른 컬럼의 값을 참조하여 변경할 때 사용
-- cp_emp1 테이블의 사원번호가 1111번인 사원의 부서번호를,
-- cp_emp1 테이블의 사원번호가 7844인 사원의 부서번호로 변경

UPDATE CP_EMP1 
SET DEPTNO = (
SELECT DEPTNO 
FROM EMP
WHERE empno = 7844)
WHERE EMPNO = 1111;

SELECT *
FROM CP_EMP1;

-- 복수행이 사용되면 err
UPDATE CP_EMP1 
SET DEPTNO = (SELECT DEPTNO FROM CP_EMP1)
WHERE EMPNO = 1111;

-- cp_emp1 테이블의 사원번호가 emp테이블에 사원명이 'KING'인 사원과
-- 동일한 사원을 찾아 연봉을 김선경 사원과 동일한 연봉으로, 입사일을 장용석 사원과 동일한 입사일
SELECT EMPNO, ENAME, DEPTNO, HIREDATE, SAL
FROM CP_EMP1;

UPDATE cp_emp1
SET sal = (SELECT sal FROM cp_emp1 WHERE ename = '김선경'), 
	  hiredate = (SELECT hiredate FROM cp_emp1 WHERE ename = '장용석' )
WHERE empno = (SELECT empno FROM emp WHERE ename = 'KING');

SELECT *
FROM CP_EMP1;

-- where절에 in을 사용하면 복수행 서브쿼리도 가능
-- cp_emp1 테이블에 10번 부서에 해당하는 사원번호를 모두 검색하여
-- cp_emp1 테이블에서 해당하는 사원들의 연봉을 5000로 변경
UPDATE CP_EMP1
SET sal = 5000
WHERE empno IN (SELECT empno FROM emp WHERE deptno = 10);

-- delete subquery
-- emp 테이블에서 사원명이 'SCOTT'인 사원의 사원번호를 조회하여
-- cp_emp1 테이블에서 같은 사원번호를 사용하는 레코드를 삭제
DELETE
FROM cp_emp1
WHERE empno = (SELECT empno FROM emp WHERE ename = 'SCOTT');

-- 복수행 서브쿼리 안됨(IN 사용시 가능)
DELETE
FROM cp_emp1
WHERE empno IN (SELECT empno FROM emp WHERE deptno = 10);
COMMIT;

SELECT * FROM CP_EMP1;

-- emp 테이블에서 사원 번호가 7654인 사원이 입사한 연도를 조회하여
-- cp_emp1 테이블에서 같은 연도에 입사한 모든 사원 정보를 삭제
DELETE 
FROM CP_EMP1 
WHERE to_char(HIREDATE,'yyyy') = (SELECT to_char(HIREDATE,'yyyy')  FROM EMP WHERE EMPNO = 7654 );

SELECT * FROM CP_EMP1;

-- emp테이블에서 부서번호가 20,30인 부서에 근무하는 사원정보를 cp_emp1에 추가
INSERT INTO cp_emp1(
SELECT empno, ename, deptno, hiredate, sal
FROM emp
WHERE deptno IN (20,30)
);

-- select subquery
-- 단수행 서브쿼리
-- emp테이블에서 사원번호가 7698인 사원의 부서번호를 조회하여
-- cp_emp1 테이블에서 같은 부서에 근무하는 사원을 조회
-- 조회 컬럼 : 사원번호, 사원명, 부서번호, 연봉
SELECT empno, ename, deptno, sal
FROM cp_emp1
WHERE deptno = (SELECT deptno FROM emp WHERE empno = 7698);

-- scalar subquery
-- 사원번호, 사원명, 부서번호, 부서명을 조회
-- 단, 부서명은 dept 테이블에 존재하는 이름으로 출력
SELECT empno, ename, deptno, (SELECT dname FROM dept d WHERE d.deptno = e.deptno) dname
FROM emp e;

-- 사원 테이블에서 평균 연봉 이상인 사원의 사원번호, 사원명, 연봉을 조회
SELECT empno, ename, sal
FROM emp
WHERE sal >= (SELECT AVG(sal) FROM emp);

-- 사원 테이블에서 가장 많은 연봉을 받는 사원의 사원명 조회
SELECT ename
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

-- 사원 테이블에서 최고연봉과 최고연봉을 받는 사원명 조회
SELECT ename, sal
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);