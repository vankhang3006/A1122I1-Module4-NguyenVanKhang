create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer(
	cID			int not null auto_increment primary key,
    cName		varchar(45) not null,
    cAge		int
);

create table Orderr (
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

insert into Customer(cName, cAge) 
values	('Minh Quan', 10),
		('Ngoc Oanh', 20),
        ('Hong Ha', 50);
        
insert into Orderr(cID, oDate, oTotalPrice)
values	(1, '2006-3-21', Null),
		(2, '2006-3-23', Null),
        (1, '2006-3-16', Null);

insert into Product(pName, pPrice)
values	('May Giat', 3),
		('Tu Lanh', 5),
        ('Dieu Hoa', 7),
        ('Quat', 1),
        ('Bep Dien', 2);

insert into OrderDetail(oID, pID, odQTY)
values	(1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
        
/*Câu 1: Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order*/
select oID, oDate, oTotalPrice from Orderr;
/*Câu 2: Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách*/
select c.cID, c.cName, c.cAge, p.pName, od.odQTY
from Customer c, Orderr o, Product p, OrderDetail od
where c.cID = o.cID and o.oID = od.oID and od.pID = p.pID;
/*Câu 3: Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào*/
select c.cName
from Customer c left join Orderr o on c.cID = o.cID
where o.oID is null;
/*Câu 4: Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)*/
select o.oID, o.oDate, sum(od.odQTY*p.pPrice) as Gia_tien
from Orderr o, OrderDetail od, Product p 
where o.oID = od.oID and p.pID = od.pID
group by o.oID;