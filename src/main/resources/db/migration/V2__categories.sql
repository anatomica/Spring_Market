DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories (id bigserial PRIMARY KEY, id_Category INT, name_Category VARCHAR(255));

insert into Categories
(id_Category, name_Category) values
(1, 'Category 1'),
(2, 'Category 2'),
(3, 'Category 3');