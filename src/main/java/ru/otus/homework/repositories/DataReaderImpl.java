package ru.otus.homework.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.otus.homework.config.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataReaderImpl implements DataReader {

    private final AppConfig appConfig;

    public DataReaderImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public List<String> readData() {

        var questionsDataList = new ArrayList<String>();

        try {
            var inputStreamReader = new InputStreamReader(
                    new ClassPathResource(appConfig.getDataPath(), this.getClass().getClassLoader()).getInputStream()
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
