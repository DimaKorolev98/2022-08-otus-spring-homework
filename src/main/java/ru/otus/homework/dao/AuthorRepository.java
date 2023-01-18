package ru.otus.homework.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.homework.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String authorName);
}
