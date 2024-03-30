SELECT decode('AB','A','소심하다','B','터프하다','AB','싸이코',
							'O','우유부단','사람의 혈액형이 아닙니다.')
FROM dual;

-- 사원테이블에서 사원번호, 사원명, 부서번호, 부서명을 조회
-- 단, 부서명은 부서번호가 10번인 경우 개발부, 20번인 경우 유지보수, 30번인 경우 영업
-- 그외 축구부
SELECT empno, ename, deptno, decode(deptno,10,'개발부',20,'유지보수부',30,'영업부','축구부') deptname
FROM emp
ORDER BY deptno;

-- CASE문
SELECT empno, ename, deptno,
			 case deptno when 10 then '개발부'
			 						 when 20 then '유지보수'
			 						 when 30 then '영업부'
			 						 else '축구부'
			 end deptname
FROM emp;

-- 사원테이블에서 사원번호, 사원명, 부서번호, 연봉, 특별보너스를 조회
-- 단, 특별보너스는 부서별로 균등지급
-- 10번 부서는 연봉의 10%로 설정
-- 20번 부서는 연봉과 보너스를 합산한 금액 35%
-- 30번 부서는 연봉의 50% 그외 연봉 100%로 출력
SELECT empno, ename, deptno, sal,
			 case deptno when 10 then sal*0.1
			 						 when 20 then sal*1.1*0.35
			 						 when 30 then sal*0.5
			 						 else sal
			 end bonus
FROM emp;

-------------------- 변환함수 --------------------
-- 날짜 변환
-- 연도 : y
-- 월 : mm
-- 일 : dd
-- 요일수 : d
SELECT sysdate, to_char(sysdate,'yyyy-mm-dd d dy day am hh(hh12, hh24):mi:ss')
FROM dual;

-- 날짜 형식이 너무 길면 error발생
SELECT to_char(sysdate,'yyyy " 년 " mm " 월 " dd " 일 " hh " 시 " mi " 분 " ss " 초 "')
FROM dual;

-- 사원 테이블에서 사원번호, 사원명, 입사일 조회
-- 단, 입사일은 월-일-년 요일의 형식으로 출력
SELECT empno, ename, to_char(hiredate, 'mm-dd-yyyy day') hiredate
FROM emp;

-- 사원 테이블에서 입사년도가 1981년인 사원의 사원번호
SELECT empno, ename, hiredate, sal
FROM emp
WHERE to_char(hiredate,'yyyy') = '1981';

-- to_char 앞에는 지워지지 않는 공백이 존재
-- 입력한 값보다 pattern 길이가 작으면 출력되지 않음
SELECT '[' || to_char(2023, '0,000,000'), '[' || to_char(2023, '9,999,999'),
				to_char(202308,'0,000')
FROM dual;

-- 사원테이블에서 사원번호, 연봉, 부서번호를 조회
-- 단, 연봉은 데이터가 있는 것까지만 3자마다 ,넣어 출력
SELECT empno, to_char(sal,'9,999') sal, deptno
FROM emp;

-- date 컬럼에 sysdate로 추가하는 경우에 시간 정보가 들어간다.
-- date 컬럼에 다른 날짜 정보를 추가할 때에는 날짜형식의 문자열을 사용하거나
-- to_date 함수를 사용

-- 날짜 형식의 문자열
INSERT INTO test_date values ('2023-08-04');
-- 연-월-일의 형태가 아니라면 err
INSERT INTO test_date values ('08-04-2023');

-- to_date 함수를 사용
INSERT INTO test_date values(to_date('2023-08-04', 'yyyy-mm-dd'));
-- to_date로 문자열이 pattern에 해당되는 날짜로 변환되기 때문에 insert 가능
INSERT INTO test_date values(to_date('08-05-2023', 'mm-dd-yyyy'));

-- to_date를 사용하지 않았을 때 err : 함수 호출하는 경우에만
-- to_char 함수의 첫번째 매개변수는 date로 선언되어있다.
SELECT to_char('2023-08-24','mm-dd-yyyy')
FROM dual;

SELECT * FROM test_date;

-- 해결법 : 문자열을 날짜형으로 변경해야한다. to_date 사용
SELECT to_char(to_date('2023-08-05','yyyy-mm-dd'), 'dd-mm-yyyy')
FROM dual;

-- to_number
SELECT '8'+'3', to_number('8') + to_number('3')
FROM dual;
