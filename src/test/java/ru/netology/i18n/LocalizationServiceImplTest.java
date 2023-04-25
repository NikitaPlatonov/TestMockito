package ru.netology.i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService;
    @BeforeEach
    void init(){
        localizationService = Mockito.spy(LocalizationServiceImpl.class);
    }

    @Test
    void locale_for_Russia() {
        String expectedMessage = "Добро пожаловать";
        assertSame(expectedMessage, localizationService.locale(Country.RUSSIA));
    }

    @Test
    void locale_for_USA() {
        String expectedMessage = "Welcome";
        assertSame(expectedMessage, localizationService.locale(Country.USA));
    }
}