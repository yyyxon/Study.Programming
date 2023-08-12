-- 중복배제
-- DISTINCT, GROUP BY로 할 수 있다.

-- 사원테이블에서 매니저 번호를 조회
-- 단, 중복된 매니저 번호는 출력하지 않는다.
-- DISTINCT
-- DISTINCT는 중복 배제를 하지 않은 다른 컬럼과 같이 사용해도
-- 에러가 발생하지 않는다. (중복배제를 하지 않는다.)
-- 중복값이 없는 컬럼과 함께 사용하면 중복배제를 하지 않는다.
-- 중복값이 있는 컬럼과 함께 사용하면 앞의 컬럼에 대해 중복배제 수행
SELECT DISTINCT mgr, deptno
FROM emp;

-- GROUP BY
-- GROUP BY 식에 정의되지 않은 컬럼이 SELECT 컬럼에 사용되면 ERROR 발생
SELECT mgr
FROM emp
GROUP BY mgr;

-- 중복값이 없는 컬럼과 함께 사용하면 중복배제를 하지 않는다.
SELECT mgr, ename
FROM emp
GROUP BY mgr, ename;

-- 중복값이 있는 컬럼과 함께 사용하면 앞의 컬럼에 대해 중복배제 수행
SELECT mgr, deptno
FROM emp
GROUP BY mgr, deptno;


-- GROUP BY HAVING : 그룹으로 묶여지는 조건을 설정
-- 사원 테이블에서 사원수가 3명 이상인 부서의 부서번호를 검색
SELECT deptno, count(deptno)
FROM emp
GROUP BY deptno
HAVING count(deptno) >= 3;

-- 사원 테이블에서 10번 부서가 아닌 부서의 부서번호
SELECT deptno         -- 4. 조회
FROM emp              -- 1. emp 테이블에서
GROUP BY deptno    		-- 3. 그룹으로 묶고
HAVING deptno != 10;  -- 2. 10번 부서가 아닌 부서만

SELECT deptno         -- 4. 조회
FROM emp              -- 1. emp 테이블에서
WHERE deptno != 10    -- 2. 10번 부서가 아닌 부서만 조회
GROUP BY deptno;    	-- 3. 그룹으로 묶은 후

-------------------------------- 정렬 --------------------------------
-- 숫자 정렬
-- 사원테이블에서 사원번호, 사원명, 연봉을 검색
-- 단, 연봉의 오름차순으로 정렬하여 조회
SELECT empno, ename, sal
FROM emp
ORDER BY sal;

-- 사원테이블에서 사원번호, 사원명, 연봉을 검색
-- 단, 사원명의 내림차순으로 정렬하여 조회
SELECT empno, ename, sal
FROM emp
ORDER BY ename desc;

-- 사원테이블에서 사원번호, 사원명, 연봉을 검색
-- 단, 연봉의 오름차순으로 정렬하여 조회, 같은 연봉이 존재하면
-- 사원명의 오름차순으로 정렬하여 조회
SELECT empno, ename, sal
FROM emp
ORDER BY sal, ename;

-- 문자열의 정렬은 자릿수의 정렬
-- char형 숫자의 경우 첫번째 자리끼리 비교-> 두번째 자리끼리 비교 -> ...
CREATE TABLE test_orderby(
num varchar2(5)
);

INSERT INTO test_orderby values('1');
INSERT INTO test_orderby values('1001');
INSERT INTO test_orderby values('2');
INSERT INTO test_orderby values('10002');
INSERT INTO test_orderby values('25');
INSERT INTO test_orderby values('201');
INSERT INTO test_orderby values('3');

commit;

select *
from test_orderby
order by num;

