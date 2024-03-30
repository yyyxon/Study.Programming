-- 함수는 밖으로

-- 숙제
-- 1. 배기량이 1500~3000 사이인 차량의 제조국,제조사,모델명,년식,가격,
-- 이미지,입력일,배기량, 옵션을 조회
-- 단. 출력은 배기량의 내림차순 정렬했을때 3~6번째 레코드만 조회하고,
-- 옵션은 처음 ',' 까지만 출력 할것. 가격과 연식은 3자리마다 ,를 넣어출력,
-- 입력일은 월-일-년 의 형식으로 출력할 것.
SELECT country, maker, model, to_char(car_year,'9,999') car_year, to_char(price,'9,999') price, car_img,
to_char(hiredate,'mm-dd-yyyy') input_date, cc, 
trim(substr(car_option,1,decode(instr(car_option,','), 0, length(car_option), instr(car_option,',')-1))) car_option
FROM (
	SELECT ROW_NUMBER() OVER(ORDER BY cc desc) rn,
	country, cco.maker, cma.model, car_year, price, car_img, hiredate, cc, car_option
	FROM car_model cmo, car_maker cma, car_country cco
	WHERE cmo.model = cma.model AND cma.maker = cco.maker AND cc BETWEEN 1500 AND 3000
)
WHERE rn IN (3,4,5,6);

-- 2. 부서번호가 10, 30, 40번인 모든 부서의 사원번호,사원명,입사일,
-- 연봉,연봉순위,부서명,부서번호,위치, 우편번호,시도, 구군,동,번지 를 조회.
-- 단,출력은 사원번호의 오름차순으로 정렬했을 때 2~5번째 레코드만 출력,
-- 우편번호는 '-' 뒤부터 끝까지 출력, 번지가 없다면 '번지없음'으로 대체
-- 하여 출력 ,입사일은 월-일-년 요일까지 출력  ( emp 사원번호와 zipcode SEQ컬럼을 조인조건 사용)
SELECT empno, ename, to_char(hiredate,'mm-dd-yyyy day') hiredate, sal, sal_rank, 
dname, deptno, loc, substr(zipcode,instr(zipcode,'-')+1) zipcode, sido, gugun, dong, nvl(bunji,'번지없음') bunji
FROM (
	SELECT empno, ename, hiredate, sal, ROW_NUMBER() over(ORDER BY sal desc) sal_rank,
	ROW_NUMBER() over(ORDER BY empno) rn,
	dname, d.deptno, loc, zipcode, sido, gugun, dong, bunji
	FROM emp e, dept d, zipcode z
	WHERE z.seq(+) = e.empno AND e.deptno(+) = d.deptno AND d.deptno IN (10,30,40)
)
WHERE rn BETWEEN 2 AND 5;

-- 3. 차량의 제조사가 '현대','기아','삼성','BMW','AUDI'이고 옵션에 'ABS','TCS'가
-- 있는 차량의  제조국, 제조사,모델명, 연식,가격, 옵션, 이미지, 배기량 조회
-- 단, 연식의 내림차순 정렬하고, 연식이 같다면 가격의 내림차순으로 정렬
-- 하여 출력, 이미지는 이미지명과 확장자를 구분하여 출력할것,
-- 제조사명이 영어라면 Bmw, Audi 의 형식으로 출력
SELECT country, initcap(cma.maker) maker, cmo.model, car_year, price, car_option, 
substr(car_img,1,instr(car_img,'.')-1) car_img, 
substr(car_img,instr(car_img,'.')) car_img_ext, cc
FROM car_model cmo, car_country cc, car_maker cma
WHERE cmo.model = cma.model AND cma.maker = cc.maker AND cma.maker IN ('현대', '기아', '삼성', 'BMW', 'AUDI') 
AND (instr(car_option,'ABS') <> 0  OR instr(car_option,'ABS') <> 0)
ORDER BY car_year DESC, price DESC;

-- 4. 모델명이 'K5','아반테', '소렌토','A8','SM3' 인 차량의 번호, 모델명, 제조국,
-- 제조사,가격,연식을 아래와 같은 형식의 문장으로 출력.
-- 단,번호는 1번부터 출력하고,
-- 출력 가격의 오름차순을 정렬했을 때 2~7 사이의 레코드만 출력,
-- [모델명] 차량의 연식은 [ xxxx ]이고, 제조국은 [국산|수입]이며, 
-- [XX]사가 제조사입니다. 가격은 [0,000,000]원 입니다.
SELECT rownum num, '[' || model || '] 차량의 연식은 [' || car_year || ']이고, 제조국은 [' || country || '] 이며, [' || maker || ']사가 제조사입니다. 가격은 [' || 
to_char(rpad(price,7,0),'0,000,000') || ']원 입니다.' output
FROM(
	SELECT cmo.model, country, cma.maker, price, car_year, row_number() over(ORDER BY price) rn
	FROM car_model cmo, car_country cc, car_maker cma
	WHERE cmo.model = cma.model AND cma.maker = cc.maker AND cmo.model IN ('K5', '아반테', '소렌토', 'A8','SM3')
)
WHERE rn BETWEEN 2 AND 7;

-- 5. 제조사가 '현대'인 차량의 년식, 모델명, 연식별 총가격을 조회하세요.
SELECT car_year, cmo.model, sum(price)
FROM car_model cmo, car_maker cma
WHERE cmo.model = cma.model AND maker = '현대'
GROUP BY car_year, cmo.model;

-- 6. 사원명이 'S'로 끝나거나 이름5자이면서 세번째 글자가 'A'인 
-- 사원의  사원번호, 사원명, 입사일, 연봉, 세금, 실수령액, 연봉인상액,
-- 부서번호,부서명,위치,우편번호,시도, 구군,동,번지 를 조회
-- 단,실수령액은 연봉+퇴직금+보너스-세금(연봉 3.3) 로 계산
-- 연봉인상액은 부서번호에 따라 차등 인상 
-- 10- 년봉 7%, 20- 년봉 4%, 30- 년봉+보너스 10%, 그외 3%로 
-- 계산하여 3자리마다 ,를 넣어 출력. 
-- 모든 영어는 소문자로 출력.
SELECT empno, lower(ename) ename, hiredate, sal, sal * 0.033 AS tax,
sal + trunc((sal * 10000 / 12 * (sysdate - hiredate) / 365) + nvl(comm,0) - sal * 0.033) AS real_sal, 
trunc(decode(d.deptno, 10, sal*0.07, 20, sal*0.04, 30, (sal + nvl(comm,0))*0.1, sal * 0.03)) increase_sal,
lower(dname) dname, lower(d.deptno) deptno, lower(loc) loc, zipcode, sido, gugun, dong, bunji
FROM emp e, dept d, zipcode z
WHERE z.seq = e.empno AND e.deptno = d.deptno AND (ename LIKE '%S' OR (length(ename) = 5 AND instr(ename,'A') = 3));

-- 하루 평균 임금 * 30 * 근무일수 / 365
-- 하루 평균 임금 : 연봉 / 12 / 30
SELECT trunc(sal * 10000 / 12 * (sysdate - hiredate) / 365) , hiredate
FROM emp;

SELECT * FROM car_model;

SELECT * FROM car_maker;

SELECT * FROM car_country;