create database oop_project ;

use oop_project ;


create table KHACHHANG
(
    MAKH int identity(1,1) primary key ,
    TENKH nvarchar(50) not null ,
    DIENTHOAI nvarchar(15) not null ,
    EMAIL nvarchar(50) not null ,
    DIACHI nvarchar(200) not null ,
)  ;


create table NHANVIEN
(
    MANV int identity(1,1) primary key ,
    TENNV nvarchar(50) not null ,
    SDT nvarchar(20) not null ,
    EMAIL nvarchar(50) not null ,
    DCNV nvarchar(100) not null
)  ;


create table LINHKIEN
(
    MALK int identity(1,1)  primary key ,
    TENLK nvarchar(100) not null ,
    NSX nvarchar(100) not null ,
    GIALK int not null
)  ;


create table SANPHAM
(
    IMEI varchar(50) primary key ,
    MAKH int not null ,
    TENSP nvarchar(100) not null ,
    LOAISP nvarchar(50) not null ,
    NXS nvarchar(100) not null ,
    THOIGIANBAOHANH nvarchar(50) not null ,
    HINHANHSP nvarchar(200) not null ,
    THONGTINSP text not null
)  ;

create table DONBAOHANH
(
    MADON int identity(1,1) primary key ,
    IMEI varchar(50) not null,
    MAKH int not null ,
    HINHANHTHIETBI nvarchar(200) not null ,
    MOTABENH text not null ,
    MALK int not null ,
    GIADON int not null ,
    MANV int not null ,
    TRANGTHAISUACHUA text not null
)  ;


SELECT * FROM dbo.DONBAOHANH WHERE MADON = 9;
-- các quan hệ

alter table SANPHAM
    add constraint fk_KH foreign key (MAKH) references KHACHHANG(MAKH) ;

alter table DONBAOHANH
    add constraint fk_NV foreign key (MANV) references NHANVIEN(MANV) ;

alter table DONBAOHANH
    add constraint fk_IMEI foreign key (IMEI) references SANPHAM(IMEI) ;

alter table DONBAOHANH
    add constraint fk_LK foreign key (MALK) references LINHKIEN(MALK) ;

ALTER TABLE dbo.DONBAOHANH 
DROP COLUMN HINHANHTHIETBI;
 

ALTER TABLE dbo.DONBAOHANH
ADD NGAYTAO DATETIME;
 