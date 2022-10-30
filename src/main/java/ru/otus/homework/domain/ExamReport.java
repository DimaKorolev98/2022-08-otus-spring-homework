package ru.otus.homework.domain;

public class ExamReport {

    private final Student student;
    private int rightAnswerCount;
    private int wrongAnswerCount;

       public ExamReport(Student student) {
        this.student = student;
        this.rightAnswerCount = 0;
    }

    public void incrementRight() {
        rightAnswerCount++;
    }

    public void incrementWrong() {
        wrongAnswerCount++;
    }

    public String formatReport() {
        return String.format(
                "FirstName: %s LastName: %s Right Answers: %d Wrong Answers: %d",
                student.getFirstName(),
                student.getLastName(),
                rightAnswerCount,
                wrongAnswerCount
        );
    }
}