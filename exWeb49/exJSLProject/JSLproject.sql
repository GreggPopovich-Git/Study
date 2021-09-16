-- 회원정보 테이블
create table tbl_member_49 (
   name varchar2(10),				-- 회원이름
   userid varchar2(10) primary key,	-- 회원ID
   pass varchar2(100) not null,		-- 비밀번호
   gender varchar2(1) not null,		-- 성별
   email varchar2(30),				-- 이메일
   tel varchar2(11) not null,		-- 전화번호
   first_time date default sysdate,	-- 가입일자
   last_time date
);
-- 자유게시판 테이블
create table tbl_board_49 (
   idx number primary key,						-- 글번호
   userid varchar2(10) references tbl_member_49,-- 작성자 ID
   name varchar2(10) not null,					-- 작성자
   pass varchar2(100) not null,					-- 비밀번호
   email varchar2(30),							-- 이메일
   subject varchar2(100) not null,				-- 제목
   contents varchar2(2000) not null,			-- 내용
   regdate date default sysdate,				-- 작성일자
   readcnt number default 0
);
-- 자유게시판 idx 시퀀스
create sequence tbl_board_49_seq_idx;
-- 자료실 테이블
create table tbl_pds_49 (
   idx number primary key,						-- 글번호
   userid varchar2(10) references tbl_member_49,-- 작성자 ID
   name varchar2(10),							-- 작성자 이름
   pass varchar2(100),							-- 비밀번호
   email varchar2(30),							-- 이메일
   subject varchar2(100) not null,				-- 제목
   contents varchar2(2000) not null,			-- 내용
   regdate date default sysdate,				-- 작성일자
   readcnt number default 0,					-- 조회수
   filename varchar2(255) null
);
create sequence tbl_pds_49_seq_idx;

create table tbl_board_comment_49 (
	coidx number primary key,
	name varchar2(10) not null,
	pass varchar2(100) not null,
	regdate date default sysdate,
	contents varchar2(600) not null,
	idx number references tbl_board_49
);
create sequence tbl_board_comment_49_seq_coidx;

create table tbl_pds_comment_49 (
	coidx number primary key,
	name varchar2(10) not null,
	pass varchar2(100) not null,
	regdate date default sysdate,
	contents varchar2(600) not null,
	idx number references tbl_pds_49
);
drop table tbl_pds_comment_49;
create sequence tbl_pds_comment_49_seq_coidx;
commit;
