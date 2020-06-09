use master
go
drop database Trung_Java5_PS08925
go
create database Trung_Java5_PS08925
go
use Trung_Java5_PS08925
go

create table DanhMuc
(
	MaDM int identity(1,1) primary key,
	TenDM nvarchar(100) not null
)
go

create table SanPham
(
	MaSP int identity(1,1) primary key,
	TenSP nvarchar(50) not null,
	DonGia int,
	SoLuong int,
	Hinh varchar(50),
	MaDM int references DanhMuc(MaDM)
)
go

create table KhachHang
(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(50) not null,
	DiaChi nvarchar(100),
	DienThoai varchar(15),
	MatKhau varchar(15)
)
go

create table DonHang
(
	MaDH int identity(1,1) primary key,
	NgayDatHang date,
	MaKH int references KhachHang(MaKH)
	
)
go

create table ChiTietDonHang
(
	MaDH int references DonHang(MaDH),
	MaSP int references SanPham(MaSP),
	DonGia int,
	SoLuong int
	Constraint pk_CTDH primary key(MaDH,MaSP)
)
go

create table admin
(
	username varchar(50) primary key,
	password varchar(50)
)
go

insert into admin values('admin','123')
go
select * from admin
go

insert into KhachHang values(N'trung',N'Q.GV','0123','3210')
insert into KhachHang values(N'ABC',N'Q.BT','0456','6540')
insert into KhachHang values(N'DEF',N'Q.TD','0789','9870')
go

insert into DanhMuc values(N'0')
insert into DanhMuc values(N'1')
insert into DanhMuc values(N'2')
insert into DanhMuc values(N'3')
go


insert into SanPham values(N'phu nu khoi nghiep',2,2,'H0.jpg',1)
insert into SanPham values(N'doi cho sao bang',8,3,'H1.jpg',2)
insert into SanPham values(N'nhe ganh uu phien',6,4,'H2.jpg',3)
insert into SanPham values(N'yeu thuong hanh phuc',9,5,'H3.jpg',2)
insert into SanPham values(N'nhat ky nguoi gia',7,4,'H4.jpg',1)
insert into SanPham values(N'loi tat khon ngoan',8,3,'H5.jpg',0)
insert into SanPham values(N'gone with the wind',8,2,'H6.jpg',1)
insert into SanPham values(N'nghe thuat',9,1,'H7.jpg',2)

select * from DanhMuc
go

insert into DonHang values('31/12/2018',1)
insert into DonHang values('31/12/2019',2)
go

insert into ChiTietDonHang values(1,2,150000,4)
insert into ChiTietDonHang values(2,1,250000,5)
go



