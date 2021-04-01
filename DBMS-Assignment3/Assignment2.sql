SHOW DATABASES;

USE storefront;

#1. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT product.productId, product.productName as 'Title'
FROM product JOIN category
ON product.Category = category.productCategory
WHERE category.productCategory != category.parentCategory;


SELECT  count(category.productCategory) as 'category count'
FROM product JOIN category
ON product.Category = category.productCategory
WHERE category.productCategory != category.parentCategory;

#2.Display Count of products as per below price range (0 - 100, 101 - 500, Above 500)
SELECT `range` , COUNT(productId) AS 'count'
FROM (SELECT productId,
    CASE
        WHEN Price BETWEEN 0 AND 100 THEN '0 - 100'
        WHEN Price BETWEEN 101 AND 500 THEN '101 - 500'
        WHEN Price > 500 THEN '> 500'
        END AS `range`
    FROM product) temp
GROUP BY `range`;


#3.Display the Categories along with number of products under each category
SELECT Category, COUNT(productId) AS 'number of products'
FROM product GROUP BY (Category);

