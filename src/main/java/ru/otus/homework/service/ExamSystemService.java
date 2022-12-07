package ru.otus.homework.service;

import ru.otus.homework.domain.Question;

import java.util.List;

public interface ExamSystemService {
    List<Question> getQuestionsList(int i);

    String formatExamCase(Question question);
}
