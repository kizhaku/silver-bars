create table SILVERBAR_ORDER(
  ORDER_ID int not null AUTO_INCREMENT,
  USER_ID int,
  QUANTITY numeric(10, 2) not null,
  PRICE numeric(10, 2) not null,
  TYPE varchar(100) null,
  PRIMARY KEY ( ORDER_ID )
);

create table SILVERBAR_USER(
  USER_ID int not null AUTO_INCREMENT,
  NAME varchar(100) null,
  PRIMARY KEY ( USER_ID )
);

