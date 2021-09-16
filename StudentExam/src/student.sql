use jsl49;
show tables;
-- 복합 기본키
create table tbl_student_201905(
	syear char(1) not null,
	sclass char(2) not null,
	sno char(2) not null,
	sname varchar(20) not null,
	birth char(8),
	gender char(1),
	tel1 char(3),
	tel2 char(4),
	tel3 char(4),
	primary key(syear, sclass, sno)
);
-- 복합 기본키
create table tbl_dept_201905(
	syear char(1) not null,
	sclass char(2) not null,
	tname varchar(20),
	primary key(syear, sclass)
);
-- 복합 외래키
create table tbl_score_201905(
	syear char(1) not null,
	sclass char(2) not null,
	sno char(2) not null,
	kor int(3),
	eng int(3),
	mat int(3),
	foreign key(syear,sclass,sno) references tbl_student_201905(syear,sclass,sno)
);
-- student table 자료입력
insert into tbl_student_201905 values ('1','01','01','김학생','20020101','F','010','1234','1001');
insert into tbl_student_201905 values ('1','01','02','이학생','20020201','M','010','1234','1002');
insert into tbl_student_201905 values ('1','01','03','박학생','20020301','M','010','1234','1003');
insert into tbl_student_201905 values ('1','02','01','조학생','20020401','M','010','1234','1004');
insert into tbl_student_201905 values ('1','02','02','유학생','20020501','M','010','1234','1005');
insert into tbl_student_201905 values ('1','02','03','여학생','20020601','M','010','1234','1006');
insert into tbl_student_201905 values ('1','03','01','남학생','20020701','F','010','1234','1007');
insert into tbl_student_201905 values ('1','03','02','황학생','20020801','F','010','1234','1008');
insert into tbl_student_201905 values ('1','03','03','전학생','20020901','F','010','1234','1009');
-- dept table 자료입력
insert into tbl_dept_201905 values ('1','01','김교사');
insert into tbl_dept_201905 values ('1','02','이교사');
insert into tbl_dept_201905 values ('1','03','박교사');
-- score table 자료입력
insert into tbl_score_201905 values ('1','01','01','50','50','50');
insert into tbl_score_201905 values ('1','01','02','60','40','100');
insert into tbl_score_201905 values ('1','01','03','70','70','70');
insert into tbl_score_201905 values ('1','02','01','80','80','80');
insert into tbl_score_201905 values ('1','02','02','50','50','50');
insert into tbl_score_201905 values ('1','02','03','40','90','80');
insert into tbl_score_201905 values ('1','03','01','70','70','70');
insert into tbl_score_201905 values ('1','03','02','80','60','90');
insert into tbl_score_201905 values ('1','03','03','90','80','70');

select * from tbl_student_201905;

delete from tbl_student_201905 where sclass = 4;
commit;


insert into tbl_student_201905 values ('1','03','04','장학생','20020901','F','010','1234','1009');


insert into tbl_score_201905 values ('1','03','04','91','81','71');


select stu.syear, stu.sclass, stu.sno, stu.sname, stu.gender, sco.kor, sco.eng, sco.mat from tbl_student_201905 stu,tbl_score_201905 sco where stu.syear = sco.syear and stu.sclass = sco.sclass and stu.sno = sco.sno;

select de.syear, de.sclass, de.tname, sum(sco.kor) as kor, sum(sco.eng) as eng, sum(sco.mat) as mat, round(avg(sco.kor),1), round(avg(sco.eng),1), round(avg(sco.mat),1) from tbl_dept_201905 de, tbl_score_201905 sco where de.syear = sco.syear and de.sclass = sco.sclass group by de.syear, de.sclass, de.tname order by de.tname;



