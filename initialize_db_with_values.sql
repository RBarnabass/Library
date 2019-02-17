create table author
(
  id        int auto_increment
    primary key,
  full_name varchar(255) not null
);

create table publisher
(
  id   int auto_increment
    primary key,
  name varchar(255) not null
);

create table book
(
  id           int auto_increment
    primary key,
  name         varchar(255) not null,
  publisher_id int          not null,
  publish_year year         not null,
  constraint book_publisher_id_fk
  foreign key (publisher_id) references publisher (id)
    on update cascade
    on delete cascade
);

create index book_publisher_id_fk
  on book (publisher_id);

create table book_authors
(
  id         int auto_increment
    primary key,
  book_id    int        not null,
  author_id  int        not null,
  is_primary tinyint(1) not null,
  constraint book_by_authors_book_id_fk
  foreign key (book_id) references book (id)
    on update cascade
    on delete cascade,
  constraint book_by_authors_author_id_fk
  foreign key (author_id) references author (id)
    on update cascade
    on delete cascade
);

create index book_by_authors_author_id_fk
  on book_authors (author_id);

create index book_by_authors_book_id_fk
  on book_authors (book_id);

create table copy
(
  id      int auto_increment
    primary key,
  book_id int not null,
  constraint copy_book_id_fk
  foreign key (book_id) references book (id)
    on update cascade
    on delete cascade
);

create index copy_book_id_fk
  on copy (book_id);

create table role
(
  id   int auto_increment
    primary key,
  type varchar(30) not null
);

create table user
(
  id                int auto_increment
    primary key,
  full_name         varchar(255) not null,
  birth_date        date         not null,
  registration_date date         not null
);

create table credential
(
  id       int auto_increment
    primary key,
  login    varchar(100) not null,
  password varchar(255) not null,
  role_id  int          not null,
  user_id  int          not null,
  constraint credential_login_uindex
  unique (login),
  constraint credential_role_id_fk
  foreign key (role_id) references role (id),
  constraint credential_user_id_fk
  foreign key (user_id) references user (id)
);

create index credential_role_id_fk
  on credential (role_id);

create index credential_user_id_fk
  on credential (user_id);

create table time_period
(
  id          int auto_increment
    primary key,
  copy_id     int  not null,
  user_id     int  not null,
  start_date  date not null,
  end_date    date null,
  return_date date null,
  constraint time_period_copy_id_fk
  foreign key (copy_id) references copy (id)
    on update cascade
    on delete cascade,
  constraint time_period_user_id_fk
  foreign key (user_id) references user (id)
    on update cascade
    on delete cascade
);

create index time_period_copy_id_fk
  on time_period (copy_id);

create index time_period_user_id_fk
  on time_period (user_id);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

INSERT INTO library.user (id, full_name, birth_date, registration_date) VALUES (1, 'Emmett Brown', '1999-10-04', '2019-02-17');
INSERT INTO library.user (id, full_name, birth_date, registration_date) VALUES (2, 'Mety Slav', '1997-10-04', '2019-01-17');

INSERT INTO library.role (id, type) VALUES (1, 'user');
INSERT INTO library.role (id, type) VALUES (2, 'admin');

INSERT INTO library.credential (id, login, password, role_id, user_id) VALUES (1, 'md1guy', 'password', 1, 1);
INSERT INTO library.credential (id, login, password, role_id, user_id) VALUES (2, 'metyslav', 'userPassword', 2, 2);

INSERT INTO library.publisher (id, name) VALUES (1, 'Cool Publisher');

INSERT INTO library.book (id, name, publisher_id, publish_year) VALUES (1, 'Great book', 1, 2007);
INSERT INTO library.book (id, name, publisher_id, publish_year) VALUES (2, 'Maybe a little worse book', 1, 1998);

INSERT INTO library.copy (id, book_id) VALUES (1, 1);
INSERT INTO library.copy (id, book_id) VALUES (2, 1);
INSERT INTO library.copy (id, book_id) VALUES (3, 2);

INSERT INTO library.author (id, full_name) VALUES (1, 'John Doe');
INSERT INTO library.author (id, full_name) VALUES (2, 'Hello Kitty');

INSERT INTO library.book_authors (id, book_id, author_id, is_primary) VALUES (1, 1, 1, 1);
INSERT INTO library.book_authors (id, book_id, author_id, is_primary) VALUES (2, 2, 1, 0);
INSERT INTO library.book_authors (id, book_id, author_id, is_primary) VALUES (3, 2, 2, 1);

INSERT INTO library.time_period (id, copy_id, user_id, start_date, end_date, return_date) VALUES (3, 1, 2, '2016-05-10', '2016-06-15', '2016-06-05');
INSERT INTO library.time_period (id, copy_id, user_id, start_date, end_date, return_date) VALUES (4, 3, 2, '2019-02-17', '2019-02-17', null);
INSERT INTO library.time_period (id, copy_id, user_id, start_date, end_date, return_date) VALUES (5, 2, 1, '2019-01-05', '2019-02-05', null);