-- 숫자 두 개를 입력받아 + 연산 후 연산 결과를 내보내는 Procedure 작성
CREATE OR REPLACE PROCEDURE plus_proc(num1 IN NUMBER, num2 NUMBER, num3 OUT number, msg out varchar2)
IS

BEGIN
	-- <:= 오징어
	num3 := num1 + num2; -- := PL/SQL의 대입연산자
	msg := '오늘은 금요일 입니다.';
END;
/

