package ru.otus.homework.shell;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.homework.service.LocaleService;

@ShellComponent
public class LocaleChangeCommand {

    private final LocaleService localeService;
    public LocaleChangeCommand(LocaleService localeService) {
        this.localeService = localeService;
    }

    @ShellMethod("set locale for session")
    void defineLocale(@ShellOption String localeCode) {
        localeService.defineLocale(Locale.forLanguageTag(localeCode));
        System.out.println(localeService.getLocaleForSession());
    }
}
