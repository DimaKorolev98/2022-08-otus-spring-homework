package ru.otus.homework.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.homework.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByName(String genreName);
}
