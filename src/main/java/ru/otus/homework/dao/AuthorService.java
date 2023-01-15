package ru.otus.homework.dao;

import ru.otus.homework.domain.Author;

public interface AuthorService extends GenericDomainCrud<Long, Author>{
    Author findByName(String authorName);
}
