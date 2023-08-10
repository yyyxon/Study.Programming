-- 1. 사원 테이블에서 '10'번 부서가 아니면서 연봉이 1000이상 3000이하의
-- 모든 사원들의  사원번호,사원명, 입사일,부서번호, 연봉을 조회하세요.
SELECT empno, ename, hiredate, deptno, sal
FROM emp
WHERE deptno <> 10 AND sal BETWEEN 1000 AND 3000;

-- 2. 사원 테이블에서 보너스를 수령하는 사원들의
-- 사원번호, 사원명, 연봉, 보너스, 총 수령액, 월급을 조회 하세요.
-- 월급은 연봉을 12개월로 나눠 연산합니다.
-- 총수령액은 월급과 보너스를 합산한 금액입니다.
SELECT empno, ename, sal, comm, ROUND(sal/12) as mon_sal, ROUND(sal/12)+comm total
FROM emp
WHERE comm is not null;

-- 3.  사원 테이블에서 부서번호가 10,30인
-- 사원들의 사원명, 사원번호, 연봉을 조회 하세요.
-- 단, 출력은 "xxxx번 xxxx사원님 연봉은 xxx$입니다. "
-- 의 형식으로 하고, inline view의 컬럼명은 OutPut 으로 설정할 것.
SELECT empno || '번 ' || ename || ' 사원님 연봉은 ' || sal || '$입니다.' "OutPut"
FROM emp
WHERE deptno IN (10,30);

-- 4. 사원 테이블에서 연봉이 3000 미만인 사원들의
-- 사원번호, 사원명, 입사일, 연봉, 직무, 부서번호를 조회 하세요.
-- 단, 연봉의 오름차순으로 정렬할 것,
-- 동일 연봉이 있다면 사원명의 내림차순으로 정렬할 것.
SELECT empno, ename, hiredate, sal, job, deptno
FROM emp
WHERE sal < 3000
ORDER BY sal, ename desc;

-- 5.
CREATE TABLE test_like2 (
  num number(3),
  name varchar(30),
  addr varchar(300),
  highschool varchar(30)
);

INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(1, '기임줌인', '서울시 동작구 상도동', '정기고');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(2, '정대만', '경기도 부천시 원미구', '썸타고');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(3, '송태섭', '서울시 동대문구 동대문2동', '정기고');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(4, '박상준', '서울시 동작구 상도동', '오지고');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(5, '이동원', '서울시 동작구 동대문4동', '지리고');

-- 6. test_like2 테이블에서 '서울시'에 거주하며
-- 이름이 3글자인 학생의  번호, 학생명,  주소, 학교정보를
-- 아래와  같은 형식으로 출력하세요.
-- 컬럼명은 대소문자 구분하여 OutPut으로 할것.
-- 출력형식 :  번호 : x, 이름 : xx, 주소 : xx, 학교 : xx
SELECT '번호 : ' || num || ', 이름 : ' || name || ', 주소 : ' ||
addr || ', 학교 : ' || highschool "OutPut"
FROM test_like2
WHERE addr LIKE '서울시%' AND name LIKE '___';

-- 7. 사원테이블에서 사원명이 4글자이거나 연봉이 3000이상인 사원의
-- 사원번호, 사원명, 연봉, 입사일, 부서번호, 직무를 조회 할 것.
SELECT empno, ename, sal, hiredate, deptno, job
FROM emp
WHERE ename LIKE '____' OR sal >= 3000;

-- 8. 사원 테이블에서 사원번호, 사원명, 입사일, 연봉, 내년연봉을 조회 하세요.
-- 내년 연봉은 현재 연봉보다 7% 향상된 금액으로 계산하여 출력할 것.
SELECT empno, ename, hiredate, sal, sal*1.07 next_sal
FROM emp;

-- 9. 사원 테이블에서 사원명이 'A'로 시작하면서 연봉이 1600이상인
-- 사원의 사원명,연봉,직무, 매니저번호, 입사일을 조회 할 것.
-- 단, 입사일이 가장 최근인 사원부터 출력할 것.
SELECT ename, sal, job, mgr, hiredate
FROM emp
WHERE ename LIKE 'A%' AND sal >= 1600
ORDER BY hiredate DESC;
