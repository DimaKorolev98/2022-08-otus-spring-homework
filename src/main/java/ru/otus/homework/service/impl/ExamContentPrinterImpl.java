package ru.otus.homework.service.impl;

import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.ExamContentPrinter;

import java.util.List;
@Component
public class ExamContentPrinterImpl implements ExamContentPrinter {

    @Override
    public void printExamContent(List<Question> examContent) {
        examContent.forEach(ec-> System.out.println(ec.toString()));
    }
}
