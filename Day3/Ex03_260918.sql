create database Ex3_260918;

create table KHACHHANG (
	MAKHACHHANG char(10) not null,
	TENCONGTY varchar(40) not null,
	DIACHI varchar(40) not null,
	TENGIAODICH varchar(40),
	EMAIL char(40) not null,
	DIENTHOAI char(11),
	FAX char(20),
	
	primary key (MAKHACHHANG)
)


create table DONDATHANG(
	SOHOADON int not null,
	MAKHACHHANG char(10) not null,
	MANHANVIEN char(10) not null,
	NGAYDATHANG date,
	NGAYGIAOHANG date,
	NGAYCHUYENHANG date,
	NOIGIAOHANG varchar(40)
	
	primary key (SOHOADON)
)

create table NHANVIEN (
	MANHANVIEN char(10),
	HO varchar(20),
	TEN varchar(20),
	ngaysinh date,
	ngaylamviec date,
	diachi varchar(40),
	dienthoai int,
	luongcoban float,
	phucap float
	
	primary key (manhanvien)
)

create table NHACUNGCAP (
	macongty char(10),
	tencongty varchar(40),
	tengiaodich varchar(40),
	diachi varchar(40),
	dienthoai char(11),
	fax char(20),
	email char(40)
	
	primary key (macongty)
)

create table chitietdathang (
	sohoadon int,
	mahang char(10),
	giaban float,
	soluong float,
	mucgiamgia float
	
	primary key (sohoadon, mahang)
)
alter table mathang drop column macongty
create table mathang(
	mahang char(10),
	tenhang varchar(40),
	macongty char(10),
	maloaihang char(10),
	soluong int,
	donvitinh char(10),
	giahang float
	
	primary key (mahang)
)


create table loaihang(
	maloaihang char(10),
	tenloaihang varchar(40)
	
	primary key (maloaihang)
)

-- Tao khoa ngoai
alter table dondathang add foreign key (makhachhang) references khachhang(makhachhang);
alter table dondathang add foreign key (manhanvien) references nhanvien(manhanvien);
alter table chitietdathang add foreign key (sohoadon) references dondathang(sohoadon);
alter table chitietdathang add foreign key (mahang) references mathang(mahang);
alter table mathang add foreign key (macongty) references nhacungcap(macongty);
alter table mathang add foreign key (maloaihang) references loaihang(maloaihang);

-- insert du lieu
insert loaihang(maloaihang, tenloaihang)
values ('1','loaihang1'),('2','loaihang2'),('3','loaihang3'), ('4','loaihang4')

insert NHACUNGCAP(macongty, tencongty, tengiaodich, diachi, dienthoai, fax, email)
values ('cty1', 'cong ty 1', 'giao dich1', 'dia chi 1', '0987654321', 'fax1', 'mail1'),
('cty2', 'cong ty 2', 'giao dich2', 'dia chi 2', '0986754321', 'fax2', 'mail2'),
('cty3', 'cong ty 3', 'giao dich3', 'dia chi 3', '0982254321', 'fax3', 'mail3'),
('cty4', 'cong ty 4', 'giao dich4', 'dia chi 4', '0985554321', 'fax4', 'mail4'),
('cty5', 'cong ty 5', 'giao dich5', 'dia chi 5', '0982354321', 'fax5', 'mail5')

insert mathang(mahang, tenhang, macongty, maloaihang, soluong, donvitinh, giahang)
values ('mh1', 'ten hang 1', 'cty1', '1', 112, 'VND', '100000'),
('mh2', 'ten hang 2', 'cty3', '3', 31, 'VND', '50000'),
('mh3', 'ten hang 3', 'cty1', '1', 52, 'VND', '150000'),
('mh4', 'ten hang 4', 'cty4', '4', 122, 'VND', '30000'),
('mh5', 'ten hang 5', 'cty5', '2', 108, 'USD', '10')


insert NHANVIEN(MANHANVIEN, HO, TEN, ngaysinh, ngaylamviec, diachi, dienthoai, luongcoban, phucap)
values ('nv1', 'ho1', 'ten1', '1993/12/12', '2016/5/4', 'Dia chi 1', '01633813366', 2000000, 300000),
('nv2', 'ho2', 'ten2', '1994/2/12', '2017/7/4', 'Dia chi 2', '01633983366', 1500000, 300000),
('nv3', 'ho3', 'ten3', '1995/6/2', '2016/5/4', 'Dia chi 3', '01633813366', 2000000, 300000),
('nv4', 'ho4', 'ten4', '1993/5/1', '2015/6/3', 'Dia chi 4', '01683813366', 7000000, 900000),
('nv5', 'ho5', 'ten5', '1997/2/12', '2017/12/4', 'Dia chi 5', '0333813366', 3000000, 500000)

insert KHACHHANG(MAKHACHHANG, TENCONGTY, TENGIAODICH, DIACHI, EMAIL, DIENTHOAI, FAX)
values ('kh1', 'cong ty 1', 'giao dich1', 'dia chi 1', 'email1', '0987898765', 'fax1'),
		('kh2', 'cong ty 6', 'giao dich6', 'dia chi 6', 'email6', '0985898765','fax 2'),
		('kh3', 'cong ty 7', 'giao dich3', 'dia chi 7', 'email7', '0987778765', 'fax 3'),
		('kh4', 'cong ty 8', 'giao dich8', 'dia chi 8', 'email8', '0987898666', 'fax 4'),
		('kh5', 'cong ty 2', 'giao dich2', 'dia chi 2', 'mail2', '0986754321', 'fax2')


insert DONDATHANG(SOHOADON, MAKHACHHANG, MANHANVIEN, NGAYDATHANG, NGAYGIAOHANG, NGAYCHUYENHANG, NOIGIAOHANG)
values (1, 'kh1', 'nv1', '2018/6/6','2018/6/8','2018/6/10','dia chi 1'),
	   (2, 'kh1', 'nv3', '2018/7/12','2018/7/13',null,'dia chi 6'),
	   (3, 'kh3', 'nv2', '2018/8/10','2018/8/12','2018/8/13','dia diem 7'),
	   (4, 'kh4', 'nv2', '2018/2/6','2018/2/8','2018/2/10',null),
	   (5, 'kh5', 'nv5', '2018/6/6','2018/6/8','2018/6/10','dia diem 8')

delete DONDATHANG
delete chitietdathang

insert chitietdathang(sohoadon, mahang, giaban, soluong, mucgiamgia)
values (1, 'mh1', 200000, 2, 20),
	   (1, 'mh2', 300000, 1, 10),
	   (3, 'mh3', 150000, 3, 40),
	   (4, 'mh2', 10000, 4, 50),
	   (2, 'mh5', 200000, 1, 0)

use Ex3_260918
select * from khachhang


-- Câu 1: Hãy cho biết có những khách hàng nào lại chính là đối tác cung cấp hàng
-- của công ty (tức là có cùng tên giao dịch).

select distinct ncc.macongty, ncc.tencongty, ncc.tengiaodich from 
(((KHACHHANG as kh join DONDATHANG as ddh on kh.MAKHACHHANG = ddh.MAKHACHHANG)
right join chitietdathang as ctdh on ddh.SOHOADON = ctdh.sohoadon)
right join mathang as mh on mh.mahang = ctdh.mahang)
right join NHACUNGCAP as ncc on mh.macongty = ncc.macongty
where kh.TENGIAODICH = ncc.tengiaodich


-- Câu 2: Những đơn đặt hàng nào yêu cầu giao hàng ngay tại cty đặt hàng và những 
-- đơn đó là của công ty nào?

select ddh.SOHOADON, kh.TENCONGTY from 
(DONDATHANG as ddh left join KHACHHANG as kh on ddh.MAKHACHHANG = kh.MAKHACHHANG)
where ddh.NOIGIAOHANG =kh.DIACHI

--Câu 3: Những mặt hàng nào chưa từng được khách hàng đặt mua?

select mh.mahang from mathang as mh
where mh.mahang not in
(select mh.mahang from
(mathang as mh join chitietdathang as ctdh on mh.mahang = ctdh.mahang)
join DONDATHANG as ddh on ddh.SOHOADON = ctdh.sohoadon)

-- Câu 4: Những nhân viên nào của công ty chưa từng lập bất kỳ một hoá đơn đặt hàng nào?

select nv.MANHANVIEN, nv.TEN
from NHANVIEN as nv 
where nv.MANHANVIEN not in
(select nv.MANHANVIEN from 
NHANVIEN as nv join DONDATHANG as ddh on nv.MANHANVIEN = ddh.MANHANVIEN)

-- Câu 5: Trong năm 2003, những mặt hàng nào chỉ được đặt mua đúng một lần

create view mathang_view
as 
	select ctdh.mahang, ddh.SOHOADON, COUNT(ddh.SOHOADON) as 'So lan mua'
	from DONDATHANG as ddh join chitietdathang as ctdh on ctdh.sohoadon = ddh.SOHOADON
	where YEAR(ddh.NGAYDATHANG) = 2018
	group by ddh.SOHOADON, ctdh.mahang
	
------
	
select mhv.mahang
from mathang_view as mhv
where mhv.[So lan mua] = 1

drop view mathang_view

-- Câu 6: Hãy cho biết mỗi một khách hàng đã phải bỏ ra bao nhiêu tiền để đặt mua hàng của công ty?


select DONDATHANG.MAKHACHHANG, SUM(ctdh.giaban*ctdh.soluong - ctdh.giaban*ctdh.soluong*ctdh.mucgiamgia/100) as 'So tien da mua'
from DONDATHANG join chitietdathang as ctdh on DONDATHANG.SOHOADON = ctdh.sohoadon
group by DONDATHANG.MAKHACHHANG

-- Câu 7:  Mỗi một nhân viên của công ty đã lập bao nhiêu đơn đặt hàng (nếu nhân viên chưa hề lập một
--  hoá đơn nào thì cho kết quả là 0)

select nv.MANHANVIEN,  COUNT(ddh.SOHOADON) as 'So hoa don'
from NHANVIEN as nv left outer join DONDATHANG as ddh on nv.MANHANVIEN = ddh.MANHANVIEN
group by nv.MANHANVIEN

-- Câu 8: Cho biết tổng số tiền hàng mà cửa hàng thu được trong mỗi tháng của năm 2003 (thời được gian
-- tính theo ngày đặt hàng).

select MONTH(ddh.NGAYDATHANG) as 'Thang' ,Sum(ctdh.giaban*ctdh.soluong - ctdh.giaban*ctdh.soluong*ctdh.mucgiamgia/100) as 'So tien'
from DONDATHANG as ddh join chitietdathang as ctdh on ctdh.sohoadon = ddh.SOHOADON
where YEAR(ddh.NGAYDATHANG) = 2003
group by MONTH(ddh.NGAYDATHANG)
order by MONTH(ddh.NGAYDATHANG)

-- Câu 9: Hãy cho biết tổng số lượng hàng của mỗi mặt hàng mà cty đã có (tổng số lượng hàng hiện có và đã bán).

----- sai!
declare mahang_cs cursor for select ddh.SOHOADON from DONDATHANG as ddh
open mahang_cs

declare @mahang char(10)
fetch next from mahang_cs into @mahang

while @@FETCH_STATUS = 0
begin
	if(@mahang in (select ctdh.mahang from chitietdathang as ctdh)) 
		begin
			select mh.mahang, COUNT(mh.soluong) + (select ddh.SOHOADON, COUNT(ddh.SOHOADON) as 'So luong'
				from DONDATHANG as ddh join chitietdathang as ctdh on ddh.SOHOADON = ctdh.sohoadon
				group by ddh.SOHOADON)
			from mathang as mh join chitietdathang as ctdh on mh.mahang = ctdh.mahang
			where mh.mahang = 'mh1'
			group by mh.mahang
		end
	else
		begin
			select COUNT(mh.soluong) as 'So luong'
			from mathang as mh
			group by mh.mahang
		end
	
	fetch next from mahang_cs into @mahang	
end

close mahang_cs
deallocate mahang_cs


-- Câu 10:  Nhân viên nào của cty bán được số lượng hàng nhiều nhất và số lượng hàng
-- bán được của nhân viên này là bao nhiêu?

select top 1 NHANVIEN.MANHANVIEN, COUNT(NHANVIEN.MANHANVIEN) 'So luong'
from NHANVIEN join DONDATHANG on NHANVIEN.MANHANVIEN = DONDATHANG.MANHANVIEN
group by NHANVIEN.MANHANVIEN
order by COUNT(NHANVIEN.MANHANVIEN) desc

-- Câu 11: Mỗi một đơn đặt hàng đặt mua những mặt hàng nào và tổng số tiền mà mỗi đơn
-- đặt hàng phải trả là bao nhiêu?
select DONDATHANG.SOHOADON, ctdh.mahang, (ctdh.giaban* ctdh.soluong - ctdh.giaban* ctdh.soluong*ctdh.mucgiamgia/100) as 'so tien'
from (DONDATHANG join chitietdathang as ctdh on DONDATHANG.SOHOADON = ctdh.sohoadon)

-- Câu 12: Hãy cho biết mỗi một loại hàng bao gồm những mặt hàng nào, tổng số lượng hàng
-- của mỗi loại và tổng số lượng của tất cả các mặt hàng hiện có trong công ty là bao nhiêu? 
-- (chưa bán à đã bán nhưng chưa giao hàng)

select lh.maloaihang, mh.mahang, mh.soluong
from mathang as mh join loaihang as lh on lh.maloaihang = mh.maloaihang
order by lh.maloaihang
select sum(mh.soluong) + (select sum(ctdh.soluong)
from chitietdathang as ctdh join DONDATHANG as ddh on ddh.SOHOADON = ctdh.sohoadon
where ddh.NGAYGIAOHANG < GETDATE()) as 'tong so luong hang hoa hien dang co'
from mathang as mh 



-- Câu 13: Thống kê xem trong năm 2018, mỗi một mặt hàng trong mỗi tháng và trong cả năm bán
-- được với số lượng bao nhiêu.

declare @i int = 1

print 'So luong ban moi mat hang trong moi thang'
while @i <= 12

begin	
	if @i = 12
		begin
		print 'So luong ban moi mat hang trong ca nam'
			select  distinct mh.mahang, SUM(ddh.SOHOADON) as 'So luong da ban trong ca nam'
			from (mathang as mh join chitietdathang as ctdh on ctdh.mahang = mh.mahang)
			join DONDATHANG as ddh on ddh.SOHOADON = ctdh.sohoadon
			group by mh.mahang
		end
	
	select  distinct @i as 'Thang', mh.mahang, SUM(ddh.SOHOADON) as 'So luong da ban trong thang'
	from (mathang as mh join chitietdathang as ctdh on ctdh.mahang = mh.mahang)
	join DONDATHANG as ddh on ddh.SOHOADON = ctdh.sohoadon
	where month(ddh.NGAYGIAOHANG) = @i
	group by mh.mahang
	
	set @i = @i + 1;
	print 'Thang' print @i		
end

-- Câu 14: Cập nhật lại giá trị NGAYCHUYENHANG của những bản ghi có giá trị
-- NGAYCHUYENHANG chưa xác định (NULL) trong bảng DONDATHANG bằng với giá trị của trường NGAYDATHANG.

declare sohoadon cursor for select ddh.SOHOADON from DONDATHANG as ddh
open sohoadon
declare @sohoadon int
fetch next from sohoadon into @sohoadon
while @@FETCH_STATUS = 0
begin
	if ((select ddh.NGAYCHUYENHANG from DONDATHANG as ddh where ddh.SOHOADON = @sohoadon) is NULL )
		begin
			update DONDATHANG 
			set NGAYCHUYENHANG = NGAYDATHANG
			where SOHOADON = @sohoadon
		end
	fetch next from sohoadon into @sohoadon
end
close sohoadon
deallocate sohoadon

select * from DONDATHANG


-- Câu 15: Cập nhật giá trị của trường NOIGIAOHANG trong bảng DONDATHANG bằng địa chỉ của
-- khách hàng đối với những đơn đặt hàng chưa xác định được nơi giao hàng (có giá trị trường
-- NOIGIAOHANG bằng NULL)

declare sohoadon cursor for select ddh.SOHOADON from DONDATHANG as ddh
open sohoadon
declare @sohoadon1 int
fetch next from sohoadon into @sohoadon1
while @@FETCH_STATUS = 0
begin
	if((select ddh.NOIGIAOHANG from DONDATHANG as ddh where ddh.SOHOADON = @sohoadon1) is NULL)
		begin
			update DONDATHANG
			set NOIGIAOHANG = (select kh.DIACHI from KHACHHANG as kh join DONDATHANG as ddh on ddh.MAKHACHHANG = kh.MAKHACHHANG where ddh.SOHOADON = @sohoadon1)
			where SOHOADON = @sohoadon1
		end
	fetch next from sohoadon into @sohoadon1	
end
close sohoadon
deallocate sohoadon

select * from DONDATHANG

-- Câu 16: Cập nhật lại dữ liệu trong bảng KHACHHANG sao cho nếu tên công ty và tên TENGIAODICH
-- của khách hàng trùng với TENGIAODICH của một nhà cung cấp nào đó
-- thì DIACHI, DIENTHOAI, FAX và EMAIL phải giống nhau.


declare makhachhang cursor for select kh.MAKHACHHANG from KHACHHANG as kh
open makhachhang
declare @makhachhang char(10)
fetch next from makhachhang into @makhachhang
while @@FETCH_STATUS = 0
begin
	----!!! (-_-) !!!----
	fetch next from makhachhang into @makhachhang	
end
close makhachhang
deallocate makhachhang

select * from KHACHHANG
select * from NHACUNGCAP


-- Câu 17:  Tăng lương lên gấp rưỡi cho những nhân viên bán được số lượng hàng nhiều hơn 100 trong năm 2003


declare manhanvien cursor for select nv.MANHANVIEN from NHANVIEN as nv
open manhanvien
declare @manhanvien char(10)
fetch next from manhanvien into @manhanvien
print @manhanvien
while @@FETCH_STATUS = 0
begin
	if (select COUNT(NHANVIEN.MANHANVIEN) 'So luong'
	from NHANVIEN join DONDATHANG on NHANVIEN.MANHANVIEN = DONDATHANG.MANHANVIEN
	where NHANVIEN.MANHANVIEN = @manhanvien)>= 100
		begin
			update NHANVIEN
			set luongcoban = luongcoban * 1.5
			where MANHANVIEN = @manhanvien
		end
	fetch next from manhanvien into @manhanvien
end
close manhanvien
deallocate manhanvien

-- Câu 18:  Tăng phụ cấp lên bằng 50% lương cho những nhân viên bán được hàng nhiều nhất.

declare manhanvien cursor for select nv.MANHANVIEN from NHANVIEN as nv
open manhanvien
declare @manhanvien1 char(10)
fetch next from manhanvien into @manhanvien1
while @@FETCH_STATUS = 0
begin
	if (select COUNT(NHANVIEN.MANHANVIEN) 'So luong'
	from NHANVIEN join DONDATHANG on NHANVIEN.MANHANVIEN = DONDATHANG.MANHANVIEN
	where NHANVIEN.MANHANVIEN = @manhanvien1)= (select top 1 COUNT(NHANVIEN.MANHANVIEN) 'So luong'
	from NHANVIEN join DONDATHANG on NHANVIEN.MANHANVIEN = DONDATHANG.MANHANVIEN
	group by NHANVIEN.MANHANVIEN
	order by COUNT(NHANVIEN.MANHANVIEN) desc)
		begin
			update NHANVIEN
			set phucap = luongcoban*0.5
			where MANHANVIEN = @manhanvien1
		end
	fetch next from manhanvien into @manhanvien1
end
close manhanvien
deallocate manhanvien

select * from NHANVIEN

-- Câu 19: Giảm 25% lương của những nhân viên trong năm 2003 ko lập được bất kỳ đơn đặt hàng nào


declare manhanvien cursor for select nv.MANHANVIEN from NHANVIEN as nv
open manhanvien
declare @manhanvien2 char(10)
fetch next from manhanvien into @manhanvien2
while @@FETCH_STATUS = 0
begin
	if @manhanvien2 not in(select NHANVIEN.MANHANVIEN
		from NHANVIEN join DONDATHANG on NHANVIEN.MANHANVIEN = DONDATHANG.MANHANVIEN
		where year(DONDATHANG.NGAYDATHANG) = 2018
		group by NHANVIEN.MANHANVIEN
		having COUNT(NHANVIEN.MANHANVIEN) >= 1)
		begin
			update NHANVIEN
			set luongcoban = luongcoban - luongcoban*0.25
			where MANHANVIEN = @manhanvien2
		end
	fetch next from manhanvien into @manhanvien2
end
close manhanvien
deallocate manhanvien

select * from NHANVIEN

-- Câu 20: Giả sử trong bảng DONDATHANG có them trường SOTIEN cho biết số tiền mà khách
-- hàng phải trả trong mỗi dơnđặt hàng. Hãy tính giá trị cho trường này.

alter table dondathang add SOTIEN float

declare sohoadon cursor for select ddh.SOHOADON from DONDATHANG as ddh
open sohoadon
declare @shd int
fetch next from sohoadon into @shd
while @@FETCH_STATUS = 0
begin
	update DONDATHANG
	set SOTIEN = (
		select sum(ctdh.giaban*ctdh.soluong - ctdh.giaban*ctdh.soluong*ctdh.mucgiamgia/100)
		from DONDATHANG as ddh join chitietdathang as ctdh on ctdh.sohoadon = ddh.SOHOADON
		where ddh.SOHOADON = @shd)
	where SOHOADON =@shd
	fetch next from sohoadon into @shd
end
close sohoadon
deallocate sohoadon

select * from DONDATHANG


-- Câu 21: Xoá khỏi bảng MATHANG những mặt hàng có số lượng bằng 0 và không được đặt mua trong
-- bất kỳ đơn đặt hàng nào.

