-- 하나의 테이블에서 사용
-- emp 테이블에서 7788 사원이 존재한다면 직무가 'MANAGER'인 사원들을 검색
-- 조회 컬럼 : 사원 번호, 사원명, 직무, 연봉을 조회
-- 사원 번호가 7789인 사원은 존재하지 않으므로 바깥 쿼리가 실행되지 않음 -> 조회 결과X
SELECT empno, ename, job, sal
FROM emp
WHERE job = 'MANAGER' AND EXISTS (SELECT 1 FROM emp WHERE empno = 7788);
-- SELECT ename FROM emp WHERE empno = 7788

SELECT *
FROM CP_EMP1;

-- cp_emp1테이블과 emp테이블에 동일하게 존재하는 사원에 대해서 사원번호
-- 사원번호, 사원명, 보서번호, 입사일, 연봉을 조회 
SELECT empno, ename, deptno, to_char(hiredate,'yyyy-mm-dd') hiredate, sal
FROM EMP
WHERE deptno = 30 AND EXISTS (SELECT 1 FROM cp_emp1 WHERE cp_emp1.empno = emp.empno);

-- car_model 테이블에서 car_maker 테이블에서 동일 모델이 존재하는 경우에
-- 모델이 K5인 차량에 대해서 모델명, 연식, 가격, 옵션 조회
SELECT model, car_year, cc, price, car_option
FROM car_model
WHERE model = 'K5' AND EXISTS (SELECT 1 FROM car_maker WHERE car_maker.model = car_model.model);

---------------------------------------------------------------------------------------------------
-- alter를 사용한 테이블 변경
CREATE TABLE test_alter (
num NUMBER,
neam varchar2(20),
addr NUMBER
);

-- 컬럼명 변경
ALTER TABLE test_alter RENAME COLUMN neam TO name;

-- 테이블명 변경
ALTER TABLE test_alter RENAME TO test_alter1;

-- 데이터형 변경
-- 레코드가 없는 경우 : 데이터형 자체를 변경할 수 있다.
-- ADDR 컬럼을 NUMBER -> VARCHAR2(300)
ALTER TABLE test_alter MODIFY addr varchar2(300);

INSERT INTO TEST_ALTER(num, name, addr) VALUES (1, '김선경', '서울시 강남구');

-- 레코드가 있는 경우 : 동일 데이터형에서 크기만 변경할 수 있다.
ALTER TABLE test_alter MODIFY addr NUMBER(22); -- 에러!
ALTER TABLE test_alter MODIFY addr varchar2(300) NOT NULL; -- 제약사항도 추가가능

-- 컬럼 추가
-- test_alter 테이블 age컬럼 추가
ALTER TABLE test_alter1 ADD age number(3) CHECK (age BETWEEN 20 AND 29);

-- test_alter 테이블에 primary key 제약을 가지는 id컬럼을 추가
-- 컬럼이 추가되면 null값이 들어가므로 X
-- 모든 레코드를 삭제한 후 PRIMARY KEY 제약을 가지는 컬럼을 추가
-- 모든 레코드 절사
TRUNCATE TABLE test_alter;
ALTER TABLE test_alter ADD id varchar2(20) CONSTRAINT PK_id PRIMARY KEY;

INSERT INTO TEST_ALTER(num, name, addr, age, id) VALUES (1, '김선경', '서울시 강남구', 25, 'kim');
INSERT INTO TEST_ALTER(num, name, addr, age, id) VALUES (2, '임태균', '경기도 용인시 처인구', 25, 'lim');

-- 컬럼 삭제
-- 제약사항과 상관없이 삭제 가능
-- age 컬럼 삭제
ALTER TABLE test_alter DROP COLUMN age;

---------------------------------------------------------------------------------------------------
-- alter를 사용한 제약사항 변경
-- 제약사항 삭제
-- test_alter1 테이블에서 PK 삭제
ALTER TABLE test_alter1 DROP CONSTRAINT Pk_id;

-- test_alter1 테이블에서 check 조건 삭제
ALTER TABLE test_alter1 DROP CONSTRAINT SYS_C007459;

-- 제약사항이 삭제되었으므로 제약사항에 위배되는 레코드를 추가할 수 있다.
INSERT INTO TEST_ALTER1 (id) VALUES ('kim');

-- 제약사항 추가 : 레코드의 상황에 따라 다르다.
-- id 컬럼에 PK제약설정
ALTER TABLE TEST_ALTER1 ADD CONSTRAINT PK_TEST_ALTER1 PRIMARY KEY(ID);

DELETE FROM TEST_ALTER1 WHERE num IS NULL;

-- 제약사항의 활성화, 비활성화
-- id 컬럼의 제약사항 비활성화 => 같은 아이디가 입력된다.
ALTER TABLE TEST_ALTER1 disable CONSTRAINT pk_test_alter1;
-- 동일 아이디가 입력된다.
INSERT INTO TEST_ALTER1 (id) VALUES ('kim');

-- id 컬럼의 제약사항 활성화 : 레코드의 상태에 따라 다르다.
-- 제약사항에 위배되는 레코드를 삭제한 후 활성화해야한다.
ALTER TABLE TEST_ALTER1 enable CONSTRAINT pk_test_alter1;
DELETE FROM TEST_ALTER1 WHERE num IS NULL;

SELECT *
FROM user_constraints
WHERE table_name = 'TEST_ALTER1';

SELECT * 
FROM TEST_ALTER1;