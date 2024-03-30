-- 1.사원 테이블에서 사원번호,사원명, 입사일, 연봉을 조회하세요.
-- 단, 연봉은 전체 8자리로 하여 $를 붙여 출력하고, 연봉의 오름차순으로 정렬하여 출력하세요
-- 예) $00001250
SELECT empno, ename, hiredate, '$' || lpad(sal,8,0) sal
FROM emp
ORDER BY sal;

-- 2.사원 테이블에서 직무가 MANAGER, SALESMAN, CLERK인 사원의
-- 사원번호, 사원명, 직무, 입사일, 연봉, 보너스, 실수령액을 조회하세요.
-- 단, 사원명은 첫글자만 대문자로 출력할 것.
-- 실수령액은 연봉과 보너스를 합산한 금액에서 3.3%를 뺀 금액으로 연산하되
-- 원단위를 반올림하여 출력할 것.
SELECT empno, initcap(ename) ename, job, hiredate, sal, comm, ROUND(sal + nvl(comm,0) - ((sal + nvl(comm,0)) * 0.033)) as pay
FROM emp
WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

-- 3. car_model 테이블에서 모델이 k5, 아반테, a8이거나 옵션에 ‘ABS’가 있는 ‘
-- 차량의 가격, 연식, 옵션,이미지를 조회하세요.
-- 단. 모델명은 소문자로 출력할 것.
-- car_option은 두번째 , 까지만 출력할 것
-- 이미지는 모두 소문자로 출력할 것.
-- 가격의 내림차순으로 정렬하되 가격이 같다면, 모델명의 내림차순으로 정렬할것
SELECT LOWER(model) model, price, car_year,
			 TRIM(SUBSTR(car_option,1,INSTR(car_option,',',INSTR(car_option,',')+1)-1)) car_option,
			 LOWER(car_img) car_img
FROM car_model
WHERE LOWER(model) IN ('k5','아반테','a8') OR INSTR(car_option,'ABS') <> 0
ORDER BY price desc, model desc;

select *
from car_model;