package ru.otus.homework.dao;

import ru.otus.homework.domain.Author;

public interface AuthorDao  {
    Author findByName(String authorName);
}