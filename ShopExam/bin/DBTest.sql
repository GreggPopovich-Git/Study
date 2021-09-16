use jsl49;

select * from tbl_member_001;
-- 전체 인원수 카운트 count()
select count(*) from tbl_member_001;
-- city에서 중복 제외 카운트 distinct
select count(distinct city) from tbl_member_001;
-- city를 기준으로 그룹을 묶어서 카운트 group by
select city, count(city) from tbl_member_001 group by city;
-- 회원번호 기준으로 그룹을 묶어서  매출 합계 sum()
select custno, sum(price) from tbl_money_001 group by custno;
-- 두개의 항목을 그룹으로..
select custno, sdate, sum(price) from tbl_money_001 group by custno, sdate;
-- sum(price)를 기준으로 sort (기본은 오름차순) DESC(내림차순)
select custno, sdate, sum(price) from tbl_money_001 group by custno, sdate order by sum(price);

-- 서브쿼리 select 안에 또다른 select가 들어감.
-- ex) select * from (select * from where ...)

-- tbl_member_001을 기준으로 회원번호, 성명, 도시이름 출력 (JOIN)
select mem.custno, mem.custname, ci.cityname from tbl_member_001 mem, tbl_city_001 ci where mem.city=ci.city;
-- 회원별 매출액
-- 회원번호, 이름, 전화번호, 등급, 매출합계
select mem.custno, custname, phone, grade, sum(price) from tbl_member_001 mem, tbl_money_001 mon where mem.custno = mon.custno group by custno, custname, phone, grade order by sum(price) desc;


select mem.custno, mem.custname, mem.phone, mem.gender, mem.joindate,mem.grade, ci.cityname from tbl_member_001 mem, tbl_city_001 ci where mem.city=ci.city;
