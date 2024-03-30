create table test_date(
now_date date
);

-- ��¥ �߰�
-- sysdate : �ý����� ���� ��¥ ����
insert into test_date
values (sysdate);

-- ��¥ ������ ���ڿ� : ���� ��¥�� �ƴ� �ٸ� ��¥�� �Է��� �� �ִ�.
insert into test_date (now_date)
values('2023-07-29');

-- to_date �Լ�
insert into test_date (now_date)
values(to_date('2023-07-31','yyyy-mm-dd'));

insert into test_date (now_date)
values(to_date('20230720'));

select * from test_date;

-- 1. test_table ���̺��� �����ϰ�
-- ��ȣ, �̸�, ����, ����, �̸���, ��, �Է����� ���� �� �ִ� ���̺��� ����
-- ��ȣ : ���� 5������ �Է�(0~99999)
-- �̸� : �ִ� 10�ڱ��� �Է�
-- ���� : ���� �Ǵ� ���ڸ� �Է�
-- �̸���
-- �� : A,B,C,D�� �������� �ѱ��ڸ� �Է�
-- �Է��� : �����Ͱ� �߰��Ǵ� ���� ��¥
CREATE TABLE test_table(
	num number(5),
	name varchar2(30),
	age number(3),
	gender char(6),
	email varchar2(50),
	class char(1),
	input_date date
);

-- 2. test_table ���̺� ���ڵ带 �߰�
-- 1, ���ٿ�, 25, ����, kang@daum.net, A, ���糯¥
-- 2, ���±���, 25, ����, lim@naver.com, B, 2023-08-30
-- 3, ȫ..����, 26, ����, hong@gmail.com, C, ���糯¥
insert into test_table
values (1, '���ٿ�', 25, '����', 'kang@daum.net', 'A', sysdate);
insert into test_table
values (2, '���±���', 25, '����', 'lim@naver.com', 'B', '2023-08-30');
insert into test_table
values (3, 'ȫ..����', 26, '����', 'hong@gmail.com', 'C', sysdate);

select * from test_table;

insert into test_string(name)
values('��뼮');

select * from test_string;

commit;

update test_string
set name = 'ȫ������'
where name = 'ȫ����';
