package ru.otus.homework.domain;

public class ExamReport {

    private final Student student;
    private final String reportPattern;
    private int rightAnswerCount;
    private int wrongAnswerCount;

       public ExamReport(Student student, String reportPattern) {
        this.student = student;
        this.rightAnswerCount = 0;
        this.reportPattern = reportPattern;
    }

    public void incrementRight() {
        rightAnswerCount++;
    }

    public void incrementWrong() {
        wrongAnswerCount++;
    }

    public String formatReport() {
        return String.format(
                reportPattern,
                student.getFirstName(),
                student.getLastName(),
                rightAnswerCount,
                wrongAnswerCount
        );
    }
}