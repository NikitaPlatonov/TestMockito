package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    GeoServiceImpl geoService;

    @BeforeEach
    void init(){
        geoService = Mockito.spy(GeoServiceImpl.class);
    }

    @Test
    void byIp_Russia() {
        Country expectedCountry = Country.RUSSIA;
        String MOSCOW_IP = "172.0.32.11";
        assertSame(geoService.byIp(MOSCOW_IP).getCountry(), expectedCountry);
    }
    @Test
    void byIp_USA() {
        Country expectedCountry = Country.USA;
        String NEW_YORK_IP = "96.44.183.149";
        assertSame(geoService.byIp(NEW_YORK_IP).getCountry(), expectedCountry);
    }
}