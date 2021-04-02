SHOW DATABASES;

#CREATE STOREFRONT DATABASE
CREATE DATABASE storefront;

#SELECT STOREFRONT DATABASE
USE storefront;

show tables;

# CREATE USER TABLE
CREATE TABLE user(
    userId VARCHAR(10) PRIMARY KEY,
    userMailId VARCHAR(15) UNIQUE, 
    userName VARCHAR(20),
    userContact VARCHAR(10)
    );

#CREATE CATEGOTY TABLE
CREATE TABLE category(
    Id VARCHAR(10) PRIMARY KEY,
    productCategory VARCHAR(10) ,
    parentId VARCHAR(10),
    fOREIGN KEY (parentId) 
        REFERENCES category(Id)
        ON DELETE CASCADE
);


#CREATE TABLE PRODUCT
CREATE TABLE product(
    productId VARCHAR(10) PRIMARY KEY,
    productName VARCHAR(50),
    Description VARCHAR(100),
    Price DOUBLE,
    Stock INT,
    categoryId VARCHAR(10),
    TimeAdded TIMESTAMP DEFAULT NOW(),
    Status VARCHAR(10),
    FOREIGN KEY (categoryId)
        REFERENCES category (Id)
        ON DELETE CASCADE
);


#CREATE TABLE IMAGE
CREATE TABLE images(
   imageId VARCHAR(10),
   image VARCHAR(10),
   productId VARCHAR(10),
   FOREIGN KEY(productId)
    REFERENCES product(productId)
    ON DELETE CASCADE
);


#CREATE MAKEORDER TABLE


CREATE TABLE makeOrder(
    orderId VARCHAR(10) PRIMARY KEY,
    userId VARCHAR(10),
    TimeAdded TIMESTAMP DEFAULT NOW(),
     FOREIGN KEY (userId)
        REFERENCES user (userId)
        ON DELETE CASCADE
);


CREATE TABLE orderDetail(
    Id VARCHAR(10) PRIMARY KEY,
    orderId VARCHAR(10),
    productId VARCHAR(10),
    ProductQuantity INT,
    orderStatus VARCHAR(10),
    FOREIGN KEY (ProductID)
        REFERENCES product (ProductID)
        ON DELETE CASCADE,
    FOREIGN KEY (orderId) 
        REFERENCES makeOrder(orderId) 
        ON DELETE CASCADE
    );


#CREATE TABLE ADDRESS
CREATE TABLE address(
    orderId VARCHAR(10) PRIMARY KEY,
    oneLineAddress VARCHAR(100),
    city VARCHAR(50),
    State VARCHAR(50),
    Pincode VARCHAR(10),
    Country VARCHAR(50),
    UserID VARCHAR(10),
    FOREIGN KEY (UserID)
        REFERENCES user (userId)
        ON DELETE CASCADE,
    FOREIGN KEY (orderId)
        REFERENCES makeOrder (orderId)
        ON DELETE CASCADE
);



# command to remove Product table
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE product;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE product(
    productId VARCHAR(10) PRIMARY KEY,
    productName VARCHAR(50),
    Description VARCHAR(100),
    Price DOUBLE,
    Stock INT,
    categoryId VARCHAR(10),
    TimeAdded TIMESTAMP DEFAULT NOW(),
    Status VARCHAR(10),
    FOREIGN KEY (categoryId)
        REFERENCES category (Id)
        ON DELETE CASCADE
);


