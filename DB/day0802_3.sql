--------------------- 문자열 함수 ---------------------
-- 길이 : length
SELECT length('ABCD'), length('오늘은 수요일 입니다.')
FROM dual;

-- 사원테이블에서 사원명이 4글자인 사원들의 사원명, 연봉, 입사일 조회
SELECT ename, sal, hiredate
FROM emp
WHERE length(ename) = 4;

-- 모두 대문자 : UPPER
SELECT upper('AbcdEf') "AbcdEf"
FROM dual;

-- 모두 소문자 : LOWER
SELECT lower('AbcdEf') "AbcdEf"
FROM dual;

-- 사원 테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명, 매니저번호 조회
SELECT empno, ename, mgr
FROM emp
WHERE ename = UPPER('scott');
-- WHERE lower(ename) = 'scott';

SELECT ename, lower(ename) lower_ename
FROM emp;

-- 첫 글자를 대문자로 : initcap
-- 모든 글자가 대문자여도 첫 글자만 대문자로 바꿈
-- 띄어쓰기 이후에도 적용됨
SELECT initcap('oracle'), initcap('ORACLE'), initcap('i am boy'),
			 initcap('java oracle jdbc html')
FROM dual;

SELECT ename, initcap(ename)
FROM emp;

-- 특정 문자의 인덱스 얻기 : instr
-- instr(문자열,찾을문자열)
-- instr(문자열,찾을문자열,시작 인덱스)
-- ORACLE의 시작 인덱스 : 1
-- 해당 문자열이 없으면 : 0
SELECT instr('ABCDEF','A'), instr('ABCDEF','B'), instr('ABCDEF','K'),
			 instr('ABCDEF','CDE'), instr('ABCDEFAB','A',2)
FROM dual;

-- 사원 테이블에서 사원명에 두번째 글자에 'A'가 있는 사원의 사원명을 조회
SELECT ename
FROM emp
WHERE instr(ename,'A') = 2;

-- 특정 문자열 얻기 : substr
SELECT substr('ABCDEF',2,3), substr('ABCDEF',3)
FROM dual;

ALTER TABLE test_null add email varchar2(50) default 'test@test.com';

INSERT INTO test_null(email) values('kim@daum.net');
INSERT INTO test_null(email) values('sangjun@gmail.com');
INSERT INTO test_null(email) values('hongchanyoung@nate.com');
INSERT INTO test_null(email) values('chacha@charchar.co.kr');

-- test_null 테이블의 이메일 컬럼을 사용하여 메일주소와 도메인 주소를 분리
SELECT substr(email,1,instr(email,'@')-1) mail,
			 substr(email,instr(email,'@')+1) domain
FROM test_null
WHERE instr(email, 'gmail.com') <> 0;
-- WHERE email LIKE '%gmail.com';
-- WHERE substr(email, instr(email,'@')+1) = 'gmail.com';

-- 공백제거 : trim
SELECT '['||trim('   A BC   ')||']',
			 '['||ltrim('   A BC   ')||']',
			 '['||rtrim('   A BC   ')||']'
FROM dual;

-- 특정 문자열 삭제 trim ~ from
SELECT trim('a' from 'aaaaaaOracleaaaaaa')
FROM dual;

-- 특정 문자 채우기
-- lpad(값, 전체글자수, 채울문자열)
-- 한글은 한 자에 2byte로 처리 됨
-- 채워지는 문자와 전체 글자수가 맞지 않으면 나머지는 공백으로 채워짐
SELECT lpad('ABCDE', 10, '$'), lpad('가나다', 10, '$'), lpad('가나다', 11, '카')
FROM dual;

-- rpad(값, 전체글자수, 채울문자열)
SELECT rpad('ABCDE', 10, '#'), rpad('ABCDE', 8, 'u')
FROM dual;
