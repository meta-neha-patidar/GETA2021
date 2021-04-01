#Consider a form where providing a Zip Code populates associated City and State
#Create appropriate tables and relationships for the same and write a SQL
#query for that returns a Resultset containing Zip Code, City Names and
#States ordered by State Name and City Name.
CREATE TABLE city(ZipCode VARCHAR(10) PRIMARY KEY,cityName VARCHAR(30) NOT NULL);

CREATE TABLE state(stateName VARCHAR(50),CityZipCode VARCHAR(50)PRIMARY KEY,
    FOREIGN KEY (CityZipCode) REFERENCES city (ZipCode)
);


INSERT INTO city VALUES('458895','mandsaur'),
    ('458478','neemuch'),
    ('458926','ratlam'),
    ('489622','ujjain'),
    ('674523','patana'),
    ('332769','jodhpur');
    
INSERT INTO state VALUES('madhya pradesh','458895'),
    ('madhya pradesh','458478'),
    ('madhya pradesh','458926'),
    ('bihar','674523'),
    ('rajasthan','332769'),
    ('madhya pradesh','489622');
    
SELECT stateName, cityName, ZipCode
FROM city JOIN state
ON ZipCode =CityZipCode
ORDER BY stateName, cityName;