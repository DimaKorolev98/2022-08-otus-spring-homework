package ru.otus.homework.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.dao.BookDao;
import ru.otus.homework.dao.CommentDao;
import ru.otus.homework.domain.Comment;

import javax.transaction.Transactional;


@ShellComponent
public class CommentCRUD {

    private final CommentDao commentDao;
    private final BookDao bookDao;

    public CommentCRUD(CommentDao commentDao, BookDao bookDao) {
        this.commentDao = commentDao;
        this.bookDao = bookDao;
    }

    @ShellMethod
    public void findAllComments(){
        System.out.println(commentDao.getAll().toString());
    }

    @ShellMethod
    @Transactional
    public void addComment(String title , String text){
        Comment comment = new Comment();
        comment.setText(text);
        var book = bookDao.findByName(title);
        if(book == null){
            System.out.println("Нет такой книги: " + title);
        } else {
            comment.setBook(book);
            commentDao.save(comment);
        }
    }
}
