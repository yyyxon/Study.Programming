--���ڿ��� ������ ��
--ũ�⸦ �������� ������ �⺻ ����� ��
--char, varchar2�� 0�� �⺻ �������̹Ƿ� ������ ���ڿ� �ȵ�
create table test_string(
ssn char, --ũ�⸦ �������� ������ ���� �Է��� �� ����
name varchar2(1));

--�̸�,����,�ּ� �����ϴ� ���̺� ����
--���� ���̰� ������ ��� char, �׷��� ������ varchar2
create table test_string(
name varchar2(15), --�ѱ� �ϳ��� 3byte UTF-8 2*2*2
gender char(1),
addr varchar2(200));

--������ ������ �ִ� ���̺��� �˻�
select tname
from tab;

--�� �߰� > �ѱ� 1�ڴ� 3byte, ������&���� 1�ڴ� 1byte
insert into test_string(name, gender, addr)
values('�ڻ���','M','����� ������ ���ﵿ �ѵ����� 8�� 4���ǽ� ���ڸ�');

insert into test_string
values('Ȳ�ݵ�����','M','����');

--byte���� �ʰ��Ͽ� ���� ���Ե�������
insert into test_string
values('Ȳ�ݵ�������','M','����');

--������&���� 1�ڴ� 1byte
insert into test_string
values('MMMMMMMMMMMMMM1','M','����');

SELECT *
FROM TEST_STRING;
