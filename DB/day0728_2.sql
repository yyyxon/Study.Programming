-- DD : Data Dictionary (데이터 사전) - tab
-- DBMS의 운영정보가 들어있는 테이블
-- 계정마다 사용가능한 DD가 다르다.
-- RECORD/ROW/TUPLE

-- ctrl + enter
-- ctrl + f7 (블럭잡은 코드만 실행)

select * from tab;

select * from dba_users;

select * from TEST_NUMBER;

-- TEST_NUMBER 테이블에 1, 28, 65.23을 추가
insert into test_number(num1, age, weight)
values(1, 28, 65.23);

-- NUM1 컬럼은 숫자 22개가 기본
insert into test_number(num1, age, weight)
values(1111111111111111111111, 28, 65.23);

-- AGE컬럼은 숫자 3개만 입력 가능(0~999)
insert into test_number(num1, age, weight)
values(2, 999, 65.23);

-- weight 0.00 ~ 999.99까지 입력 가능
insert into test_number(num1, age, weight)
values(3, 28, 0.00);

insert into test_number(num1, age, weight)
values(4, 28, 65.7);

insert into test_number(num1, age, weight)
values(5, 28, 999.99);

-- 정수가 3자리 초과하여 에러
insert into test_number(num1, age, weight)
values(6, 28, 1000);

-- 실수는 자릿수 초과해도 알아서 맞춰들어감
insert into test_number(num1, age, weight)
values(7, 28, 1.1234);

commit;

select * from TEST_NUMBER;
