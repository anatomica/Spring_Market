DROP TABLE IF EXISTS Client CASCADE;
CREATE TABLE Client (id bigserial PRIMARY KEY, name VARCHAR(255));

DROP TABLE IF EXISTS OrderClient CASCADE;
CREATE TABLE OrderClient (id bigserial PRIMARY KEY, id_Client INT, id_Product INT);

drop table if exists Products cascade;
create table Products (id bigserial, title varchar(255), description varchar(5000), category INT, price int, primary key(id));
insert into Products
(title, description, category, price) values
('Cheese', 'Fresh cheese', 1, 320),
('Milk', 'Fresh milk', 2, 80),
('Apples', 'Fresh apples', 3, 80),
('Bread', 'Fresh bread', 1, 30),
('A1', '', 2, 1),
('A2', '', 3, 2),
('A3', '', 1, 3),
('A4', '', 2, 4),
('A5', '', 3, 5),
('A6', '', 1, 6),
('A7', '', 2, 7),
('A8', '', 3, 8),
('A9', '', 1, 9),
('A10', '', 2, 10),
('A11', '', 3, 11),
('A12', '', 1, 12),
('A13', '', 2, 13),
('A14', '', 3, 14),
('A15', '', 1, 15),
('A16', '', 2, 16),
('A17', '', 3, 17),
('A18', '', 1, 18),
('A19', '', 2, 19),
('A20', '', 3, 20);
