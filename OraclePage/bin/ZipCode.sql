CREATE TABLE zipcode (
  ZIPCODE varchar(7) NOT NULL ,
  SIDO varchar(6) NOT NULL ,
  GUGUN varchar(30) NOT NULL ,
  DONG varchar(70) NOT NULL ,
  BUNJI varchar(50) NOT NULL
);

select count(*) from zipcode;

select * from zipcode where dong like '%오류동%';




