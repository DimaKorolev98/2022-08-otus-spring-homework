package ru.otus.homework.dao;

import ru.otus.homework.domain.Comment;

public interface CommentService extends GenericDomainCrud<Long, Comment> {
    void deleteAll();
}
