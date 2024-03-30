-- DD : Data Dictionary (������ ����) - tab
-- DBMS�� ������� ����ִ� ���̺�
-- �������� ��밡���� DD�� �ٸ���.
-- RECORD/ROW/TUPLE

-- ctrl + enter
-- ctrl + f7 (������ �ڵ常 ����)

select * from tab;

select * from dba_users;

select * from TEST_NUMBER;

-- TEST_NUMBER ���̺� 1, 28, 65.23�� �߰�
insert into test_number(num1, age, weight)
values(1, 28, 65.23);

-- NUM1 �÷��� ���� 22���� �⺻
insert into test_number(num1, age, weight)
values(1111111111111111111111, 28, 65.23);

-- AGE�÷��� ���� 3���� �Է� ����(0~999)
insert into test_number(num1, age, weight)
values(2, 999, 65.23);

-- weight 0.00 ~ 999.99���� �Է� ����
insert into test_number(num1, age, weight)
values(3, 28, 0.00);

insert into test_number(num1, age, weight)
values(4, 28, 65.7);

insert into test_number(num1, age, weight)
values(5, 28, 999.99);

-- ������ 3�ڸ� �ʰ��Ͽ� ����
insert into test_number(num1, age, weight)
values(6, 28, 1000);

-- �Ǽ��� �ڸ��� �ʰ��ص� �˾Ƽ� �����
insert into test_number(num1, age, weight)
values(7, 28, 1.1234);

commit;

select * from TEST_NUMBER;
