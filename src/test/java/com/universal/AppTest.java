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


    //
    @Test
    public void testGetCountries() {
        List<Country> countries = app.getCountries();
        assertNotNull(countries);
        System.out.println("Get Country Function's output is not null");
        }

    @Test
    public void testGetCountriesInAfrica() {
        List<Country> africanCountries = app.getCountriesInAfrica();
        assertNotNull(africanCountries);
        System.out.println("Get Country In Africa Function's output is not null");
       }

    @Test
    public void testGetCountriesInCentralAfrica() {
        List<Country> centralAfricanCountries = app.getCountriesInCentralAfrica();
        assertNotNull(centralAfricanCountries);
        System.out.println("Get Country In Central Africa Function's output is not null");
    }
//
//    @Test
//    void displayisNull() {
//        List<Country> countries = new ArrayList<>();
//        app.displayCountriesOrderedByPopulation(countries);
//    }

    @Test
    public void testGetCitiesOrderbyPopulation() {
        List<City> cityWorld = app.getCitiesOrderedByPopulation();
        assertNotNull(cityWorld);
        System.out.println("Get Cities ordered by population Function's output is not null");
    }

    @Test
    public void testGetCitiesbyContinentOrderbyPopulation() {
        List<City> cityContinent = app.getCitiesByContinentOrderedByPopulation();
        assertNotNull(cityContinent);
        System.out.println("Get Cities by Continent Function's output is not null");

    }

    @Test
    public void testGetCitiesbyRegionOrderbyPopulation() {
        List<City> cityRegion = app.getCitiesByRegionOrderedByPopulation();
        assertNotNull(cityRegion);
        System.out.println("Get Cities by Region Function's output is not null");
        }

    @Test
    public void testGetCitiesinCountryOrderbyPopulation() {
        List<City> cityCountry = app.getCitiesInCountryOrderedByPopulation();
        assertNotNull(cityCountry);
        System.out.println("Get Cities in Country Function's output is not null");
        }

    @Test
    public void testGetCitiesinDistinct() {
        List<City> cityDiscrict = app.getCitiesInDistrict();
        assertNotNull(cityDiscrict);
        System.out.println("Get Cities in Distinct Function's output is not null");
    }

    @Test
    public void testGetAllCapitalCitiesbyPopulation() {
        List<City> CapitalCities = app.getAllCapitalCitiesByPopulation();
        assertNotNull(CapitalCities);
        System.out.println("Get all Capital Cities by Population Function's output is not null");
    }

    @Test
    public void testCapitalinContinent() {
        List<City> CapitalContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(CapitalContinent);
        System.out.println("Get Capital Cities by Continent Function's output is not null");
    }

    @Test
    public void testCapitalinRegion() {
        List<City> CapitalRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(CapitalRegion);
        System.out.println("Get Capital Cities by Region Function's output is not null");
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
    void displayCountriesorderbyPopulation()
    {
        List<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setCode("CMR");
        country.setName("Cameroon");
        country.setContinent("Africa");
        country.setRegion("Central Africa");
        country.setPopulation(15085000);
        countries.add(country);
        app.displayCountriesOrderedByPopulation(countries);
    }

    @Test
    void displayCountries()
    {
        List<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.setCode("GAB");
        country.setName("Gabon");
        country.setContinent("Africa");
        country.setRegion("Central Africa");
        country.setPopulation(1226000);
        country.setCapital("902");
        countries.add(country);
        app.displayCountries(countries);
    }
}
