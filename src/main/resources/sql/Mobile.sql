use mybatis;

create table Mobile (
    id int(11) unsigned not null auto_increment comment 'id',
    os varchar(32) not null default '' comment 'os',
    brand varchar(32) not null default '' comment 'brand',
    model varchar(32) not null default '' comment 'model',
    price int(11) unsigned not null default 0 comment 'price',
    primary key (id),
    key (model)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Mobile';
