/**
 * This is the java class for unit testing for each report.
 * */

package com.universal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.AfterAll;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
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
    public void testTop7Countries() {
        List<Country> Top7PopulatedCountries= app.getTopSevenCountriesInWorldByPopulation();
        assertNotNull(Top7PopulatedCountries);
        System.out.println("Top 7 countries in the World Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CountriesisEmpty() {
        List<Country> topCountries= app.getTopSevenCountriesInWorldByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountries);
        assertFalse(topCountries.isEmpty());
        System.out.println("Top 7 countries in the World Report is not empty");
    }


    @Test
    public void testTop7CountriesInAsia() {
        List<Country> Top7PopulatedCountriesInAsia= app.getTopSevenCountriesInAsiaByPopulation();
        assertNotNull(Top7PopulatedCountriesInAsia);
        System.out.println("Top 7 Countries in Asia Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CountriesAsiaIsEmpty() {
        List<Country> topCountriesAsia = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesAsia);
        assertFalse(topCountriesAsia.isEmpty());
        System.out.println("Top 7 countries in Asia Report is not empty");
    }

    @Test
    public void testTop7CountriesInSouthEastAsia() {
        List<Country> Top7CountriesInSouthEastAsia= app.getTopSevenCountriesInSouthEastAsia();
        assertNotNull(Top7CountriesInSouthEastAsia);
        System.out.println("Top 7 Countries in South East Asia Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CountriesSouthEastAsiaIsEmpty() {
        List<Country> topCountriesSouthEastAsia = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesSouthEastAsia);
        assertFalse(topCountriesSouthEastAsia.isEmpty());
        System.out.println("Top 7 countries in South East Asia Report is not empty");
    }

    @Test
    public void testTop7CitiesInWorld() {
        List<City> Top7CitiesInWorld= app.getTopSevenCitiesInWorldOrderedByPopulation();
        assertNotNull(Top7CitiesInWorld);
        System.out.println("Top 7 Cities in World Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CitiesInWorldIsEmpty() {
        List<City> topCitiesInWorld = app.getTopSevenCitiesInWorldOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInWorld);
        assertFalse(topCitiesInWorld.isEmpty());
        System.out.println("Top 7 cities in world Report is not empty");
    }

    @Test
    public void testTop7CitiesInContinent() {
        List<City> Top7CitiesInContinent= app.getTopSevenCitiesInContinentOrderedByPopulation();
        assertNotNull(Top7CitiesInContinent);
        System.out.println("Top 7 Cities in Continent Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CitiesInContinentIsEmpty() {
        List<City> topCitiesInContinent = app.getTopSevenCitiesInContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInContinent);
        assertFalse(topCitiesInContinent.isEmpty());
        System.out.println("Top 7 cities in continent Report is not empty");
    }


    @Test
    public void testTop7CitiesInRegion() {
        List<City> Top7CitiesInRegion= app.getTopSevenCitiesInRegionOrderedByPopulation();
        assertNotNull(Top7CitiesInRegion);
        System.out.println("Top 7 Cities in Region Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CitiesInRegionIsEmpty() {
        List<City> topCitiesInRegion = app.getTopSevenCitiesInRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInRegion);
        assertFalse(topCitiesInRegion.isEmpty());
        System.out.println("Top 7 cities in region Report is not empty");
    }

    @Test
    public void testTop7CitiesInCountry() {
        List<City> Top7CitiesInCountry= app.getTopSevenCitiesInCountryOrderedByPopulation();
        assertNotNull(Top7CitiesInCountry);
        System.out.println("Top 7 Cities in Region Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CitiesInCountryIsEmpty() {
        List<City> topCitiesInCountry = app.getTopSevenCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInCountry);
        assertFalse(topCitiesInCountry.isEmpty());
        System.out.println("Top 7 cities in country Report is not empty");
    }

    @Test
    public void testTop7CitiesInDistrict() {
        List<City> Top7CitiesInDistrict= app.getTopSevenCitiesInDistrictOrderedByPopulation();
        assertNotNull(Top7CitiesInDistrict);
        System.out.println("Top 7 Cities in District Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CitiesInDistrictIsEmpty() {
        List<City> topCitiesInDistrict = app.getTopSevenCitiesInDistrictOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInDistrict);
        assertFalse(topCitiesInDistrict.isEmpty());
        System.out.println("Top 7 cities in district Report is not empty");
    }

    @Test
    public void testTop7CapitalCitiesInWorld() {
        List<City> Top7CapitalCitiesInWorld= app.getTopSevenCapitalCitiesOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInWorld);
        System.out.println("Top 7 Capital Cities in World Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CapitalCitiesIsEmpty() {
        List<City> topCapitalCities = app.getTopSevenCapitalCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCities);
        assertFalse(topCapitalCities.isEmpty());
        System.out.println("Top 7 capital cities in world Report is not empty");
    }

    @Test
    public void testTop7CapitalCitiesInContinent() {
        List<City> Top7CapitalCitiesInContinent= app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInContinent);
        System.out.println("Top 7 Capital Cities in Continent Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CapitalCitiesInContinentIsEmpty() {
        List<City> topCapitalCitiesInContinent = app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesInContinent);
        assertFalse(topCapitalCitiesInContinent.isEmpty());
        System.out.println("Top 7 capital cities in continent Report is not empty");
    }

    @Test
    public void testTop7CapitalCitiesInRegion() {
        List<City> Top7CapitalCitiesInRegion= app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInRegion);
        System.out.println("Top 7 Capital Cities in Region Organized by largest to smallest is not null");
    }

    @Test
    public void testTop7CapitalCitiesInRegionIsEmpty() {
        List<City> topCapitalCitiesInRegion = app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesInRegion);
        assertFalse(topCapitalCitiesInRegion.isEmpty());
        System.out.println("Top 7 capital cities in Region Report is not empty");
    }

    @Test
    void displayCities()
    {
        List<City> city = new ArrayList<>();
        City cities = new City();
        cities.setCityName("Pathein");
        cities.setCountryOfCity("Myanmar");
        cities.setCityDistrict("Pathein District");
        cities.setCityPopulation(169773);
        city.add(cities);
        app.displayCities(city);
    }

    @Test
    void displayCapitalCities()
    {
        List<City> capitalcity = new ArrayList<>();
        City capitalcities = new City();
        capitalcities.setCityName("Pathien");
        capitalcities.setCountryCode("95");
        capitalcities.setCityPopulation(169773);
        capitalcity.add(capitalcities);
        app.displayCapitalCities(capitalcity);
    }

    @Test
    void displayCountries()
    {
        List<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setName("Gabon");
        country.setContinent("Africa");
        country.setRegion("Central Africa");
        country.setPopulation(Long.valueOf(1226000));
        country.setCapital("902");
        countries.add(country);
        app.displayCountries(countries);
    }


    @Test
    void testDisplayAllQuery() {
        // Call display all query
        app.displayAllQuery();
        // Assert that each array list is null
        assertNotNull(app.getTopSevenCountriesInWorldByPopulation());
    }

}

