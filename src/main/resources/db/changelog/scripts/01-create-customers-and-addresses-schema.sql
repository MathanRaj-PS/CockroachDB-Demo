CREATE TABLE Customer (
  Id UUID NOT NULL,
  FirstName STRING(64000),
  LastName STRING(64000),
  PRIMARY KEY(Id)
);

--CREATE INDEX customer_idx ON customer (orgid, customertype );


CREATE TABLE Address (
  CustomerId STRING(36) NOT NULL REFERENCES customer(id) ON DELETE CASCADE,
  Id UUID(36) NOT NULL,
  Address1 STRING(64000)
  Address2 STRING(64000)
  City STRING(64000),
  Country STRING(36),
  Postcode STRING(36)
  PRIMARY KEY(Id)
) ;
--CREATE INDEX address_idx ON address (orgid, customerid );