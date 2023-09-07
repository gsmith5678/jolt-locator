BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO coffee_shops (shop_name, main_image, website_link, price_range, rating, highlights, menu_link, latitude, longitude, isApproved)
VALUES ('Third Way Cafe', 'third_way_cafe.png', 'https://www.thirdwaycafe.org/', 1, 4, 'coffee, non-dairy', 'www.thirdwaycafe.org/menu', 39.95471, -83.08208, true),
		('Fox in the Snow Cafe - Short North', 'foxinthesnow.jpeg', 'https://www.foxinthesnow.com/', 3, 4, 'coffee, food, dessert, bean, alcohol, non-dairy, outdoor seating, dog friendly', 'www.foxinthesnow.com/menus/#menu', 39.98411, -82.99934, true),
		('Fox in the Snow Cafe - German Village', 'foxinthesnow.jpeg', 'https://www.foxinthesnow.com/', 3, 4, 'coffee, food, dessert, bean, alcohol, non-dairy, outdoor seating, dog friendly', 'www.foxinthesnow.com/menus/#menu',39.93971, -82.99047, true),
		('Fox in the Snow Cafe - New Albany', 'foxinthesnow.jpeg', 'https://www.foxinthesnow.com/', 3, 4, 'coffee, food, dessert, bean, alcohol, non-dairy, outdoor seating, dog friendly', 'www.foxinthesnow.com/menus/#menu', 40.08196, -82.81368, true),
		('Pistacia Vera', 'pistacia_vera.png', 'https://www.pistaciavera.com/', 4, 4, 'coffee, food, dessert, non-dairy, outdoor seating, dog friendly', 'https://static1.squarespace.com/static/525406e0e4b03949ba5345ea/t/642d8a566dc7e770f0464b5a/1680706135156/FULL+MENU+SPRING+2023+NEW+FINAL+%281%29.pdf', 39.95127,-82.99614, true),
		('One Line Coffee - Short North', 'one_line_coffee.jpg', 'https://www.onelinecoffee.com/short-north-location/', 3, 5, 'coffee, dessert, bean, non-dairy', 'https://www.toasttab.com/one-line-coffee-short-north-745-n-high-st/v3', 39.97774126, -83.00381997, true),
		('Brioso Coffee', 'brioso_coffee.png', 'https://briosocoffee.com/', 2, 3, 'coffee, bean, non-dairy, outdoor seating', 'https://briosocoffee.com/pages/high-st', 39.9635789, -83.00105985, true),
		('Kolache Republic', 'kolache_republic.jpg', 'https://kolacherepublic.com/', 4, 2, 'coffee, food, dessert, non-dairy', 'https://kolacherepublic.com/menu/', 39.94790022, -82.99756926, true),
		('Emmetts Cafe', 'emmetts_cafe.png', 'https://www.emmettscafe.com/', 2, 4, 'coffee, food, dessert, non-dairy, outdoor seating, dog friendly', 'https://www.emmettscafe.com/menu-s-high', 39.94622497, -82.99745726, true),
		('Global Gallery', 'global_gallery.png', 'http://www.globalgallerycolumbus.com/', 3, 5, 'coffee, food, dessert, bean, alcohol, non-dairy, outdoor seating, dog friendly', 'http://www.globalgallerycolumbus.com/menu-2', 40.03430057, -83.01686601, true),
		('Staufs Coffee', 'staufs_coffee.png', 'https://www.staufs.com/', 3, 4, 'coffee, food, dessert, non-dairy, outdoor seating, dog friendly', 'https://www.staufs.com/grandviewheightsmenu', 39.98381, -83.045258, true),
		('Basic Biscuits, Kindness, and Coffee', 'basic_biscuits.png', 'https://www.getbasicbiscuits.com/', 4, 3, 'coffee, food, alcohol, non-dairy, outdoor seating', 'https://www.getbasicbiscuits.com/home', 39.97476, -83.03456, true),
		('Qamaria Yemeni Coffee Co.', 'qamaria_coffee.png', 'https://www.qamariacoffee.com/', 4, 3, 'coffee, dessert, bean, smoothies, non-dairy', 'https://www.clover.com/online-ordering/qamaria-hilliard', 40.017262, -83.158974, true),
		('The Roosesvelt Coffeehouse', 'roosevelt_coffee.png', 'https://www.rooseveltcoffee.org/', 3, 3, 'coffee, dessert, food, non-dairy, outdoor seating, dog friendly', 'https://roosevelt.coffee/shop/', 39.96601, -82.99315, true),
		('Mission Coffee Co.', 'mission_coffee.png', 'https://www.missioncoffeeco.com/', 2, 2, 'coffee, bean', 'https://www.missioncoffeeco.com/collections', 39.91948, -82.99417, true),
		('Bottoms Up Coffee', 'bottoms_up.png', 'https://www.bottomsupcoffee.com/', 3, 5, 'food, alcohol, dessert', 'https://www.bottomsupcoffee.com/menu', 39.95862, -83.02913, true),
		('Roaming Goat Coffee', 'roaming_goat.png', 'https://www.roaminggoatcoffee.com/Default.asp', 5, 4, 'bean, non-dairy', 'https://www.zmenu.com/roaming-goat-coffee-columbus-online-menu/', 39.97970, -83.00425, true),
		('RIDEhome', 'ride_home.png', 'https://www.ride-home.com/', 1, 5, 'dessert', 'https://www.ride-home.com/', 40.08710, -83.01766, true)

		;

INSERT INTO address (address)
VALUES ('3058 W Broad St, Columbus, OH 43204'),
		('1031 N 4th St, Columbus, OH 43201'),
		('210 Thurman Ave, Columbus, OH 43206'),
		('160 W Main St G, New Albany, OH 43054'),
		('541 S. 3rd St, Columbus, OH 43215'),
		('745 N. High St, Columbus, OH 43215'),
		('53 N. High St, Columbus, OH 43215'),
		('702 S. High St, Columbus, OH 43206'),
		('774 S. High St, Columbus, OH 43206'),
		('3535 N. High Street, Columbus, OH 43214'),
		('1277 Grandview Ave, Columbus, OH 43212'),
		('1160 Goodale Boulevard, Columbus, OH 43212'),
		('3221 Hilliard Rome Rd, Hilliard, OH 43026'),
		('300 E Long St Columbus, OH 43215'),
		('2060 S High St, Columbus, OH 43207'),
		('1069 West Broad St. Columbus, OH 43222'),
		('849 N High St, Columbus, OH 43215'),
		('650 High St, Worthington, OH 43085')
		;

INSERT INTO hours (shop_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES (1, '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '8a-2p', '8a-2p'),
		(2, '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '8a-3p', '8a-3p'),
		(3, '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '8a-3p', '8a-3p'),
		(4, '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '8a-3p', '8a-3p'),
		(5, '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p', '7a-3p'),
		(6, '7a-7p', '7a-7p', '7a-7p', '7a-7p', '7a-8p', '8a-8p', '8a-7p'),
		(7, '7a-2p', '7a-2p', '7a-2p', '7a-2p', '7a-2p', '8a-2p', 'closed'),
		(8, 'closed', 'closed', '7a-1p', '7a-1p', '7a-1p', '8a-1p', '9a-1p'),
		(9, '7a-2p', '7a-2p', '7a-2p', '7a-2p', '7a-2p', '8a-3p', '8a-3p'),
		(10, '8a-7p', '8a-7p', '8a-7p', '8a-7p', '8a-7p', '8a-8p', '8a-7p'),
		(11, '6:30a-6p', '6:30a-6p', '6:30a-6p', '6:30a-6p', '6:30a-8p', '7a-8p', '8a-6p'),
		(12, 'closed', '7a-12p', '7a-12p', '7a-12p', '7a-12p', '8a-1p', '8a-1p'),
		(13, '7a-2p', '7a-2p', '7a-2p', '7a-2p', '7a-2p', '7a-2p', '7a-2p'),
		(14, '7a-6p', '7a-6p', '7a-6p', '7a-6p', '7a-6p', '8a-6p', '8a-6p'),
		(15, '8:30a-4:30p', '8:30a-4:30p', '8:30a-4:30p', '8:30a-4:30p', '8:30a-4:30p', '8:30a-4:30p', '8:30a-4:30p'),
		(16, '7:30p-1p', '7:30a-6p', '7:30a-6p', '7:30a-6p', '7:30a-6p', '8a-3p', '11a-3p'),
		(17, '7a-6p', '7a-6p', '7a-6p', '7a-6p', '7a-6p', '8a-6p', '8a-6p'),
		(18, '11a-6p', '11a-6p', '11a-6p', '11a-6p', '11a-6p', '11a-6p', '12p-5p')
		;

INSERT INTO shop_address (shop_id, address_id)
VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10), (11, 11), (12, 12), (13, 13), (14, 14), (15, 15), (16, 16), (17, 17),
(18, 18);

COMMIT TRANSACTION;
