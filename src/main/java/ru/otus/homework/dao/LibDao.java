package ru.otus.homework.dao;

import ru.otus.homework.domain.Author;

import java.util.List;

public interface LibDao<T> {
   T save (T domain);

   void delete(T domain);

    List<T> getAll();

    T findByName(String name);
}
