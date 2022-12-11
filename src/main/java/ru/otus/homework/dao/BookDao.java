package ru.otus.homework.dao;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookDao {
     List<Book> findAll();
     Book insert(Book book);
     void update(Book book);
     void delete(long id);
     void setNewTitle(Book book);
     void setNewAuthor(Book book);
     void setNewGenre(Book book);
}
