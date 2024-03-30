-- cp_dept�� �μ���ȣ, �μ���, ��ġ�� �߰��ϴ� procedure ����
-- �μ���ȣ�� 0~99 ������ ���� �߰��� �� �ִ�.
-- 0~99������ ���� �ƴ϶�� ���� �߰����� �ʴ´�.
create or replace procedure insert_proc(deptno in number,
dname in varchar2, loc varchar2, cnt out number, msg out varchar2)
is

begin

	if deptno between 0 and 99 then
	   insert into cp_dept(deptno, dname, loc) values(deptno, dname, loc);

		 cnt := sql%rowcount;

		 if cnt = 1 then
		 msg := '�μ����� �߰� ����';
				commit;
		 end if;
	end if;

	exception
	when DUP_VAL_ON_INDEX then
	msg := '�μ����� �߰� ���� [�μ��� �̹� ������]';

end;
/
