INSERT INTO price_list (price)
VALUES (10.10),
       (5.50),
       (30.40),
       (200),
       (1740);

INSERT INTO product (name)
VALUES ('CONTRAST PRINT KNIT T-SHIRT'),
       ('TEXTURED KNIT T-SHIRT'),
       ('SNOOPY PEANUTS™ GRAFFITI T-SHIRT'),
       ('(250 ML) CHAMOMILE & SANDALWOOD HAND AND BODY LOTION'),
       ('S23 Ultra')
;


INSERT INTO curr (curr_type)
VALUES ('EUR'),
       ('AUS'),
       ('COP');

INSERT INTO brand (company)
VALUES ('ZARA'),
       ('FALABELLA'),
       ('JB HI FI');


INSERT INTO price (start_date, end_date, price_list_id, product_id, priority, price, curr_id, brand_id)
VALUES ('2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 1, 1, 35.50, 1, 1),
 ('2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 1, 0, 200.50, 1, 1),
 ('2023-04-01 00:00:00', '2023-04-28 23:59:59', 5, 5, 0, 2000, 2, 3)
;