-- 1.��� ���̺��� �����ȣ,�����, �Ի���, ������ ��ȸ�ϼ���.
-- ��, ������ ��ü 8�ڸ��� �Ͽ� $�� �ٿ� ����ϰ�, ������ ������������ �����Ͽ� ����ϼ���
-- ��) $00001250
SELECT empno, ename, hiredate, '$' || lpad(sal,8,0) sal
FROM emp
ORDER BY sal;

-- 2.��� ���̺��� ������ MANAGER, SALESMAN, CLERK�� �����
-- �����ȣ, �����, ����, �Ի���, ����, ���ʽ�, �Ǽ��ɾ��� ��ȸ�ϼ���.
-- ��, ������� ù���ڸ� �빮�ڷ� ����� ��.
-- �Ǽ��ɾ��� ������ ���ʽ��� �ջ��� �ݾ׿��� 3.3%�� �� �ݾ����� �����ϵ�
-- �������� �ݿø��Ͽ� ����� ��.
SELECT empno, initcap(ename) ename, job, hiredate, sal, comm, ROUND(sal + nvl(comm,0) - ((sal + nvl(comm,0)) * 0.033)) as pay
FROM emp
WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

-- 3. car_model ���̺��� ���� k5, �ƹ���, a8�̰ų� �ɼǿ� ��ABS���� �ִ� ��
-- ������ ����, ����, �ɼ�,�̹����� ��ȸ�ϼ���.
-- ��. �𵨸��� �ҹ��ڷ� ����� ��.
-- car_option�� �ι�° , ������ ����� ��
-- �̹����� ��� �ҹ��ڷ� ����� ��.
-- ������ ������������ �����ϵ� ������ ���ٸ�, �𵨸��� ������������ �����Ұ�
SELECT LOWER(model) model, price, car_year,
			 TRIM(SUBSTR(car_option,1,INSTR(car_option,',',INSTR(car_option,',')+1)-1)) car_option,
			 LOWER(car_img) car_img
FROM car_model
WHERE LOWER(model) IN ('k5','�ƹ���','a8') OR INSTR(car_option,'ABS') <> 0
ORDER BY price desc, model desc;

select *
from car_model;