BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO coffee_shops (shop_name, main_image, website_link, price_range, rating, highlights, menu_link)
VALUES ('test_name', 'test_image', 'test_link', 1, 1, 'test_highlights', 'test_menu');

INSERT INTO address (address)
VALUES ('test_address');

INSERT INTO hours (shop_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES (1, '9-5', '9-5', '9-5', '9-5', '9-5', '9-5', '9-5');

INSERT INTO shop_address (shop_id, address_id)
VALUES (1, 1);


COMMIT TRANSACTION;
