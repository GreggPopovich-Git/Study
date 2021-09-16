-- 195p~ 혼자 해보기
-- 1번 문제
select ename, job from emp where job = (select job from emp where eno = 7788);
-- 2번 문제
select ename, job from emp where salary > (select salary from emp where eno = 7499);
-- 3번 문제
select ename, job, salary from emp where salary = (select min(salary) from emp);
-- 4번 문제
select job, round(avg(salary), 1) from emp group by job having round(avg(salary), 1) = (select min(round(avg(salary), 1)) from emp group by job);
-- 5번 문제
select ename, salary, dno from emp where salary in (select min(salary) from emp group by dno);
-- 6번 문제
select eno, ename, job, salary from emp where salary < any (select salary from emp where job = 'ANALYST') and job != 'ANALYST';
-- 7번 문제
select ename from emp where eno in (select eno from emp where manager is null);
-- 8번 문제
select ename from emp where eno in (select eno from emp where manager is not null);
-- 9번 문제
select ename, hiredate from emp where dno = (select dno from emp where ename = 'BLAKE') and ename != 'BLAKE';
-- 10번 문제
select eno, ename from emp where salary > (select avg(salary) from emp) order by salary;
-- 11번 문제
select eno, ename from emp where dno in (select dno from emp where ename like '%K%');
-- 12번 문제
select ename, dno, job from emp where dno = (select dno from dept where loc = 'DALLAS');
-- 13번 문제
select ename, salary from emp where manager = (select eno from emp where ename = 'KING');
-- 14번 문제
select dno, ename, job from emp where dno = (select dno from dept where dname = 'RESEARCH');
-- 15번 문제
select eno, ename, salary from emp where salary > (select avg(salary) from emp) and dno in (select dno from emp where ename like '%M%');
-- 16번 문제
select job, avg(salary) from emp group by job having avg(salary) = (select min(avg(salary)) from emp group by job);
-- 17번 문제
select ename from emp where eno in (select manager from emp);

select * from tab;
