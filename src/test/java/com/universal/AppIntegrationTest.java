/**
 * This is the report for the integration testing which testing the expected
 * only largest and smallest countries, cities, capital cities on world or continent or
 * region or country or district.
 */

package com.universal;

import com.google.protobuf.AbstractMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

//    @Test
//    public void testGetCountriesInAfrica() {
//        List<Country> africanCountries = app.getCountriesInAfrica();
//        assertNotNull(africanCountries);
//        System.out.println("Get Country In Africa Function's output is not null");
//    }

    @Test
    void testTopGetCountriesInWorld()
    {
        List<Country> country = app.getCountries();
        Country topCountry = country.get(0);

        assertEquals(topCountry.getName(), "China");
        assertEquals(topCountry.getContinent(), "Asia");
        assertEquals(topCountry.getRegion(), "Eastern Asia");
        assertEquals(topCountry.getPopulation(), 1277558000);
    }

    @Test
    void testBottomGetCountriesInWorld()
    {
        List<Country> country = app.getCountries();
        Country bottomCountry = country.get(country.size()-1);

        assertEquals(bottomCountry.getName(), "United States Minor Outlying Islands");
        assertEquals(bottomCountry.getContinent(), "Oceania");
        assertEquals(bottomCountry.getRegion(), "Micronesia/Caribbean");
        assertEquals(bottomCountry.getPopulation(), 0);
    }

    @Test
    void testTopGetCountriesInAfrica()
    {
        List<Country> countryinAfrica = app.getCountriesInAfrica();
        Country topCountryinAfrica = countryinAfrica.get(0);
        assertEquals(topCountryinAfrica.getName(), "Nigeria");
        assertEquals(topCountryinAfrica.getContinent(), "Africa");
        assertEquals(topCountryinAfrica.getRegion(), "Western Africa");
        assertEquals(topCountryinAfrica.getPopulation(), 111506000);
    }

    @Test
    void testBottomGetCountriesInAfrica()
    {
        List<Country> bottomcountryinAfrica = app.getCountriesInAfrica();
        Country bottomCountryinAfrica = bottomcountryinAfrica.get(bottomcountryinAfrica.size()-1);

        assertEquals(bottomCountryinAfrica.getName(), "British Indian Ocean Territory");
        assertEquals(bottomCountryinAfrica.getContinent(), "Africa");
        assertEquals(bottomCountryinAfrica.getRegion(), "Eastern Africa");
        assertEquals(bottomCountryinAfrica.getPopulation(), 0);
    }

    @Test
    void testTopGetCountriesInCentralAfrica()
    {
        List<Country> countryinCentralAfrica = app.getCountriesInCentralAfrica();
        Country topCountryinCentralAfrica = countryinCentralAfrica.get(0);

        assertEquals(topCountryinCentralAfrica.getName(), "Congo, The Democratic Republic of the");
        assertEquals(topCountryinCentralAfrica.getContinent(), "Africa");
        assertEquals(topCountryinCentralAfrica.getRegion(), "Central Africa");
        assertEquals(topCountryinCentralAfrica.getPopulation(), 51654000);
    }

    @Test
    void testBottomGetCountriesInCentralAfrica()
    {
        List<Country> bottomCountryInCentralAfrica = app.getCountriesInCentralAfrica();
        Country BottomCountryInCentralAfrica = bottomCountryInCentralAfrica.get(bottomCountryInCentralAfrica.size()-1);

        assertEquals(BottomCountryInCentralAfrica.getName(), "Sao Tome and Principe");
        assertEquals(BottomCountryInCentralAfrica.getContinent(), "Africa");
        assertEquals(BottomCountryInCentralAfrica.getRegion(), "Central Africa");
        assertEquals(BottomCountryInCentralAfrica.getPopulation(), 147000);
    }

    @Test
    void testTopGetCapitalCitiesInWorld()
    {
        List<City> CapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City topCapitalCities = CapitalCitiesInWorld.get(0);

        assertEquals(topCapitalCities.getCityName(), "Seoul");
        assertEquals(topCapitalCities.getCountryCode(), "South Korea");
        assertEquals(topCapitalCities.getCityPopulation(), 9981619);
    }

    @Test
    void testBottomGetCapitalCitiesInWorld()
    {
        List<City> BottomCapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City BottomCapitalCities = BottomCapitalCitiesInWorld.get(BottomCapitalCitiesInWorld.size()-1);

        assertEquals(BottomCapitalCities.getCityName(), "Adamstown");
        assertEquals(BottomCapitalCities.getCountryCode(), "Pitcairn");
        assertEquals(BottomCapitalCities.getCityPopulation(), 42);
    }

    @Test
    void testTopGetCapitalCitiesByContinent()
    {
        List<City> CapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City topCapitalCitiesByContinent = CapitalCitiesByContinent.get(0);

        assertEquals(topCapitalCitiesByContinent.getCityName(), "Cairo");
        assertEquals(topCapitalCitiesByContinent.getCountryCode(), "Egypt");
        assertEquals(topCapitalCitiesByContinent.getCityPopulation(), 6789479);
    }

    @Test
    void testBottomGetCapitalCitiesByContinent()
    {
        List<City> BottomCapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City bottomCapitalCitiesByContinent = BottomCapitalCitiesByContinent.get(BottomCapitalCitiesByContinent.size()-1);

        assertEquals(bottomCapitalCitiesByContinent.getCityName(), "Jamestown");
        assertEquals(bottomCapitalCitiesByContinent.getCountryCode(), "Saint Helena");
        assertEquals(bottomCapitalCitiesByContinent.getCityPopulation(), 1500);
    }

    @Test
    void testTopGetCapitalCitiesByRegion()
    {
        List<City> CapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City topCapitalCitiesbyRegion = CapitalCitiesByRegion.get(0);

        assertEquals(topCapitalCitiesbyRegion.getCityName(), "Kinshasa");
        assertEquals(topCapitalCitiesbyRegion.getCountryCode(), "Congo, The Democratic Republic of the");
        assertEquals(topCapitalCitiesbyRegion.getCityPopulation(), 5064000);
    }

    @Test
    void testbottomGetCapitalCitiesByRegion()
    {
        List<City> BottomCapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City bottomCapitalCitiesbyRegion = BottomCapitalCitiesByRegion.get(BottomCapitalCitiesByRegion.size()-1);

        assertEquals(bottomCapitalCitiesbyRegion.getCityName(), "Malabo");
        assertEquals(bottomCapitalCitiesbyRegion.getCountryCode(), "Equatorial Guinea");
        assertEquals(bottomCapitalCitiesbyRegion.getCityPopulation(), 40000);
    }

    @Test
    void testTopGetCitiesInWorld()
    {
        List<City> CitiesInWorld = app.getCitiesOrderedByPopulation();
        City topCitiesInWorld = CitiesInWorld.get(0);

        assertEquals(topCitiesInWorld.getCityName(), "Mumbai (Bombay)");
        assertEquals(topCitiesInWorld.getCountryOfCity(), "India");
        assertEquals(topCitiesInWorld.getCityDistrict(), "Maharashtra");
        assertEquals(topCitiesInWorld.getCityPopulation(), 10500000);
    }

    @Test
    void testBottomGetCitiesInWorld()
    {
        List<City> BottomCitiesInWorld = app.getCitiesOrderedByPopulation();
        City bottomCitiesInWorld = BottomCitiesInWorld.get(BottomCitiesInWorld.size()-1);

        assertEquals(bottomCitiesInWorld.getCityName(), "Adamstown");
        assertEquals(bottomCitiesInWorld.getCountryOfCity(), "Pitcairn");
        assertEquals(bottomCitiesInWorld.getCityDistrict(), "–");
        assertEquals(bottomCitiesInWorld.getCityPopulation(), 42);
    }

    @Test
    void testTopGetCitiesByContinent()
    {
        List<City> CitiesByContinent = app.getCitiesByContinentOrderedByPopulation();
        City topCitiesbyContinent = CitiesByContinent.get(0);

        assertEquals(topCitiesbyContinent.getCityName(), "Cairo");
        assertEquals(topCitiesbyContinent.getCountryOfCity(), "Egypt");
        assertEquals(topCitiesbyContinent.getCityDistrict(), "Kairo");
        assertEquals(topCitiesbyContinent.getCityPopulation(), 6789479);
    }

    @Test
    void testBottomGetCitiesByContinent()
    {
        List<City> BottomCitiesByContinent = app.getCitiesByContinentOrderedByPopulation();
        City bottomCitiesbyContinent = BottomCitiesByContinent.get(BottomCitiesByContinent.size()-1);

        assertEquals(bottomCitiesbyContinent.getCityName(), "Jamestown");
        assertEquals(bottomCitiesbyContinent.getCountryOfCity(), "Saint Helena");
        assertEquals(bottomCitiesbyContinent.getCityDistrict(), "Saint Helena");
        assertEquals(bottomCitiesbyContinent.getCityPopulation(), 1500);
    }


    @Test
    void testTopGetCitiesByRegion()
    {
        List<City> CitiesByRegion = app.getCitiesByRegionOrderedByPopulation();
        City topCitiesbyRegion = CitiesByRegion.get(0);

        assertEquals(topCitiesbyRegion.getCityName(), "Kinshasa");
        assertEquals(topCitiesbyRegion.getCountryOfCity(), "Congo, The Democratic Republic of the");
        assertEquals(topCitiesbyRegion.getCityDistrict(), "Kinshasa");
        assertEquals(topCitiesbyRegion.getCityPopulation(), 5064000);
    }

    @Test
    void testBottomGetCitiesByRegion()
    {
        List<City> BottomCitiesByRegion = app.getCitiesByRegionOrderedByPopulation();
        City bottomCitiesbyRegion = BottomCitiesByRegion.get(BottomCitiesByRegion.size()-1);

        assertEquals(bottomCitiesbyRegion.getCityName(), "Malabo");
        assertEquals(bottomCitiesbyRegion.getCountryOfCity(), "Equatorial Guinea");
        assertEquals(bottomCitiesbyRegion.getCityDistrict(), "Bioko");
        assertEquals(bottomCitiesbyRegion.getCityPopulation(), 40000);
    }

    @Test
    void testTopGetCitiesByCountry()
    {
        List<City> CitiesByCountry = app.getCitiesInCountryOrderedByPopulation();
        City topCitiesbyCountry = CitiesByCountry.get(0);

        assertEquals(topCitiesbyCountry.getCityName(), "Paris");
        assertEquals(topCitiesbyCountry.getCountryOfCity(), "France");
        assertEquals(topCitiesbyCountry.getCityDistrict(), "Île-de-France");
        assertEquals(topCitiesbyCountry.getCityPopulation(), 2125246);
    }

    @Test
    void testBottomGetCitiesByCountry()
    {
        List<City> BottomCitiesByCountry = app.getCitiesInCountryOrderedByPopulation();
        City bottomCitiesbyCountry = BottomCitiesByCountry.get(BottomCitiesByCountry.size()-1);

        assertEquals(bottomCitiesbyCountry.getCityName(), "Montreuil");
        assertEquals(bottomCitiesbyCountry.getCountryOfCity(), "France");
        assertEquals(bottomCitiesbyCountry.getCityDistrict(), "Île-de-France");
        assertEquals(bottomCitiesbyCountry.getCityPopulation(), 90674);
    }

    @Test
    void testTopGetCitiesByDistrict()
    {
        List<City> CitiesByDistinct = app.getCitiesInDistrict();
        City topCitiesbyDistinct = CitiesByDistinct.get(0);

        assertEquals(topCitiesbyDistinct.getCityName(), "La Matanza");
        assertEquals(topCitiesbyDistinct.getCountryOfCity(), "Argentina");
        assertEquals(topCitiesbyDistinct.getCityDistrict(), "Buenos Aires");
        assertEquals(topCitiesbyDistinct.getCityPopulation(), 1266461);
    }

    @Test
    void testBottomGetCitiesByDistrict()
    {
        List<City> BottomCitiesByDistinct = app.getCitiesInDistrict();
        City bottomCitiesbyDistinct = BottomCitiesByDistinct.get(BottomCitiesByDistinct.size()-1);

        assertEquals(bottomCitiesbyDistinct.getCityName(), "Tandil");
        assertEquals(bottomCitiesbyDistinct.getCountryOfCity(), "Argentina");
        assertEquals(bottomCitiesbyDistinct.getCityDistrict(), "Buenos Aires");
        assertEquals(bottomCitiesbyDistinct.getCityPopulation(), 91101);
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
    void displayCountriesOrderByPopulation()
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

    @Test
    public void testMainWithNoArguments() {
        String[] args = {};
        App.main(args);
        assertFalse(outContent.toString().contains("All the countries in the world organised by largest population to smallest"));

    }
}
