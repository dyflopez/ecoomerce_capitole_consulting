INSERT INTO product (product_id,name)
VALUES (35455,'RIPPED DENIM JACKET DRESS');

INSERT INTO price (start_date, end_date, price_list_id, product_id, priority, price, curr_id, brand_id)
VALUES ('2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 1, 1),
       ('2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1,  25.45, 1, 1),
       ('2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1,  30.50, 1, 1),
       ('2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 1, 1)
;