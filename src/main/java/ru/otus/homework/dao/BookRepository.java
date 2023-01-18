package ru.otus.homework.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.homework.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
}
