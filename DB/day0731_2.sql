insert into test_table (num,name) values (1,'�ڻ���');

-- ���̺� ���� : ������ ���̺��� ���������� ����.
drop table test_table;

select * from test_table;

-- ������ ���� : show�� SQLPlus �����̰�,
-- golden�� SQLPlus���� �������� �ʴ´�.
show recyclebin;

-- tab : DD
select * from tab;

-- �����뿡 �ִ� ���̺� ����(���ڵ���� ���� ������)
-- �����ϴ� ���̺��� original_name�� ����Ѵ�.
-- �����ϴ� ������ ���� �̸��� ���� ���̺��� �ִٸ� ����x
flashback table test_table to before drop;

select * from test_table;

-- ���̺� ����
drop table test_table;

purge recyclebin;

----DML : insert---------------------------------------------------------
-- �÷����� �����Ͽ� insert
insert into test_string values('�ڻ���','M','����� ��õ��');

-- ���� ���� �� �ִ�.(���� �� �÷����� ��õǾ����� �ʱ� ������)
insert into test_string(name,gender) values('M','M');

SELECT * FROM test_string;

select * from student;
