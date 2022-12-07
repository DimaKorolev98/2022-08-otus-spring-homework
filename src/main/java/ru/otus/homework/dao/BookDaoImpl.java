package ru.otus.homework.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.isNull;

@Repository

public class BookDaoImpl implements BookDao{
    private final NamedParameterJdbcTemplate jdbc;

    public BookDaoImpl(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Book> findAll() {
       return jdbc.query("select b.id, b.title, a.id as authorId, g.id as genreId, g.genreName as genre_name, a.authorName as author_name from Books b  JOIN Authors a on b.authorId = a.id  JOIN Genres g on b.genreId = g.id", new BookListResultSetExtractor());
    }

    @Override
    public Book insert(Book book) {
        var holder = new GeneratedKeyHolder();
        var parameters = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("author",book.getAuthor().getId())
                .addValue("genre", book.getGenre().getId());
    jdbc.update("insert into Books (title, authorId, genreId) values (:title,:author,:genre)", parameters, holder, new String[]{"id"});
    book.setId(holder.getKey().longValue());

    return book;
    }

    @Override
    public void update(Book book) {
        var parameters = new MapSqlParameterSource()
                .addValue("id",book.getId())
                .addValue("title", book.getTitle())
                .addValue("author", book.getAuthor().getId())
                .addValue("genre", book.getGenre().getId());
        jdbc.update("update Books set title = :title, authorId = :author, genreId = :genre where id = :id", parameters);
    }
    @Override
    public void setNewTitle(Book book) {
        var parameters = new MapSqlParameterSource()
                .addValue("id",book.getId())
                .addValue("title", book.getTitle());
        jdbc.update("update Books set title = :title where id = :id", parameters);
    }
    @Override
    public void setNewAuthor(Book book) {
        var parameters = new MapSqlParameterSource()
                .addValue("id",book.getId())
                .addValue("author", book.getAuthor().getId());
        jdbc.update("update Books set authorId = :author where id = :id", parameters);
    }
    @Override
    public void setNewGenre(Book book) {
        var parameters = new MapSqlParameterSource()
                .addValue("id",book.getId())
                .addValue("genre", book.getGenre().getId());
        jdbc.update("update Books set genreId = :genre where id = :id", parameters);
    }

    @Override
    public void delete(long id) {
        var parameters = new MapSqlParameterSource("id",id);
    jdbc.update("delete from Books where id = :id", parameters);
    }

    private static class BookListResultSetExtractor implements ResultSetExtractor<List<Book>> {

        @Override
        public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
            var books = new HashMap<Long, Book>();
            long bookId;

            while (rs.next()) {
                bookId = rs.getLong("id");
                Book book;
                if (books.containsKey(bookId)) {
                    book = books.get(bookId);
                } else {
                    book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setTitle(rs.getString("title"));
                    books.put(bookId, book);
                }
                var genreId = rs.getLong("genreId");
                if (!rs.wasNull()) {
                    var genre = new Genre(genreId, rs.getString("genre_name"));
                    book.setGenre(genre);
                }
                var authorId = rs.getLong("authorId");
                if (!rs.wasNull()) {
                    var author = new Author(authorId, rs.getString("author_name"));
                    book.setAuthor(author);
                }
            }
            return new ArrayList<Book>(books.values());
        }
    }
}
