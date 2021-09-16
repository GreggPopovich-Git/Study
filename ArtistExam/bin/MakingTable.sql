use jsl49;

create table tbl_artist_201905(
	artist_id char(4) not null primary key,
	artist_name varchar(20),
	artist_gender char(1),
	artist_birth char(8),
	talent char(1),
	agency varchar(20)
);

create table tbl_mento_201905(
	mento_id char(4) not null primary key,
	mento_name varchar(20)
);

create table tbl_point_201905(
	serial_no int(8) not null primary key,
	artist_id char(4) not null,
	foreign key(artist_id) references tbl_artist_201905(artist_id),
	mento_id char(4) not null,
	foreign key(mento_id) references tbl_mento_201905(mento_id),
	point int(3)
);

show tables;
show index from tbl_point_201905;

create table tbl_test(
	idx int not null primary key auto_increment,
	name varchar(20) not null,
	tel varchar(13)
);

select * from tbl_point_201905;
insert into tbl_test(name,tel) values('aaa','111');
insert into tbl_test(name) values('bbb');
-- artist table 자료입력
insert into tbl_artist_201905 values('A001','김스타','F','19970101','1','A엔터테인먼트');
insert into tbl_artist_201905 values('A002','조스타','M','19980201','2','B엔터테인먼트');
insert into tbl_artist_201905 values('A003','왕스타','M','19990301','3','C엔터테인먼트');
insert into tbl_artist_201905 values('A004','정스타','M','20000401','1','D엔터테인먼트');
-- mento table 자료입력
insert into tbl_mento_201905 values('J001','함멘토');
insert into tbl_mento_201905 values('J002','박멘토');
insert into tbl_mento_201905 values('J003','장멘토');
-- point table 자료입력
insert into tbl_point_201905 values(2019001,'A001','J001',78);
insert into tbl_point_201905 values(2019002,'A001','J002',76);
insert into tbl_point_201905 values(2019003,'A001','J003',70);
insert into tbl_point_201905 values(2019004,'A002','J001',80);
insert into tbl_point_201905 values(2019005,'A002','J002',72);
insert into tbl_point_201905 values(2019006,'A002','J003',78);
insert into tbl_point_201905 values(2019007,'A003','J001',90);
insert into tbl_point_201905 values(2019008,'A003','J002',92);
insert into tbl_point_201905 values(2019009,'A003','J003',88);
insert into tbl_point_201905 values(2019010,'A004','J001',96);
insert into tbl_point_201905 values(2019011,'A004','J002',90);
insert into tbl_point_201905 values(2019012,'A004','J003',98);
insert into tbl_point_201905 values(2019013,'A005','J001',88);
insert into tbl_point_201905 values(2019014,'A005','J002',86);
insert into tbl_point_201905 values(2019015,'A005','J003',86);

update tbl_point_201905 set point = 86 where serial_no = 2019016;
--두 테이블 조인 해서 합계 평균 계산
select art.artist_id, art.artist_name, art.artist_gender, sum(point), round(avg(point),2)from tbl_artist_201905 art, tbl_point_201905 po  where art.artist_id = po.artist_id group by art.artist_id, artist_name, artist_gender order by sum(point) desc
