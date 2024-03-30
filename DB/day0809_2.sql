-- _ORACLE_SCRIPT를 사용해야 c##이 붙어있지 않은 계정을 생성할 수 있다.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 자신의 이름의 이니셜로 계정 생성
CREATE USER ysy identified BY 1234;

-- 계정 조회 : dba_users DD
SELECT *
FROM dba_users
WHERE username IN ('SCOTT','YSY');

-- 권한 조회 : dba_role_privs, dba_sys_privs DD
SELECT *
FROM dba_role_privs
WHERE grantee IN ('SCOTT','YSY');

SELECT *
FROM dba_sys_privs
WHERE grantee IN ('SCOTT','YSY');

-- 생성한 계정에 접속 권한 부여
REVOKE RESOURCE FROM YSY; -- 권한 해제
GRANT CONNECT TO YSY;

-- 생성한 계정에 DB 사용 권한 부여
GRANT RESOURCE TO YSY;

-- 생성한 계정에 DBA 사용 권한 부여
GRANT DBA TO YSY;

-- 권한 회수
REVOKE DBA FROM YSY;

-- 계정 삭제
-- 객체를 생성하지 않은 계정 삭제
DROP USER ysy_sub;

-- 객체를 생성한 계정을 삭제 : cascade 옵션을 붙임
-- 접속중인 계정은 삭제 불가
DROP USER ysy CASCADE;


