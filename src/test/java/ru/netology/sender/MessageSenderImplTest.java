package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    LocalizationServiceImpl localizationService;
    GeoServiceImpl geoService;
    MessageSenderImpl messageSender;

    @BeforeEach
    void init() {
        geoService = Mockito.spy(GeoServiceImpl.class);
        localizationService = Mockito.spy(LocalizationServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void send_Russian_Message() {
        //TODO поведение теста
        String MOSCOW_IP = "172.0.32.11";
        Location location = new Location("Moscow", Country.RUSSIA, "random", 1);
        Mockito.when(geoService.byIp(MOSCOW_IP)).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Добро пожаловать");
        String expectMessage = "Добро пожаловать";
        // TODO исполнение теста
        Assertions.assertEquals(expectMessage, localizationService.locale(location.getCountry()));
        Mockito.verify(localizationService, Mockito.only()).locale(location.getCountry());
    }
    @Test
    void send_USA_Message() {
        String NEW_YORK_IP = "96.44.183.149";
        Location location = new Location("New York", Country.USA, "random", 1);
        Mockito.when(geoService.byIp(NEW_YORK_IP)).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Welcome");
        String expectMessage = "Welcome";
        Assertions.assertEquals(expectMessage, localizationService.locale(location.getCountry()));
        Mockito.verify(localizationService, Mockito.only()).locale(location.getCountry());
    }
}


