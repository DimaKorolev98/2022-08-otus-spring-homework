package ru.otus.homework.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataReaderImpl implements DataReader {

    private String fileName;

    @Value("${questions.fileName}")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<String> readData() {

        var questionsDataList = new ArrayList<String>();

        try {
            var inputStreamReader = new InputStreamReader(
                    new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream()
            );
            var reader = new BufferedReader(inputStreamReader);
            String line;

            int rowCount = 0;

            while ((line = reader.readLine()) != null) {
                rowCount += 1;
                if (rowCount == 1) {
                    continue;
                }
                questionsDataList.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionsDataList;
    }
}
