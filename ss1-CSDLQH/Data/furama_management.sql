create database furama_management;
use furama_management;

create table vi_tri(
	ma_vi_tri int auto_increment,
    ten_vi_tri nvarchar(45) not null,
    primary key(ma_vi_tri)
);

create table trinh_do(
	ma_trinh_do int auto_increment,
    ten_trinh_do nvarchar(45) not null,
    primary key(ma_trinh_do)
);

create table bo_phan(
	ma_bo_phan int auto_increment,
    ten_bo_phan nvarchar(45),
    primary key(ma_bo_phan)
);

create table nhan_vien(
	ma_nhan_vien int auto_increment,
    ho_ten nvarchar(255) not null,
    ngay_sinh date not null,
    so_cmnd double not null unique,
    luong double not null,
    so_dien_thoai varchar(10) not null unique,
    email varchar(255) not null unique,
    dia_chi nvarchar(255) not null,
    ma_vi_tri int not null,
    ma_trinh_do int not null,
    ma_bo_phan int not null,
    primary key(ma_nhan_vien),
    foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table loai_khach(
	ma_loai_khach int not null auto_increment primary key,
    ten_loai_khach varchar(45) not null
);   

create table khach_hang(
	ma_khach_hang int not null auto_increment primary key,
    ho_ten nvarchar(255) not null,
    ngay_sinh date not null,
    gioi_tinh bit default 1,
    so_cmnd double not null unique,
    so_dien_thoai varchar(10) not null unique,
    email varchar(255) not null unique,
    dia_chi nvarchar(255) not null,
    ma_loai_khach int not null,
    foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table kieu_thue(
	ma_kieu_thue int not null auto_increment primary key,
    ten_kieu_thue varchar(10) not null
);

create table loai_dich_vu(
	ma_loai_dich_vu int not null auto_increment primary key,
    ten_loai_dich_vu varchar(10) not null
);

create table dich_vu(
	ma_dich_vu int not null auto_increment primary key,
    ten_dich_vu varchar(255) not null,
    dien_tich double not null,
    chi_phi_thue double not null,
    so_nguoi_toi_da int not null,
    tieu_chuan_phong varchar(10) not null,
    mo_ta_tien_nghi_khach nvarchar(255) not null,
    dien_tich_ho_boi int null,
    so_tang int null,
    ma_kieu_thue int not null,
    ma_loai_dich_vu int not null,
    foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
    foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table dich_vu_di_kem(
	ma_dich_vu_di_kem int not null auto_increment primary key,
    ten_dich_vu_di_kem nvarchar(255) not null,
    gia double not null,
    don_vi nvarchar(10) not null,
    trang_thai nvarchar(255) not null
);

create table hop_dong(
	ma_hop_dong int not null auto_increment primary key,
    ngay_lam_hop_dong date not null,
    ngay_ket_thuc date not null,
    tien_dat_coc double default 0,
    ma_nhan_vien int not null,
    ma_khach_hang int not null,
    ma_dich_vu int not null,
    foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
    foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table hop_dong_chi_tiet(
	ma_hop_dong_chi_tiet int not null auto_increment primary key,
    so_luong int not null,
    ma_hop_dong int not null,
    ma_dich_vu_di_kem int not null,
    foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
    foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);