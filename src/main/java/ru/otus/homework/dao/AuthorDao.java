package ru.otus.homework.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository

public class AuthorDao implements LibDao<Author> {


    @PersistenceContext
    private final EntityManager entityManager;

    public AuthorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Author save(Author author) {

        if (author.getId() == null) {
            entityManager.persist(author);
        } else {
            entityManager.merge(author);
        }
        return author;
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from Author a where a.id = :id").executeUpdate();

    }

    @Override
    public List<Author> getAll() {
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();

    }


    @Override
    public Author findByName(String authorName) {

        var query = entityManager.createQuery("select a from Author a where a.name = :authorName", Author.class);
        query.setParameter("authorName", authorName);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}

