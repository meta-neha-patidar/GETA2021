#1. Create a view displaying the order 
#information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
#with latest ordered items should be displayed first for last 60 days.
CREATE VIEW information AS  SELECT product.productId,productName as 'Title',
    product.Price,userName,userMailId,DATE(makeOrder.TimeAdded) AS 'Order Date',
    orderStatus
FROM user JOIN makeOrder 
ON makeOrder.userID = user.userId
JOIN product ON makeOrder.productId = product.productId
WHERE 
    DATEDIFF(NOW(), makeOrder.TimeAdded) <= 60 
ORDER BY makeOrder.TimeAdded DESC;

#2.Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT * FROM information WHERE orderStatus = 'SHIPPED';

#3.Use the above view to display the top 5 most selling products.

SELECT productId,COUNT(*) AS 'sellingProduct'
FROM information 
GROUP BY productId ORDER BY sellingProduct LIMIT 5;