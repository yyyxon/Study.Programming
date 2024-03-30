-- 숙제1.
-- 사원 테이블에서 연봉이 1500~3000사이인 사원의
-- 사원번호, 사원명, 연봉, 입사일, 부서번호, 직무, 매니저번호를 조회한 레코드를 사용하여
-- emp_work테이블을 생성하고 추가합니다.
CREATE TABLE emp_work AS (
SELECT EMPNO, ENAME, SAL, HIREDATE, DEPTNO, JOB, MGR
FROM EMP
WHERE SAL BETWEEN 1500 AND 3000
);

-- 숙제2.
-- emp테이블에서 10번 30번 부서의 사원 정보를 조회하여 emp_work테이블에 
-- 조회 결과를 추가합니다. 
-- 단, 사원번호는 조회된 사원번호에 1000을 더한 값으로 추가할 것.
-- 원본 data 7788 -> insert 8788
INSERT INTO EMP_WORK (
SELECT EMPNO+1000, ENAME, SAL, HIREDATE, DEPTNO, JOB, MGR
FROM EMP
WHERE DEPTNO IN (10,30)
);
COMMIT;

-- 숙제 3.
-- emp_work 테이블에서 10번 부서에 근무하는 사원들의 연봉을  emp테이블의 
-- 사원번호가 7698번 사원 연봉과 7782번 사원의 연봉을 더한 금액으로 변경하세요.
UPDATE emp_work
SET sal = (SELECT SUM(sal) FROM emp WHERE empno IN (7698, 7782))
WHERE deptno = 10;
COMMIT;

-- 숙제4. emp_work 테이블에 아래와 같은 레코드를 추가하세요.
-- 사원번호 : emp_work의 가장 마지막 사원번호에서 1 증가한 번호, 사원명 : 김선경, 직무 : 개발자, 
-- 입사일 : 추가되는 시점의 다음날
INSERT INTO emp_work (empno, ename, job, hiredate)
VALUES ((SELECT MAX(empno)+1 FROM emp_work), '김선경', '개발자', sysdate+1);
COMMIT;

SELECT * FROM EMP_WORK;

-- 숙제5. 아래와 같은 레코드를 저장할 수 있는  sales테이블을 생성하고 레코드를 추가하세요.
CREATE TABLE sales (
	num NUMBER,
	product VARCHAR2(30),
	price NUMBER,
	sales_date DATE,
	quantity NUMBER
);

INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (1, '키보드', 20000, '2023-08-25', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (2, '마우스', 27000, '2023-08-25', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (3, '모니터', 350000, '2023-08-25', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (4, '키보드', 23000, '2023-08-25', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (5, '키보드', 15000, '2023-08-25', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (6, '키보드', 20000, '2023-08-26', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (7, '마우스', 13000, '2023-08-26', 1);
INSERT INTO sales (num, product, price, sales_date, quantity)
VALUES (8, '키보드', 22000, '2023-08-26', 1);
COMMIT;

-- 숙제 6. 상품명, 총가격, 판매건수, 판매일, 입력일 을 저장할 수 있는  sales_adjustment 테이블을 생성하세요.
CREATE TABLE sales_adjustment (
	product VARCHAR2(30),
	total_price NUMBER,
	total_sales NUMBER,
	sales_date DATE,
	input_date DATE
);

-- sales 테이블에서 ‘2023-08-25’ 에 판매된 상품의 상품명, 총가격, 판매건수를  sales_adjustment
-- 테이블에 추가하세요. 
INSERT INTO sales_adjustment (
SELECT product, sum(price) total_price, count(product) total_sales, sales_date, sysdate
FROM sales
WHERE sales_date = '2023-08-25'
GROUP BY product, sales_date
);

SELECT *
FROM SALES_ADJUSTMENT;