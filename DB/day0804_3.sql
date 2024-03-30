-- select 복수행 subquery
-- inline view를 사용한 조회 : 많은 양의 레코드에서 일부분만 잘라내서 볼 때
-- 바깥 쿼리는 안쪽 쿼리에서 조회된 결과(레코드,컬럼)만 사용할 수 있다.

SELECT salary
FROM (SELECT empno, ename, job, sal salary
FROM emp); -- 가상 테이블

-- 안 쪽 쿼리에서 함수나 연산자가 사용된 경우에는 alias를 붙여 일반 컬럼으로 만들고
-- 외부 쿼리에서 사용한다.
SELECT *
FROM (SELECT empno, ename, job, sal salary, nvl(comm,0) comm -- alias를 붙여 일반 컬럼처럼 사용
FROM emp);

-- rownum : 조회결과에 가상번호 부여하기
-- 사원테이블에서 번호, 사원번호, 사원명 조회
SELECT rownum, empno, ename
FROM emp;

-- 1번부터는 검색이 되나 그이외의 번호부터는 검색되지 않는다.
-- 사원 테이블에서 번호, 사원번호, 사원명을 조회
-- 단, 번호의 1~5번까지만 출력할 것
SELECT rownum, empno, ename
FROM EMP
WHERE rownum BETWEEN 1 AND 5;

-- 번호의 5~10번까지만 출력 -> 안됨!
-- 무조건 1번부터 검색해야 가능
SELECT rownum, empno, ename
FROM EMP
WHERE rownum BETWEEN 5 AND 10;

-- ORDER BY와 함께 사용되면 번호가 먼저 부여되고 정렬되기 때문에 번호가 섞인다.
SELECT ROWNUM, ENAME, SAL 
FROM EMP
ORDER BY SAL;

-- rownum은 select마다 각각 사용된다.
-- 서브쿼리를 사용하더라도 외부쿼리의 select으로 새로 생성됨
-- 이름의 오름차순으로 정렬하고, 정렬된 이름에 순차적인 번호를 부여
SELECT rownum, empno, ename
FROM (SELECT rownum , empno, ename
		  FROM emp
		  ORDER BY ename);

-- alias를 부여하면 안쪽 쿼리의 rownum을 사용할 수 있다.
SELECT rownum r, empno, ename
FROM (SELECT rownum r, empno, ename
		  FROM emp
		  ORDER BY ename);

-- 사원 테이블에서 가장 마지막에 입사한 사원부터 5명의 사원 정보를 조회
SELECT * 
FROM (SELECT empno, ename, hiredate, sal
		  FROM emp
		  ORDER BY hiredate DESC)
WHERE rownum <= 5;

-- 사원 테이블에서 가장 마지막에 입사한 이전 사원부터 5명의 사원 정보를 조회
-- 조회 컬럼 : 사원 번호, 사원명, 입사일, 연봉
-- 1. 가장 마지막에 입사한 사원한테 1번을 부여
-- 2. rownum은 1번부터만 비교된다. (문제 alias는 붙어있는 where절에서 사용할 수 없다.)
-- 3. 2번의 문제를 해결하기위해 (alias를 실제 컬럼처럼 사용하기 위해) inline view를 하나 더 만든다.
SELECT r2, empno, ename, hiredate, sal
FROM (SELECT rownum r2, empno, ename, hiredate, sal
		  FROM (SELECT empno, ename, hiredate, sal
		  			FROM emp
		  			ORDER BY hiredate DESC)
		  )
WHERE r2 BETWEEN 2 AND 6;

SELECT *
FROM (SELECT empno, ename, row_number() over(ORDER BY hiredate desc) rn, sal
		  FROM EMP)
WHERE rn BETWEEN 2 AND 6;
