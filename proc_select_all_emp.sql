-- ��� ���̺��� ��� ����� �����ȣ, �����, ����, �μ���ȣ
-- �Ի��� ��ȸ
create or replace procedure select_all_emp(cur out sys_refcursor)
is

begin
                             , EMP
	--Ŀ���� ����.
	open cur for
		select empno, ename, sal, to_char(hiredate, 'yyyy-mm-dd') hiredate
		from emp;

end;
/
