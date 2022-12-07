package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework.dao.AuthorDao;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

@ShellComponent
public class BookCRUD {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    Book book = new Book();

    public BookCRUD(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @ShellMethod
    public void findAll() {
        System.out.println(bookDao.findAll().toString());
    }

    @ShellMethod
    public void delete(long id) {
        bookDao.delete(id);
    }
    @ShellMethod
    public void insert(String title, String author, String genre){
        book.setTitle(title);
        book.setAuthor(authorDao.findByName(author));
        book.setGenre(genreDao.findByName(genre));
        bookDao.insert(book);
    }

    @ShellMethod
    public void update (long id, String title, String author, String genre){
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(authorDao.findByName(author));
        book.setGenre(genreDao.findByName(genre));
        bookDao.update(book);
    }
    @ShellMethod
    public void newAuthor(long id, String authorName){
        book.setId(id);
        book.setAuthor(authorDao.findByName(authorName));
        bookDao.setNewAuthor(book);
    }
    @ShellMethod
    public void newTitle(long id, String title){
        book.setId(id);
        book.setTitle(title);
        bookDao.setNewTitle(book);
    }
    @ShellMethod
    public void newGenre(long id, String genreName){
        book.setId(id);
        book.setGenre(genreDao.findByName(genreName));
        bookDao.setNewGenre(book);
    }
}
