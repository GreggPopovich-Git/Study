-- 154 page
-- 1번 문제
select max(salary) Max, min(salary) Min, sum(salary) Sum, round(avg(salary)) from emp;
-- 2번 문제
select job, max(salary) Max, min(salary) Min, sum(salary) Sum, round(avg(salary),0) Avg from emp group by job;
-- 3번 문제
select job, count(*) cnt from emp group by job;
-- 4번 문제
select count(manager) mcnt from emp;
-- 5번 문제
select max(salary) - min(salary) diff from emp;
-- 6번 문제
select job, min(salary) Min from emp group by job having not min(salary) < 2000 order by min(salary) desc;
-- 7번 문제
select dno, count(*) cnt, round(avg(salary),2) Avg from emp group by dno;
-- 8번 문제
select decode(dno, 10, 'ACCOUNTING',
				   20, 'RESEARCH',
				   30, 'SALES',
				   40, 'OPERATIONS') dname,
	   decode(dno, 10, 'NEW YORK',
	   			   20, 'DALLAS',
	   			   30, 'CHICAGO',
	   			   40, 'BOSTON') loc,
	   count(*) cnt, round(avg(salary)) sal from emp group by dno;
-- 9번 문제
select job, dno, decode(dno, 10, sum(salary)) d10,
				 decode(dno, 20, sum(salary)) d20,
				 decode(dno, 30, sum(salary)) d30,
				 sum(salary) tot from emp group by job, dno order by dno;