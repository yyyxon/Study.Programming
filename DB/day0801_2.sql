-- 사원 테이블에서 보너스를 수령하지 않는 사원의
-- 사원번호, 연봉, 보너스, 입사일 조회
-- null은 관계연산자로 비교되지 않는다. comm != null 안됨!
SELECT empno, sal, comm, hiredate
FROM emp
WHERE comm is null;

SELECT * FROM EMP;

CREATE TABLE test_like(
	name varchar2(30),
	addr varchar2(300)
);

insert into test_like(name, addr) values('강다연','서울시 강남구 역삼동');
insert into test_like(name, addr) values('김다영','서울시 동대문구 동대문동');
insert into test_like(name, addr) values('홍찬영','서울시 경기도 수원시 영통구 영통동');
insert into test_like(name, addr) values('홍홍찬영','서울시 강남구 대포동');
insert into test_like(name, addr) values('송지하','경기도 수원시 수원동');
insert into test_like(name, addr) values('김선경','마계인천시 부평구 대포동');

commit;

-- like는 특수문자와 함께 사용되지 않으면 = 과 같은 검색을 한다.
SELECT *
FROM test_like
WHERE name like '김선경';

-- '강남구'에 살고있는 사람을 검색
SELECT *
FROM test_like
WHERE addr like '%강남구%';

-- test_like 테이블에서 서울시에 살고있는 사람들의 이름과 주소를 조회
SELECT *
FROM test_like
WHERE addr like '서울시%';

-- test_like 테이블에서 '대포동'에 살고 있는 사람들의 이름과 주소를 조회
SELECT *
FROM test_like
WHERE addr like '%대포동';

-- test_like 테이블에서 주소에 '수원시'가 포함된 사람들의 이름과 주소를 조회
SELECT *
FROM test_like
WHERE addr like '%수원시%';

-- 사원테이블에서 사원에 'A'가 포함된 사원들의
-- 사원번호, 사원명, 입사일 조회
SELECT empno, ename, hiredate
FROM emp
WHERE ename LIKE '%A%';

-- 사원테이블에서 사원에 'L'이 두개 포함된 사원들의
-- 사원번호, 사원명, 입사일 조회
SELECT empno, ename, hiredate
FROM emp
WHERE ename LIKE '%L%L%';

-- _ 의 사용 
-- test_like 테이블에서 이름이 4글자인 사람을 검색
SELECT *
FROM test_like
WHERE name like '____';

-- 이름이 3글자이면서 '영'으로 끝나는 이름을 검색
SELECT name
FROM test_like
WHERE name like '__영';

-- 사원 테이블에서 사원명이 끝문자의 전 문자가 'E'인 사원들의 사원명 검색
SELECT ename
FROM emp
WHERE ename like '%E_';

SELECT zipcode, sido, gugun, dong, bunji
FROM zipcode
WHERE dong LIKE '신월2동%' AND gugun = '양천구';
