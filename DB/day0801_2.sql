-- ��� ���̺��� ���ʽ��� �������� �ʴ� �����
-- �����ȣ, ����, ���ʽ�, �Ի��� ��ȸ
-- null�� ���迬���ڷ� �񱳵��� �ʴ´�. comm != null �ȵ�!
SELECT empno, sal, comm, hiredate
FROM emp
WHERE comm is null;

SELECT * FROM EMP;

CREATE TABLE test_like(
	name varchar2(30),
	addr varchar2(300)
);

insert into test_like(name, addr) values('���ٿ�','����� ������ ���ﵿ');
insert into test_like(name, addr) values('��ٿ�','����� ���빮�� ���빮��');
insert into test_like(name, addr) values('ȫ����','����� ��⵵ ������ ���뱸 ���뵿');
insert into test_like(name, addr) values('ȫȫ����','����� ������ ������');
insert into test_like(name, addr) values('������','��⵵ ������ ������');
insert into test_like(name, addr) values('�輱��','������õ�� ���� ������');

commit;

-- like�� Ư�����ڿ� �Բ� ������ ������ = �� ���� �˻��� �Ѵ�.
SELECT *
FROM test_like
WHERE name like '�輱��';

-- '������'�� ����ִ� ����� �˻�
SELECT *
FROM test_like
WHERE addr like '%������%';

-- test_like ���̺��� ����ÿ� ����ִ� ������� �̸��� �ּҸ� ��ȸ
SELECT *
FROM test_like
WHERE addr like '�����%';

-- test_like ���̺��� '������'�� ��� �ִ� ������� �̸��� �ּҸ� ��ȸ
SELECT *
FROM test_like
WHERE addr like '%������';

-- test_like ���̺��� �ּҿ� '������'�� ���Ե� ������� �̸��� �ּҸ� ��ȸ
SELECT *
FROM test_like
WHERE addr like '%������%';

-- ������̺��� ����� 'A'�� ���Ե� �������
-- �����ȣ, �����, �Ի��� ��ȸ
SELECT empno, ename, hiredate
FROM emp
WHERE ename LIKE '%A%';

-- ������̺��� ����� 'L'�� �ΰ� ���Ե� �������
-- �����ȣ, �����, �Ի��� ��ȸ
SELECT empno, ename, hiredate
FROM emp
WHERE ename LIKE '%L%L%';

-- _ �� ��� 
-- test_like ���̺��� �̸��� 4������ ����� �˻�
SELECT *
FROM test_like
WHERE name like '____';

-- �̸��� 3�����̸鼭 '��'���� ������ �̸��� �˻�
SELECT name
FROM test_like
WHERE name like '__��';

-- ��� ���̺��� ������� �������� �� ���ڰ� 'E'�� ������� ����� �˻�
SELECT ename
FROM emp
WHERE ename like '%E_';

SELECT zipcode, sido, gugun, dong, bunji
FROM zipcode
WHERE dong LIKE '�ſ�2��%' AND gugun = '��õ��';
