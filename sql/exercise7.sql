create table dept_temp
    as select * from dept;
select * from tab;
create table emp_temp
    as select * from emp;
select * from emp_temp;
select * from dept_temp;
   
-- 1. EMP ���̺��� ������ȣ�� 7499���� ������ ������ 5000�޷��� �����Ѵ�. 
update emp_temp set sal = 5000
where empno = 7499;
rollback;

-- 2. EMP���̺��� �μ���ȣ�� 20���� �������� ������ ���� ���޿��� 10% �λ��� �ݾ����� �����Ѵ�.
update emp_temp set sal = 1.1*sal
where deptno = 20;
rollback;

-- 3. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 50, �μ���ġ: BOSTON,  �μ���: RESERCH
insert into dept_temp values(50,'BOSTON','RESERCH');
rollback;


-- 4. EMP ���̺� �Ʒ��� ���� �����͸� �����Ѵ�.
-- ������ȣ: 9900, �����̸�: JACKSON, ����: SALESMAN, �μ���ȣ: 10, ���� : 800
insert into emp_temp(empno, ename, job, deptno, sal ) values(9900,'JACKSON','SALESMAN',10,800);\
rollback;

-- 5. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 60, �μ���ġ: NULL,  �μ���: MARKETING
insert into dept_temp values(60,'','MARKETING');
rollback;

-- 6. ������ȣ�� 7698���� ������ �μ���ȣ�� 7369�� ������ 
-- �μ���ȣ�� �����Ѵ�.
update emp_temp set deptno = (select deptno from emp_temp where empno = 7369)
where empno = 7698;
rollback;

-- 7. 20�� �μ��� �������� ��� �����Ѵ�.
delete from emp_temp 
where deptno = 20;
rollback;

-- 8. ������ 1000 ������ �������� �����Ѵ�.
delete from emp_temp 
where sal < 1000;
rollback;

-- 9. ������ȣ�� 7900 �� ������ ������ ���� ���޿��� 5% ������Ű��
--    �μ���ȣ�� 40���� �����Ѵ�.
update emp_temp set sal = 1.05*sal,deptno = 40
where empno = 7900;
rollback;

-- 10. ���縦 �������� �Ի����� 38�� �̻��� �����鿡 ���Ͽ� 
--     ������ 2��� �����ϰ� Ŀ�̼ǵ� 3000���� �����Ѵ�.
--    (�Ի����� �⵵�� �������� �ݿø��Ͽ� ����Ѵ�.)
update emp_temp set sal = 2*sal,comm = 3000
where (months_between(sysdate, round(hiredate,'yyyy'))/12)>38;
rollback;

create
         