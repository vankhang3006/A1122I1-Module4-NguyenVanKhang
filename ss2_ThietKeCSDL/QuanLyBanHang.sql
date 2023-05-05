create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
	cID			int not null auto_increment primary key,
    cName		varchar(45) not null,
    cAge		int
);

create table Orderr(
	oID			int not null auto_increment primary key,
    cID			int not null,
    oDate		date,
    oTotalPrice	double,
    foreign key(cID) references Customer(cID)
);

create table Product(
	pID			int not null auto_increment primary key,
    pName		varchar(45) not null,
    pPrice		double
);

create table OrderDetail(
	oID			int not null,
    pID			int not null,
    odQTY		int not null,
	primary key(oID, pID),
    foreign key(oID) references Orderr(oID),
    foreign key(pID) references Product(pID)
);