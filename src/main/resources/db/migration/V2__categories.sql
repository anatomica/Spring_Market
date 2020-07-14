DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO Categories
(name) values
('Категория 1'),
('Категория 2'),
('Категория 3');

DROP TABLE IF EXISTS products_categories CASCADE;
CREATE TABLE products_categories (product_id bigserial, category_id bigserial, foreign key (product_id) references products.products (id), foreign key (category_id) references categories (id));
insert into products_categories (product_id, category_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(3, 1),
(4, 2),
(5, 3),
(5, 1),
(6, 2),
(7, 3),
(8, 1),
(9, 2),
(10, 3),
(11, 1),
(12, 2),
(13, 3),
(14, 1),
(15, 2),
(16, 3),
(17, 1),
(20, 2);
