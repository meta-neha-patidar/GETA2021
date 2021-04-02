USE storefront;
select * from makeOrder;
#1. Display Recent 50 Orders placed (Id, Order Date, Order Total)

SELECT makeOrder.orderId,makeOrder.TimeAdded, (SELECT SUM(Price)
    FROM product JOIN orderDetail 
    ON product.productId = orderDetail.productId
    WHERE orderDetail.orderId = makeOrder.orderId) as 'total'
FROM makeOrder
ORDER BY makeOrder.TimeAdded DESC LIMIT 50;
    
    

#2. Display 10 most expensive Orders.
SELECT makeOrder.orderId,makeOrder.TimeAdded, (SELECT SUM(Price)
    FROM product JOIN orderDetail 
    ON product.productId = orderDetail.productId
    WHERE orderDetail.orderId = makeOrder.orderId) as 'total'
FROM makeOrder
ORDER BY total DESC LIMIT 10;

    
#3.Display all the Orders which are placed more than 10 days old and one or more items from those orders are still 
#not shipped.

SELECT makeOrder.orderId,makeOrder.TimeAdded,orderStatus
FROM makeOrder JOIN orderDetail
ON makeOrder.orderId = orderDetail.orderId
WHERE DATEDIFF(NOW(), makeOrder.TimeAdded) > 1 and orderStatus = 'placed';


#4.Display list of shoppers which haven't ordered anything since last month.
SELECT DISTINCT(user.userId), userName
from makeOrder JOIN user
ON makeOrder.userId = user.userId
WHERE
    DATEDIFF(NOW(), TimeAdded) >= 30;

#5. Display list of shopper along with orders placed by them in last 15 days. 
SELECT user.userId, userName,orderId
FROM user JOIN makeOrder
ON user.userId = makeOrder.userId
WHERE DATEDIFF(NOW(), TimeAdded) <=15;

#6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT orderDetail.orderId,userId,productId
FROM makeOrder JOIN orderDetail
ON makeOrder.orderId = orderDetail.orderId
WHERE orderStatus = 'shipped' ;

#7. Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price
SELECT orderDetail.productId,makeOrder.TimeAdded,product.price
FROM orderDetail JOIN makeOrder
ON orderDetail.orderId = makeOrder.orderId
JOIN product ON orderDetail.productId = product.productId
WHERE product.price >90 AND product.price <100;