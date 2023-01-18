package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.AuthorDao;
import ru.otus.homework.domain.Author;

import javax.transaction.Transactional;

@ShellComponent
public class AuthorCRUD {
    private final AuthorDao authorDao;

    public AuthorCRUD(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @ShellMethod
    @Transactional
    public void addAuthor(String authorName){
        authorDao.save(new Author(authorName));
    }

    @ShellMethod
    public void findAllAuthors() {
        System.out.println(authorDao.getAll().toString());
    }

    @ShellMethod
    public void findAllAuthorsWithBooks() {
        authorDao.getAllWithBooks().stream().map(x-> x.toString() + " Количество книг:" + x.getBooks().size())
                .forEach(System.out::println);
    }
    @ShellMethod
    @Transactional
    public void deleteAuthor(String authorName){
        authorDao.delete(authorDao.findByName(authorName));
    }

}
