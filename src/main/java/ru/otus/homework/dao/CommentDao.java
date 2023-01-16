package ru.otus.homework.dao;

import org.springframework.stereotype.Repository;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class CommentDao implements LibDao<Comment> {

    @PersistenceContext
    private final EntityManager entityManager;

    public CommentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            entityManager.persist(comment);
        } else {
            entityManager.merge(comment);
        }
        return comment;
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from Comment c where c.id = :id").executeUpdate();
    }

    @Override
    public List<Comment> getAll() {
        return entityManager.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    @Override
    public Comment findByName(String name) {
        return null;
    }
}
