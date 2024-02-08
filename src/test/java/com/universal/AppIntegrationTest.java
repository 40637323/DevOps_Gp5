package com.universal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    public void testGetCountriesInAfrica() {
        List<Country> africanCountries = app.getCountriesInAfrica();
        assertNotNull(africanCountries);
        System.out.println("Get Country In Africa Function's output is not null");
    }

}