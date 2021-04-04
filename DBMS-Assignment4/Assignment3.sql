#Identify the columns require indexing in order, product, category tables and create indexes.

#user

ALTER TABLE user
ADD INDEX userName(userName);


#category
ALTER TABLE category
ADD INDEX productCategory(productCategory);

#product
ALTER TABLE product
ADD INDEX productName(productName),
ADD INDEX Stock(Stock),
ADD INDEX TimeAdded(TimeAdded),
ADD INDEX Status(Status);

#images
ALTER TABLE images
ADD INDEX image(image);

#makeOrder
ALTER TABLE makeOrder
Add INDEX TimeAdded(TimeAdded);

#orderDetails
ALTER TABLE orderDetail
ADD INDEX orderIdD(orderId),
ADD INDEX productIdD(productId),
ADD INDEX orderStatus(orderStatus);

#address
ALTER TABLE address
ADD INDEX city(city),
ADD INDEX State(State),
ADD INDEX Pincode(Pincode),
ADD INDEX Country(Country);