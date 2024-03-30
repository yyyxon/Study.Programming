--�����Լ�

SELECT  DECODE( 'l','A','�ҽ��ϴ�','B','�����ϴ�',
'AB','������','O','�����δ�','����� �ƴϹ��̴�') as ������
FROM   dual;

--��������񿡼� �����ȣ, �����, �μ���ȣ, �μ����� ��ȸ
--��, �μ����� �μ���ȣ�� 10���� ��� ���ߺ�, 20��-��������,
--30-���� , �� �� �౸��
SELECT EMPNO, ENAME, DEPTNO ,
			DECODE( DEPTNO, 10,'���ߺ�',20,'��������',30,'����',
			'�౸��') as deptname
FROM  EMP;

--case�� ���
SELECT  EMPNO, ENAME, DEPTNO,
				case deptno when 10 then '���ߺ�'
										when 20 then '��������'
										when 30 then '������'
										else '�౸��'
				end hangul_dname
FROM EMP;

--������̺��� �����ȣ, �����, �μ���ȣ, ����, Ư��
--���ʽ��� ��ȸ
--��, Ư�����ʽ��� �μ����� �յ�����
--10�� �μ��� ������ 10%�� ����
--20�� �μ��� ������ ���ʽ��� �ջ��� �ݾ� 15%
--30�� �μ��� ������ 50% ,�� �� ���� 100%�� ���
SELECT EMPNO, ENAME, DEPTNO, SAL
			case  when
					  when
					  when
					  else
			end
FROM  EMP;

                                ��
------------��ȯ�Լ�-------------------------
--��¥��ȯ
SELECT sysdate, to_char(sysdate,'yyyy-mm-dd d dy day am hh(hh12, hh24):mi:ss') as "date"
FROM   dual;

--��¥ ������ �ʹ� ��� error �߻�
SELECT to_char
(sysdate,'yyyy " ��" mm " ��" dd " �� " hh " �� " mi " �� " ss " �� "  ') as "date"
FROM   dual;


--��� ���̺��� ��� ��ȣ, �����, �Ի��� ��ȸ
--��, �Ի����� ��-��-�� ������ �������� ���
SELECT EMPNO, ENAME, to_char(HIREDATE, 'mm - dd - yyyy') as hiredate
FROM  EMP;

--������̺��� �Ի�⵵�� 1981���� ����� �����ȣ, �����
--�Ի���, ������ ��ȸ
SELECT EMPNO, ENAME, HIREDATE, SAL
FROM  EMP
WHERE to_char(HIREDATE,'yyyy') = 1981 ;


--���ں�ȯ
SELECT '['||to_char(2023,'0,000,000') ,'['||to_char(2023,'9,999,999'),
				to_char(202308,'0,000')
FROM   dual;

--������̺��� �����ȣ, ����, �μ���ȣ�� ��ȸ
--��, ������ �����Ͱ� �ִ� �� ������ 3�ڸ��� , �� �־����
SELECT EMPNO, to_char(SAL,'9,999,999'), DEPTNO
FROM 	EMP ;


--���ں�ȯ
select * from TEST_DATE;
--date �÷��� sysdate�� �߰��ϴ� ��쿡 �ð� ������ ����
--date �÷��� �ٸ� ���� ������ �߰��� ������ ��¥������
--���ڿ��� ����ϰų� to_date �Լ��� ���
insert into test_date values('2023-08-04');

--����������� �ƴϾ error
insert into test_date values('08-04-2023');

--to_date �Լ��� ����Ͽ� ��¥���� �߰�
insert into test_date values(to_date('2023-08-04','yyyy-mm-dd'));
--to_date�� ���ڿ��� pattern�� �ش�Ǵ� ��¥�� ��ȯ�Ǳ�
--������ insert�� �ȴ�.
insert into test_date values(to_date('08-04-2023','mm-dd-yyyy'));

select * from TEST_DATE;

--to_date�� ������� �ʾ����� error : �Լ�ȣ���ϴ� ��쿡��
--to_char�Լ��� ù ��° �Ű������� date�� ����Ǿ��ִ�.
SELECT  to_char('2023-08-24','mm-dd-yyyy')
FROM 	dual;

--�ذ�� : ���ڿ��� TEST_LIKE, TEST_LIKE��¥ �������� �����ؾ� �Ѵ�
--to_date ���
SELECT  to_char(to_date('2023-08-05','yyyy-mm-dd'),'dd-mm-yyyy')
FROM   dual;


--���ں�ȯ
SELECT  '8'+'3' ,to_number('8') + to_number('3')
FROM   dual;

