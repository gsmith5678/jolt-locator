BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_address;
DROP TABLE IF EXISTS shop_address;
DROP TABLE IF EXISTS favorites;
DROP TABLE IF EXISTS visited;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS hours;
DROP TABLE IF EXISTS coffee_shops;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE coffee_shops (
	shop_id serial,
	shop_name varchar(255) NOT NULL,
	main_image varchar(255) NOT NULL,
	website_link varchar(255) NOT NULL,
	price_range int,
	rating int,
	highlights varchar(255),
	menu_link varchar(255),
	latitude float(10) NOT NULL,
	longitude float(10) NOT NULL,
	distance int DEFAULT 0,
	isApproved boolean DEFAULT false,


	CONSTRAINT pk_shop_id PRIMARY KEY (shop_id)
);


CREATE TABLE hours (
	hours_id serial,
	shop_id int NOT NULL,
	monday varchar(255),
	tuesday varchar(255),
	wednesday varchar(255),
	thursday varchar(255),
	friday varchar(255),
	saturday varchar(255),
	sunday varchar(255),

	CONSTRAINT pk_hours_id PRIMARY KEY (hours_id),
	CONSTRAINT fk_shop_id FOREIGN KEY (shop_id) REFERENCES coffee_shops(shop_id)
);

CREATE TABLE address (
	address_id serial,
	address varchar(255) NOT NULL,

	CONSTRAINT pk_address_id PRIMARY KEY (address_id)
);

CREATE TABLE user_address (
	user_id int NOT NULL,
	address_id int NOT NULL,

	CONSTRAINT pk_user_id_address_id PRIMARY KEY (user_id, address_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE shop_address (
	shop_id int,
	address_id int,

	CONSTRAINT pk_shop_id_address_id PRIMARY KEY (shop_id, address_id),
	CONSTRAINT fk_shop_id FOREIGN KEY (shop_id) REFERENCES coffee_shops(shop_id),
	CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE favorites (
	user_id int,
	shop_id int,

	CONSTRAINT pk_user_id_shop_id PRIMARY KEY (user_id, shop_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_shop_id FOREIGN KEY (shop_id) REFERENCES coffee_shops(shop_id)
);

CREATE TABLE visited (
	user_id int,
	shop_id int,

	CONSTRAINT pk_user_id_shop_visited_id PRIMARY KEY (user_id, shop_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_shop_id FOREIGN KEY (shop_id) REFERENCES coffee_shops(shop_id)
);

COMMIT TRANSACTION;

