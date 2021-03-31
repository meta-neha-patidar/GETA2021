USE storefront;
#1. insert data in tables
#insert data in user table
INSERT INTO user VALUES('1', 'neha@g.com','neha','8901234567'),
('2', 'muskan@g.com','muskan','9023456781'),
('3', 'apoorva@g.com','apoorva','7890123456'),
('4', 'snato@g.com','santo','7823456901');

#insert data in category table
INSERT INTO category VALUES('cosmatic','cosmatic'),
    ('electronic','electronic'),
    ('mobile' , 'electronic'),
    ('facewash', 'cosmatic'),
    ('facecream', 'cosmatic');
 
 #insert data in product table
INSERT INTO product VALUES('1', 'lakme peachmilk','24 hrs moisturiser',99,5,'facecream',now()),
    ('2', 'himaliya','neem purifier',100,10,'facewash',now()),
    ('3', 'oppo','4ram 64rom',10000,2,'mobile',now());
    
#insert data in images table
INSERT INTO images VALUES('1','image1','1'),
    ('2','image2','2'),
    ('3','image3','1');

#insert data in makeOrder table
INSERT INTO makeOrder(orderId,orderStatus, userId,productId ,productPrice) 
    VALUES('101','shipped','2','1',99),
    ('102','shipped','1','2',100),
    ('103','return','1','2',100);


#insert data in address table
INSERT INTO address(orderId,oneLineAddress,city,State,Pincode ,Country)
    VALUES('1','rcew,ajmer road','jaipur','rajasthan','302026','india'),
    ('2','rcew,ajmer road','jaipur','rajasthan','302026','india');


#2. Display Id, Title, Category Title, Price of the products

SELECT productId,
        productName,
        category.productCategory
        Price
FROM product JOIN category 
ON product.Category = category.productCategory
ORDER BY timeAdded DESC;


#3. display the list of product which does'nt have image
SELECT * 
FROM product
WHERE productId NOT IN (SELECT productId from images);


#4. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title

SELECT cat1.productCategory,
    CASE
        WHEN cat1.productCategory = cat2.parentCategory THEN 'Top Category'
        ELSE cat2.productCategory
    END as 'parent category'
FROM category cat1
    JOIN category cat2 ON cat1.parentCategory= cat2.productCategory
ORDER BY `parent category`,`productCategory`;


#5. Display Id, Title, Parent Category Title of all the leaf Categories

SELECT 
    cat1.productCategory,  cat2.parentCategory AS 'Parent Category Title'
FROM
    category cat1
        JOIN
    category cat2 ON cat1.parentCategory = cat2.productCategory
WHERE
    cat1.productCategory NOT IN (SELECT 
        parentCategory
    FROM
        category);

#6. Display the list of Products whose Quantity on hand (Inventory) is under 50

SELECT * FROM product WHERE stock < 50;
