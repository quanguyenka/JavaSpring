create database QLSV_GV;
drop database QLSV_GV
use QLSV_GV
create table GIAOVIEN(
	ACOUNT char(20) not null,
	FIRSTNAME varchar(30) not null,
	LASTNAME varchar(20) not null,
	EMAIL char(50) not null
	
	primary key (ACOUNT)
);

drop table SINHVIEN
drop table GIAOVIEN

create table SINHVIEN (
	ID char(10) not null,
	HOTEN varchar(50) not null,
	EMAIL char(50) not null,
	LOP char(10) not null,
	SDT char(11),
	GHICHU text,
	ACOUNT char(20) not null
	
	primary key (ID)
);


alter table SINHVIEN add foreign key (ACOUNT) references GIAOVIEN(ACOUNT)

select * from GIAOVIEN

insert GIAOVIEN(ACOUNT, FIRSTNAME, LASTNAME, EMAIL)
values ('user1', 'first name 1', 'last name 1', 'giaovien1@gmail.com'),
('user2', 'first name 2', 'last name 2', 'giaovien2@gmail.com'),
('user3', 'first name 3', 'last name 3', 'giaovien3@gmail.com'),
('user4', 'first name 4', 'last name 4', 'giaovien4@gmail.com'),
('user5', 'first name 5', 'last name 5', 'giaovien5@gmail.com')

insert GIAOVIEN(ACOUNT, FIRSTNAME, LASTNAME, EMAIL)
values ('1', '1', '1', '1')

select * from SINHVIEN

insert SINHVIEN(ID, HOTEN, EMAIL, LOP,SDT, GHICHU, ACOUNT)
values 
('SV1', 'sinh vien 1', 'sinhvien1@gmail.com', 'lop1', '0987654321','ghi chu 1','user1'),
('SV2', 'sinh vien 2', 'sinhvien2@gmail.com', 'lop2', '0987654322','ghi chu 2','user1'),
('SV3', 'sinh vien 3', 'sinhvien3@gmail.com', 'lop3', '0987654323','ghi chu 3','user3'),
('SV4', 'sinh vien 4', 'sinhvien4@gmail.com', 'lop4', '0987654324','ghi chu 4','user2'),
('SV5', 'sinh vien 5', 'sinhvien5@gmail.com', 'lop5', '0987654325','ghi chu 5','user4'),
('SV6', 'sinh vien 6', 'sinhvien6@gmail.com', 'lop4', '0987654326','ghi chu 6','user2'),
('SV7', 'sinh vien 7', 'sinhvien7@gmail.com', 'lop3', '0987654327','ghi chu 7','user3'),
('SV8', 'sinh vien 8', 'sinhvien8@gmail.com', 'lop8', '0987654328','ghi chu 8','user4'),
('SV9', 'sinh vien 9', 'sinhvien9@gmail.com', 'lop8', '0987654361','ghi chu 9','user5'),
('SV10', 'sinh vien 10', 'sinhvien10@gmail.com', 'lop1', '0987654321','ghi chu 10','user5')
use QLSV_GV
select * from SINHVIEN
INSERT INTO SINHVIEN(ID, HOTEN, EMAIL, LOP, SDT, GHICHU, ACOUNT)VALUES ('SV11','sinh vien 2','sinhvien2@gmail.com','lop3','097287356','ghi chu 11','user1')