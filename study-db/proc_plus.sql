-- ���� �� ���� �Է¹޾� + ���� �� ���� ����� �������� Procedure �ۼ�
CREATE OR REPLACE PROCEDURE plus_proc(num1 IN NUMBER, num2 NUMBER, num3 OUT number, msg out varchar2)
IS

BEGIN
	-- <:= ��¡��
	num3 := num1 + num2; -- := PL/SQL�� ���Կ�����
	msg := '������ �ݿ��� �Դϴ�.';
END;
/

