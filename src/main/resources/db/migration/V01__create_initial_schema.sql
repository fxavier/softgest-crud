CREATE TABLE category(
category_id BIGSERIAL NOT NULL,
name VARCHAR(100) NOT NULL,
PRIMARY KEY(category_id)
);

CREATE TABLE subcategory(
subcategory_id BIGSERIAL NOT NULL,
name VARCHAR(100) NOT NULL,
category_id BIGINT NOT NULL,
PRIMARY KEY(subcategory_id),
CONSTRAINT fk_subcategory_category
  FOREIGN KEY(category_id) REFERENCES category(category_id)
);

CREATE TABLE country(
country_id BIGSERIAL,
country_name VARCHAR(255) NOT NULL,
code CHAR(2) DEFAULT NULL,
PRIMARY KEY(country_id)
);


CREATE TABLE currency(
currency_id BIGSERIAL NOT NULL,
currency_name VARCHAR(100),
currency_code CHAR(3),
PRIMARY KEY(currency_id)
);

CREATE TABLE brand(
brand_id BIGSERIAL NOT NULL,
brand_name VARCHAR(255) NOT NULL,
PRIMARY KEY(brand_id)
);

CREATE TABLE product(
product_id BIGSERIAL NOT NULL,
product_name VARCHAR(250) NOT NULL,
product_description TEXT,
purchase_price NUMERIC(19, 2),
other_expenses NUMERIC(19, 2),
sell_price NUMERIC(19, 2) NOT NULL DEFAULT 0,
vat NUMERIC(19, 2) NOT NULL DEFAULT 0,
sell_price_vat NUMERIC(19, 2) NOT NULL,
profit NUMERIC(19, 2) NOT NULL,
quantity BIGINT NOT NULL,
min_stock BIGINT NOT NULL,
max_stock BIGINT NOT NULL,
subcategory_id BIGINT,
PRIMARY KEY(product_id),
CONSTRAINT fk_product_subcategory
  FOREIGN KEY(subcategory_id) REFERENCES subcategory(subcategory_id)
);

CREATE TABLE store(
store_id BIGSERIAL NOT NULL,
store_name VARCHAR(255) NOT NULL,
phone_number VARCHAR(100),
cell_number VARCHAR(100),
address TEXT,
PRIMARY KEY(store_id)
);

CREATE TABLE customer(
customer_id BIGSERIAL NOT NULL,
customer_name VARCHAR(255) NOT NULL,
phone_number VARCHAR(100),
cell_number VARCHAR(100),
email VARCHAR(255),
account VARCHAR(100),
credit_limit NUMERIC(19, 2) DEFAULT 0,
credit NUMERIC(19, 2) DEFAULT 0,
active BOOLEAN DEFAULT true,
PRIMARY KEY(customer_id)
);

CREATE TABLE bank(
bank_id BIGSERIAL NOT NULL,
bank_name VARCHAR(255) NOT NULL,
PRIMARY KEY(bank_id)
);

