use jsl49;

show tables;

drop table tbl_board;

create table tbl_board(
	bno int primary key auto_increment, -- 글번호
	title varchar(100) not null, -- 글제목
	contents text, -- 글내용(64k까지 가능)
	writer varchar(20), -- 작성자
	regdate date, -- 글작성일자
	readcnt int default 0 -- 조회수
);

insert into tbl_board(title, contents, writer, regdate) 
values ('글제목입니다','글내용입니다','홍길동',curdate());
-- 재귀호출
insert into tbl_board(title, contents, writer, regdate) 
	(select title, contents, writer, regdate from tbl_board);

select count(*) from tbl_board;

-- 가장 최근글 10개 불러오기
-- 1페이지
(1 - 1) * 10
select * from tbl_board order by bno desc limit 0, 10;
-- 2페이지 
(2 - 1) * 10
select * from tbl_board order by bno desc limit 10, 10;
-- 3페이지
(3 - 1) * 10
select * from tbl_board order by bno desc limit 20, 10;

