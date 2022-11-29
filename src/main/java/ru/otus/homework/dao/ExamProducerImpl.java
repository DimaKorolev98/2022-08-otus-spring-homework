package ru.otus.homework.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.homework.domain.Question;
import ru.otus.homework.repositories.DataReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class ExamProducerImpl implements ExamProducer {

    private final DataReader dataReader;

    public ExamProducerImpl(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public List<Question> getQuestion() {
        var examContent = new ArrayList<Question>();
        var questionsDataList = dataReader.readData();
        questionsDataList.forEach(
                str -> {
                    var question = parseQuestionsString(str);
                    examContent.add(question);
                }
        );

        return examContent;
    }

    private Question parseQuestionsString(String line){
        var question = new Question();
        var scanner = new Scanner(line);


        int index = 0 ;
                scanner.useDelimiter(",");
                while (scanner.hasNext()){

                     while (scanner.hasNext()){
                         String data = scanner.next();
                         if(index == 0){
                             question.setId(Integer.parseInt(data));
                         }
                         else if (index == 1){
                             question.setQuestion(data);
                         }
                         else if (index == 2){
                             question.setRightAnswer(Integer.parseInt(data));
                         }
                         else {
                             question.getAnswers().add(data);
                         }
                         index++;
                     }
                     index = 0;
                }
                return question;
    }
}
