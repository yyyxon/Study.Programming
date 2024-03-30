--alias ���

--������̺��� �����ȣ, �����, ����, �μ���ȣ �˻�
--��, �����ȣ�� emp_no��, ������� emp_name����, �μ���ȣ�� dept_no
--�� ����� ��.

SELECT  empno as emp_no, ename emp_name, job, deptno dept_no
FROM  emp;


-----------------------������-------------------------------
--���ڿ� ���� : ||
--������̺��� �����, ������ ��ȸ
--��, ����� xxx���� ������ xxx�Դϴ�.

SELECT  ename || '���� ������ ' || sal || '�Դϴ�.' "output"
FROM  emp;

SELECT   empno || ename || sal || mgr
FROM    emp;


--��� : + , - , * , /

--��� ���̺��� ��� ��ȣ, �����, ������ ��ȸ
--��, �����ȣ�� ���� ��ȣ���� 1 ������ ������ ��ȸ�� ��.
SELECT empno, empno +1 increment_num, ename, sal
FROM  EMP;

-- ��� ���̺��� �����ȣ, �����, �Ŵ��� ��ȣ, ����, ������ ��ȸ
--��, ������ ������ 3.3%�� ������ ���� ���
SELECT  empno,ename, mgr, sal, sal *0.033 tax
FROM  EMP;

-- null�� �����ϸ� ����� null�� ���´�.
-- ��� ���̺��� �����, ����, ���ʽ�, �� ���ɾ� ��ȸ
-- ��, �� ���ɾ��� ������ ���ʽ��� �ջ��� �ݾ�
SELECT ename, sal, comm, sal+comm as total
FROM emp;

-- ��� ���̺��� �����ȣ, �Ŵ�����ȣ, �����, ����, ������ ��ȸ
-- ��, ������ ������ 12�� ���� ��
SELECT *
FROM emp;

SELECT empno, mgr, ename, sal, ROUND(sal/12) as mon_sal
FROM emp;

-- ������ ���� mod�Լ��� ����Ͽ� �����Ѵ�.
-- ����) MOD(�÷���,������)

-- ��� ���̺��� �����ȣ, �����ȣ�� 2�� ���� �������� ��ȸ
SELECT empno, MOD(empno,2)
FROM emp;

-- ��� �����ڰ� �ƴ� �ٸ� �����ڸ� ��ȸ �÷��� ����ϸ� error
SELECT sal
FROM emp
WHERE sal > 2000;

-- ���� ������
-- ��� ���̺��� ��� ��ȣ�� 7844�� ����� �����ȣ, �����,
-- ����, ����, �Ի���
SELECT empno, ename, job, sal, hiredate
FROM emp
WHERE empno = 7844;

-- ��� ���̺��� ������ 1250�� �ʰ��ϴ� �������
-- �����ȣ, �����, ����, �Ի���, �μ���ȣ, ���ʽ�
SELECT empno, ename, sal, hiredate, deptno, comm
FROM emp
WHERE sal >= 1250;

-- ��� ���̺��� ������ 3000 �̸��� �������
-- �����ȣ, �����, ����, �Ի���, �μ���ȣ, ���ʽ�
SELECT empno, ename, sal, hiredate, deptno, comm
FROM emp
WHERE sal < 3000;

-- ��� ���̺��� 10�� �μ��� �ƴ� ��� �μ� �����
-- �μ���ȣ, �����ȣ, �����, ������ ��ȸ
SELECT deptno, empno, ename, sal
FROM emp
WHERE deptno <> 10;
-- WHERE deptno != 10;
-- !=�� <>�� ��밡��

SELECT deptno, empno, ename, sal
FROM emp
WHERE deptno not in 10;

-- ��� ���̺��� ������ 2450~3000 ������ ��� �����
-- �����ȣ, �����, ����, �Ŵ�����ȣ, �Ի����� ��ȸ
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal BETWEEN 2450 AND 3000;
-- WHERE sal >= 2450 AND sal <= 3000;

-- BETWEEN�� �������� ���� ���;��Ѵ�.
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal BETWEEN 3000 AND 2450;

-- �����ڸ� ����ϸ� ���Ǹ� ������ �˻��� �ȴ�.
SELECT empno, ename, sal, mgr, hiredate
FROM emp
WHERE sal <= 3000 AND sal >= 2450;

-- ������̺��� ��� ��ȣ�� 7521, 7566, 7788�� �������
-- �����ȣ, �����, ����, ������ ��ȸ
SELECT empno, ename, job, sal
FROM emp
WHERE empno = 7521 OR empno = 7566 OR empno = 7788;

SELECT empno, ename, job, sal
FROM emp
WHERE empno IN (7521, 7566, 7788);

-- ������̺��� ������� KING, ADAMS, FORD�� ����� �����ȣ,
-- �����, �Ի���, ������ ��ȸ
SELECT '����� [' || ename || '] �Ի����� [' || hiredate || '] ���� [' || sal || ']' as output
FROM emp
WHERE ename IN ('KING', 'ADAMS', 'FORD');
