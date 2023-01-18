package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Genre;

@ShellComponent
public class GenreCRUD {

    private final GenreDao genreDao;

    public GenreCRUD(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @ShellMethod
    public void findAllGenre() {
        System.out.println(genreDao.getAll().toString());
    }


    @ShellMethod
    public void addGenre(String genreName){
        genreDao.save(new Genre(genreName));
    }

    @ShellMethod
    public void deleteGenre(String gereName){
        genreDao.delete(genreDao.findByName(gereName));
    }
}
