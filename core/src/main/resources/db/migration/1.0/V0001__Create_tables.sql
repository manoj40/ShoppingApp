-- Leave a large ID space reserved for master-data and test-data
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

CREATE TABLE Product (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name VARCHAR (255) NULL,
  type VARCHAR (255) NULL,
  quantity BIGINT (120) NULL,
  price DOUBLE NOT NULL,
  CONSTRAINT PK_Product PRIMARY KEY(id)
);

INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (1, 1, 'Eggs', 'Food', 100, 5);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (2, 1, 'Bead', 'Food', 50, 10.5);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (3, 1, 'Chips', 'Food', 70, 10);

INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (4, 1, 'Shirt', 'Fashion', 20, 500);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (5, 1, 'Pant', 'Fashion', 20, 550);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (6, 1, 'Hat', 'Fashion', 100, 225);

INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (7, 1, 'Bulbs', 'Electronics', 47, 115);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (8, 1, 'Switch', 'Electronics', 100, 50);
INSERT INTO Product (id, modificationCounter, name, type, quantity, price) VALUES (9, 1, 'Adaptor', 'Electronics', 30, 75);


CREATE TABLE User (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name VARCHAR (255) NOT NULL,
  password VARCHAR (255) NULL,
  roles VARCHAR (255) NULL,
  CONSTRAINT PK_User PRIMARY KEY(id),
  CONSTRAINT PK_Name UNIQUE KEY(name)
);

INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (1, 1, 'smith', 'smith', 'user,admin');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (2, 1, 'john', 'john', 'user');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (3, 1, 'cleark', 'cleark', 'user');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (4, 1, 'king', 'king', 'user,admin');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (5, 1, 'robert', 'robert', 'user');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (6, 1, 'admin', 'admin', 'user,admin');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (7, 1, 'hellen', 'hellen', 'user');
INSERT INTO User (id, modificationCounter, name, password, roles) VALUES (9, 1, 'rose', 'rose', 'user');

CREATE TABLE Card (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  creditCardNumber VARCHAR (255) NOT NULL,
  userName VARCHAR (255) NOT NULL,
  amount DOUBLE NOT NULL,
  status VARCHAR (255),
  CONSTRAINT PK_Card PRIMARY KEY(id),
  CONSTRAINT PK_CardNumber UNIQUE KEY(creditCardNumber)
);

INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (1, 1, '123456789123', 'smith', 987634, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (2, 1, '837464847489', 'john', 765432, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (3, 1, '932747494794', 'cleark', 768754, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (4, 1, '948404850589', 'king', 983574, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (5, 1, '659373037304', 'robert',746484, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (6, 1, '243094234049', 'admin', 947465, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (7, 1, '484830033057', 'hellen', 736748, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (8, 1, '537484947599', 'rose', 918183, 'active');


CREATE TABLE Payment (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  userName VARCHAR (255) NOT NULL,
  cardId BIGINT NOT NULL,
  amount DOUBLE NOT NULL,
  paymentStatus BOOLEAN,
  CONSTRAINT PK_Payment PRIMARY KEY(id),
  CONSTRAINT PK_CardId FOREIGN KEY(cardId) REFERENCES Card(id)
);

CREATE TABLE Orders (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  paymentId BIGINT NULL,
  userName VARCHAR (255) NOT NULL,
  products OTHER NOT NULL,
  amount DOUBLE NOT NULL,
  status BOOLEAN,
  orderTime TIMESTAMP NULL,
  CONSTRAINT PK_Order PRIMARY KEY(id),
  CONSTRAINT PK_userName FOREIGN KEY(userName) REFERENCES User(name)
  --CONSTRAINT PK_paymentId FOREIGN KEY(paymentId) REFERENCES Payment(id)
);

CREATE TABLE Cart (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  userName VARCHAR (255) NOT NULL,
  products OTHER NOT NULL,
  CONSTRAINT PK_Cart PRIMARY KEY(id),
  CONSTRAINT PK_UserNameFk FOREIGN KEY(userName) REFERENCES User(name)
);