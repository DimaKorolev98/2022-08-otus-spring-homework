package ru.otus.homework.services.impl;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;
import ru.otus.homework.dao.BookRepository;
import ru.otus.homework.dao.BookService;
import ru.otus.homework.domain.Book;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());

    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title) ;
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}

