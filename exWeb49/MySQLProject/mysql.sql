use jsl49;

show tables;
select * from tbl_member;

create table tbl_board (
   idx int not null auto_increment,
   name varchar(20) not null,
   pass varchar(20) not null,
   subject varchar(100) not null,
   email varchar(30),
   contents text not null,
   regdate date not null,
   readcnt int default 0,
   primary key (idx)
);
drop table tbl_member;
create table tbl_member(
   name varchar(20) not null,
   userid varchar(20) not null primary key,
   passwd varchar(100) not null,
   gubun varchar(6),
   zipcode varchar(7),
   addr1 varchar(200),
   addr2 varchar(100),
   tel varchar(11) not null,
   email varchar(100),
   job varchar(20),
   intro varchar(2000),
   favorite varchar(255),
   first_time datetime not null,
   last_time datetime
);

select * from tbl_member where email like 'iloveoov5082@gmail.com';