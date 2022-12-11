insert into Authors (authorName)
values ('Erich Maria Remarque');
insert into Authors (authorName)
values ('John Ronald Reuel Tolkien');
insert into Authors (authorName)
values ('Robert Martin');
insert into Authors (authorName)
values ('Pushkin');
insert into Authors (authorName)
values ('Tolstoy');
insert into Authors (authorName)
values ('Mick Bulgakov');

insert into Genres (genreName)
values ('Novel');
insert into Genres (genreName)
values ('Fantasy');
insert into Genres (genreName)
values ('Computer science');

insert into Books (authorId, title, genreId)
values ((select id from Authors where authorName = 'Erich Maria Remarque'), 'Three comrades', (select id from Genres where genreName = 'Novel'));
insert into Books (authorId, title, genreId)
values ((select id from Authors where authorName = 'John Ronald Reuel Tolkien'), 'Lord Of The Rings', (select id from Genres where genreName = 'Fantasy'));
insert into Books (authorId, title, genreId)
values ((select id from Authors where authorName = 'Robert Martin'), 'Clean code', (select id from Genres where genreName = 'Fantasy'));


