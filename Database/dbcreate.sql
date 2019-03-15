DROP TABLE Reviews;
DROP TABLE Vehicles;
DROP TABLE Services;
DROP TABLE Balance;
DROP TABLE Transactions;
DROP TABLE Requests;
DROP TABLE Customers;
DROP TABLE Professional;

CREATE TABLE Customers (
CustomerId int(10) NOT NULL,
CustomerType boolean NOT NULL,
Name varchar(30) NOT NULL,
CardAuthToken varchar(30),
Vehicles varchar(20),
SubscriptionDate Date,
Email varchar(100) NOT NULL,
MobileNumber varchar(10),
PasswordToken varchar(20) NOT NULL,
PRIMARY KEY (CustomerId)
);

CREATE TABLE Professional (
ProfessionalId int(10),
Name varchar(30),
PasswordToken varchar(20),
Location int(10),
BankToken int(30),
Services varchar(100),
AvRating int(1),
Email varchar(100),
MobileNumber varchar(10),
ABN int(11),
CertificationNumber varchar(20),
PriceVariance DECIMAL(3,2),
PRIMARY KEY (ProfessionalId)
);

CREATE TABLE Requests (
RequestId int(10),
CustomerId int(10),
ProfessionalId int(10),
Accepted boolean,
Problem int(1),
VehicleId int(10),
Location int(10),
Duration int(3),
RequestDate Date,
PRIMARY KEY (RequestId),
FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
FOREIGN KEY (ProfessionalId) REFERENCES Professional(ProfessionalId)
);

CREATE TABLE Reviews (
ReviewId int(10),
CustomerId int(10),
TextString varchar(200),
Rating int(1),
ProfessionalId int(10),
PRIMARY KEY (ReviewId),
FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId)
);

CREATE TABLE Transactions (
TransactionId int(10),
RequestId int(10),
Amount DECIMAL(9,2),
Status varchar(20),
TransactionDate DATE,
PRIMARY KEY (TransactionId),
FOREIGN KEY (RequestId) REFERENCES Requests(RequestId)
);

CREATE TABLE Vehicles (
VehicleId int(10),
NumberPlate varchar(6),
MakeModel varchar(40),
Year int(4),
PRIMARY KEY (VehicleId)
);

CREATE TABLE Services (
Id int(10),
Name varchar(50),
Cost DECIMAL(9,2),
PRIMARY KEY (Id)
);

CREATE TABLE Balance (
Money DECIMAL(9,2)
);
