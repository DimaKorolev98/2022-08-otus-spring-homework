package ru.otus.homework.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.AppConfig;
import ru.otus.homework.domain.ExamReport;
import ru.otus.homework.service.ExamSystemService;
import ru.otus.homework.service.ExaminationService;
import ru.otus.homework.service.StudentService;
import ru.otus.homework.service.UIService;

@Service("examinationService")
public class ExaminationServiceImpl implements ExaminationService {


    private static final int MAX_ANSWER = 4;
    private static final int EXAM_ANSWER_COUNT = 3;


    private final ExamSystemService examSystemService;
    private final UIService uiService;
    private final StudentService studentService;
    private final String reportPattern;

    public ExaminationServiceImpl(ExamSystemService examSystemService, UIService uiService, StudentService studentService, MessageSource messageSource,
                                  AppConfig appConfiguration) {
        this.examSystemService = examSystemService;
        this.uiService = uiService;
        this.studentService = studentService;

        reportPattern = messageSource.getMessage("report.pattern",null, null, appConfiguration.getLocale());
    }

    @Override
    public void takeExam() {
        var student = studentService.getStudent();

        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }

        var answerList = examSystemService.getQuestionsList(EXAM_ANSWER_COUNT);
        var examReport = new ExamReport(student, reportPattern);
        answerList.forEach(
                q -> {
                    var enteredValue = uiService.input(examSystemService.formatExamCase(q));
                    var numAns = 0;
                    try {
                        numAns = Integer.parseInt(enteredValue);
                    } catch (NumberFormatException ex) {
                    }

                    if (numAns > 0 && numAns < MAX_ANSWER && numAns == q.getRightAnswer()) {
                        examReport.incrementRight();
                    } else {
                        examReport.incrementWrong();
                    }
                }
        );
        uiService.output(String.format(examReport.formatReport()));
    }
}
