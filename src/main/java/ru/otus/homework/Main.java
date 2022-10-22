package ru.otus.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework.dao.ExamRead;
import ru.otus.homework.dao.ExamReadImpl;
import ru.otus.homework.domain.Question;
import ru.otus.homework.service.ExamContentPrinter;
import ru.otus.homework.service.ExamContentPrinterImpl;

public class Main {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        ExamRead examRead = context.getBean("examReaderImpl", ExamReadImpl.class);
        ExamContentPrinter examContentPrinter = context.getBean("examPrinterImpl", ExamContentPrinterImpl.class);
        examContentPrinter.printExamContent(examRead.getQuestion());
    }
}
