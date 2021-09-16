create table tbl_product_201909(
	p_code char(4) primary key,
	p_name varchar2(20),
	p_size varchar2(40),
	p_type varchar2(20),
	p_price int
);

create table tbl_worklist_201909(
	w_workno char(8) primary key,
	p_code char(4),
	w_quentity int,
	w_workdate date
);

create table tbl_process_201909(
	w_workno char(8) primary key,
	p_p1 char(1),
	p_p2 char(1),
	p_p3 char(1),
	p_p4 char(1),
	p_p5 char(1),
	p_p6 char(1),
	w_lastdate char(8),
	w_lasttime char(4)
);

insert into tbl_product_201909 values ('A001','A-1형소형박스','100X110X50','A형골판지',5000);
insert into tbl_product_201909 values ('A002','A-2형소형박스','100X110X70','A형골판지',6000);
insert into tbl_product_201909 values ('A003','A-3형소형박스','100X110X1000','A형골판지',7000);
insert into tbl_product_201909 values ('B001','B-1형소형박스','150X130X50','A형골판지',10000);
insert into tbl_product_201909 values ('B002','B-2형소형박스','150X130X70','A형골판지',11000);
insert into tbl_product_201909 values ('B003','B-3형소형박스','150X130X100','A형골판지',13000);
insert into tbl_product_201909 values ('C001','C-1형소형박스','180X150X50','A형골판지',15000);
insert into tbl_product_201909 values ('C002','C-2형소형박스','180X150X70','A형골판지',17000);
insert into tbl_product_201909 values ('C003','C-3형소형박스','180X150X100','A형골판지',20000);

insert into tbl_worklist_201909 values ('20190001','A001',100,'20191101');
insert into tbl_worklist_201909 values ('20190002','A002',150,'20191101');
insert into tbl_worklist_201909 values ('20190003','A003',200,'20191101');
insert into tbl_worklist_201909 values ('20190004','B001',250,'20191102');
insert into tbl_worklist_201909 values ('20190005','B002',100,'20191102');
insert into tbl_worklist_201909 values ('20190006','B003',150,'20191102');
insert into tbl_worklist_201909 values ('20190007','C001',100,'20191103');
insert into tbl_worklist_201909 values ('20190008','C002',150,'20191103');
insert into tbl_worklist_201909 values ('20190009','C003',200,'20191103');

insert into tbl_process_201909 values ('20190001','Y','Y','Y','Y','Y','Y','20191001','0930');
insert into tbl_process_201909 values ('20190002','Y','Y','Y','Y','Y','Y','20191001','1030');
insert into tbl_process_201909 values ('20190003','Y','Y','Y','Y','Y','Y','20191001','1130');
insert into tbl_process_201909 values ('20190004','Y','Y','Y','Y','Y','N','20191002','1330');
insert into tbl_process_201909 values ('20190005','Y','Y','Y','Y','Y','N','20191002','1430');
insert into tbl_process_201909 values ('20190006','Y','Y','Y','Y','Y','N','20191002','1530');
insert into tbl_process_201909 values ('20190007','Y','Y','Y','Y','N','N','20191003','1630');
insert into tbl_process_201909 values ('20190008','Y','Y','Y','Y','N','N','20191003','1730');
-- 1번문제
select * from tbl_product_201909;
-- 2번문제
select w.w_workno,w.p_code,p.p_name,p.p_size,p.p_type,w.w_quentity,to_char(w.w_workdate,'YYYY-MM-DD') from tbl_product_201909 p, tbl_worklist_201909 w where p.p_code = w.p_code;
-- 3번문제
insert into tbl_process_201909 values (?,?,?,?,?,?,?,?,?);
-- 4번문제
select pc.w_workno,pd.p_code,pd.p_name,decode(pc.p_p1, 'Y', '완료', 'N', '~'),
decode(pc.p_p2, 'Y', '완료', 'N', '~'),decode(pc.p_p3, 'Y', '완료', 'N', '~'),
decode(pc.p_p4, 'Y', '완료', 'N', '~'),decode(pc.p_p5, 'Y', '완료', 'N', '~'),
decode(pc.p_p6, 'Y', '완료', 'N', '~'),to_char(to_date(pc.w_lastdate), 'YYYY-MM-DD'),to_char(to_date(pc.w_lasttime,'HH24MI'), 'HH24:MI') 
from tbl_product_201909 pd, tbl_process_201909 pc, tbl_worklist_201909 w 
where pd.p_code = w.p_code and w.w_workno = pc.w_workno order by p_code;

