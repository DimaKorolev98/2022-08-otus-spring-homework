drop table if exists comments;
create table comments
(
    id   long primary key auto_increment,
    text varchar(1000),
    book_id long
);

drop table if exists genres;
create table genres
(
    id   long primary key auto_increment,
    name  varchar(255) unique
);

drop table if exists authors;
create table authors
(
    id   long PRIMARY KEY AUTO_INCREMENT ,
    name  varchar(255) unique
);

drop table if exists books;
create table books
(
    id      long primary key auto_increment,
    title   varchar(255),
    genre_id long,
    author_id long
);

alter table books
    add constraint fk_bookGenre
        foreign key (genre_id) references genres(Id);

alter table books
    add constraint fk_bookAuthor
        foreign key (author_id) references authors(Id);

alter table comments
    add constraint fk_commentBook
        foreign key (book_id) references books(Id) ON DELETE CASCADE;
