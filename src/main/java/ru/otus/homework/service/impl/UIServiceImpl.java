package ru.otus.homework.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework.config.AppConfig;
import ru.otus.homework.service.LocaleService;
import ru.otus.homework.service.UIService;

import java.util.Locale;
import java.util.Scanner;

@Service("uiService")
public class UIServiceImpl implements UIService {

    private final MessageSource messageSource;
    private final LocaleService localeService;

    public UIServiceImpl(MessageSource messageSource, LocaleService localeService) {
        this.messageSource = messageSource;
        this.localeService = localeService;
    }

    @Override
    public String input(String greeting) {
        var localeMsg = messageSource.getMessage(greeting, null, greeting, localeService.getLocaleForSession());

        Scanner scan = new Scanner(System.in);
        System.out.println(localeMsg);
        return scan.nextLine();
    }

    @Override
    public void output(String data) {
        System.out.println(data);
    }
}