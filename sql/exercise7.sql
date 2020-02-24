create table dept_temp
    as select * from dept;
select * from tab;
create table emp_temp
    as select * from emp;
select * from emp_temp;
select * from dept_temp;
   
-- 1. EMP 테이블에서 직원번호가 7499번인 직원의 월급을 5000달러로 변경한다. 
update emp_temp set sal = 5000
where empno = 7499;
rollback;

-- 2. EMP테이블에서 부서번호가 20번인 직원들의 월급을 현재 월급에서 10% 인상한 금액으로 변경한다.
update emp_temp set sal = 1.1*sal
where deptno = 20;
rollback;

-- 3. DEPT 테이블에 아래의 조건으로 데이터를 입력한다.
-- 부서번호: 50, 부서위치: BOSTON,  부서명: RESERCH
insert into dept_temp values(50,'BOSTON','RESERCH');
rollback;


-- 4. EMP 테이블에 아래와 같은 데이터를 삽입한다.
-- 직원번호: 9900, 직원이름: JACKSON, 직업: SALESMAN, 부서번호: 10, 월급 : 800
insert into emp_temp(empno, ename, job, deptno, sal ) values(9900,'JACKSON','SALESMAN',10,800);\
rollback;

-- 5. DEPT 테이블에 아래의 조건으로 데이터를 입력한다.
-- 부서번호: 60, 부서위치: NULL,  부서명: MARKETING
insert into dept_temp values(60,'','MARKETING');
rollback;

-- 6. 직원번호가 7698번인 직원의 부서번호를 7369번 직원의 
-- 부서번호로 변경한다.
update emp_temp set deptno = (select deptno from emp_temp where empno = 7369)
where empno = 7698;
rollback;

-- 7. 20번 부서의 직원들을 모두 삭제한다.
delete from emp_temp 
where deptno = 20;
rollback;

-- 8. 월급이 1000 이하인 직원들을 삭제한다.
delete from emp_temp 
where sal < 1000;
rollback;

-- 9. 직원번호가 7900 인 직원의 월급을 현재 월급에서 5% 증가시키고
--    부서번호를 40으로 변경한다.
update emp_temp set sal = 1.05*sal,deptno = 40
where empno = 7900;
rollback;

-- 10. 현재를 기준으로 입사한지 38년 이상인 직원들에 대하여 
--     월급을 2배로 변경하고 커미션도 3000으로 변경한다.
--    (입사일은 년도를 기준으로 반올림하여 계산한다.)
update emp_temp set sal = 2*sal,comm = 3000
where (months_between(sysdate, round(hiredate,'yyyy'))/12)>38;
rollback;

create
         