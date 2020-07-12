DROP TABLE IF EXISTS Client CASCADE;
CREATE TABLE Client (id bigserial PRIMARY KEY, name VARCHAR(255));

DROP TABLE IF EXISTS OrderClient CASCADE;
CREATE TABLE OrderClient (id bigserial PRIMARY KEY, idClient INT, idProduct INT);

drop table if exists Products cascade;
create table Products (id bigserial, title varchar(255), description varchar(5000), price int, category int, primary key(id));
insert into Products
(title, description, price, category) values
('Cheese', 'Fresh cheese', 320, 1),
('Milk', 'Fresh milk', 80, 2),
('Apples', 'Fresh apples', 80, 3),
('Bread', 'Fresh bread', 30, 1),
('A1', '', 1, 2),
('A2', '', 2, 3),
('A3', '', 3, 1),
('A4', '', 4, 2),
('A5', '', 5, 3),
('A6', '', 6, 1),
('A7', '', 7, 2),
('A8', '', 8, 3),
('A9', '', 9, 1),
('A10', '', 10, 2),
('A11', '', 11, 3),
('A12', '', 12, 1),
('A13', '', 13, 2),
('A14', '', 14, 3),
('A15', '', 15, 1),
('A16', '', 16, 2),
('A17', '', 17, 3),
('A18', '', 18, 1),
('A19', '', 19, 2),
('A20', '', 20, 3);