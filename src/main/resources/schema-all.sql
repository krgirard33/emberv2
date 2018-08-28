DROP TABLE ticket_list IF EXISTS;

CREATE TABLE ticket_list (
    id INTEGER NOT NULL AUTO_INCREMENT,
    ticket_num VARCHAR(12),
    buyer_name VARCHAR(30),
    buyer_email VARCHAR(30),
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    city VARCHAR(30),
    state VARCHAR(5),
    zip INT(10),
    country VARCHAR(25),
    type VARCHAR(5),
    );