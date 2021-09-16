-- 회원 정보 테이블
create table tbl_sample_member (
	name varchar2(15),				-- 회원이름
	userid varchar2(15) primary key,	-- 회원ID
	pass varchar2(100) not null,		-- 비밀번호
	email varchar2(30) not null,		-- 이메일
	tel varchar2(12) not null,		-- 전화번호
	first_time date default sysdate,	-- 가입일자
	last_time date					-- 최종로그인
);

-- 갤러리 테이블
create table tbl_sample_gallery (
	idx number primary key,			-- 고유번호
	userid varchar2(15) references tbl_sample_member,
	name varchar2(20) NOT NULL,       -- 작성자 이름
	pass varchar2(100) NOT NULL,      -- 비밀번호
	subject varchar2(100) NOT NULL,   -- 제목
	contents clob,					-- 내용
	regdate date default sysdate,     -- 등록일자
	readcnt number default 0			-- 조회수
);
create sequence tbl_sample_gallery_seq_idx;

-- 공지사항 테이블
create table tbl_sample_notice (
	idx number primary key,			-- 고유번호
	userid varchar2(15) references tbl_sample_member,
	name varchar2(20) NOT NULL,       -- 작성자 이름
	subject varchar2(100) NOT NULL,   -- 제목
	contents clob,					-- 내용
	boardtype varchar2(30),			-- 게시판종류
	filename varchar2(255),			-- 파일이름
	regdate date default sysdate,     -- 등록일자
	readcnt number default 0			-- 조회수
);
create sequence tbl_sample_notice_seq_idx;

-- 자유게시판
create table tbl_sample_board (
	idx number primary key,
	userid varchar2(15) references tbl_sample_member,
	name varchar2(20) not null,
	subject varchar2(100) not null,
	pass varchar2(100) not null,
	contents clob,
	regdate date default sysdate,
	readcnt number default 0
);
create sequence tbl_sample_board_seq_idx;

-- 질문답변
create table tbl_sample_qa (
	idx number primary key,
	userid varchar2(15) references tbl_sample_member,
	name varchar2(20) not null,
	subject varchar2(100) not null,
	pass varchar2(100) not null,
	contents clob,
	regdate date default sysdate,
	readcnt number default 0,
	answer varchar2(1000)
);
create sequence tbl_sample_qa_seq_idx;