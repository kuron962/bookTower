CREATE TABLE book(
    id int IDENTITY (1, 1) PRIMARY KEY NOT NULL,
    title varchar(100) NOT NULL,
	category varchar(25),
    status varchar(25),
)
GO