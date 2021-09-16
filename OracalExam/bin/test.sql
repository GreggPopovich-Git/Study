select * from tab;

select ename, salary, job, dno, nvl(commission,0), salary*12 as tot, salary*12+nvl(commission,0) from emp;

select sysdate from dual;

-- 1번 문제
select ename, salary, salary+300 from emp;
-- 2번 문제
select ename, salary, salary*12+100 from emp order by salary*12+100 desc;
-- 3번 문제
select ename, salary from emp where salary > 2000 order by salary desc;
-- 4번 문제
select ename, dno from emp where eno = 7788;
-- 5번 문제
select ename, salary from emp where salary not between 2000 and 3000;
-- 6번 문제
select ename, job, to_char(hiredate,'YY-MM-DD') from emp where hiredate between '81/02/20' and '81/05/01';
-- 7번 문제
select ename, dno from emp where dno = 20 or dno = 30 order by ename;
-- 8번 문제
select ename, salary, dno from emp where salary between 2000 and 3000 and dno in(20,30) order by ename;
-- 9번 문제
select ename, to_char(hiredate,'YY-MM-DD') from emp where hiredate like '81%';
-- 10번 문제
select ename, job from emp where manager is null;
-- 11번 문제
select ename, salary, commission from emp where commission is not null order by salary, commission;
-- 12번 문제
select ename from emp where ename like '__R%';
-- 13번 문제
select ename from emp where ename like '%A%' and ename like '%E%';
-- 14번 문제
select ename, job, salary from emp where job in('CLERK','SALESMAN') and salary not in(1600,950,1300);
-- 15번 문제
select ename, salary, commission from emp where commission >= 500;

-- 문제 1번
select substr(hiredate,1,2) 년도, substr(hiredate,4,2) 달 from emp;
-- 문제 2번
select * from emp where substr(hiredate,4,2) = '04';
-- 문제 3번
select * from emp where mod(eno,2) = 0;
-- 문제 4번
select to_char(hiredate,'YY-MM-DD'), to_char(hiredate,'YY/MON/DD DY') from emp;
-- 문제 5번
select trunc(sysdate - to_date('2021-01-01','YYYY/MM/DD')) from dual;
-- 문제 6번
select eno, ename, nvl(manager, 0) from emp;
-- 문제 7번
select eno, ename, job, salary, decode(job, 'ANALYST', salary+200,
										'SALESMAN', salary+180,
										'MANAGER', salary+150,
										'CLERK', salary+100, salary
										) as update_salary from emp;
