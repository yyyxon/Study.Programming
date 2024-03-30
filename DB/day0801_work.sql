-- 1. ��� ���̺��� '10'�� �μ��� �ƴϸ鼭 ������ 1000�̻� 3000������
-- ��� �������  �����ȣ,�����, �Ի���,�μ���ȣ, ������ ��ȸ�ϼ���.
SELECT empno, ename, hiredate, deptno, sal
FROM emp
WHERE deptno <> 10 AND sal BETWEEN 1000 AND 3000;

-- 2. ��� ���̺��� ���ʽ��� �����ϴ� �������
-- �����ȣ, �����, ����, ���ʽ�, �� ���ɾ�, ������ ��ȸ �ϼ���.
-- ������ ������ 12������ ���� �����մϴ�.
-- �Ѽ��ɾ��� ���ް� ���ʽ��� �ջ��� �ݾ��Դϴ�.
SELECT empno, ename, sal, comm, ROUND(sal/12) as mon_sal, ROUND(sal/12)+comm total
FROM emp
WHERE comm is not null;

-- 3.  ��� ���̺��� �μ���ȣ�� 10,30��
-- ������� �����, �����ȣ, ������ ��ȸ �ϼ���.
-- ��, ����� "xxxx�� xxxx����� ������ xxx$�Դϴ�. "
-- �� �������� �ϰ�, inline view�� �÷����� OutPut ���� ������ ��.
SELECT empno || '�� ' || ename || ' ����� ������ ' || sal || '$�Դϴ�.' "OutPut"
FROM emp
WHERE deptno IN (10,30);

-- 4. ��� ���̺��� ������ 3000 �̸��� �������
-- �����ȣ, �����, �Ի���, ����, ����, �μ���ȣ�� ��ȸ �ϼ���.
-- ��, ������ ������������ ������ ��,
-- ���� ������ �ִٸ� ������� ������������ ������ ��.
SELECT empno, ename, hiredate, sal, job, deptno
FROM emp
WHERE sal < 3000
ORDER BY sal, ename desc;

-- 5.
CREATE TABLE test_like2 (
  num number(3),
  name varchar(30),
  addr varchar(300),
  highschool varchar(30)
);

INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(1, '��������', '����� ���۱� �󵵵�', '�����');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(2, '���븸', '��⵵ ��õ�� ���̱�', '��Ÿ��');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(3, '���¼�', '����� ���빮�� ���빮2��', '�����');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(4, '�ڻ���', '����� ���۱� �󵵵�', '������');
INSERT INTO test_like2 (num, name, addr, highschool) VALUES
(5, '�̵���', '����� ���۱� ���빮4��', '������');

-- 6. test_like2 ���̺��� '�����'�� �����ϸ�
-- �̸��� 3������ �л���  ��ȣ, �л���,  �ּ�, �б�������
-- �Ʒ���  ���� �������� ����ϼ���.
-- �÷����� ��ҹ��� �����Ͽ� OutPut���� �Ұ�.
-- ������� :  ��ȣ : x, �̸� : xx, �ּ� : xx, �б� : xx
SELECT '��ȣ : ' || num || ', �̸� : ' || name || ', �ּ� : ' ||
addr || ', �б� : ' || highschool "OutPut"
FROM test_like2
WHERE addr LIKE '�����%' AND name LIKE '___';

-- 7. ������̺��� ������� 4�����̰ų� ������ 3000�̻��� �����
-- �����ȣ, �����, ����, �Ի���, �μ���ȣ, ������ ��ȸ �� ��.
SELECT empno, ename, sal, hiredate, deptno, job
FROM emp
WHERE ename LIKE '____' OR sal >= 3000;

-- 8. ��� ���̺��� �����ȣ, �����, �Ի���, ����, ���⿬���� ��ȸ �ϼ���.
-- ���� ������ ���� �������� 7% ���� �ݾ����� ����Ͽ� ����� ��.
SELECT empno, ename, hiredate, sal, sal*1.07 next_sal
FROM emp;

-- 9. ��� ���̺��� ������� 'A'�� �����ϸ鼭 ������ 1600�̻���
-- ����� �����,����,����, �Ŵ�����ȣ, �Ի����� ��ȸ �� ��.
-- ��, �Ի����� ���� �ֱ��� ������� ����� ��.
SELECT ename, sal, job, mgr, hiredate
FROM emp
WHERE ename LIKE 'A%' AND sal >= 1600
ORDER BY hiredate DESC;
