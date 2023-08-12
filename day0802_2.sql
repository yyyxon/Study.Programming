-- DUAL : 가상 테이블
-- SELECT에 입력하는 값이 컬럼명이자 값
SELECT '김선경' name , 28 , sysdate input_date
FROM dual;

------------------------수치 함수------------------------
-- 절대값 : abs(값)
SELECT abs(-8), abs(-8.2)
FROM dual;

-- 반올림 : round(값), round(값,자릿수)
-- 자릿수에서 반올림x 반올림해서 자릿수만큼 만들어라o
-- 실수부 반올림 : 반올림하여 볼 자릿수
SELECT round(777.777,2), round(777.774,2), round(777.777,1), round(777.777)
FROM dual;

-- 정수부 반올림 : 반올림하려는 자리
-- 정수부는 해당 자리에서 반올림 수행
SELECT round(777.777,-1), round(777.777,-2)
FROM dual;

-- 올림 : ceil
-- 소수점이하에 값이 존재하면 무조건 올림
SELECT ceil(10.1), ceil(10.01), ceil(10.000001)
FROM dual;

-- 내림 : floor
SELECT floor(10.9), floor(10.09)
FROM dual;

-- 절사 : trunc
-- 실수부에서는 그 다음 자릿수부터 절사
-- 정수부에서는 그 자리에서 바로 절사
SELECT trunc(555.555,1), trunc(555.555,-1), trunc(555.555)
FROM dual;

-- 사원 테이블에서 사원번호, 사원명, 연봉, 세금을 조회
-- 단, 세금은 연봉의 3.3%로 연산하고 원단위 절사하여 출력
-- 원 단위 절사 -> 1원 단위 ㄴㄴ
SELECT empno, ename, sal, trunc(sal*0.033,-1) tax
FROM emp;

CREATE TABLE test_null(
	num number,
	name varchar2(30),
	input_date date
);

INSERT INTO test_null(num, name, input_date)
VALUES(1, '강다연', sysdate);

-- 숫자나 날짜는 컬럼이 생략되는 경우에 null이 입력된다.
INSERT INTO test_null(name) VALUES('김다영');

commit;

-- 가변길이형이나 고정길이형은 컬럼이 생략되거나, ''가 입력되면 null이 입력된다.
-- 컬럼이 생략되는 경우
INSERT INTO test_null(num) values(2);
-- ''가 입력되는 경우
INSERT INTO test_null(num,name,input_date) values(3,'',sysdate);

commit;

-- nvl
-- nvl(컬럼명,null일 때 값)
-- test_null 테이블에서 번호, 입력일을 조회
-- 단, 번호가 없다면 0으로, 날짜가 없다면 현재 날짜로 출력
-- 문자열이더라도 데이터 형식이 같다면 제대로 출력됨
-- 형 변환이 된다면 에러가 발생하지 않는다.
-- 날짜 형식의 문자열 가능
SELECT nvl(num,0) num, nvl(input_date,'2022-08-02') input_date
FROM test_null;

SELECT num, input_date
FROM test_null;

-- 같은 데이터형이 아니라면 ERROR 발생
-- 숫자 형식의 문자열 가능
SELECT nvl(num, '10') num, nvl(input_date, sysdate) input_date
FROM test_null;
-- 같은 데이터형이 아니므로 에러
SELECT nvl(num, '10번') num, nvl(input_date, '오늘은 수요일') input_date
FROM test_null;

-- nvl2
-- test_null 테이블에서 이름과 이름이 있는지를 조회
-- nvl2(컬럼명, null이 아닐 때 값, null일 때 값)
-- 단, 이름이 있다면 '있음' 없으면 '익명'
SELECT name, nvl2(name, '있음', '익명')
FROM test_null;

-- 사원테이블에서 사원번호, 사원명, 연봉, 보너스, 총수령액을 조회
-- 단, 총 수령액은 연봉과 보너스를 합산한 금액으로 조회
SELECT empno, ename, sal, comm, sal+nvl(comm,0) as total
FROM emp;

-- zipcode 테이블에서 자신이 거주하는 동의 우편번호, 시도, 구군, 동, 번지
-- 단, 번지가 없다면 '번지 없음'을 출력
SELECT zipcode, sido, gugun, dong, nvl(bunji,'번지없음') bunji
FROM zipcode;

SELECT ZIPCODE, SIDO, GUGUN, DONG, BUNJI
FROM ZIPCODE
WHERE DONG LIKE '상도동%';
