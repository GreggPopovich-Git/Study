
/* Drop Tables */

DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE products CASCADE CONSTRAINTS;
DROP TABLE zipcode CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE member
(
	id varchar2(20) NOT NULL,
	pwd varchar2(100),
	name varchar2(50),
	address varchar2(20),
	tel varchar2(13),
	indate date DEFAULT SYSDATE,
	zipcode varchar2(7) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE orders
(
	o_seq number(10) NOT NULL,
	id varchar2(20),
	product_code varchar2(20),
	product_size varchar2(5),
	quantity varchar2(5),
	result char(1),
	indate date,
	PRIMARY KEY (o_seq)
);


CREATE TABLE products
(
	product_code varchar2(20) NOT NULL,
	product_name varchar2(100),
	product_kind char(1),
	product_price1 varchar2(10),
	product_price2 varchar2(10),
	product_content varchar2(1000),
	product_image varchar2(50),
	sizeSt varchar2(5),
	sizeEt varchar2(5),
	product_quantity varchar2(5),
	useyn char(1),
	indate date,
	PRIMARY KEY (product_code)
);


CREATE TABLE zipcode
(
	zipcode varchar2(7) NOT NULL,
	sido varchar2(30),
	gugun varchar2(30),
	dong varchar2(30),
	bunji varchar2(30),
	PRIMARY KEY (zipcode)
);



/* Create Foreign Keys */

ALTER TABLE orders
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE orders
	ADD FOREIGN KEY (product_code)
	REFERENCES products (product_code)
;


ALTER TABLE member
	ADD FOREIGN KEY (zipcode)
	REFERENCES zipcode (zipcode)
;



