package ru.otus.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.config.AppConfig;
import ru.otus.homework.service.LocaleService;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {

    private Locale locale;

    public LocaleServiceImpl(AppConfig configuration) {
        this.locale = configuration.getLocale();
    }

    @Override
    public void defineLocale(Locale newLocale) {
        this.locale = newLocale;
    }

    @Override
    public Locale getLocaleForSession() {
        return locale;
    }
}
