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

    // Test if the top Country in the world is suitable with actual result
    @Test
    public void testGetTopSevenCountriesInWorldByPopulation() {
        //Country countryPopulation = new Country(); // Assuming the class containing the method is named CountryPopulation
        List<Country> topCountries = app.getTopSevenCountriesInWorldByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountries);
        assertFalse(topCountries.isEmpty());

        // Extracting the first line of output
        Country firstCountry = topCountries.get(0);
        assertEquals("China",firstCountry.getName());
        assertEquals("Asia",firstCountry.getContinent());
        assertEquals("Eastern Asia",firstCountry.getRegion());
        assertEquals(Long.valueOf(1277558000),firstCountry.getPopulation());
        assertEquals("Peking",firstCountry.getCapital());
    }

    @Test
    public void testGetBottomOfTopSevenCountriesInWorldByPopulation() {
        List<Country> topCountriesBottom = app.getTopSevenCountriesInWorldByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesBottom);
        assertFalse(topCountriesBottom.isEmpty());

        // Extracting the first line of output
        Country lastCountry = topCountriesBottom.get(topCountriesBottom.size()-1);
        assertEquals("Russian Federation",lastCountry.getName());
        assertEquals("Europe",lastCountry.getContinent());
        assertEquals("Eastern Europe",lastCountry.getRegion());
        assertEquals(Long.valueOf(146934000),lastCountry.getPopulation());
        assertEquals("Moscow",lastCountry.getCapital());
    }

    @Test
    public void testGetTopSevenCountriesInAsiaByPopulation() {
        //Country countryPopulation = new Country(); // Assuming the class containing the method is named CountryPopulation
        List<Country> topCountriesAsia = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesAsia);
        assertFalse(topCountriesAsia.isEmpty());

        // Extracting the first line of output
        Country firstCountry = topCountriesAsia.get(0);
        assertEquals("China",firstCountry.getName());
        assertEquals("Asia",firstCountry.getContinent());
        assertEquals("Eastern Asia",firstCountry.getRegion());
        assertEquals(Long.valueOf(1277558000),firstCountry.getPopulation());
        assertEquals("Peking",firstCountry.getCapital());
    }

    @Test
    public void testGetBottomOfTopSevenCountriesInAsiaByPopulation() {
        List<Country> topCountriesAsiaBottom = app.getTopSevenCountriesInAsiaByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesAsiaBottom);
        assertFalse(topCountriesAsiaBottom.isEmpty());

        // Extracting the first line of output
        Country lastCountry = topCountriesAsiaBottom.get(topCountriesAsiaBottom.size()-1);
        assertEquals("Vietnam",lastCountry.getName());
        assertEquals("Asia",lastCountry.getContinent());
        assertEquals("Southeast Asia",lastCountry.getRegion());
        assertEquals(Long.valueOf(79832000),lastCountry.getPopulation());
        assertEquals("Hanoi",lastCountry.getCapital());
    }

    @Test
    public void testGetTopSevenCountriesInSouthEastAsia() {
        List<Country> topCountriesSouthEastAsia = app.getTopSevenCountriesInSouthEastAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesSouthEastAsia);
        assertFalse(topCountriesSouthEastAsia.isEmpty());

        // Extracting the first line of output
        Country firstCountry = topCountriesSouthEastAsia.get(0);
        assertEquals("Indonesia",firstCountry.getName());
        assertEquals("Asia",firstCountry.getContinent());
        assertEquals("Southeast Asia",firstCountry.getRegion());
        assertEquals(Long.valueOf(212107000),firstCountry.getPopulation());
        assertEquals("Jakarta",firstCountry.getCapital());
    }

    @Test
    public void testGetBottomOfTopSevenCountriesInSouthEastAsia() {
        List<Country> topCountriesSouthEastAsiaBottom = app.getTopSevenCountriesInSouthEastAsia();

        // Check if the list is not null and has at least one element
        assertNotNull(topCountriesSouthEastAsiaBottom);
        assertFalse(topCountriesSouthEastAsiaBottom.isEmpty());

        // Extracting the first line of output
        Country lastCountry = topCountriesSouthEastAsiaBottom.get(topCountriesSouthEastAsiaBottom.size()-1);
        assertEquals("Cambodia",lastCountry.getName());
        assertEquals("Asia",lastCountry.getContinent());
        assertEquals("Southeast Asia",lastCountry.getRegion());
        assertEquals(Long.valueOf(11168000),lastCountry.getPopulation());
        assertEquals("Phnom Penh",lastCountry.getCapital());
    }

    @Test
    public void testGetTopSevenCitiesInWorld() {
        List<City> topCities = app.getTopSevenCitiesInWorldOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCities);
        assertFalse(topCities.isEmpty());

        // Extracting the first line of output
        City firstCity = topCities.get(0);
        assertEquals("Mumbai (Bombay)",firstCity.getCityName());
        assertEquals("India",firstCity.getCountryOfCity());
        assertEquals("Maharashtra",firstCity.getCityDistrict());
        assertEquals(10500000,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInWorldBottom() {
        List<City> topCitiesBottom = app.getTopSevenCitiesInWorldOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesBottom);
        assertFalse(topCitiesBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCitiesBottom.get(topCitiesBottom.size()-1);
        assertEquals("Istanbul",bottomCity.getCityName());
        assertEquals("Turkey",bottomCity.getCountryOfCity());
        assertEquals("Istanbul",bottomCity.getCityDistrict());
        assertEquals(8787958,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInContinent() {
        List<City> topCities = app.getTopSevenCitiesInContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCities);
        assertFalse(topCities.isEmpty());

        // Extracting the first line of output
        City firstCity = topCities.get(0);
        assertEquals("Cairo",firstCity.getCityName());
        assertEquals("Egypt",firstCity.getCountryOfCity());
        assertEquals("Kairo",firstCity.getCityDistrict());
        assertEquals(6789479,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInContinentBottom() {
        List<City> topCitiesContinentBottom = app.getTopSevenCitiesInContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesContinentBottom);
        assertFalse(topCitiesContinentBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCitiesContinentBottom.get(topCitiesContinentBottom.size()-1);
        assertEquals("Cape Town",bottomCity.getCityName());
        assertEquals("South Africa",bottomCity.getCountryOfCity());
        assertEquals("Western Cape",bottomCity.getCityDistrict());
        assertEquals(2352121,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInRegion() {
        List<City> topCities = app.getTopSevenCitiesInRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCities);
        assertFalse(topCities.isEmpty());

        // Extracting the first line of output
        City firstCity = topCities.get(0);
        assertEquals("Abidjan",firstCity.getCityName());
        assertEquals("Côte d’Ivoire",firstCity.getCountryOfCity());
        assertEquals("Abidjan",firstCity.getCityDistrict());
        assertEquals(2500000,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInRegionBottom() {
        List<City> topCitiesRegionBottom = app.getTopSevenCitiesInRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesRegionBottom);
        assertFalse(topCitiesRegionBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCitiesRegionBottom.get(topCitiesRegionBottom.size()-1);
        assertEquals("Monrovia",bottomCity.getCityName());
        assertEquals("Liberia",bottomCity.getCountryOfCity());
        assertEquals("Montserrado",bottomCity.getCityDistrict());
        assertEquals(850000,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInCountry() {
        List<City> topCitiesCountry = app.getTopSevenCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesCountry);
        assertFalse(topCitiesCountry.isEmpty());

        // Extracting the first line of output
        City firstCity = topCitiesCountry.get(0);
        assertEquals("Lagos",firstCity.getCityName());
        assertEquals("Nigeria",firstCity.getCountryOfCity());
        assertEquals("Lagos",firstCity.getCityDistrict());
        assertEquals(1518000,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInCountryBottom() {
        List<City> topCitiesCountryBottom = app.getTopSevenCitiesInCountryOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesCountryBottom);
        assertFalse(topCitiesCountryBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCitiesCountryBottom.get(topCitiesCountryBottom.size()-1);
        assertEquals("Abeokuta",bottomCity.getCityName());
        assertEquals("Nigeria",bottomCity.getCountryOfCity());
        assertEquals("Ogun",bottomCity.getCityDistrict());
        assertEquals(427400,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInDistrict() {
        List<City> topCitiesDistrict = app.getTopSevenCitiesInDistrictOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesDistrict);
        assertFalse(topCitiesDistrict.isEmpty());

        // Extracting the first line of output
        City firstCity = topCitiesDistrict.get(0);
        assertEquals("Ibadan",firstCity.getCityName());
        assertEquals("Nigeria",firstCity.getCountryOfCity());
        assertEquals("Oyo & Osun",firstCity.getCityDistrict());
        assertEquals(1432000,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCitiesInDistrictBottom() {
        List<City> topCitiesDistrictBottom = app.getTopSevenCitiesInDistrictOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCitiesDistrictBottom);
        assertFalse(topCitiesDistrictBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCitiesDistrictBottom.get(topCitiesDistrictBottom.size()-1);
        assertEquals("Ife",bottomCity.getCityName());
        assertEquals("Nigeria",bottomCity.getCountryOfCity());
        assertEquals("Oyo & Osun",bottomCity.getCityDistrict());
        assertEquals(296800,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInWorld() {
        List<City> topCapitalCities = app.getTopSevenCapitalCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCities);
        assertFalse(topCapitalCities.isEmpty());

        // Extracting the first line of output
        City firstCity = topCapitalCities.get(0);
        assertEquals("Seoul",firstCity.getCityName());
        assertEquals("South Korea",firstCity.getCountryCode());
        assertEquals(9981619,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInWorldBottom() {
        List<City> topCapitalCitiesBottom = app.getTopSevenCapitalCitiesOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesBottom);
        assertFalse(topCapitalCitiesBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCapitalCitiesBottom.get(topCapitalCitiesBottom.size()-1);
        assertEquals("London",bottomCity.getCityName());
        assertEquals("United Kingdom",bottomCity.getCountryCode());
        assertEquals(7285000,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInContinent() {
        List<City> topCapitalCitiesContinent = app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesContinent);
        assertFalse(topCapitalCitiesContinent.isEmpty());

        // Extracting the first line of output
        City firstCity = topCapitalCitiesContinent.get(0);
        assertEquals("Cairo",firstCity.getCityName());
        assertEquals("Egypt",firstCity.getCountryCode());
        assertEquals(6789479,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInContinentBottom() {
        List<City> topCapitalCitiesContinentBottom = app.getTopSevenCapitalCitiesByContinentOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesContinentBottom);
        assertFalse(topCapitalCitiesContinentBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCapitalCitiesContinentBottom.get(topCapitalCitiesContinentBottom.size()-1);
        assertEquals("Tripoli",bottomCity.getCityName());
        assertEquals("Libyan Arab Jamahiriya",bottomCity.getCountryCode());
        assertEquals(1682000,bottomCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInRegion() {
        List<City> topCapitalCitiesRegion = app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesRegion);
        assertFalse(topCapitalCitiesRegion.isEmpty());

        // Extracting the first line of output
        City firstCity = topCapitalCitiesRegion.get(0);
        assertEquals("Kinshasa",firstCity.getCityName());
        assertEquals("Congo, The Democratic Republic of the",firstCity.getCountryCode());
        assertEquals(5064000,firstCity.getCityPopulation());
    }

    @Test
    public void testGetTopSevenCapitalCitiesInRegionBottom() {
        List<City> topCapitalCitiesRegionBottom = app.getTopSevenCapitalCitiesByRegionOrderedByPopulation();

        // Check if the list is not null and has at least one element
        assertNotNull(topCapitalCitiesRegionBottom);
        assertFalse(topCapitalCitiesRegionBottom.isEmpty());

        // Extracting the first line of output
        City bottomCity = topCapitalCitiesRegionBottom.get(topCapitalCitiesRegionBottom.size()-1);
        assertEquals("Libreville",bottomCity.getCityName());
        assertEquals("Gabon",bottomCity.getCountryCode());
        assertEquals(419000,bottomCity.getCityPopulation());
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
    void displayAllQuery(){
        assertFalse(outContent.toString().contains("All the countries in the world organised by largest population to smallest"));
    }
    //app test
    @Test
    public void testMainWithNoArguments() {
        String[] args = {};
        App.main(args);
        assertNotNull(app);
    }
}


