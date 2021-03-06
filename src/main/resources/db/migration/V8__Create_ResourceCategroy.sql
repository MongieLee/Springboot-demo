create table resource_categroy
(
    id       int primary key auto_increment,
    name     varchar(20),
    sequence int default 0,
    created_at   dateTime,
    updated_at  datetime,
    UNIQUE (name)
)ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;
