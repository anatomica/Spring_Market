DROP TABLE IF EXISTS Client CASCADE;
CREATE TABLE Client (id bigserial PRIMARY KEY, name VARCHAR(255));

DROP TABLE IF EXISTS OrderClient CASCADE;
CREATE TABLE OrderClient (id bigserial PRIMARY KEY, id_Client INT, id_Product INT);

drop table if exists Products cascade;
create table Products (id bigserial, title varchar(255), description varchar(5000), price int, primary key(id));
insert into Products
(title, description, price) values
('Cheese', 'Fresh cheese', 320),
('Milk', 'Fresh milk', 80),
('Apples', 'Fresh apples', 80),
('Bread', 'Fresh bread', 30),
('A1', '', 1),
('A2', '', 2),
('A3', '', 3),
('A4', '', 4),
('A5', '', 5),
('A6', '', 6),
('A7', '', 7),
('A8', '', 8),
('A9', '', 9),
('A10', '', 10),
('A11', '', 11),
('A12', '', 12),
('A13', '', 13),
('A14', '', 14),
('A15', '', 15),
('A16', '', 16),
('A17', '', 17),
('A18', '', 18),
('A19', '', 19),
('A20', '', 20);
