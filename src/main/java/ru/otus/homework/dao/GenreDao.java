package ru.otus.homework.dao;

import ru.otus.homework.domain.Genre;

public interface GenreDao {
    Genre findByName(String genreName);
}
