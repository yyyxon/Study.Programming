-- inner join : 양쪽 테이블에 같은 값이 있는 것만 조회
-- 조인 조건에 사용되는 컬럼에 어느 한 쪽 테이블에만 값이 존재하면 조인되지않는다.
-- 중복되는 컬럼명에는 테이블명을 기술하여 식별되도록 작성한다.

-- 사원번호, 사원명, 부서번호, 부서명, 위치 검색
-- ANSI 문법
SELECT EMPNO, ENAME, EMP.DEPTNO, DEPT.DEPTNO, DNAME, LOC
FROM EMP
INNER JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO;

-- 테이블명이 길면 작성하기 어렵다 => 테이블명에 alias를 붙여서 사용
-- 테이블 alias는 inline view에 반영되지 않는다.
SELECT E.EMPNO, E.ENAME, E.DEPTNO, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E
INNER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;

-- Oracle inner join 문법
SELECT EMPNO, ENAME, EMP.DEPTNO, DEPT.DEPTNO, DNAME, LOC
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- alias 사용 : 테이블명에 alias가 부여되면 이전 테이블명은 사용할 수 없다.
SELECT EMPNO, ENAME, E.DEPTNO, D.DEPTNO, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

-- 차량의 제조국, 제조사, 모델명을 검색
SELECT country, cc.maker, model
FROM car_country cc, car_maker cm
WHERE cc.maker = cm.maker;

-- 보유중인 차량의 제조국, 제조사, 모델명, 가격, 연식을 조회
SELECT *
FROM CAR_MODEL;

SELECT *
FROM CAR_COUNTRY; -- MAKER, COUNTRY

SELECT *
FROM CAR_MAKER; -- MAKER, MODEL

SELECT COUNTRY, CMA.MAKER, CMO.MODEL, PRICE, CC
FROM CAR_MODEL CMO, CAR_MAKER CMA, CAR_COUNTRY CC
WHERE CMO.MODEL = CMA.MODEL AND CMA.MAKER = CC.MAKER;

SELECT COUNTRY, CMA.MAKER, CMO.MODEL, PRICE, CC
FROM CAR_MODEL CMO 
INNER JOIN CAR_MAKER CMA
ON CMO.MODEL = CMA.MODEL
INNER JOIN CAR_COUNTRY CC
ON CMA.MAKER = CC.MAKER;

SELECT *
FROM car_maker;

--------------------------------------------------------------------------------
-- outer join
-- left, right : 레코드가 존재하는 테이블을 선택
-- 모든 부서의 부서번호, 부서명, 사원번호, 사원명을 조회
SELECT d.deptno, dname, empno, ename
FROM emp e
RIGHT OUTER JOIN dept d -- OUTER JOIN 기준 오른쪽 테이블에 모든 레코드가 존재
ON e.deptno = d.deptno;

SELECT d.deptno, dname, empno, ename
FROM dept d
LEFT OUTER JOIN emp e -- OUTER JOIN 기준 왼쪽 테이블에 모든 레코드가 존재
ON e.deptno = d.deptno;

-- full outer join : 양쪽 테이블을 모두 참조하여 레코드를 조회
SELECT d.deptno, dname, empno, ename
FROM dept d
FULL OUTER JOIN emp e
ON e.deptno = d.deptno;

-- oracle join - full outer 불가
-- 레코드가 없는 컬럼에 (+) 표시
SELECT d.deptno, dname, empno, ename
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- 모든 차량 모델의 제조국, 제조사, 모델명, 연식, 가격, 배기량
SELECT COUNTRY, CC.MAKER, CAR_YEAR, PRICE, CMA.MODEL, CC
FROM CAR_MODEL CMO 
RIGHT OUTER JOIN CAR_MAKER CMA
ON CMO.MODEL = CMA.MODEL
RIGHT OUTER JOIN CAR_COUNTRY CC
ON CMA.MAKER = CC.MAKER;

SELECT COUNTRY, CC.MAKER, CAR_YEAR, PRICE, CMA.MODEL, CC
FROM CAR_COUNTRY CC
LEFT OUTER JOIN CAR_MAKER CMA -- INNER JOIN CAR_MAKER CMA
ON CMA.MAKER = CC.MAKER
LEFT OUTER JOIN CAR_MODEL CMO 
ON CMO.MODEL = CMA.MODEL;

SELECT COUNTRY, CC.MAKER, CAR_YEAR, PRICE, CMA.MODEL, CC
FROM CAR_MODEL CMO, CAR_MAKER CMA, CAR_COUNTRY CC
WHERE CMO.MODEL(+) = CMA.MODEL AND CMA.MAKER = CC.MAKER;