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
    public void testGetCitiesOrderByPopulation() {
        List<City> cityWorld = app.getCitiesOrderedByPopulation();
        assertNotNull(cityWorld);
        System.out.println("Get Cities ordered by population Function's output is not null");
    }

    @Test
    public void testGetCitiesByContinentOrderByPopulation() {
        List<City> cityContinent = app.getCitiesByContinentOrderedByPopulation();
        assertNotNull(cityContinent);
        System.out.println("Get Cities by Continent Function's output is not null");

    }

    @Test
    public void testGetCitiesByRegionOrderByPopulation() {
        List<City> cityRegion = app.getCitiesByRegionOrderedByPopulation();
        assertNotNull(cityRegion);
        System.out.println("Get Cities by Region Function's output is not null");
    }

    @Test
    public void testGetCitiesInCountryOrderByPopulation() {
        List<City> cityCountry = app.getCitiesInCountryOrderedByPopulation();
        assertNotNull(cityCountry);
        System.out.println("Get Cities in Country Function's output is not null");
    }

    @Test
    public void testGetCitiesInDistinct() {
        List<City> cityDiscrict = app.getCitiesInDistrict();
        assertNotNull(cityDiscrict);
        System.out.println("Get Cities in Distinct Function's output is not null");
    }

    @Test
    public void testGetAllCapitalCitiesByPopulation() {
        List<City> CapitalCities = app.getAllCapitalCitiesByPopulation();
        assertNotNull(CapitalCities);
        System.out.println("Get all Capital Cities by Population Function's output is not null");
    }

    @Test
    public void testCapitalInContinent() {
        List<City> CapitalContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        assertNotNull(CapitalContinent);
        System.out.println("Get Capital Cities by Continent Function's output is not null");
    }

    @Test
    public void testCapitalInRegion() {
        List<City> CapitalRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        assertNotNull(CapitalRegion);
        System.out.println("Get Capital Cities by Region Function's output is not null");
    }


}