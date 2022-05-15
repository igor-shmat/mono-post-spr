create table if not exists mono_post.users
(
    pkey            int8 GENERATED ALWAYS AS identity ( INCREMENT 1 START 10000001 MINVALUE 10000001 MAXVALUE 99999999 CACHE 1 ),
    PRIMARY key (pkey),
    first_name      varchar(30)         not null,
    second_name     varchar(30)         not null,
    patronymic_name varchar(30),
    phone_number    varchar(15) unique  not null,
    email           varchar(100) unique not null
)
;

create table if not exists mono_post.offices
(
    pkey        int8 GENERATED ALWAYS AS identity ( INCREMENT 1 START 10001 MINVALUE 10001 MAXVALUE 99999 CACHE 1 ),
    PRIMARY KEY (pkey),
    address     varchar(250) unique not null,
    description text
)
;

create table if not exists mono_post.parcels
(
    pkey                     int8 GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 100000001 MINVALUE 100000001 MAXVALUE 999999999 CACHE 1 ),
    PRIMARY KEY (pkey),
    user_pkey                int8,
    foreign key (user_pkey) references mono_post.users (pkey),
    sender_office_pkey       int8,
    foreign key (sender_office_pkey) references mono_post.offices (pkey),
    receiver_office_pkey     int8,
    foreign key (receiver_office_pkey) references mono_post.offices (pkey),
    receiver_phone_number    varchar(15) not null,
    receiver_first_name      varchar(30) not null,
    receiver_second_name     varchar(30) not null,
    receiver_patronymic_name varchar(30),
    parcel_status            varchar(20) not null,
    create_date              timestamp   not null,
    update_date_status       timestamp   not null
)
;

create table if not exists mono_post.notifications
(
    pkey                int8 GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 100000001 MINVALUE 100000001 MAXVALUE 999999999 CACHE 1 ),
    PRIMARY KEY (pkey),
    parcel_pkey         int8,
    foreign key (parcel_pkey) references mono_post.parcels (pkey),
    notification_status varchar(20) not null,
    texts               varchar(300)
)
;