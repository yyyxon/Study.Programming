create table test_date(
now_date date
);

-- 날짜 추가
-- sysdate : 시스템의 현재 날짜 정보
insert into test_date
values (sysdate);

-- 날짜 형식의 문자열 : 현재 날짜가 아닌 다른 날짜를 입력할 수 있다.
insert into test_date (now_date)
values('2023-07-29');

-- to_date 함수
insert into test_date (now_date)
values(to_date('2023-07-31','yyyy-mm-dd'));

insert into test_date (now_date)
values(to_date('20230720'));

select * from test_date;

-- 1. test_table 테이블을 생성하고
-- 번호, 이름, 나이, 성별, 이메일, 반, 입력일을 넣을 수 있는 테이블을 생성
-- 번호 : 숫자 5개까지 입력(0~99999)
-- 이름 : 최대 10자까지 입력
-- 성별 : 남자 또는 여자만 입력
-- 이메일
-- 반 : A,B,C,D의 형식으로 한글자만 입력
-- 입력일 : 데이터가 추가되는 현재 날짜
CREATE TABLE test_table(
	num number(5),
	name varchar2(30),
	age number(3),
	gender char(6),
	email varchar2(50),
	class char(1),
	input_date date
);

-- 2. test_table 테이블에 레코드를 추가
-- 1, 강다연, 25, 여자, kang@daum.net, A, 현재날짜
-- 2, 임태균태, 25, 남자, lim@naver.com, B, 2023-08-30
-- 3, 홍..찬영, 26, 남자, hong@gmail.com, C, 현재날짜
insert into test_table
values (1, '강다연', 25, '여자', 'kang@daum.net', 'A', sysdate);
insert into test_table
values (2, '임태균태', 25, '남자', 'lim@naver.com', 'B', '2023-08-30');
insert into test_table
values (3, '홍..찬영', 26, '남자', 'hong@gmail.com', 'C', sysdate);

select * from test_table;

insert into test_string(name)
values('장용석');

select * from test_string;

commit;

update test_string
set name = '홍찬찬영'
where name = '홍찬영';
