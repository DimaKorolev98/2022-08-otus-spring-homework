CREATE TABLE Authors
(
    id   LONG AUTO_INCREMENT PRIMARY KEY,
    authorName VARCHAR(250) NOT NULL
);
create unique index if not exists author_name_u1
    on Authors (authorName);
CREATE TABLE Genres
(
    id   LONG AUTO_INCREMENT PRIMARY KEY,
    genreName VARCHAR(250) not null
);
create unique index if not exists genre_name_u1
    on Genres (genreName);
CREATE TABLE Books
(
    id       LONG AUTO_INCREMENT PRIMARY KEY,
    title    VARCHAR(250) NOT NULL,
    authorID long references Authors (id),
    genreId  long references Genres (id)
);

