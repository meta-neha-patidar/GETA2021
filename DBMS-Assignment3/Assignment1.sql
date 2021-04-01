SHOW DATABASES;

USE storefront;

#With respect to StoreFront application identify, apply and list the constraints you would apply on the columns for the tables created
ALTER TABLE user
MODIFY userMailId VARCHAR(50) NOT NULL;

ALTER TABLE category
MODIFY productCategory VARCHAR(50) NOT NULL,
MODIFY parentCategory VARCHAR(50) NOT NULL;

ALTER TABLE product
MODIFY productName VARCHAR(50) NOT NULL,
MODIFY   Description VARCHAR(100),
MODIFY   Price DOUBLE NOT NULL,
MODIFY  Stock INT NOT NULL,
MODIFY  Category VARCHAR(50) NOT NULL;

ALTER TABLE images
 MODIFY imageId VARCHAR(10) PRIMARY KEY,
MODIFY image VARCHAR(50) NOT NULL;

ALTER TABLE  makeOrder
MODIFY orderStatus VARCHAR(20),
MODIFY userId VARCHAR(10) NOT NULL,
MODIFY productPrice DOUBLE NOT NULL;


ALTER TABLE address
MODIFY oneLineAddress VARCHAR(100) NOT NULL,
MODIFY city VARCHAR(50) NOT NULL,
MODIFY State VARCHAR(50) NOT NULL,
MODIFY Pincode VARCHAR(10)NOT NULL,
MODIFY Country VARCHAR(50) NOT NULL;


