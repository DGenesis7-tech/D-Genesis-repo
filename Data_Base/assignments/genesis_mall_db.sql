CREATE DATABASE e_commerce_db;
CREATE DATABASE genesis_mall_db;
USE genesis_mall_db;
CREATE TABLE genesis_users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone_nunber bigint
 ); 

CREATE TABLE genesis_products (
product_id SERIAL PRIMARY KEY,
product_name VARCHAR(100), 
product_price_$ bigint
); 

CREATE TABLE mall_orders ( 
order_id SERIAL PRIMARY KEY,
products VARCHAR(100),
prices_$ bigint
);

 
 