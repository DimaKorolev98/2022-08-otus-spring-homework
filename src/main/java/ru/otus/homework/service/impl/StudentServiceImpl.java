package ru.otus.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.domain.Student;
import ru.otus.homework.service.StudentService;
import ru.otus.homework.service.UIService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private final UIService uiService;

    public StudentServiceImpl(UIService uiService) {
        this.uiService = uiService;
    }

    @Override
    public Student getStudent() {
        var firstName = uiService.input("enter a first name");
        var lastName = uiService.input("enter a last name");
        return new Student(firstName, lastName);
    }
}
