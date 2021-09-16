use jsl49;
create table tbl_city_001 (
	city char(2) primary key,
	cityname char(6) not null
);

desc tbl_city_001;

create table tbl_member_001 (
	custno int(6) primary key,
	custname varchar(20) not null,
	phone varchar(13),
	gender char(1),
	joindate char(8),
	grade char(1),
	city char(2) references tbl_city_001
);

desc tbl_member_001;

create table tbl_money_001 (
	custno int(6) references tbl_member_001,
	saleno int(8) primary key,
	pcost int(8),
	price int(8),
	amount int(4),
	pcode varchar(4),
	sdate char(8)
);

desc tbl_money_001;

--drop table tbl_money_001;

show tables;

--city table 자료입력
insert into tbl_city_001(city,cityname) values ('01','서울');
insert into tbl_city_001(city,cityname) values ('02','경기');
insert into tbl_city_001(city,cityname) values ('03','인천');
insert into tbl_city_001(city,cityname) values ('04','강원');
insert into tbl_city_001(city,cityname) values ('05','충북');
insert into tbl_city_001(city,cityname) values ('06','충남');
insert into tbl_city_001(city,cityname) values ('07','전북');
insert into tbl_city_001(city,cityname) values ('08','전남');
insert into tbl_city_001(city,cityname) values ('09','경북');
insert into tbl_city_001(city,cityname) values ('10','경남');
insert into tbl_city_001(city,cityname) values ('11','제주');

--member table 자료입력
insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) values (10001,'김행복','010-1111-2222','M','20151202','A','01');
insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) values (10002,'이축복','010-1111-3333','M','20151206','B','01');
insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) values (10003,'장믿음','010-1111-4444','F','20151001','B','02');
insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) values (10004,'최사랑','010-1111-5555','F','20151113','A','02');
insert into tbl_member_001(custno,custname,phone,gender,joindate,grade,city) values (10005,'진평화','010-1111-6666','F','20151225','B','11');

--money table 자료입력
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10001,20160001,500,5,2500,'A001','20160101');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10001,20160002,1000,4,4000,'A002','20160101');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10001,20160003,500,3,1500,'A008','20160101');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10002,20160004,2000,1,2000,'A004','20160102');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10002,20160005,500,1,500,'A001','20160103');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10003,20160006,1500,2,3000,'A003','20160103');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10004,20160007,500,2,1000,'A001','20160104');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10004,20160008,300,1,300,'A005','20160104');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10004,20160009,600,1,600,'A006','20160104');
insert into tbl_money_001(custno,saleno,pcost,amount,price,pcode,sdate) values (10006,20210001,5000,3,15000,'A007','20210526');

commit; -- data가 java에 반영이 안될 때 commit을 해줘야함. java에서 작업할땐 close(); 하면 commit이 됨.

