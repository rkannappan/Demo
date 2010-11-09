Create table EXPENSE_TYPE
(
	EXPENSE_TYPE_NAME Varchar NOT NULL UNIQUE,
	EXPENSE_TYPE_DESC Varchar,
 primary key (EXPENSE_TYPE_NAME)
) Without Oids;

Create table EXPENSE
(
	EXPENSE_ID Serial NOT NULL UNIQUE,
	EXPENSE_TYPE_NAME Varchar NOT NULL,
	EXPENSE_DATE Date,
	Amount Double precision,
 primary key (EXPENSE_ID)
) Without Oids;

Alter table EXPENSE add foreign key (EXPENSE_TYPE_NAME) references EXPENSE_TYPE (EXPENSE_TYPE_NAME) on update restrict on delete restrict;