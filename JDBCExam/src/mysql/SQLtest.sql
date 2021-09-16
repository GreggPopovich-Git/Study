insert into test(idx, name, birth, age) values(1, 'aaa', '2021-05-20', 27);

select * from EMP;

update test set name = 'ddd' , birth = '2020-11-11', idx = '4' where idx = 3;

delete from test where idx = 3;

select * from EMP inner join EMP on EMP.DEPTNO = DEPT.DEPTNO;