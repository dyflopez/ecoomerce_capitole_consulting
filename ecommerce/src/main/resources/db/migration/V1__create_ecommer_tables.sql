CREATE TABLE price_list
(
    price_list_id BIGINT        NOT NULL AUTO_INCREMENT,
    price         DECIMAL(6, 2) NOT NULL,
    PRIMARY KEY (price_list_id)
);

CREATE TABLE product
(
    product_id BIGINT        NOT NULL AUTO_INCREMENT,
    name       VARCHAR(1000) NOT NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE curr
(
    curr_id   BIGINT NOT NULL AUTO_INCREMENT,
    curr_type VARCHAR(3),
    PRIMARY KEY (curr_id)
);

CREATE TABLE brand
(
    brand_id BIGINT        NOT NULL AUTO_INCREMENT,
    company  VARCHAR(1000) NOT NULL,
    PRIMARY KEY (brand_id)
);

CREATE TABLE price
(
    price_id      BIGINT        NOT NULL AUTO_INCREMENT,
    start_date    DATETIME,
    end_date      DATETIME,
    price_list_id BIGINT        NOT NULL,
    product_id    BIGINT        NOT NULL,
    priority      INT           NOT NULL,
    price         DECIMAL(6, 2) NOT NULL,
    curr_id       BIGINT        NOT NULL,
    brand_id      BIGINT        NOT NULL,
    PRIMARY KEY (price_id),
    CONSTRAINT price_list_fk FOREIGN KEY (price_list_id) REFERENCES price_list (price_list_id),
    CONSTRAINT curr_fk FOREIGN KEY (curr_id) REFERENCES curr (curr_id),
    CONSTRAINT brand_fk FOREIGN KEY (brand_id) REFERENCES brand (brand_id)
);