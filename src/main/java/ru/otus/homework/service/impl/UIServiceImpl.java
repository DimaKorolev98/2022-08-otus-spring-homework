package ru.otus.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.service.UIService;

import java.util.Scanner;

@Service("uiService")
public class UIServiceImpl implements UIService {

    @Override
    public String input(String greeting) {
        Scanner scan = new Scanner(System.in);
        System.out.println(greeting);
        return scan.nextLine();
    }

    @Override
    public void output(String data) {
        System.out.println(data);
    }
}