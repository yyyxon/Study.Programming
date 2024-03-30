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
values (1,'���±�', 'A', 'tae@sist.co.kr', '010-1234-5678','��⵵ ���ν�', '����', 91, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (2,'���ٿ�', 'A', 'kang@daum.net', '010-7739-9761','����� ������ ����1��', '����', 90, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (3,'�ڻ���', 'A', 'park@test.com', '010-5878-8813','����� ���۱� �󵵵�', '����', 97, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (4,'��뼮', 'B', 'kyoung@google.com', '011-234-7611','����� ���빮�� ���빮��', '����', 190, sysdate);

insert into student_work (num, name, class, email, tel, addr, gender, java, input_date)
values (5,'���ο�', 'B', 'kim@sist.co.kr', '010-4334-7656','��õ�� ���� ����3��', '����', 89, sysdate);

commit;

-- 1������ ������ ���̺��� ����Ͽ� ��� ���ڵ�� ��� �÷��� ��ȸ�ϼ���.
SELECT *
FROM student_work;

-- 1������ ������ ���̺��� ����Ͽ� �̸�, ��, �ּ�, �ڹ������� ��ȸ�ϼ���.
SELECT name, class, addr, java
FROM student_work;

-- 3�� �л��� ������ �����ڡ��� ������ 90������ ���� A, ��ȭ��ȣ�� 010-2234-7611���� �������ּ���.
UPDATE student_work
SET gender = '����', java = '90', tel = '010-2234-7611'
WHERE num = 3;

-- �̸��� �����±ա��� �л��� ���� ��B����, ��ȭ��ȣ�� 010-1111-2341 �� �������ּ���.
UPDATE student_work
SET class = 'B', tel = '010-1111-2341'
WHERE name = '���±�';

commit;

-- ���� A���� �л��� ��� �����غ�����.
DELETE
FROM student_work
WHERE class = 'A';

-- 7������ ������ ���ڵ带 ��� ������ ������.
rollback;

-- 1������ ������ ���̺� ��ü�� ������ ������.
drop table student_work;

-- �������� Ȯ���ϰ�, �����뿡 ������ ���̺��� �����غ�����.
show recyclebin;
flashback table student_work to before drop;

-- ���̺��� ��� ���ڵ带 �����غ�����.
truncate table student_work;

-- ���̺���ü�� ���� �غ�����.
drop table student_work;

-- �������� ������ Ȯ���ϰ�, �������� ���������.
show recyclebin;
purge recyclebin;
