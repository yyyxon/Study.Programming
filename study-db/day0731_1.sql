-- select : Ư�� ���̺�ȿ��� Ư�� �÷��� ��� ���ڵ带 �˻��� �� ���

-- test_string ���̺��� �̸��� �ּҸ� �˻�
SELECT name, addr
FROM test_string;

-- test_number ���̺��� ����, �����Ը� �˻�
SELECT age, weight
FROM test_number;

INSERT INTO test_table(num, name, age, gender, email, class, input_date)
VALUES(2,'ȫ����',29,'��','honghong@test.com','A',sysdate);

commit;

-- test_table�� num�÷��� ���� 3�� ���ڵ��� �̸��� 'ȫ����'���� ����
-- where���� ������� ������ ��� ���ڵ��� �÷����� ����ȴ�.
UPDATE test_table
SET name = 'ȫ����';

rollback; -- ������ commit���� �ǵ��ư�

-- where���� ����ϸ� Ư�� ���ڵ常 ����ȴ�.
-- 0���� ���ڵ忡������ N���� ���ڵ尡 ����ȴ�.
UPDATE test_table
SET name = 'ȫ����'
WHERE num = 2;

-- DB�� �ݿ�
commit;

-- test_table���� ��ȣ�� 2���� ���ڵ��� �̸��� '�׽�Ʈ'��
-- gender�� 'M'���� �Է����� �����Ϸ� ����
-- WHERE - AND, ������ ','
UPDATE test_table
SET name = '�׽�Ʈ', gender = 'M', input_date = sysdate
WHERE num = 2;

-- ��� ���ڵ� ����
DELETE
FROM test_table;

DELETE
FROM test_table
WHERE name = '�׽�Ʈ';

rollback;

SELECT *
FROM test_table;

-- ���ڵ� ���� - truncate(rollback �Ұ�)
truncate table test_table;

-- ������ ���� : ���� �̸��� �������� �����Ѵٸ� ���� �������� �������.
commit; -- ������ ������ ��� �������� �������.

savepoint insert_a;
insert into test_table(num,name,gender) values (1,'�̵���','M');

savepoint update_b;
update test_table
set name = '�̵���'
where num = 1;

savepoint delete_c;
delete
from test_table
where num = 1;

commit; -- commit�� �Ǹ� savepoint�� ��� ����

rollback to delete_c;
rollback to update_b;
rollback to insert_a; -- ���� �ۼ��� savepoint���� ������

select * from test_table;
