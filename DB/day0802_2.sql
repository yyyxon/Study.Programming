-- DUAL : ���� ���̺�
-- SELECT�� �Է��ϴ� ���� �÷������� ��
SELECT '�輱��' name , 28 , sysdate input_date
FROM dual;

------------------------��ġ �Լ�------------------------
-- ���밪 : abs(��)
SELECT abs(-8), abs(-8.2)
FROM dual;

-- �ݿø� : round(��), round(��,�ڸ���)
-- �ڸ������� �ݿø�x �ݿø��ؼ� �ڸ�����ŭ ������o
-- �Ǽ��� �ݿø� : �ݿø��Ͽ� �� �ڸ���
SELECT round(777.777,2), round(777.774,2), round(777.777,1), round(777.777)
FROM dual;

-- ������ �ݿø� : �ݿø��Ϸ��� �ڸ�
-- �����δ� �ش� �ڸ����� �ݿø� ����
SELECT round(777.777,-1), round(777.777,-2)
FROM dual;

-- �ø� : ceil
-- �Ҽ������Ͽ� ���� �����ϸ� ������ �ø�
SELECT ceil(10.1), ceil(10.01), ceil(10.000001)
FROM dual;

-- ���� : floor
SELECT floor(10.9), floor(10.09)
FROM dual;

-- ���� : trunc
-- �Ǽ��ο����� �� ���� �ڸ������� ����
-- �����ο����� �� �ڸ����� �ٷ� ����
SELECT trunc(555.555,1), trunc(555.555,-1), trunc(555.555)
FROM dual;

-- ��� ���̺��� �����ȣ, �����, ����, ������ ��ȸ
-- ��, ������ ������ 3.3%�� �����ϰ� ������ �����Ͽ� ���
-- �� ���� ���� -> 1�� ���� ����
SELECT empno, ename, sal, trunc(sal*0.033,-1) tax
FROM emp;

CREATE TABLE test_null(
	num number,
	name varchar2(30),
	input_date date
);

INSERT INTO test_null(num, name, input_date)
VALUES(1, '���ٿ�', sysdate);

-- ���ڳ� ��¥�� �÷��� �����Ǵ� ��쿡 null�� �Էµȴ�.
INSERT INTO test_null(name) VALUES('��ٿ�');

commit;

-- �����������̳� ������������ �÷��� �����ǰų�, ''�� �ԷµǸ� null�� �Էµȴ�.
-- �÷��� �����Ǵ� ���
INSERT INTO test_null(num) values(2);
-- ''�� �ԷµǴ� ���
INSERT INTO test_null(num,name,input_date) values(3,'',sysdate);

commit;

-- nvl
-- nvl(�÷���,null�� �� ��)
-- test_null ���̺��� ��ȣ, �Է����� ��ȸ
-- ��, ��ȣ�� ���ٸ� 0����, ��¥�� ���ٸ� ���� ��¥�� ���
-- ���ڿ��̴��� ������ ������ ���ٸ� ����� ��µ�
-- �� ��ȯ�� �ȴٸ� ������ �߻����� �ʴ´�.
-- ��¥ ������ ���ڿ� ����
SELECT nvl(num,0) num, nvl(input_date,'2022-08-02') input_date
FROM test_null;

SELECT num, input_date
FROM test_null;

-- ���� ���������� �ƴ϶�� ERROR �߻�
-- ���� ������ ���ڿ� ����
SELECT nvl(num, '10') num, nvl(input_date, sysdate) input_date
FROM test_null;
-- ���� ���������� �ƴϹǷ� ����
SELECT nvl(num, '10��') num, nvl(input_date, '������ ������') input_date
FROM test_null;

-- nvl2
-- test_null ���̺��� �̸��� �̸��� �ִ����� ��ȸ
-- nvl2(�÷���, null�� �ƴ� �� ��, null�� �� ��)
-- ��, �̸��� �ִٸ� '����' ������ '�͸�'
SELECT name, nvl2(name, '����', '�͸�')
FROM test_null;

-- ������̺��� �����ȣ, �����, ����, ���ʽ�, �Ѽ��ɾ��� ��ȸ
-- ��, �� ���ɾ��� ������ ���ʽ��� �ջ��� �ݾ����� ��ȸ
SELECT empno, ename, sal, comm, sal+nvl(comm,0) as total
FROM emp;

-- zipcode ���̺��� �ڽ��� �����ϴ� ���� �����ȣ, �õ�, ����, ��, ����
-- ��, ������ ���ٸ� '���� ����'�� ���
SELECT zipcode, sido, gugun, dong, nvl(bunji,'��������') bunji
FROM zipcode;

SELECT ZIPCODE, SIDO, GUGUN, DONG, BUNJI
FROM ZIPCODE
WHERE DONG LIKE '�󵵵�%';
