-- �ߺ�����
-- DISTINCT, GROUP BY�� �� �� �ִ�.

-- ������̺��� �Ŵ��� ��ȣ�� ��ȸ
-- ��, �ߺ��� �Ŵ��� ��ȣ�� ������� �ʴ´�.
-- DISTINCT
-- DISTINCT�� �ߺ� ������ ���� ���� �ٸ� �÷��� ���� ����ص�
-- ������ �߻����� �ʴ´�. (�ߺ������� ���� �ʴ´�.)
-- �ߺ����� ���� �÷��� �Բ� ����ϸ� �ߺ������� ���� �ʴ´�.
-- �ߺ����� �ִ� �÷��� �Բ� ����ϸ� ���� �÷��� ���� �ߺ����� ����
SELECT DISTINCT mgr, deptno
FROM emp;

-- GROUP BY
-- GROUP BY �Ŀ� ���ǵ��� ���� �÷��� SELECT �÷��� ���Ǹ� ERROR �߻�
SELECT mgr
FROM emp
GROUP BY mgr;

-- �ߺ����� ���� �÷��� �Բ� ����ϸ� �ߺ������� ���� �ʴ´�.
SELECT mgr, ename
FROM emp
GROUP BY mgr, ename;

-- �ߺ����� �ִ� �÷��� �Բ� ����ϸ� ���� �÷��� ���� �ߺ����� ����
SELECT mgr, deptno
FROM emp
GROUP BY mgr, deptno;


-- GROUP BY HAVING : �׷����� �������� ������ ����
-- ��� ���̺��� ������� 3�� �̻��� �μ��� �μ���ȣ�� �˻�
SELECT deptno, count(deptno)
FROM emp
GROUP BY deptno
HAVING count(deptno) >= 3;

-- ��� ���̺��� 10�� �μ��� �ƴ� �μ��� �μ���ȣ
SELECT deptno         -- 4. ��ȸ
FROM emp              -- 1. emp ���̺���
GROUP BY deptno    		-- 3. �׷����� ����
HAVING deptno != 10;  -- 2. 10�� �μ��� �ƴ� �μ���

SELECT deptno         -- 4. ��ȸ
FROM emp              -- 1. emp ���̺���
WHERE deptno != 10    -- 2. 10�� �μ��� �ƴ� �μ��� ��ȸ
GROUP BY deptno;    	-- 3. �׷����� ���� ��

-------------------------------- ���� --------------------------------
-- ���� ����
-- ������̺��� �����ȣ, �����, ������ �˻�
-- ��, ������ ������������ �����Ͽ� ��ȸ
SELECT empno, ename, sal
FROM emp
ORDER BY sal;

-- ������̺��� �����ȣ, �����, ������ �˻�
-- ��, ������� ������������ �����Ͽ� ��ȸ
SELECT empno, ename, sal
FROM emp
ORDER BY ename desc;

-- ������̺��� �����ȣ, �����, ������ �˻�
-- ��, ������ ������������ �����Ͽ� ��ȸ, ���� ������ �����ϸ�
-- ������� ������������ �����Ͽ� ��ȸ
SELECT empno, ename, sal
FROM emp
ORDER BY sal, ename;

-- ���ڿ��� ������ �ڸ����� ����
-- char�� ������ ��� ù��° �ڸ����� ��-> �ι�° �ڸ����� �� -> ...
CREATE TABLE test_orderby(
num varchar2(5)
);

INSERT INTO test_orderby values('1');
INSERT INTO test_orderby values('1001');
INSERT INTO test_orderby values('2');
INSERT INTO test_orderby values('10002');
INSERT INTO test_orderby values('25');
INSERT INTO test_orderby values('201');
INSERT INTO test_orderby values('3');

commit;

select *
from test_orderby
order by num;

