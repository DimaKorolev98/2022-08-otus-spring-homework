package ru.otus.homework.service;

import java.util.Locale;

public interface LocaleService {
    void defineLocale(Locale locale);

    Locale getLocaleForSession();
}
