select * from tab;
desc dept;
desc emp

-- constraint_type : R 일 경우 외래키
-- 
select owner, constraint_name, constraint_type, 
table_name, r_owner, r_constraint_name from user_constraints
where table_name in('EMP', 'DEPT');



insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values(9999, 'HONG','CLERK', '7788', to_date('2017/04/30', 'yyyy/mm/dd'), 1200, null, 50);

create table dept_fk(
deptno number(2) constraint deptfk_deptno_pk primary key,
dname varchar2(14),
loc varchar2(13)
);
desc dept_fk;

create table emp_fk(
empno number(4) constraint empfk_empno_pk primary key,
ename varchar2(10),
job varchar2(9),
mgr number(4),
hiredate date,
sal number(7,2),
comm number(7,2),
deptno number(2) constraint empfk_deptno_fk references dept_fk (deptno)
);

desc emp_fk;

insert into emp_fk
values(999, 'test_name', 'test_job', null, to_date('2001/01/01', 'yyyy/mm/dd'), 3000, null, 10);

insert into dept_fk
values(10, 'test_dname', 'test_loc');

select * from dept_fk;
select * from emp_fk;

delete from dept_fk where deptno = 10;