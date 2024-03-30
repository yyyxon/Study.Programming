insert into test_table (num,name) values (1,'박상준');

-- 테이블 삭제 : 삭제된 테이블은 휴지통으로 들어간다.
drop table test_table;

select * from test_table;

-- 휴지통 보기 : show는 SQLPlus 문장이고,
-- golden은 SQLPlus문을 지원하지 않는다.
show recyclebin;

-- tab : DD
select * from tab;

-- 휴지통에 있는 테이블 복구(레코드까지 전부 복구됨)
-- 복구하는 테이블은 original_name을 사용한다.
-- 복구하는 시점에 같은 이름을 가진 테이블이 있다면 복구x
flashback table test_table to before drop;

select * from test_table;

-- 테이블 삭제
drop table test_table;

purge recyclebin;

----DML : insert---------------------------------------------------------
-- 컬럼명을 생략하여 insert
insert into test_string values('박상준','M','서울시 양천구');

-- 값이 꼬일 수 있다.(값이 들어갈 컬럼명이 명시되어있지 않기 때문에)
insert into test_string(name,gender) values('M','M');

SELECT * FROM test_string;

select * from student;
