-- Tạo cơ sở dữ liệu demo
CREATE DATABASE demo;

-- Sử dụng cơ sở dữ liệu demo
USE demo;

-- Tạo bảng Products
CREATE TABLE Products (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  productCode VARCHAR(50) NOT NULL,
  productName VARCHAR(255) NOT NULL,
  productPrice FLOAT NOT NULL,
  productAmount INT NOT NULL,
  productDescription TEXT,
  productStatus VARCHAR(50) NOT NULL
);

-- Chèn dữ liệu mẫu
INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES ('P001', 'Laptop Dell Inspiron', 1000, 10, 'Laptop cao cấp, hiệu năng mạnh', 'In stock'),
       ('P002', 'Smartphone Samsung Galaxy S20', 800, 20, 'Điện thoại thông minh đầy đủ tính năng', 'In stock'),
       ('P003', 'Tai nghe Bluetooth EarPods', 200, 50, 'Tai nghe không dây hiệu năng cao', 'In stock'),
       ('P004', 'Chuột máy tính Logitech', 50, 30, 'Chuột cao cấp, đáp ứng mọi nhu cầu', 'Out of stock'),
       ('P005', 'Bàn phím gaming Razer', 150, 15, 'Bàn phím chuyên dụng cho game thủ', 'In stock');
       
       -- Tạo Unique Index trên cột productCode
CREATE UNIQUE INDEX idx_productCode ON Products (productCode);

-- Tạo Composite Index trên các cột productName và productPrice
CREATE INDEX idx_productNamePrice ON Products (productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN với câu truy vấn SELECT để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM Products WHERE productName LIKE '%Laptop%';

-- Tạo view để lấy về các thông tin productCode, productName, productPrice, productStatus từ bảng Products:
CREATE VIEW ProductsInfo AS
SELECT productCode, productName, productPrice, productStatus
FROM Products;

-- Sửa đổi view ProductsInfo để thêm cột productAmount (số lượng sản phẩm) vào dữ liệu truy vấn:
ALTER VIEW ProductsInfo AS
SELECT productCode, productName, productPrice, productAmount, productStatus
FROM Products;

-- Xoá view ProductsInfo:
DROP VIEW ProductsInfo;

-- Thủ tục lưu trữ lấy tất cả thông tin của tất cả các sản phẩm trong bảng Products:
DELIMITER //
CREATE PROCEDURE GetProducts()
BEGIN
    SELECT *
    FROM Products;
END //
DELIMITER ;
-- Thực thi procedure GetProducts
call GetProducts();

-- Thủ tục lưu trữ thêm một sản phẩm mới vào bảng Products:
DELIMITER //
CREATE PROCEDURE AddProduct(
    IN pCode VARCHAR(50),
    IN pName VARCHAR(255),
    IN pPrice FLOAT,
    IN pAmount INT,
    IN pDesc TEXT,
    IN pStatus VARCHAR(50)
)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (pCode, pName, pPrice, pAmount, pDesc, pStatus);
END //
DELIMITER ;
-- Thực thi procedure AddProduct
call AddProduct('P006', 'Chuột gaming Logitech G203', 150, 15, 'Chuột chuyên dụng cho game thủ', 'In stock');

-- Thủ tục lưu trữ sửa thông tin sản phẩm theo id trong bảng Products:
DELIMITER //
CREATE PROCEDURE UpdateProduct(
    IN pId INT,
    IN pCode VARCHAR(50),
    IN pName VARCHAR(255),
    IN pPrice FLOAT,
    IN pAmount INT,
    IN pDesc TEXT,
    IN pStatus VARCHAR(50)
)
BEGIN
    UPDATE Products
    SET productCode = pCode,
        productName = pName,
        productPrice = pPrice,
        productAmount = pAmount,
        productDescription = pDesc,
        productStatus = pStatus
    WHERE Id = pId;
END //
DELIMITER ;
-- Thực thi procedure UpdateProduct
call UpdateProduct(1,'P007', 'Laptop Asus TUF Gaming A15 FA506IHRB-HN019W', 300, 5, 'laptop hàng đầu cho game thủ ở thời điểm hiện tại','In stock'); 

-- Thủ tục lưu trữ xoá sản phẩm theo id trong bảng Products:
DELIMITER //
CREATE PROCEDURE DeleteProduct(
    IN pId INT
)
BEGIN
    DELETE FROM Products
    WHERE Id = pId;
END //
DELIMITER ;
-- Thực thi procedure DeleteProduct
call DeleteProduct(3);