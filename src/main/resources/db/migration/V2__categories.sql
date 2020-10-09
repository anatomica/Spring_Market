DROP TABLE IF EXISTS Categories CASCADE;
CREATE TABLE Categories (id bigserial PRIMARY KEY, id_category INT, name VARCHAR(255), foreign key (id_category) references public.products (id));
INSERT INTO Categories
(id_category, name) values
(1, 'Категория 1'),
(2, 'Категория 2'),
(3, 'Категория 3');

-- drop table if exists categories cascade;
-- create table categories (id bigserial, name varchar(255), primary key(id));
-- insert into categories
-- (name) values
-- ('Категория 1'),
-- ('Категория 2'),
-- ('Категория 3');
--
-- drop table if exists products_categories cascade;
-- create table products_categories (product_id bigint not null, category_id bigint not null, primary key(product_id, category_id),
-- foreign key (product_id) references products(id), foreign key (category_id) references categories(id));
-- insert into products_categories (product_id, category_id) values (1, 1), (2, 1), (3, 2), (4, 3);