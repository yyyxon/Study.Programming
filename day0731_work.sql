CREATE TABLE student_work(
num number(5),
name varchar2(30),
class char(1),
email varchar2(50),
tel varchar2(13),
addr varchar2(240),
gender char(6),
java number(3),
input_date date
);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (1,'임태균', 'A', 'tae@sist.co.kr', '010-1234-5678','경기도 용인시', '남자', 91, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (2,'강다연', 'A', 'kang@daum.net', '010-7739-9761','서울시 강남구 역삼1동', '남자', 90, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (3,'박상준', 'A', 'park@test.com', '010-5878-8813','서울시 동작구 상도동', '여자', 97, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (4,'장용석', 'B', 'kyoung@google.com', '011-234-7611','서울시 동대문구 동대문동', '여자', 190, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (5,'김인영', 'B', 'kim@sist.co.kr', '010-4334-7656','인천구 부평구 부평3동', '여자', 89, sysdate);

commit;

-- 1번에서 생성된 테이블을 사용하여 모든 레코드와 모든 컬럼을 조회하세요.
SELECT *
FROM student_work;

-- 1번에서 생성된 테이블을 사용하여 이름, 반, 주소, 자바점수만 조회하세요.
SELECT name, class, addr, java
FROM student_work;

-- 3번 학생의 성별을 ‘남자’로 점수를 90점으로 반을 A, 전화번호를 010-2234-7611으로 변경해주세요.
UPDATE student_work
SET gender = '남자', java = '90', tel = '010-2234-7611'
WHERE num = 3;

-- 이름이 ‘임태균’인 학생의 반을 ‘B’반, 전화번호를 010-1111-2341 로 변경해주세요.
UPDATE student_work
SET class = 'B', tel = '010-1111-2341'
WHERE name = '임태균';

commit;

-- 반이 A반인 학생을 모두 삭제해보세요.
DELETE
FROM student_work
WHERE class = 'A';

-- 7번에서 삭제한 레코드를 모두 복구해 보세요.
rollback;

-- 1번에서 생성된 테이블 자체를 삭제해 보세요.
drop table student_work;

-- 휴지통을 확인하고, 휴지통에 버려진 테이블을 복구해보세요.
show recyclebin;
flashback table student_work to before drop;

-- 테이블의 모든 레코드를 절삭해보세요.
truncate table student_work;

-- 테이블자체를 삭제 해보세요.
drop table student_work;

-- 휴지통의 내용을 확인하고, 휴지통을 비워보세요.
show recyclebin;
purge recyclebin;
