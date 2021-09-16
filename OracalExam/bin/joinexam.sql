-- EQUI JOIN (inner join)

select * from emp, dept where emp.dno = dept.dno;

select eno, ename, dname, e.dno from emp e, dept d where e.dno = d.dno and eno = 7788;

-- NATURAL JOIN (자동으로 공통 컬럼을 찾아줌)

select eno, ename, dname, dno from emp e natural join dept d where eno = 7788;

-- OUTER JOIN (null 값이 있을 경우 포함 해야 할 경우) 뒤에 (+) 붙이면 됨

select e.ename ||'의 직속 상관은'|| m.ename from emp e join emp m on e.manager = m.eno(+);

-- 문제 1번
select e.ename, e.dno, d.dname from emp e, dept d where e.dno = d.dno and e.ename = 'SCOTT';
-- 문제 2번
select ename, dname, loc from emp, dept where emp.dno = dept.dno order by dname;
-- 문제 3번
select emp.dno, job, loc from emp, dept where emp.dno = dept.dno and emp.dno = 10;
-- 문제 4번
select ename, dname, loc from emp, dept where emp.dno = dept.dno and commission > 0;
-- 문제 5번
select ename, dname from emp, dept where emp.dno = dept.dno and ename like '%A%';
-- 문제 6번
select ename, job, emp.dno, dname from emp, dept where emp.dno = dept.dno and loc = 'NEW YORK';
-- 문제 7번
select e1.ename, e1.eno, e2.manager, e2.ename from emp e1, emp e2 where e1.manager = e2.eno;
-- 문제 8번
select e1.ename, e1.eno, e2.manager, e2.ename from emp e1, emp e2 where e1.manager = e2.eno(+) order by eno desc;
-- 문제 9번
select e1.ename, e1.dno, e2.ename from emp e1, emp e2 where e1.dno = e2.dno and e1.ename = 'SCOTT' and e2.ename != 'SCOTT';
-- 문제 10번
select e2.ename, e2.hiredate from emp e1, emp e2 where e1.hiredate < e2.hiredate and e1.ename = 'WARD' order by hiredate;
-- 문제 11번
select e1.ename, e1.hiredate, e2.ename, e2.hiredate from emp e1, emp e2 where e1.manager = e2.eno and e1.hiredate <= e2.hiredate;


