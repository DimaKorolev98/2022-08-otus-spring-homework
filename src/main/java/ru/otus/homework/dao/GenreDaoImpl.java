package ru.otus.homework.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GenreDaoImpl implements GenreDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GenreDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre findByName(String genreName) {
        try {
            var rezg = jdbcTemplate.queryForObject("select id, genreName from Genres where genreName = :genreName",
                    new MapSqlParameterSource("genreName", genreName),
                    new GenreRowMapper()
            );
            return rezg;
        } catch (EmptyResultDataAccessException exception) {
            System.out.println("There is NO Genre with such NAME in DB. Firstly insert AUTHOR in DB by data.sql");
            return null;
        }
    }

    private static class GenreRowMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("genreName");
            return new Genre(id, name);
        }
    }
}
