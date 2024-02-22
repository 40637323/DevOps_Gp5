/**
 * This is the java class for unit testing for each report.
 * */
package com.universal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {

    //connecting to database
    private static final String DB_LOCATION = "localhost:33060";
    private static final int DB_DELAY = 30000;
    private static App app;


    // set up before making the testing
    @BeforeAll
    public static void setUpBeforeClass() {
        app = new App();
        // app.connect(DB_LOCATION, DB_DELAY);
    }

    // make the database disconnect after all the test are checked
//    @AfterAll
//    public static void tearDown() {
//        app.disconnect();
//    }

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

    // check if the countries in Asia is noll or not
    @Test
    public void testGetCountriesInAsia() {
        List<Country> asianCountries = app.getCountriesInAsia();
        assertNotNull(asianCountries);
        System.out.println("Get Country In Asia Function's output is not null");
    }

    //test if the country in Asia is Empty or not
    @Test
    public void testGetCountryInAsiaIsEmpty() {
        List<Country> EmptyCountriesAsia= app.getCountriesInAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCountriesAsia);
        assertFalse(EmptyCountriesAsia.isEmpty());
        System.out.println("Countries in Asia is not Empty");
    }

    // check if the countries in South East Asia is noll or not
    @Test
    public void testGetCountriesInSouthEastAsia() {
        List<Country> SouthEastAsiaCountries = app.getCountriesInSouthEastAsia();
        assertNotNull(SouthEastAsiaCountries);
        System.out.println("Get Country In South East Asia Function's output is not null");
    }


    //check if the country inSouth East Asia is Empty or not
    @Test
    public void testGetCountryInSouthEastAsiaIsEmpty() {
        List<Country> EmptyCountriesSouthEastAsia= app.getCountriesInAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCountriesSouthEastAsia);
        assertFalse(EmptyCountriesSouthEastAsia.isEmpty());
        System.out.println("Countries in SouthEast Asia is not Empty");
    }

    //check if the output is null or not
    @Test
    public void testGetCitiesOrderByPopulation() {
        List<City> cityWorld = app.getCitiesOrderedByPopulation();
        assertNotNull(cityWorld);
        System.out.println("Get Cities ordered by population Function's output is not null");
    }

    //Check the ger cities functions is empty or not
    @Test
    public void testGetCitiesIsEmpty() {
        List<City> EmptyCities= app.getCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCities);
        assertFalse(EmptyCities.isEmpty());
        System.out.println("Cities in World is not empty");
    }

    //check if the output is null or not
    @Test
    public void testGetCitiesByContinentOrderByPopulation() {
        List<City> cityContinent = app.getCitiesByContinentOrderedByPopulation();
        assertNotNull(cityContinent);
        System.out.println("Get Cities by Continent Function's output is not null");

    }

    //check the get cities by continent function is empty or not
    @Test
    public void testGetCitiesByContinentIsEmpty() {
        List<City> EmptyCitiesByContinent= app.getCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByContinent);
        assertFalse(EmptyCitiesByContinent.isEmpty());
        System.out.println("Cities in Continent is not empty");
    }

    //check the get cities by region order by population is null or not
    @Test
    public void testGetCitiesByRegionOrderByPopulation() {
        List<City> cityRegion = app.getCitiesByRegionOrderedByPopulation();
        assertNotNull(cityRegion);
        System.out.println("Get Cities by Region Function's output is not null");
    }

    //check the get cities by region order by population is empty or not
    @Test
    public void testGetCitiesByRegionIsEmpty() {
        List<City> EmptyCitiesByRegion= app.getCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByRegion);
        assertFalse(EmptyCitiesByRegion.isEmpty());
        System.out.println("Cities in Region is not empty");
    }

    //check the get cities in country order by population is null or not
    @Test
    public void testGetCitiesInCountryOrderByPopulation() {
        List<City> cityCountry = app.getCitiesInCountryOrderedByPopulation();
        assertNotNull(cityCountry);
        System.out.println("Get Cities in Country Function's output is not null");
    }

    //check the get cities in country order by population is empty or not
    @Test
    public void testGetCitiesByCountryIsEmpty() {
        List<City> EmptyCitiesByCountry= app.getCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByCountry);
        assertFalse(EmptyCitiesByCountry.isEmpty());
        System.out.println("Cities in Country is not empty");
    }

    //check the get cities in district order by population is null or not
    @Test
    public void testGetCitiesInDistinct() {
        List<City> cityDiscrict = app.getCitiesInDistrict();
        assertNotNull(cityDiscrict);
        System.out.println("Get Cities in Distinct Function's output is not null");
    }

    //check the get cities in district order by population is empty or not
    @Test
    public void testGetCitiesByDistrictIsEmpty() {
        List<City> EmptyCitiesByDistrict= app.getCitiesInDistrict();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCitiesByDistrict);
        assertFalse(EmptyCitiesByDistrict.isEmpty());
        System.out.println("Cities in District is not empty");
    }


    //check the get capital cities in world order by population is null or not
    @Test
    public void testGetAllCapitalCitiesByPopulation() {
        List<City> CapitalCities = app.getAllCapitalCitiesByPopulation();
        assertNotNull(CapitalCities);
        System.out.println("Get all Capital Cities by Population Function's output is not null");
    }

    //check the get capital cities in World order by population is empty or not
    @Test
    public void testGetCapitalCitiesIsEmpty() {
        List<City> EmptyCapitalCities = app.getAllCapitalCitiesByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCities);
        assertFalse(EmptyCapitalCities.isEmpty());
        System.out.println("Capital Cities in World is not empty");
    }

    //check the get capital cities in continent order by population is null or not
    @Test
    public void testCapitalInContinent() {
        List<City> CapitalContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(CapitalContinent);
        System.out.println("Get Capital Cities by Continent Function's output is not null");
    }

    //check the get capital cities in continent order by population is empty or not
    @Test
    public void testGetCapitalCitiesInContinentIsEmpty() {
        List<City> EmptyCapitalCitiesIncontinent = app.getCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCitiesIncontinent);
        assertFalse(EmptyCapitalCitiesIncontinent.isEmpty());
        System.out.println("Capital Cities in Continent is not empty");
    }

    //check the get capital cities in region order by population is null or not
    @Test
    public void testCapitalInRegion() {
        List<City> CapitalRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(CapitalRegion);
        System.out.println("Get Capital Cities by Region Function's output is not null");
    }

    //check the get capital cities in region order by population is empty or not
    @Test
    public void testGetCapitalCitiesInRegionIsEmpty() {
        List<City> EmptyCapitalCitiesInRegion = app.getCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(EmptyCapitalCitiesInRegion);
        assertFalse(EmptyCapitalCitiesInRegion.isEmpty());
        System.out.println("Capital Cities in Region is not empty");
    }

    //check the get top 7 countries is null or not
    @Test
    public void testTop7Countries() {
        List<Country> Top7PopulatedCountries= app.getTopSevenCountriesInWorldByPopulation();
        assertNotNull(Top7PopulatedCountries);
        System.out.println("Top 7 countries in the World Organized by largest to smallest is not null");
    }

    //check the get top 7 countries function is null or not
    @Test
    public void testTop7CountriesisEmpty() {
        List<Country> topCountries= app.getTopSevenCountriesInWorldByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountries);
        assertFalse(topCountries.isEmpty());
        System.out.println("Top 7 countries in the World Report is not empty");
    }

    //check the get top 7 countries in Asia is null or not
    @Test
    public void testTop7CountriesInAsia() {
        List<Country> Top7PopulatedCountriesInAsia= app.getTopSevenCountriesInAsiaByPopulation();
        assertNotNull(Top7PopulatedCountriesInAsia);
        System.out.println("Top 7 Countries in Asia Organized by largest to smallest is not null");
    }

    //check the get top 7 countries in Asia is empty or not
    @Test
    public void testTop7CountriesAsiaIsEmpty() {
        List<Country> topCountriesAsia = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesAsia);
        assertFalse(topCountriesAsia.isEmpty());
        System.out.println("Top 7 countries in Asia Report is not empty");
    }

    //check the get top 7 countries in South East Asia is null or not
    @Test
    public void testTop7CountriesInSouthEastAsia() {
        List<Country> Top7CountriesInSouthEastAsia= app.getTopSevenCountriesInSouthEastAsia();
        assertNotNull(Top7CountriesInSouthEastAsia);
        System.out.println("Top 7 Countries in South East Asia Organized by largest to smallest is not null");
    }

    //check the get top 7 countries in South East Asia is empty or not
    @Test
    public void testTop7CountriesSouthEastAsiaIsEmpty() {
        List<Country> topCountriesSouthEastAsia = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesSouthEastAsia);
        assertFalse(topCountriesSouthEastAsia.isEmpty());
        System.out.println("Top 7 countries in South East Asia Report is not empty");
    }

    //check the get top 7 cities is null or not
    @Test
    public void testTop7CitiesInWorld() {
        List<City> Top7CitiesInWorld= app.getTopSevenCitiesInWorldOrderedByPopulation();
        assertNotNull(Top7CitiesInWorld);
        System.out.println("Top 7 Cities in World Organized by largest to smallest is not null");
    }

    //check the get top 7 cities is empty or not
    @Test
    public void testTop7CitiesInWorldIsEmpty() {
        List<City> topCitiesInWorld = app.getTopSevenCitiesInWorldOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInWorld);
        assertFalse(topCitiesInWorld.isEmpty());
        System.out.println("Top 7 cities in world Report is not empty");
    }

    //check the get top 7 cities in continent is null or not
    @Test
    public void testTop7CitiesInContinent() {
        List<City> Top7CitiesInContinent= app.getTopSevenCitiesInContinentOrderedByPopulation();
        assertNotNull(Top7CitiesInContinent);
        System.out.println("Top 7 Cities in Continent Organized by largest to smallest is not null");
    }

    //check the get top 7 cities in continent is empty or not
    @Test
    public void testTop7CitiesInContinentIsEmpty() {
        List<City> topCitiesInContinent = app.getTopSevenCitiesInContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInContinent);
        assertFalse(topCitiesInContinent.isEmpty());
        System.out.println("Top 7 cities in continent Report is not empty");
    }

    //check the get top 7 cities in region is null or not
    @Test
    public void testTop7CitiesInRegion() {
        List<City> Top7CitiesInRegion= app.getTopSevenCitiesInRegionOrderedByPopulation();
        assertNotNull(Top7CitiesInRegion);
        System.out.println("Top 7 Cities in Region Organized by largest to smallest is not null");
    }

    //check the get top 7 cities in region is empty or not
    @Test
    public void testTop7CitiesInRegionIsEmpty() {
        List<City> topCitiesInRegion = app.getTopSevenCitiesInRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInRegion);
        assertFalse(topCitiesInRegion.isEmpty());
        System.out.println("Top 7 cities in region Report is not empty");
    }

    //check the get top 7 cities in country is null or not
    @Test
    public void testTop7CitiesInCountry() {
        List<City> Top7CitiesInCountry= app.getTopSevenCitiesInCountryOrderedByPopulation();
        assertNotNull(Top7CitiesInCountry);
        System.out.println("Top 7 Cities in Region Organized by largest to smallest is not null");
    }

    //check the get top 7 cities in country is empty or not
    @Test
    public void testTop7CitiesInCountryIsEmpty() {
        List<City> topCitiesInCountry = app.getTopSevenCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInCountry);
        assertFalse(topCitiesInCountry.isEmpty());
        System.out.println("Top 7 cities in country Report is not empty");
    }

    //check the get top 7 cities in district is null or not
    @Test
    public void testTop7CitiesInDistrict() {
        List<City> Top7CitiesInDistrict= app.getTopSevenCitiesInDistrictOrderedByPopulation();
        assertNotNull(Top7CitiesInDistrict);
        System.out.println("Top 7 Cities in District Organized by largest to smallest is not null");
    }

    //check the get top 7 cities in district is empty or not
    @Test
    public void testTop7CitiesInDistrictIsEmpty() {
        List<City> topCitiesInDistrict = app.getTopSevenCitiesInDistrictOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesInDistrict);
        assertFalse(topCitiesInDistrict.isEmpty());
        System.out.println("Top 7 cities in district Report is not empty");
    }

    //check the get top 7 capital cities in world is null or not
    @Test
    public void testTop7CapitalCitiesInWorld() {
        List<City> Top7CapitalCitiesInWorld= app.getTopSevenCapitalCitiesOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInWorld);
        System.out.println("Top 7 Capital Cities in World Organized by largest to smallest is not null");
    }

    //check the get top 7 capital cities in world is empty or not
    @Test
    public void testTop7CapitalCitiesIsEmpty() {
        List<City> topCapitalCities = app.getTopSevenCapitalCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCities);
        assertFalse(topCapitalCities.isEmpty());
        System.out.println("Top 7 capital cities in world Report is not empty");
    }

    //check the get top 7 capital cities in continent is null or not
    @Test
    public void testTop7CapitalCitiesInContinent() {
        List<City> Top7CapitalCitiesInContinent= app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInContinent);
        System.out.println("Top 7 Capital Cities in Continent Organized by largest to smallest is not null");
    }

    //check the get top 7 capital cities in continent is empty or not
    @Test
    public void testTop7CapitalCitiesInContinentIsEmpty() {
        List<City> topCapitalCitiesInContinent = app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesInContinent);
        assertFalse(topCapitalCitiesInContinent.isEmpty());
        System.out.println("Top 7 capital cities in continent Report is not empty");
    }

    //check the get top 7 capital cities in region is null or not
    @Test
    public void testTop7CapitalCitiesInRegion() {
        List<City> Top7CapitalCitiesInRegion= app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(Top7CapitalCitiesInRegion);
        System.out.println("Top 7 Capital Cities in Region Organized by largest to smallest is not null");
    }

    //check the get top 7 capital cities in region is empty or not
    @Test
    public void testTop7CapitalCitiesInRegionIsEmpty() {
        List<City> topCapitalCitiesInRegion = app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesInRegion);
        assertFalse(topCapitalCitiesInRegion.isEmpty());
        System.out.println("Top 7 capital cities in Region Report is not empty");
    }

    //add a new cities to check the set method is work or not
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

    //add a new capital cities to check the set method is work or not
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

    //add a new countries to check the set method is work or not
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

    //test the display countries is empty or not
    @Test
    public void testReportCountryIsEmpty() {
        // Prepare test data
        ArrayList<Country> emptyList = new ArrayList<>();
        // Call the method
        app.displayCountries(emptyList);
    }

    //check if the countries in the world contain null value or not
    @Test
    void printDisplayCitiesTestContainsNull()
    {
        ArrayList<Country> countriesContainNull = new ArrayList<>();
        countriesContainNull.add(null);
        app.displayCountries(countriesContainNull);
    }

    //test the display cities is empty or not
    @Test
    public void testReportCitiesIsEmpty() {
        // Prepare test data
        ArrayList<City> emptyList = new ArrayList<>();
        // Call the method
        app.displayCities(emptyList);
    }

    //test the display capital cities is empty or not
    @Test
    public void testReportCapitalCitiesIsEmpty() {
        // Prepare test data
        ArrayList<City> emptyList = new ArrayList<>();
        // Call the method
        app.displayCapitalCities(emptyList);
    }

    //test the output queries are work or not
    @Test
    void testDisplayAllQuery() {
        // Call display all query
        app.displayAllQuery();
        // Assert that each array list is null
        assertNotNull(app.getAllCapitalCitiesByPopulation());
    }

    //test the main method
    @Test
    public void testMainWithNoArguments() {
        String[] args = {};
        App.main(args);
        assertNotNull(app);
    }
}