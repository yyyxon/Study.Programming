--문자열을 저장할 때
--크기를 설정하지 않으면 기본 사이즈가 들어감
--char, varchar2는 0이 기본 사이즈이므로 생략시 문자열 안들어감
create table test_string(
ssn char, --크기를 설정하지 않으면 값을 입력할 수 없음
name varchar2(1));

--이름,성별,주소 저장하는 테이블 생성
--값의 길이가 고정된 경우 char, 그렇지 않으면 varchar2
create table test_string(
name varchar2(15), --한글 하나에 3byte UTF-8 2*2*2
gender char(1),
addr varchar2(200));

--계정이 가지고 있는 테이블을 검색
select tname
from tab;

--값 추가 > 한글 1자는 3byte, 영문자&숫자 1자는 1byte
insert into test_string(name, gender, addr)
values('박상준','M','서울시 강남구 역삼동 한독빌딩 8층 4강의실 뒷자리');

insert into test_string
values('황금독수리','M','서울');

--byte수를 초과하여 값이 삽입되지않음
insert into test_string
values('황금독수리온','M','서울');

--영문자&숫자 1자는 1byte
insert into test_string
values('MMMMMMMMMMMMMM1','M','서울');

SELECT *
FROM TEST_STRING;
