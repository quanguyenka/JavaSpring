create database QLBH

use QLBH


create table MANAGER(
	idCode char(10) not null,
	name varchar(50) not null,
	pass char(20) not null,
	rank int not null
	
	primary key (idCode)
);

create table CUSTOMER(
	idCode char(10) not null,
	username varchar(50) not null,
	pass char(20) not null,
	hoTen nvarchar(50) not null,
	sdt int,
	email char(40) not null,
	diaChi nvarchar(60),
	rank int not null
	
	primary key (idCode)
);

create table packagecartype(
	packagetype char(10) not null,
	cartype char(15) not null,
	namSX int not null
	
	primary key (packagetype)
);

create table OTO(
	carCode char(10) not null,
	hangXe char(20) not null check (hangxe = 'BMW' or hangxe = 'HUYNDAI' or hangxe = 'TOYOTA'),
	gia float not null,
	namSX int not null,
	soluong int not null,
	packagetype char(10),
	cartype char(15)
	
	primary key (carCode)
);
create table CUS_CAR(
	cusCode char(10) not null,	
	carCode char(10) not null,
	packagetype char(10),
	cartype char(15) not null	
);

create table CARTYPE(
	cartype char(15),
	
	primary key (cartype)
);

-- Tao khoa ngoai

alter table OTO add foreign key (packagetype) references packagecartype(packagetype)
alter table OTO add foreign key (cartype) references CARTYPE(cartype)

alter table packagecartype add foreign key (cartype) references CARTYPE(cartype)

alter table CUS_CAR add foreign key (carCode) references OTO(carCode)
alter table CUS_CAR add foreign key (packagetype) references packagecartype(packagetype)
alter table CUS_CAR add foreign key (cusCode) references CUSTOMER(idCode)
alter table CUS_CAR add foreign key (cartype) references CARTYPE(cartype)

-- insert du lieu

--Customer
insert into CUSTOMER
values ('CS1','customer1','customer1',N'Nguyễn Thành Đô','093874876','customer1@gmail.com',N'Hà Nội',1),
('CS2','customer2','customer2',N'Lê Nhật Quang','098678397',N'customer2@gmail.com','Hà Tĩnh',1),
('CS3','customer3','customer2',N'Hoàng Thanh Nam','098376289',N'customer3@gmail.com','Hưng Yên',1),
('CS4','customer4','customer4',N'Nguyễn Gia Nhật Linh','096378365',N'customer4@gmail.com','Huế',1),
('CS','customer','customer',N'Nguyễn Hồng Anh','098765432',N'customer@gmail.com','Hà Nội',1)
--CARTYPE
insert into CARTYPE
values ('ModernCar'), ('MediumCar'), ('OldCar')
--PACKAGECARTYPE
insert into packagecartype
values ('A', 'ModernCar', '2010'),
('B','MediumCar','1997'),
('C','OldCar','1995'),
('A1','ModernCar','2006'),
('B1','MediumCar','2000'),
('C1','OldCar','1993')
--OTO
insert into OTO
values ('X1', 'BMW', '2000000000', '2011','4', 'A', 'ModernCar'),
('X2', 'TOYOTA', '2500000000', '2009','2', 'A1', 'ModernCar'),
('X3', 'HUYNDAI', '1500000000', '2004','4', 'B', 'MediumCar'),
('X4', 'BMW', '1600000000', '2003','2', 'B1', 'MediumCar'),
('X5', 'TOYOTA', '1200000000', '1995','3', 'C', 'OldCar'),
('X6', 'HUYNDAI', '1000000000', '1990','2', 'C1', 'OldCar')
--CUS_CAR
insert into CUS_CAR
values ('CS','X1','A','ModernCar'),
('CS','X2','A1','ModernCar'),
('CS','X3','B','MediumCar'),
('CS1','X2','A1','ModernCar'),
('CS1','X4','B1','MediumCar'),
('CS2','X5','C','OldCar'),
('CS2','X3','B','MediumCar')


select * from OTO
select * from CUSTOMER

select * from CUS_CAR where CUS_CAR.cusCode = 'CS'

Select * from packagecartype