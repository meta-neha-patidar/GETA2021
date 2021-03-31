USE storefront;
select * from makeOrder;
#1. Display Recent 50 Orders placed (Id, Order Date, Order Total)
SELECT orderId, 
    DATE(TimeAdded) AS 'orderdate'
FROM makeOrder
ORDER BY orderdate DESC LIMIT 50;

#2. Display 10 most expensive Orders.

SELECT orderId, productPrice as 'price',
    DATE(TimeAdded) AS 'orderdate'
from makeOrder
ORDER BY price DESC LIMIT 10;

    
#3.Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT orderId, productPrice AS 'price',
    DATE(TimeAdded) AS 'orderdate'
FROM makeOrder
WHERE  DATEDIFF(now() , TimeAdded) > 10 AND orderStatus = 'placed';

#4.Display list of shoppers which haven't ordered anything since last month.
SELECT user.userId, userName
from makeOrder JOIN user
ON makeOrder.userId = user.userId
WHERE
    DATEDIFF(NOW(), TimeAdded) >= 30;

#5. Display list of shopper along with orders placed by them in last 15 days. 
SELECT user.userId, userName,orderId,productId
FROM user JOIN makeOrder
ON user.userId = makeOrder.userId
WHERE DATEDIFF(NOW(), TimeAdded);

#6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT orderId,userId,productId
FROM makeOrder 
WHERE orderStatus = 'placed' ;

#7. Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price
SELECT makeOrder.productId, makeOrder.timeAdded ,productName
FROM makeOrder join product
ON makeOrder.productId = product.productId
where productPrice >90 AND productPrice <100;