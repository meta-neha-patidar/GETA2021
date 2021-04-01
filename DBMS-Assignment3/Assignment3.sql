#1. Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT user.userId, userName, COUNT(makeOrder.orderId) AS 'no of order'
FROM user JOIN makeOrder
ON makeorder.userId = user.userId
WHERE DATEDIFF(NOW(), makeOrder.TimeAdded) <=30 GROUP BY user.userId;

#2. Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT user.userId, userName, SUM(productPrice) AS 'revenue'
FROM user JOIN makeOrder
ON user.userId = makeOrder.userId
WHERE DATEDIFF(NOW(), makeOrder.TimeAdded) <= 30 AND makeOrder.orderStatus = 'shipped'
GROUP BY user.userId ORDER BY revenue DESC LIMIT 10;
#3. Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT product.productId,productName, SUM(makeOrder.productId) AS 'no of product'
FROM makeOrder JOIN product 
ON product.productId = makeOrder.productId
WHERE DATEDIFF(NOW(), makeOrder.TimeAdded)
GROUP BY product.productId ORDER BY `no of product` DESC LIMIT 20;


#4. Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTHNAME(TimeAdded) AS 'month',
    SUM(productId) AS 'monthlySale'
FROM makeOrder
WHERE TimeAdded >= CURDATE()- INTERVAL 6 MONTH AND orderStatus = 'shipped'
GROUP BY MONTH(TimeAdded);



#5. Mark the products as Inactive which are not ordered in last 90 days.
ALTER TABLE product 
ADD status VARCHAR(20);

SET SQL_SAFE_UPDATES=0;
UPDATE product SET status = 'Inactive'
WHERE product.productId NOT IN(
    SELECT product.productId FROM (
        SELECT product.productId FROM product JOIN makeOrder
        ON product.productId = makeOrder.productId
        WHERE DATEDIFF(NOW() , makeOrder.TimeAdded <= 90)
    ) AS temp
);
SET SQL_SAFE_UPDATES=1;

#6. Given a category search keyword, display all the Products present in this category/categories. 
SELECT product.productId, productName
FROM product
WHERE Category IN(
    SELECT productCategory FROM category
    WHERE parentCategory = (SELECT productCategory FROM category WHERE productCategory = 'cosmatic')
);

#7. Display top 10 Items which were cancelled most.
SELECT product.productId, productName, sum(makeOrder.productId) AS 'cancelled'
FROM makeOrder JOIN product
ON product.productId = makeOrder.productId
WHERE orderStatus = 'cancelled'
GROUP BY product.productId
ORDER BY cancelled DESC LIMIT 10;