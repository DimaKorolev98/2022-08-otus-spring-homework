package ru.otus.homework.dao;

import org.springframework.data.repository.CrudRepository;
import ru.otus.homework.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
