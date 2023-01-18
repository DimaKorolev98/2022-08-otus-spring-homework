package ru.otus.homework.dao;

import ru.otus.homework.domain.Genre;

public interface GenreService extends GenericDomainCrud<Long, Genre> {
    Genre findByName(String genreName);
}
