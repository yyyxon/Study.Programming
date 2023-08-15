-- 숙제 1. zipcode 테이블을 복사하여 cp_zipcode 테이블을 생성하세요.
create table cp_zipcode as ( select * from zipcode);
ALTER TABLE cp_zipcode ADD CONSTRAINT pk_cp_zipcode PRIMARY key(seq);

-- 2. 아래의 제약사항을 설정하여 테이블을 생성하세요.
CREATE TABLE account(
	num number,
	id varchar2(30) CONSTRAINT PK_account_id PRIMARY KEY,
	name varchar2(30) NOT NULL,
	addr_seq number CONSTRAINT FK_account_addr_seq REFERENCES cp_zipcode(seq),
	phone varchar2(13) CONSTRAINT UK_account_phone UNIQUE,
	age number(3) DEFAULT 0,
	gender char(1) CHECK (gender IN ('M', 'F')),
	input_date DATE DEFAULT sysdate
);

-- 3. 위의 제약사항을 성공하는 경우, 실패하는 모든 경우를 작성하세요.
-- 성공
-- id가 null이 아니면서 중복값이 아니고, 
-- name이 null이 아니고,
-- addr_seq의 값이 null이거나 cp_zipcode의 seq에 존재하는 값이고,
-- phone의 값이 null이거나 중복되지않은 값이고,
-- gender에 M또는 F값을 입력했고,
-- age와 inputdate를 생략한 경우 / age는 생략하고 input_date는 입력한 경우 / age는 입력하고 input_date는 생략한 경우
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (100, '모두생략', '테스트이름', 168, '010-9999-7890', 'M');
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (100, 'age생략', '테스트이름', 168, '010-9998-7890', 'F', '2023-08-25');
INSERT INTO account (num, id, name, addr_seq, phone, age, gender)
VALUES (100, 'input_date생략', '테스트이름', 168, '010-9997-7890', 20, 'F');

-- 실패
-- id가 null이거나 중복값이 있는 경우
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, '', '김주민', 168, '010-9999-7890', 'M');
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, 'kim', '김주민', 168, '010-9999-7890', 'M');
-- name에 값을 입력하지 않는 경우 ('', 또는 컬럼 생략)
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, 'kim3', '', 168, '010-9999-7890', 'M');
-- cp_zipcode에 존재하지 않는 값을 addr_seq에 입력하는 경우
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, 'kim3', '김주민', 168168168, '010-9999-7890', 'M');
-- phone의 값이 중복되는 경우
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, 'kim3', '김주민', 168, '010-1234-7890', 'M');
-- gender에 M또는 F외의 값을 입력했을 경우 
INSERT INTO account (num, id, name, addr_seq, phone, gender)
VALUES (1, 'kim3', '김주민', 168, '010-9999-7890', 'S');

-- 4. 3번으로 생성한 테이블에 아래와 같은 데이터를 추가하세요.
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (1, 'kim', '김주민', 168, '010-1234-7890', 'M', sysdate);
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (2, 'kim1', '김선경', 52144, '010-2234-8811', 'M', sysdate);
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (3, 'lee', '동원', 3298, '010-8471-1345', 'M', sysdate);
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (4, 'kim2', '김인영', 1, '010-1111-2222', 'F', sysdate);
INSERT INTO account (num, id, name, addr_seq, phone, gender, input_date)
VALUES (5, 'hong', '홍지성', 35000, '010-4511-3134', 'M', sysdate);
COMMIT;

SELECT *
FROM account;

-- 5. 아이디, 이름, 전화번호, 우편번호, 주소를 조회하세요.
-- 주소는 cp_zipcode 테이블에 sido,gugun,dong 컬럼을 결합하여 하나로 출력합니다.
SELECT id, name, phone, 
(SELECT zipcode FROM cp_zipcode WHERE seq = addr_seq) zipcode, 
(SELECT sido || ' ' || gugun || ' ' || dong FROM cp_zipcode WHERE seq = addr_seq) addr
FROM account;

SELECT *
FROM user_tab_cols
WHERE table_name = 'CP_ZIPCODE';

-- oracle : alter 안됨, modify 가능한
-- add, drop column
