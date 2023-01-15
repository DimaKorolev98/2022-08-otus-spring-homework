package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.AuthorService;
import ru.otus.homework.dao.BookService;
import ru.otus.homework.dao.CommentService;
import ru.otus.homework.dao.GenreService;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;

import javax.transaction.Transactional;

@ShellComponent
public class BookCRUD {
    private final BookService bookDao;
    private final AuthorService authorDao;
    private final GenreService genreDao;
    Author author;
    Genre genre;

    public BookCRUD(BookService bookDao, AuthorService authorDao, GenreService genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @ShellMethod
    public void findAll() {
        System.out.println(bookDao.findAll());
    }

    @ShellMethod
    public void addAuthor(String authorName) {
        authorDao.save(new Author(authorName));
    }

    @ShellMethod
    @Transactional
    public void addBook(String title, String authorName, String genreName) {
        Book book = new Book();
        book.setTitle(title);
        var author = authorDao.findByName(authorName);
        if (author == null) {
            author = authorDao.save(new Author(authorName));
        }
        book.setAuthor(author);

        var genre = genreDao.findByName(genreName);
        if (genre == null) {
            genre = genreDao.save(new Genre(genreName));
        }
        book.setGenre(genre);

        bookDao.save(book);
    }

//    @ShellMethod
//    public void addComment(String title, String text) {
//        Comment comment = new Comment();
//        comment.setText(text);
//        var book = bookDao.findByTitle(title);
//        if (book == null) {
//            System.out.println("Нет такой книги: " + title);
//        } else {
//            comment.setBook(book);
//            commentDao.save(comment);
//        }
//    }

    @ShellMethod
    public void findAllAuthors() {
        System.out.println(authorDao.findAll().toString());
    }

    @ShellMethod
    public void findAllGenre() {
        System.out.println(genreDao.findAll().toString());
    }

    @ShellMethod
    public void delete(String title) {
        bookDao.delete(bookDao.findByTitle(title));
    }

}
