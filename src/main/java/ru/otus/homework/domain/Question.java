package ru.otus.homework.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Question {

    private int id;
    private String question;
    private int rightAnswer;
    private List<String> answers;

    public Question() {
        answers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    @Override
    public String toString() {
        return (
                MessageFormat.format(
                        "Question'{'id={0}, question=''{1}'', rightAnswer={2}, answers={3}'}'",
                        id,
                        question,
                        rightAnswer,
                        answers
                )
        );
    }
}
