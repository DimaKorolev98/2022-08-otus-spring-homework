package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.AuthorDao;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.dao.CommentDao;
import ru.otus.homework.dao.GenreDao;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;
import ru.otus.homework.domain.Genre;

import javax.transaction.Transactional;

@ShellComponent
public class BookCRUD {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final CommentDao commentDao;
    Author author;
    Genre genre;

    public BookCRUD(BookDao bookDao, AuthorDao authorDao, GenreDao genreDao, CommentDao commentDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.commentDao = commentDao;
    }

    @ShellMethod
    public void findAll() {
        System.out.println(bookDao.getAll());
    }

    @ShellMethod
    @Transactional
    public void addBook(String title, String authorName, String genreName){
        Book book = new Book();
        book.setTitle(title);
        var author = authorDao.findByName(authorName);
        if (author == null) {
            author = authorDao.save(new Author(authorName));
        }
        book.setAuthor(author);

        var genre = genreDao.findByName(genreName);
        if(genre == null) {
            genre = genreDao.save(new Genre(genreName));
        }
        book.setGenre(genre);

        bookDao.save(book);
    }

    @ShellMethod
    @Transactional
    public void deleteBook(String title) {
        bookDao.delete(bookDao.findByName(title));
    }

//    @ShellMethod
//    @Transactional
//    public void deleteComment(String id){
//        commentDao.delete(commentDao.);
//    }


}
