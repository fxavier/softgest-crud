CREATE TABLE unity(
unity_id BIGSERIAL NOT NULL,
designation VARCHAR(100) NOT NULL,
PRIMARY KEY(unity_id)
);

CREATE TABLE supplier(
supplier_id BIGSERIAL NOT NULL,
supplier_name VARCHAR(100) NOT NULL,
supplier_website VARCHAR(255) NOT NULL,
supplier_email VARCHAR(255) NOT NULL,
supplier_phone VARCHAR(100) NOT NULL,
supplier_cell VARCHAR(100) NOT NULL,
supplier_address TEXT,
credit_limit NUMERIC(19, 2),
balance NUMERIC(19, 2),
account VARCHAR(100),
observation TEXT,
country_id BIGINT,
PRIMARY KEY(supplier_id),
CONSTRAINT fk_suplier_country
  FOREIGN KEY(country_id) REFERENCES country(country_id)
);

CREATE TABLE product_supplier(
product_id BIGINT NOT NULL,
supplier_id BIGINT NOT NULL,
PRIMARY KEY(product_id, supplier_id),
CONSTRAINT fk_product_supplier_product
  FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_supplier_product_suplier
  FOREIGN KEY(supplier_id) REFERENCES supplier(supplier_id)
);

ALTER TABLE product
ADD COLUMN product_code VARCHAR(100),
ADD COLUMN bar_code VARCHAR(500),
ADD COLUMN batch_number VARCHAR(255),
ADD COLUMN expiration_date DATE,
ADD COLUMN unity_id BIGINT NOT NULL,
ADD CONSTRAINT fk_product_unity
  FOREIGN KEY(unity_id) REFERENCES unity(unity_id);
