package ru.otus.homework.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.dao.AuthorRepository;
import ru.otus.homework.dao.AuthorService;
import ru.otus.homework.domain.Author;

import java.util.List;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findByName(String authorName) {

        return authorRepository.findByName(authorName);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }


    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> findAll() {
        return newArrayList(authorRepository.findAll());
    }
}
