package com.universal;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    private static final String DB_LOCATION = "localhost:33060";
    private static final int DB_DELAY = 30000;
    private static App app;

    @BeforeAll
    public static void setUpBeforeClass() {
        app = new App();
        app.connect(DB_LOCATION, DB_DELAY);
    }

    @AfterAll
    public static void tearDown() {
        app.disconnect();
    }

    @Test
    public void testGetCountries() {
        List<Country> countries = app.getCountries();
        assertNotNull(countries);
        // Add more assertions based on the expected behavior of the method
        // For example, check if the list is not empty, or check specific values.
    }

    @Test
    public void testGetCountriesInAfrica() {
        List<Country> africanCountries = app.getCountriesInAfrica();
        assertNotNull(africanCountries);
        // Add more assertions based on the expected behavior of the method
        // For example, check if the list is not empty, or check specific values.
    }

    @Test
    public void testGetCountriesInCentralAfrica() {
        List<Country> centralAfricanCountries = app.getCountriesInCentralAfrica();
        assertNotNull(centralAfricanCountries);
        // Add more assertions based on the expected behavior of the method
        // For example, check if the list is not empty, or check specific values.
    }

    @Test
    void displayCountries()
    {
        List<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setCode("CMR");
        country.setName("Cameroon");
        country.setContinent("Africa");
        country.setRegion("Central Africa");
        country.setPopulation(15085000);
        app.displayCountriesOrderedByPopulation(countries);
    }

    @Test
    void displayisNull() {
        List<Country> countries = new ArrayList<>();
        app.displayCountriesOrderedByPopulation(countries);
    }


}
