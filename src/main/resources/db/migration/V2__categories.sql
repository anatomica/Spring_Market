DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories (id bigserial PRIMARY KEY, idCategory INT, nameCategory VARCHAR(255));

insert into Categories
(idCategory, nameCategory) values
(1, 'Category 1'),
(2, 'Category 2'),
(3, 'Category 3');