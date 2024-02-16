/**
 * This is the java class for unit testing for each report.
 * */
package com.universal;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

    //check if the output is null or not
    @Test
    public void testGetCountries() {
        List<Country> countries = app.getCountries();
        assertNotNull(countries);
        System.out.println("Get Country Function's output is not null");
        }

    // check if the countries in the world is Empty or not

    @Test
    public void testGetCountryisEmpty() {
        List<Country> EmptyCountries= app.getCountries();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCountries);
        assertFalse(EmptyCountries.isEmpty());
        System.out.println("Countries in World is not Empty");
    }

    @Test
    public void testGetCountriesInAsia() {
        List<Country> asianCountries = app.getCountriesInAsia();
        assertNotNull(asianCountries);
        System.out.println("Get Country In Asia Function's output is not null");
    }

    @Test
    public void testGetCountryInAsiaIsEmpty() {
        List<Country> EmptyCountriesAsia= app.getCountriesInAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCountriesAsia);
        assertFalse(EmptyCountriesAsia.isEmpty());
        System.out.println("Countries in Asia is not Empty");
    }

    @Test
    public void testGetCountriesInSouthEastAsia() {
        List<Country> SouthEastAsiaCountries = app.getCountriesInSouthEastAsia();
        assertNotNull(SouthEastAsiaCountries);
        System.out.println("Get Country In South East Asia Function's output is not null");
    }

    @Test
    public void testGetCountryInSouthEastAsiaIsEmpty() {
        List<Country> EmptyCountriesSouthEastAsia= app.getCountriesInAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCountriesSouthEastAsia);
        assertFalse(EmptyCountriesSouthEastAsia.isEmpty());
        System.out.println("Countries in SouthEast Asia is not Empty");
    }
    @Test
    public void testGetCitiesOrderByPopulation() {
        List<City> cityWorld = app.getCitiesOrderedByPopulation();
        assertNotNull(cityWorld);
        System.out.println("Get Cities ordered by population Function's output is not null");
    }

    @Test
    public void testGetCitiesIsEmpty() {
        List<City> EmptyCities= app.getCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCities);
        assertFalse(EmptyCities.isEmpty());
        System.out.println("Cities in World is not empty");
    }

    @Test
    public void testGetCitiesByContinentOrderByPopulation() {
        List<City> cityContinent = app.getCitiesByContinentOrderedByPopulation();
        assertNotNull(cityContinent);
        System.out.println("Get Cities by Continent Function's output is not null");

    }

    @Test
    public void testGetCitiesByContinentIsEmpty() {
        List<City> EmptyCitiesByContinent= app.getCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByContinent);
        assertFalse(EmptyCitiesByContinent.isEmpty());
        System.out.println("Cities in Continent is not empty");
    }

    @Test
    public void testGetCitiesByRegionOrderByPopulation() {
        List<City> cityRegion = app.getCitiesByRegionOrderedByPopulation();
        assertNotNull(cityRegion);
        System.out.println("Get Cities by Region Function's output is not null");
        }

    @Test
    public void testGetCitiesByRegionIsEmpty() {
        List<City> EmptyCitiesByRegion= app.getCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByRegion);
        assertFalse(EmptyCitiesByRegion.isEmpty());
        System.out.println("Cities in Region is not empty");
    }

    @Test
    public void testGetCitiesInCountryOrderByPopulation() {
        List<City> cityCountry = app.getCitiesInCountryOrderedByPopulation();
        assertNotNull(cityCountry);
        System.out.println("Get Cities in Country Function's output is not null");
    }

    @Test
    public void testGetCitiesByCountryIsEmpty() {
        List<City> EmptyCitiesByCountry= app.getCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByCountry);
        assertFalse(EmptyCitiesByCountry.isEmpty());
        System.out.println("Cities in Country is not empty");
    }

    @Test
    public void testGetCitiesInDistinct() {
        List<City> cityDiscrict = app.getCitiesInDistrict();
        assertNotNull(cityDiscrict);
        System.out.println("Get Cities in Distinct Function's output is not null");
    }

    @Test
    public void testGetCitiesByDistrictIsEmpty() {
        List<City> EmptyCitiesByDistrict= app.getCitiesInDistrict();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByDistrict);
        assertFalse(EmptyCitiesByDistrict.isEmpty());
        System.out.println("Cities in District is not empty");
    }

    @Test
    public void testGetAllCapitalCitiesByPopulation() {
        List<City> CapitalCities = app.getAllCapitalCitiesByPopulation();
        assertNotNull(CapitalCities);
        System.out.println("Get all Capital Cities by Population Function's output is not null");
    }

    @Test
    public void testGetCapitalCitiesIsEmpty() {
        List<City> EmptyCapitalCities = app.getAllCapitalCitiesByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCities);
        assertFalse(EmptyCapitalCities.isEmpty());
        System.out.println("Capital Cities in World is not empty");
    }

    @Test
    public void testCapitalInContinent() {
        List<City> CapitalContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(CapitalContinent);
        System.out.println("Get Capital Cities by Continent Function's output is not null");
    }

    @Test
    public void testGetCapitalCitiesInContinentIsEmpty() {
        List<City> EmptyCapitalCitiesIncontinent = app.getCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCitiesIncontinent);
        assertFalse(EmptyCapitalCitiesIncontinent.isEmpty());
        System.out.println("Capital Cities in Continent is not empty");
    }

    @Test
    public void testCapitalInRegion() {
        List<City> CapitalRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(CapitalRegion);
        System.out.println("Get Capital Cities by Region Function's output is not null");
    }

    @Test
    public void testGetCapitalCitiesInRegionIsEmpty() {
        List<City> EmptyCapitalCitiesInRegion = app.getCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCitiesInRegion);
        assertFalse(EmptyCapitalCitiesInRegion.isEmpty());
        System.out.println("Capital Cities in Region is not empty");
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
        country.setCode("GAB");
        country.setName("Gabon");
        country.setContinent("Africa");
        country.setRegion("Central Africa");
        country.setPopulation(Long.valueOf(1226000));
        country.setCapital("902");
        countries.add(country);
        app.displayCountries(countries);
    }


    @Test
    public void testReportCountryIsEmpty() {
        // Prepare test data
        ArrayList<Country> emptyList = new ArrayList<>();
        // Call the method
        app.displayCountries(emptyList);
    }

    //check if the countries in the world contain null value or not
    @Test
    void printSalariesTestContainsNull()
    {
        ArrayList<Country> countriesContainNull = new ArrayList<>();
        countriesContainNull.add(null);
        app.displayCountries(countriesContainNull);
    }

    @Test
    void testDisplayAllQuery() {
        // Call display all query
        app.displayAllQuery();
        // Assert that each array list is null
        assertNotNull(app.getAllCapitalCitiesByPopulation());
    }
}