SHOW DATABASES;
USE storefront;
#Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
#DROP PROCEDURE AverageSales;
DELIMITER //
CREATE PROCEDURE AverageSales (month INT, year INT)
BEGIN
  SELECT 
        product.productId, 
        product.productName,
        ROUND (AVG(ProductQuantity), 2) AS 'AverageSales'
  FROM 
        makeOrder
            JOIN
        orderDetail ON orderDetail.OrderID = makeOrder.orderId
            JOIN
        product ON product.productId = orderDetail.productId
  WHERE MONTH(makeOrder.TimeAdded) = month AND year = YEAR(makeOrder.TimeAdded)
  GROUP BY product.productId;
END 

//
DELIMITER ;

CALL AverageSales(4, 2021);

select * from orderDetail;



#Create a stored procedure to retrieve table having order detail with status for a given period.
#Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date.

DROP PROCEDURE DetailsOfOrder;

DELIMITER //
CREATE PROCEDURE DetailsOfOrder (start DATE, endDate DATE)
BEGIN
IF start > endDate THEN SET start = DATE_FORMAT(endDate, '%Y-%m-01');
END IF;
SELECT orderDetail.OrderID, ProductID, orderStatus
  FROM orderDetail 
  JOIN makeOrder ON makeOrder.orderId = orderDetail.orderID
  WHERE TimeAdded BETWEEN start AND endDate;
END //
DELIMITER ;

CALL DetailsOfOrder('2021-04-20', '2021-04-03');

CALL DetailsOfOrder('2021-04-03', '2021-04-20');
