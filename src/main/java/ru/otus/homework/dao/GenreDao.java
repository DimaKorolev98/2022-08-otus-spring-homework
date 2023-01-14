package ru.otus.homework.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class GenreDao implements LibDao<Genre> {

    @PersistenceContext
    private final EntityManager entityManager;



    public GenreDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public Genre save(Genre genre) {


        if (Objects.isNull(genre.getId())) {

            entityManager.persist(genre);
        } else {
            entityManager.merge(genre);
        }
        return genre;

    }

    @Override
    public void delete(long id) {
        var q= entityManager.createQuery("delete from Genre g where g.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Genre> getAll() {
        return entityManager.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public Genre findByName(String genreName) {

        var query = entityManager.createQuery("select g from Genre g where g.name = :genreName", Genre.class);
        query.setParameter("genreName", genreName);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
