package ru.otus.homework.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class AuthorDaoImpl implements AuthorDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author findByName(String authorName) {
        try {
            var rez = jdbcTemplate.queryForObject("Select id, authorName from Authors where authorName = :authorName",
                    new MapSqlParameterSource("authorName", authorName),
                    new AuthorRowMapper()
            );
            return rez;
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("There is NO Author with such NAME in DB. Firstly insert AUTHOR in DB by data.sql");
            return null;
        }
    }
    private static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("authorName");
            return new Author(id, name);
        }
    }
}
