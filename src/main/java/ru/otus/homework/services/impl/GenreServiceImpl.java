package ru.otus.homework.services.impl;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.GenreRepository;
import ru.otus.homework.dao.GenreService;
import ru.otus.homework.domain.Genre;

import java.util.List;

@Service("genreService")
public class GenreServiceImpl implements GenreService {


    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public List<Genre> findAll() {
        return Lists.newArrayList(genreRepository.findAll());
    }

    @Override
    public Genre findByName(String genreName) {
        return genreRepository.findByName(genreName);
    }
}
