CREATE TABLE unity(
unity_id BIGSERIAL NOT NULL,
designation VARCHAR(100) NOT NULL,
PRIMARY KEY(unity_id)
);


CREATE TABLE suplier(
suplier_id BIGSERIAL NOT NULL,
suplier_name VARCHAR(100) NOT NULL,
suplier_website VARCHAR(255) NOT NULL,
suplier_email VARCHAR(255) NOT NULL,
suplier_phone VARCHAR(100) NOT NULL,
suplier_cell VARCHAR(100) NOT NULL,
suplier_address TEXT,
credit_limit NUMERIC(19, 2),
balance NUMERIC(19, 2),
account VARCHAR(100),
observation TEXT,
country_id BIGINT,
PRIMARY KEY(suplier_id),
CONSTRAINT fk_suplier_country
  FOREIGN KEY(country_id) REFERENCES country(country_id)
);

ALTER TABLE product
ADD COLUMN product_code VARCHAR(100),
ADD COLUMN bar_code VARCHAR(500),
ADD COLUMN expiration_date DATE,
ADD COLUMN unity_id BIGINT NOT NULL,
ADD CONSTRAINT fk_product_unity
  FOREIGN KEY(unity_id) REFERENCES unity(unity_id);
