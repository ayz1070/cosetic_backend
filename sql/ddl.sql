drop table if exists member CASCADE;
create table member
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);



CREATE TABLE shipping
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id        BIGINT       NOT NULL,
    tracking_number VARCHAR(255) NOT NULL,
    carrier         VARCHAR(255) NOT NULL
);