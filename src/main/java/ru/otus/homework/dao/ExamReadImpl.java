package ru.otus.homework.dao;

import org.springframework.core.io.ClassPathResource;
import ru.otus.homework.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamReadImpl implements ExamRead{

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Question> getQuestion() {
        var examContent = new ArrayList<Question>();
        try{
            var isr = new InputStreamReader(new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream());
            var reader = new BufferedReader(isr);
            String questionLine;

            int rowCount = 0;

            while ((questionLine = reader.readLine()) != null){
                rowCount+=1;
                if (rowCount == 1){
                    continue;
                }

                var sc = new Scanner(questionLine);

                int index = 0 ;
                sc.useDelimiter(",");
                while (sc.hasNext()){
                     var examQuestion = new Question();

                     while (sc.hasNext()){
                         String data = sc.next();
                         if(index == 0){
                             examQuestion.setId(Integer.parseInt(data));
                         }
                         else if (index == 1){
                             examQuestion.setQuestion(data);
                         }
                         else if (index == 2){
                             examQuestion.setRightAnswer(Integer.parseInt(data));
                         }
                         else {
                             examQuestion.getAnswers().add(data);
                         }
                         index++;
                     }
                     index = 0;
                     examContent.add(examQuestion);
                }
            }
                reader.close();

            return examContent;
        } catch (IOException e){
            System.out.println(String.format("Ошибка чтения файла %", fileName));
        }
        return null;
    }
}
