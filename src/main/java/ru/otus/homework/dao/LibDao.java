package ru.otus.homework.dao;

import java.util.List;

public interface LibDao<T> {
   T save (T domain);

   void delete(long id);

    List<T> getAll();

    T findByName(String name);
}
