USE storefront;
#1. insert data in tables
#insert data in user table
INSERT INTO user
VALUES('1', 'neha@g.com','neha','8901234567'),
    ('2', 'muskan@g.com','muskan','9023456781'),
    ('3', 'apoorva@g.com','apoorva','7890123456'),
    ('4', 'snato@g.com','santo','7823456901');

#insert data in category table
INSERT INTO category VALUES('101','cosmatic','101'),
    ('102','electronic','102'),
    ('103','mobile' , '102'),
    ('104','facewash', '101'),
    ('105','facecream', '101');

 
 #insert data in product table
INSERT INTO product(productId,productName,Description,Price,Stock,categoryId,TimeAdded,Status)
VALUES('1', 'lakme peachmilk','24 hrs moisturiser',99,5,'105',now(),'active'),
    ('2', 'himaliya','neem purifier',100,10,'104',now(),'active'),
    ('3', 'oppo','4ram 64rom',10000,2,'103',now(),'active');

#insert data in images table
INSERT INTO images VALUES('1','image1','1'),
    ('2','image2','2'),
    ('3','image3','1');

#insert data in makeOrder table
INSERT INTO makeOrder(orderId, userId) 
    VALUES('101','2'),
    ('102','1'),
    ('103','1');
INSERT INTO orderDetail(Id,orderId,productId,ProductQuantity,orderStatus)
VALUES('1001','101','1',2,'placed'),
    ('1002','101','2',1,'shipped'),
    ('1003','101','3',1,'return'),
    ('1004','102','1',1,'placed'),
    ('1005','103','2',1,'shipped'),
    ('1006','103','3',1,'return');
    
select * from orderDetail;
#insert data in address table
INSERT INTO address(orderId,oneLineAddress,city,State,Pincode ,Country)
    VALUES('101','rcew,ajmer road','jaipur','rajasthan','302026','india'),
    ('102','rcew,ajmer road','jaipur','rajasthan','302026','india'),
    ('103','aazad chock','mandsaur','mp','458895','india');


#2. Display Id, Title, Category Title, Price of the products

SELECT productId,
        productName AS 'Title',
        category.productCategory,
        Price
FROM product JOIN category 
ON product.CategoryId = category.Id
ORDER BY timeAdded DESC;


#3. display the list of product which does'nt have image
SELECT * 
FROM product
WHERE productId NOT IN (SELECT productId from images);


#4. Display all Id, Title and Parent Category Title for all the
#Categories listed, sorted by Parent Category Title and then Category Title

SELECT cat1.Id,cat1.productCategory,
    CASE
        WHEN cat1.Id = cat2.parentId THEN 'Top Category'
        ELSE cat2.productCategory
    END as 'parent category'
FROM category cat1
    JOIN category cat2 ON cat1.parentId= cat2.Id
ORDER BY `parent category`,`productCategory`;


#5. Display Id, Title, Parent Category Title of all the leaf Categories

SELECT 
    cat1.Id, cat1.productCategory, cat2.productCategory AS 'Parent Category Title'
FROM
    category cat1
        JOIN
    category cat2 ON cat1.parentId = cat2.Id
WHERE
    cat1.Id NOT IN (SELECT 
        parentId
    FROM
        category);

#6. Display the list of Products whose Quantity on hand (Inventory) is under 50

SELECT * FROM product WHERE stock < 50;
