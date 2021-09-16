drop table tbl_test_202005;
drop table tbl_city_202005;
drop table tbl_area_202005;

create table tbl_area_202005 (
	area_code char(2) primary key,
	area_name varchar2(20) not null
);

create table tbl_city_202005 (
	city_code char(2) primary key,
	city_name varchar2(10) not null,
	area_code char(2) references tbl_area_202005,
	city_tel1 char(3),
	city_tel2 char(4),
	city_tel3 char(4),
	city_admin char(12),
	city_level char(1)
);

create table tbl_test_202005 (
	test_date char(8) not null,
	test_ampm char(2),
	pollution char(2),
	city_code char(2) references tbl_city_202005,
	test_value number(5)
);

insert into tbl_area_202005 values ('A1','서울경기');
insert into tbl_area_202005 values ('A2','충청');
insert into tbl_area_202005 values ('A3','경상');
insert into tbl_area_202005 values ('A4','전라');

insert into tbl_city_202005 values ('01','서울','A1','02','1588','0001','김담당','1');
insert into tbl_city_202005 values ('02','경기','A1','031','1588','0001','이담당','2');
insert into tbl_city_202005 values ('03','인천','A1','032','1588','0001','박담당','3');
insert into tbl_city_202005 values ('04','세종','A2','044','1588','0001','조담당','4');
insert into tbl_city_202005 values ('05','대전','A2','042','1588','0001','백담당','1');
insert into tbl_city_202005 values ('06','대구','A3','053','1588','0001','황담당','2');

insert into tbl_test_202005 values ('20200301','AM','P1','01',131);
insert into tbl_test_202005 values ('20200301','AM','P1','02',156);
insert into tbl_test_202005 values ('20200301','AM','P1','03',160);
insert into tbl_test_202005 values ('20200301','AM','P1','04',56);
insert into tbl_test_202005 values ('20200301','AM','P1','05',78);
insert into tbl_test_202005 values ('20200301','AM','P1','06',79);
insert into tbl_test_202005 values ('20200301','PM','P1','01',140);
insert into tbl_test_202005 values ('20200301','PM','P1','02',170);
insert into tbl_test_202005 values ('20200301','PM','P1','03',150);
insert into tbl_test_202005 values ('20200301','PM','P1','04',66);
insert into tbl_test_202005 values ('20200301','PM','P1','05',70);
insert into tbl_test_202005 values ('20200301','PM','P1','06',80);
--2번문제
select city_code, city_name, c.area_code, area_name, city_tel1 || '-' || city_tel2 || '-' || city_tel3, city_admin, decode(city_level, '1', '사원', '2', '주임', '3', '대리', '4', '과장') 
from tbl_city_202005 c, tbl_area_202005 a where c.area_code = a.area_code;
--3번문제
insert into tbl_test_202005 values('?,?,?,?,?')
--4번문제
select substr(test_date,0,4) || '년' || substr(test_date,5,2) || '월' || substr(test_date,7,2) || '일', 
decode(test_ampm, 'AM', '오전', 'PM', '오후'), pollution, t.city_code, city_name, area_name, test_value 
from tbl_test_202005 t, tbl_city_202005 c, tbl_area_202005 a 
where t.city_code = c.city_code and c.area_code = a.area_code;
--5번문제
select substr(test_date,0,4) || '년' || substr(test_date,5,2) || '월' || substr(test_date,7,2) || '일', city_name, avg(test_value), 
case when avg(test_value) > 150 then '매우나쁨' 
	 when avg(test_value) > 80 then '나쁨' 
	 when avg(test_value) > 30 then '보통'
	 else '좋음' end as test
from tbl_test_202005 t, tbl_city_202005 c where t.city_code = c.city_code 
group by test_date, city_name;


