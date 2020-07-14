DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories (id bigserial PRIMARY KEY, id_category INT, name VARCHAR(255), foreign key (id_category) references products.products (id));
INSERT INTO Categories
(id_category, name) values
(1, 'Категория 1'),
(2, 'Категория 2'),
(3, 'Категория 3');
