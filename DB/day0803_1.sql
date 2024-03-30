SELECT decode('AB','A','�ҽ��ϴ�','B','�����ϴ�','AB','������',
							'O','�����δ�','����� �������� �ƴմϴ�.')
FROM dual;

-- ������̺��� �����ȣ, �����, �μ���ȣ, �μ����� ��ȸ
-- ��, �μ����� �μ���ȣ�� 10���� ��� ���ߺ�, 20���� ��� ��������, 30���� ��� ����
-- �׿� �౸��
SELECT empno, ename, deptno, decode(deptno,10,'���ߺ�',20,'����������',30,'������','�౸��') deptname
FROM emp
ORDER BY deptno;

-- CASE��
SELECT empno, ename, deptno,
			 case deptno when 10 then '���ߺ�'
			 						 when 20 then '��������'
			 						 when 30 then '������'
			 						 else '�౸��'
			 end deptname
FROM emp;

-- ������̺��� �����ȣ, �����, �μ���ȣ, ����, Ư�����ʽ��� ��ȸ
-- ��, Ư�����ʽ��� �μ����� �յ�����
-- 10�� �μ��� ������ 10%�� ����
-- 20�� �μ��� ������ ���ʽ��� �ջ��� �ݾ� 35%
-- 30�� �μ��� ������ 50% �׿� ���� 100%�� ���
SELECT empno, ename, deptno, sal,
			 case deptno when 10 then sal*0.1
			 						 when 20 then sal*1.1*0.35
			 						 when 30 then sal*0.5
			 						 else sal
			 end bonus
FROM emp;

-------------------- ��ȯ�Լ� --------------------
-- ��¥ ��ȯ
-- ���� : y
-- �� : mm
-- �� : dd
-- ���ϼ� : d
SELECT sysdate, to_char(sysdate,'yyyy-mm-dd d dy day am hh(hh12, hh24):mi:ss')
FROM dual;

-- ��¥ ������ �ʹ� ��� error�߻�
SELECT to_char(sysdate,'yyyy " �� " mm " �� " dd " �� " hh " �� " mi " �� " ss " �� "')
FROM dual;

-- ��� ���̺��� �����ȣ, �����, �Ի��� ��ȸ
-- ��, �Ի����� ��-��-�� ������ �������� ���
SELECT empno, ename, to_char(hiredate, 'mm-dd-yyyy day') hiredate
FROM emp;

-- ��� ���̺��� �Ի�⵵�� 1981���� ����� �����ȣ
SELECT empno, ename, hiredate, sal
FROM emp
WHERE to_char(hiredate,'yyyy') = '1981';

-- to_char �տ��� �������� �ʴ� ������ ����
-- �Է��� ������ pattern ���̰� ������ ��µ��� ����
SELECT '[' || to_char(2023, '0,000,000'), '[' || to_char(2023, '9,999,999'),
				to_char(202308,'0,000')
FROM dual;

-- ������̺��� �����ȣ, ����, �μ���ȣ�� ��ȸ
-- ��, ������ �����Ͱ� �ִ� �ͱ����� 3�ڸ��� ,�־� ���
SELECT empno, to_char(sal,'9,999') sal, deptno
FROM emp;

-- date �÷��� sysdate�� �߰��ϴ� ��쿡 �ð� ������ ����.
-- date �÷��� �ٸ� ��¥ ������ �߰��� ������ ��¥������ ���ڿ��� ����ϰų�
-- to_date �Լ��� ���

-- ��¥ ������ ���ڿ�
INSERT INTO test_date values ('2023-08-04');
-- ��-��-���� ���°� �ƴ϶�� err
INSERT INTO test_date values ('08-04-2023');

-- to_date �Լ��� ���
INSERT INTO test_date values(to_date('2023-08-04', 'yyyy-mm-dd'));
-- to_date�� ���ڿ��� pattern�� �ش�Ǵ� ��¥�� ��ȯ�Ǳ� ������ insert ����
INSERT INTO test_date values(to_date('08-05-2023', 'mm-dd-yyyy'));

-- to_date�� ������� �ʾ��� �� err : �Լ� ȣ���ϴ� ��쿡��
-- to_char �Լ��� ù��° �Ű������� date�� ����Ǿ��ִ�.
SELECT to_char('2023-08-24','mm-dd-yyyy')
FROM dual;

SELECT * FROM test_date;

-- �ذ�� : ���ڿ��� ��¥������ �����ؾ��Ѵ�. to_date ���
SELECT to_char(to_date('2023-08-05','yyyy-mm-dd'), 'dd-mm-yyyy')
FROM dual;

-- to_number
SELECT '8'+'3', to_number('8') + to_number('3')
FROM dual;
