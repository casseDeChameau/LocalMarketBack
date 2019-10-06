insert into Sellers(id, shop_name, lat, lng, url_photo) values (1, 'The Mug Store', 50.837670, 4.352490, 'https://source.unsplash.com/random/600x600/?shop');
insert into Sellers(id, shop_name, lat, lng, url_photo) values (2, 'Cat Empire', 50.844614, 4.345716, 'https://source.unsplash.com/random/600x600/?stall');
insert into Sellers(id, shop_name, lat, lng, url_photo) values (3, 'Bubble blue', 50.828413, 4.373384, 'https://source.unsplash.com/random/600x600/?boutique');

insert into Products(id, photo1, name, quantity, price, seller_id) values (1, 'https://source.unsplash.com/random/600x600/?mug', 'mug', 6, 12.99, 1);
insert into Products(id, photo1, name, quantity, price, seller_id) values (2, 'https://source.unsplash.com/random/601x601/?mug', 'mug2', 2, 12.99, 2);
insert into Products(id, photo1, name, quantity, price, seller_id) values (3, 'https://source.unsplash.com/random/602x602/?mug', 'mug3', 4, 12.99, 3);
insert into Products(id, photo1, name, quantity, price, seller_id) values (4, 'https://source.unsplash.com/random/600x600/?cup', 'mug4', 6, 12.99, 1);
insert into Products(id, photo1, name, quantity, price, seller_id) values (5,'https://source.unsplash.com/random/601x601/?cup', 'mug5', 6, 12.99, 2);

INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, PARSEDATETIME('01-01-2019', 'dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, PARSEDATETIME('01-01-2019','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, PARSEDATETIME('01-01-2019','dd-MM-yyyy'));



INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);


