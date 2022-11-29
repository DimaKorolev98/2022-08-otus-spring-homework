package ru.otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.homework.service.ExaminationService;
import ru.otus.homework.service.StudentService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        var examinationService = ctx.getBean("examinationService", ExaminationService.class);

        var studentService = ctx.getBean("studentService", StudentService.class);
        examinationService.takeExam();
    }
}
