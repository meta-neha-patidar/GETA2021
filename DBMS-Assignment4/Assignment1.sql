#1.Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
SHOW DATABASES;
USE storefront;

DROP FUNCTION NumberOfOrders;  

DELIMITER //
CREATE function NumberOfOrders(month INT, year INT) returns INT DETERMINISTIC
BEGIN
    DECLARE orderCount INT ;
    SELECT COUNT(orderId) 
    FROM makeOrder 
    WHERE month(TimeAdded) = month  AND year(TimeAdded) = year
    INTO orderCount;
    RETURN orderCount;
END
// 
DELIMITER ;

SELECT NumberOfOrders(4, 2021) AS 'Number of Orders';

#Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER //
CREATE function MaxOrderMonth(year INT) returns VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE maxOrderMonth VARCHAR(20);
    SELECT MONTHNAME(TimeAdded)
    FROM makeOrder
    WHERE year(TimeAdded) = year
    GROUP BY month(TimeAdded)
    HAVING COUNT(*) = 
        (SELECT MAX(totalOrdersOfMonth)
        FROM 
            (SELECT TimeAdded, COUNT(*) totalOrdersOfMonth
            FROM makeOrder
            WHERE year(TimeAdded) = year
            GROUP BY month(TimeAdded)) 
        AS maxOrderMonth)
    INTO maxOrderMonth;
    RETURN maxOrderMonth;
END
// 
DELIMITER ;

SELECT MaxOrderMonth(2021) AS 'Maximum Orders Month';

