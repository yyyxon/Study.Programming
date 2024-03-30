-- select : 특정 테이블안에서 특정 컬럼의 모든 레코드를 검색할 때 사용

-- test_string 테이블에서 이름과 주소를 검색
SELECT name, addr
FROM test_string;

-- test_number 테이블에서 나이, 몸무게를 검색
SELECT age, weight
FROM test_number;

INSERT INTO test_table(num, name, age, gender, email, class, input_date)
VALUES(2,'홍지성',29,'남','honghong@test.com','A',sysdate);

commit;

-- test_table에 num컬럼의 값이 3인 레코드의 이름을 '홍찬영'으로 변경
-- where절을 사용하지 않으면 모든 레코드의 컬럼값이 변경된다.
UPDATE test_table
SET name = '홍찬영';

rollback; -- 마지막 commit으로 되돌아감

-- where절을 사용하면 특정 레코드만 변경된다.
-- 0건의 레코드에서부터 N건의 레코드가 변경된다.
UPDATE test_table
SET name = '홍찬영'
WHERE num = 2;

-- DB에 반영
commit;

-- test_table에서 번호가 2번인 레코드의 이름을 '테스트'로
-- gender를 'M'으로 입력일을 현재일로 변경
-- WHERE - AND, 나머지 ','
UPDATE test_table
SET name = '테스트', gender = 'M', input_date = sysdate
WHERE num = 2;

-- 모든 레코드 삭제
DELETE
FROM test_table;

DELETE
FROM test_table
WHERE name = '테스트';

rollback;

SELECT *
FROM test_table;

-- 레코드 절삭 - truncate(rollback 불가)
truncate table test_table;

-- 저장점 생성 : 같은 이름의 저장점이 존재한다면 이전 저장점은 사라진다.
commit; -- 이전에 설정한 모든 저장점이 사라진다.

savepoint insert_a;
insert into test_table(num,name,gender) values (1,'이동운','M');

savepoint update_b;
update test_table
set name = '이동원'
where num = 1;

savepoint delete_c;
delete
from test_table
where num = 1;

commit; -- commit이 되면 savepoint를 모두 삭제

rollback to delete_c;
rollback to update_b;
rollback to insert_a; -- 이후 작성된 savepoint까지 없어짐

select * from test_table;
