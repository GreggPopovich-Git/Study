select * from tab;

create table tbl_board(
	bno number primary key,
	writer varchar2(20),
	title varchar2(100),
	contents varchar2(4000),
	regdate date default sysdate,
	readcnt number default 0
);

-- sequence(초기값, 증가값) - 계정당 1개
create sequence tbl_board_bno_seq increment by 1 start with 1;
-- 값 입력
insert into tbl_board(bno, writer, title, contents) values (tbl_board_bno_seq.nextval, '홍길동', '제목입니다.', '내용입니다.');

select * from tbl_board;
-- 재귀복사
insert into tbl_board(bno, writer, title, contents) (select tbl_board_bno_seq.nextval, writer, title, contents from tbl_board);

select rownum, bno, writer from tbl_board where bno > 50 order by bno desc;

-- 최근 5개
select * from tbl_board where rownum <= 5 order by bno desc;
-- 서브쿼리 이용
select * from (select * from tbl_board order by bno desc) where rownum <= 5;
-- 페이지 나누기 10개 단위
select bno, writer from (select bno, writer from tbl_board order by bno desc) where rownum <= 10;
select * from (select rownum rn, * from tbl_board order by bno desc) where rownum <= 20 and rownum > 10;
-- 1페이지
select x.* from (select rownum rnum, a.* from (select * from tbl_board order by bno desc) a where rownum <= 10) x where x.rnum >= 1;
-- 2페이지
select x.* from (select rownum rnum, a.* from (select * from tbl_board order by bno desc) a where rownum <= 20) x where x.rnum >= 11;



