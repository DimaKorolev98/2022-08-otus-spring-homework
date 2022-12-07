package ru.otus.homework.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework.service.ExaminationService;

@ShellComponent
public class TakeExamCommand {

    private final ExaminationService examinationService;

    public TakeExamCommand(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @ShellMethod("Take exam and report generate")
    public void takeExam() {
        examinationService.takeExam();
    }
}