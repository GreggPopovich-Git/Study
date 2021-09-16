create table tbl_cust_201004 (
	p_no char(4) primary key,
	p_name varchar2(20),
	p_birth char(8),
	p_gender char(1),
	p_tel1 char(3),
	p_tel2 char(4),
	p_tel3 char(4),
	p_city char(2)
);

create table tbl_order_201004 (
	p_seno number(8) primary key,
	p_no references tbl_cust_201004,
	i_code references tbl_injection_201004,
	p_date date
);

create table tbl_injection_201004 (
	i_code char(4) primary key,
	i_name varchar2(20),
	i_age varchar2(20)
);

insert into tbl_cust_201004 values ('1001','김고객','19850301','M','010','2222','0001','10');
insert into tbl_cust_201004 values ('1002','이고객','19900301','M','010','2222','0002','20');
insert into tbl_cust_201004 values ('1003','박고객','19770301','F','010','2222','0003','30');
insert into tbl_cust_201004 values ('1004','조고객','19650301','F','010','2222','0004','10');
insert into tbl_cust_201004 values ('1005','황고객','19400301','M','010','2222','0005','40');
insert into tbl_cust_201004 values ('1006','양고객','19440301','F','010','2222','0006','40');
insert into tbl_cust_201004 values ('1007','허고객','19760301','F','010','2222','0007','10');

insert into tbl_injection_201004 values ('A001','A형간염','19~39세');
insert into tbl_injection_201004 values ('A002','TD백신','40~49세');
insert into tbl_injection_201004 values ('A003','인플루엔자','50~64세');
insert into tbl_injection_201004 values ('A004','폐렴사슬알균','65세이상');

-- 문제 2번
select p_no, p_name, p_birth, decode(p_gender, 'M', '남', 'F', '여'), p_tel1 || '-' || p_tel2 || '-' || p_tel3, 
decode(p_city, '10', '서울', '20', '경기', '30', '강원', '40', '대구') from tbl_cust_201004;
-- 문제 3번
insert into tbl_order201004 values (?, ?, ?, ?);
-- 문제 4번
select substr(to_char(p_seno), 0, 4) || '-' || substr(to_char(p_seno), 5) , c.p_no, p_name, o.i_code, i_name, to_char(p_date, 'YYYY-MM-DD') 
from tbl_cust_201004 c, tbl_order_201004 o, tbl_injection_201004 i 
where c.p_no = o.p_no and o.i_code = i.i_code order by p_seno;
-- 문제 5번
select o.i_code, i_name, c from 
(select i_code, count(i_code) c from tbl_order_201004 group by i_code) o, 
tbl_injection_201004 i where i.i_code = o.i_code order by i_code;

select i_code, count(i_code) c from tbl_order_201004 group by i_code;
