package ru.otus.homework.service;

import ru.otus.homework.dao.ExamRead;
import ru.otus.homework.domain.Question;

import java.util.List;

public class ExamContentPrinterImpl implements ExamContentPrinter{

    @Override
    public void printExamContent(List<Question> examContent) {
        examContent.forEach(ec-> System.out.println(ec.toString()));
    }
}
