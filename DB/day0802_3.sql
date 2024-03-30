--------------------- ���ڿ� �Լ� ---------------------
-- ���� : length
SELECT length('ABCD'), length('������ ������ �Դϴ�.')
FROM dual;

-- ������̺��� ������� 4������ ������� �����, ����, �Ի��� ��ȸ
SELECT ename, sal, hiredate
FROM emp
WHERE length(ename) = 4;

-- ��� �빮�� : UPPER
SELECT upper('AbcdEf') "AbcdEf"
FROM dual;

-- ��� �ҹ��� : LOWER
SELECT lower('AbcdEf') "AbcdEf"
FROM dual;

-- ��� ���̺��� ������� 'scott'�� ����� �����ȣ, �����, �Ŵ�����ȣ ��ȸ
SELECT empno, ename, mgr
FROM emp
WHERE ename = UPPER('scott');
-- WHERE lower(ename) = 'scott';

SELECT ename, lower(ename) lower_ename
FROM emp;

-- ù ���ڸ� �빮�ڷ� : initcap
-- ��� ���ڰ� �빮�ڿ��� ù ���ڸ� �빮�ڷ� �ٲ�
-- ���� ���Ŀ��� �����
SELECT initcap('oracle'), initcap('ORACLE'), initcap('i am boy'),
			 initcap('java oracle jdbc html')
FROM dual;

SELECT ename, initcap(ename)
FROM emp;

-- Ư�� ������ �ε��� ��� : instr
-- instr(���ڿ�,ã�����ڿ�)
-- instr(���ڿ�,ã�����ڿ�,���� �ε���)
-- ORACLE�� ���� �ε��� : 1
-- �ش� ���ڿ��� ������ : 0
SELECT instr('ABCDEF','A'), instr('ABCDEF','B'), instr('ABCDEF','K'),
			 instr('ABCDEF','CDE'), instr('ABCDEFAB','A',2)
FROM dual;

-- ��� ���̺��� ����� �ι�° ���ڿ� 'A'�� �ִ� ����� ������� ��ȸ
SELECT ename
FROM emp
WHERE instr(ename,'A') = 2;

-- Ư�� ���ڿ� ��� : substr
SELECT substr('ABCDEF',2,3), substr('ABCDEF',3)
FROM dual;

ALTER TABLE test_null add email varchar2(50) default 'test@test.com';

INSERT INTO test_null(email) values('kim@daum.net');
INSERT INTO test_null(email) values('sangjun@gmail.com');
INSERT INTO test_null(email) values('hongchanyoung@nate.com');
INSERT INTO test_null(email) values('chacha@charchar.co.kr');

-- test_null ���̺��� �̸��� �÷��� ����Ͽ� �����ּҿ� ������ �ּҸ� �и�
SELECT substr(email,1,instr(email,'@')-1) mail,
			 substr(email,instr(email,'@')+1) domain
FROM test_null
WHERE instr(email, 'gmail.com') <> 0;
-- WHERE email LIKE '%gmail.com';
-- WHERE substr(email, instr(email,'@')+1) = 'gmail.com';

-- �������� : trim
SELECT '['||trim('   A BC   ')||']',
			 '['||ltrim('   A BC   ')||']',
			 '['||rtrim('   A BC   ')||']'
FROM dual;

-- Ư�� ���ڿ� ���� trim ~ from
SELECT trim('a' from 'aaaaaaOracleaaaaaa')
FROM dual;

-- Ư�� ���� ä���
-- lpad(��, ��ü���ڼ�, ä�﹮�ڿ�)
-- �ѱ��� �� �ڿ� 2byte�� ó�� ��
-- ä������ ���ڿ� ��ü ���ڼ��� ���� ������ �������� �������� ä����
SELECT lpad('ABCDE', 10, '$'), lpad('������', 10, '$'), lpad('������', 11, 'ī')
FROM dual;

-- rpad(��, ��ü���ڼ�, ä�﹮�ڿ�)
SELECT rpad('ABCDE', 10, '#'), rpad('ABCDE', 8, 'u')
FROM dual;
