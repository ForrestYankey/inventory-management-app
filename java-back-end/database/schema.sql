BEGIN TRANSACTION;

DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS hello;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE hello (
	string varchar(100)
);

CREATE TABLE inventory (
	item_id SERIAL,
	name varchar(100),
	description varchar(1000),
	quantity NUMERIC,
	price DECIMAL
);

COMMIT TRANSACTION;