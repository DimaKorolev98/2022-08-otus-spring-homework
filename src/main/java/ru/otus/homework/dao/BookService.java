package ru.otus.homework.dao;

import ru.otus.homework.domain.Book;

public interface BookService extends GenericDomainCrud<Long, Book> {
    void deleteAll();
    Book findByTitle(String title);
}
