create table tbl_custinfo_202010 (
	custno char(4) primary key,
	custname varchar2(20),
	custjumin char(13),
	custtel1 char(3),
	custtel2 char(4),
	custtel3 varchar2(4)
);

select * from tbl_custinfo_202010;

create table tbl_saleinfo_202010 (
	saleno char(4) primary key,
	oildate char(8),
	oiltype char(1),
	amount int,
	paytype char(1),
	custno char(4),
	creditcard char(16),
	oilcost int
);

create table tbl_oilinfo_202010 (
	oiltype char(1) primary key,
	oilname varchar(20)
);

insert into tbl_custinfo_202010 values('1001','김고객','9901011000001','010','1234','0001');
insert into tbl_custinfo_202010 values('1002','이고객','8901011000002','010','1234','0002');
insert into tbl_custinfo_202010 values('1003','박고객','7901011000003','010','1234','0003');
insert into tbl_custinfo_202010 values('1004','조고객','6901011000004','010','1234','0004');
insert into tbl_custinfo_202010 values('1005','황고객','5901011000005','010','1234','0005');
insert into tbl_custinfo_202010 values('1006','홍고객','9501011000006','010','1234','0006');
insert into tbl_custinfo_202010 values('1007','최고객','8701011000007','010','1234','0007');

insert into tbl_oilinfo_202010 values('1','휘발유');
insert into tbl_oilinfo_202010 values('2','고급휘발유');
insert into tbl_oilinfo_202010 values('3','경유');
insert into tbl_oilinfo_202010 values('4','등유');

insert into tbl_saleinfo_202010 values('9001','20211001','1',30,'2','1001','3001200130014001',45000);
insert into tbl_saleinfo_202010 values('9002','20211001','1',40,'1','1002',null,56000);
insert into tbl_saleinfo_202010 values('9003','20211001','2',40,'2','1003','4001200130014003',72000);
insert into tbl_saleinfo_202010 values('9004','20211002','2',60,'2','1004','5001200130014004',102000);
insert into tbl_saleinfo_202010 values('9005','20211002','3',50,'1',null,null,55000);
insert into tbl_saleinfo_202010 values('9006','20211002','3',50,'2',null,'3001200130014005',55000);

commit;

-- 3번문제
select saleno, REGEXP_REPLACE(oildate, '(.{4})(.{2})(.{2})', '\1년\2월\3일'), oilname, amount, decode(paytype, 1, '현금', 2, '카드'), nvl(custname, '비회원'), nvl(s.custno,'비회원'),
nvl(custtel1,'000') || '-' || nvl(custtel2,'0000') || '-' || nvl(custtel3,'0000') as tel, nvl(creditcard, ' '), oilcost 
from tbl_custinfo_202010 c, tbl_oilinfo_202010 o, tbl_saleinfo_202010 s 
where c.custno(+) = s.custno and o.oiltype = s.oiltype 
order by saleno;
-- 4번문제
select REGEXP_REPLACE(oildate, '(.{4})(.{2})(.{2})', '\1년\2월\3일'), oilname, count(oilcost) gun, sum(oilcost) tot
from tbl_saleinfo_202010 a, tbl_oilinfo_202010 b where a.oiltype = b.oiltype
group by oildate, oilname order by a.oildate, b.oilname;

