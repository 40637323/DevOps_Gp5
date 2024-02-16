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
    void testTopGetCountriesInWorld()
    {
        List<Country> country = app.getCountries();
        Country topCountry = country.get(0);

        assertEquals("China",topCountry.getName() );
        assertEquals("Asia", topCountry.getContinent());
        assertEquals("Eastern Asia", topCountry.getRegion());
        assertEquals(Long.valueOf(1277558000),topCountry.getPopulation());
    }

    @Test
    void testBottomGetCountriesInWorld()
    {
        List<Country> country = app.getCountries();
        Country bottomCountry = country.get(country.size()-1);

        assertEquals("United States Minor Outlying Islands",bottomCountry.getName() );
        assertEquals("Oceania",bottomCountry.getContinent() );
        assertEquals("Micronesia/Caribbean",bottomCountry.getRegion());
        assertEquals(Long.valueOf(0),bottomCountry.getPopulation());
    }

    @Test
    void testTopGetCountriesInAsia()
    {
        List<Country> countryinAsia = app.getCountriesInAsia();
        Country topCountryinAsia = countryinAsia.get(0);
        assertEquals("China",topCountryinAsia.getName());
        assertEquals("Asia",topCountryinAsia.getContinent());
        assertEquals("Eastern Asia",topCountryinAsia.getRegion());
        assertEquals(Long.valueOf(1277558000),topCountryinAsia.getPopulation());
    }

    @Test
    void testBottomGetCountriesInAsia()
    {
        List<Country> bottomcountryinAsia = app.getCountriesInAsia();
        Country bottomCountryinAsia = bottomcountryinAsia.get(bottomcountryinAsia.size()-1);

        assertEquals("Maldives",bottomCountryinAsia.getName());
        assertEquals("Asia",bottomCountryinAsia.getContinent());
        assertEquals("Southern and Central Asia",bottomCountryinAsia.getRegion());
        assertEquals(Long.valueOf(286000),bottomCountryinAsia.getPopulation());
    }

    @Test
    void testTopGetCountriesInSouthEastAsia()
    {
        List<Country> countryinSouthEastAsia = app.getCountriesInSouthEastAsia();
        Country topCountryinSouthEastAsia = countryinSouthEastAsia.get(0);

        assertEquals("Indonesia",topCountryinSouthEastAsia.getName());
        assertEquals("Asia",topCountryinSouthEastAsia.getContinent());
        assertEquals("Southeast Asia",topCountryinSouthEastAsia.getRegion());
        assertEquals(Long.valueOf(212107000),topCountryinSouthEastAsia.getPopulation());
    }

    @Test
    void testBottomGetCountriesInSouthEastAsia()
    {
        List<Country> bottomCountryInSouthEastAsia = app.getCountriesInSouthEastAsia();
        Country BottomCountryInSouthEastAsia = bottomCountryInSouthEastAsia.get(bottomCountryInSouthEastAsia.size()-1);

        assertEquals("Brunei",BottomCountryInSouthEastAsia.getName());
        assertEquals("Asia",BottomCountryInSouthEastAsia.getContinent());
        assertEquals("Southeast Asia",BottomCountryInSouthEastAsia.getRegion());
        assertEquals(Long.valueOf(328000),BottomCountryInSouthEastAsia.getPopulation() );
    }

    @Test
    void testTopGetCapitalCitiesInWorld()
    {
        List<City> CapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City topCapitalCities = CapitalCitiesInWorld.get(0);

        assertEquals("Seoul",topCapitalCities.getCityName());
        assertEquals("South Korea",topCapitalCities.getCountryCode());
        assertEquals(9981619,topCapitalCities.getCityPopulation());
    }

    @Test
    void testBottomGetCapitalCitiesInWorld()
    {
        List<City> BottomCapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City BottomCapitalCities = BottomCapitalCitiesInWorld.get(BottomCapitalCitiesInWorld.size()-1);

        assertEquals("Adamstown",BottomCapitalCities.getCityName());
        assertEquals("Pitcairn",BottomCapitalCities.getCountryCode());
        assertEquals(42,BottomCapitalCities.getCityPopulation());
    }

    @Test
    void testTopGetCapitalCitiesByContinent()
    {
        List<City> CapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City topCapitalCitiesByContinent = CapitalCitiesByContinent.get(0);

        assertEquals("Cairo",topCapitalCitiesByContinent.getCityName());
        assertEquals("Egypt",topCapitalCitiesByContinent.getCountryCode());
        assertEquals(6789479,topCapitalCitiesByContinent.getCityPopulation());
    }

    @Test
    void testBottomGetCapitalCitiesByContinent()
    {
        List<City> BottomCapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City bottomCapitalCitiesByContinent = BottomCapitalCitiesByContinent.get(BottomCapitalCitiesByContinent.size()-1);

        assertEquals("Jamestown",bottomCapitalCitiesByContinent.getCityName());
        assertEquals("Saint Helena",bottomCapitalCitiesByContinent.getCountryCode());
        assertEquals(1500,bottomCapitalCitiesByContinent.getCityPopulation());
    }

    @Test
    void testTopGetCapitalCitiesByRegion()
    {
        List<City> CapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City topCapitalCitiesbyRegion = CapitalCitiesByRegion.get(0);

        assertEquals("Kinshasa",topCapitalCitiesbyRegion.getCityName());
        assertEquals("Congo, The Democratic Republic of the",topCapitalCitiesbyRegion.getCountryCode());
        assertEquals(5064000,topCapitalCitiesbyRegion.getCityPopulation());
    }

    @Test
    void testbottomGetCapitalCitiesByRegion()
    {
        List<City> BottomCapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City bottomCapitalCitiesbyRegion = BottomCapitalCitiesByRegion.get(BottomCapitalCitiesByRegion.size()-1);

        assertEquals("Malabo",bottomCapitalCitiesbyRegion.getCityName());
        assertEquals("Equatorial Guinea",bottomCapitalCitiesbyRegion.getCountryCode());
        assertEquals(40000,bottomCapitalCitiesbyRegion.getCityPopulation());
    }

    @Test
    void testTopGetCitiesInWorld()
    {
        List<City> CitiesInWorld = app.getCitiesOrderedByPopulation();
        City topCitiesInWorld = CitiesInWorld.get(0);

        assertEquals("Mumbai (Bombay)",topCitiesInWorld.getCityName());
        assertEquals("India",topCitiesInWorld.getCountryOfCity());
        assertEquals("Maharashtra",topCitiesInWorld.getCityDistrict());
        assertEquals(10500000,topCitiesInWorld.getCityPopulation());
    }

    @Test
    void testBottomGetCitiesInWorld()
    {
        List<City> BottomCitiesInWorld = app.getCitiesOrderedByPopulation();
        City bottomCitiesInWorld = BottomCitiesInWorld.get(BottomCitiesInWorld.size()-1);

        assertEquals("Adamstown",bottomCitiesInWorld.getCityName());
        assertEquals("Pitcairn",bottomCitiesInWorld.getCountryOfCity());
        assertEquals("–",bottomCitiesInWorld.getCityDistrict());
        assertEquals(42,bottomCitiesInWorld.getCityPopulation());
    }

    @Test
    void testTopGetCitiesByContinent()
    {
        List<City> CitiesByContinent = app.getCitiesByContinentOrderedByPopulation();
        City topCitiesbyContinent = CitiesByContinent.get(0);

        assertEquals("Cairo",topCitiesbyContinent.getCityName());
        assertEquals("Egypt",topCitiesbyContinent.getCountryOfCity());
        assertEquals("Kairo",topCitiesbyContinent.getCityDistrict());
        assertEquals(6789479,topCitiesbyContinent.getCityPopulation());
    }

    @Test
    void testBottomGetCitiesByContinent()
    {
        List<City> BottomCitiesByContinent = app.getCitiesByContinentOrderedByPopulation();
        City bottomCitiesbyContinent = BottomCitiesByContinent.get(BottomCitiesByContinent.size()-1);

        assertEquals("Jamestown",bottomCitiesbyContinent.getCityName());
        assertEquals("Saint Helena",bottomCitiesbyContinent.getCountryOfCity());
        assertEquals("Saint Helena",bottomCitiesbyContinent.getCityDistrict());
        assertEquals(1500,bottomCitiesbyContinent.getCityPopulation());
    }


    @Test
    void testTopGetCitiesByRegion()
    {
        List<City> CitiesByRegion = app.getCitiesByRegionOrderedByPopulation();
        City topCitiesbyRegion = CitiesByRegion.get(0);

        assertEquals("Kinshasa",topCitiesbyRegion.getCityName());
        assertEquals("Congo, The Democratic Republic of the",topCitiesbyRegion.getCountryOfCity());
        assertEquals("Kinshasa",topCitiesbyRegion.getCityDistrict());
        assertEquals(5064000,topCitiesbyRegion.getCityPopulation());
    }

    @Test
    void testBottomGetCitiesByRegion()
    {
        List<City> BottomCitiesByRegion = app.getCitiesByRegionOrderedByPopulation();
        City bottomCitiesbyRegion = BottomCitiesByRegion.get(BottomCitiesByRegion.size()-1);

        assertEquals("Malabo",bottomCitiesbyRegion.getCityName());
        assertEquals("Equatorial Guinea",bottomCitiesbyRegion.getCountryOfCity());
        assertEquals("Bioko",bottomCitiesbyRegion.getCityDistrict());
        assertEquals(40000,bottomCitiesbyRegion.getCityPopulation());
    }

    @Test
    void testTopGetCitiesByCountry()
    {
        List<City> CitiesByCountry = app.getCitiesInCountryOrderedByPopulation();
        City topCitiesbyCountry = CitiesByCountry.get(0);

        assertEquals("Paris",topCitiesbyCountry.getCityName());
        assertEquals("France",topCitiesbyCountry.getCountryOfCity());
        assertEquals("Île-de-France",topCitiesbyCountry.getCityDistrict());
        assertEquals(2125246,topCitiesbyCountry.getCityPopulation());
    }

    @Test
    void testBottomGetCitiesByCountry()
    {
        List<City> BottomCitiesByCountry = app.getCitiesInCountryOrderedByPopulation();
        City bottomCitiesbyCountry = BottomCitiesByCountry.get(BottomCitiesByCountry.size()-1);

        assertEquals("Montreuil",bottomCitiesbyCountry.getCityName());
        assertEquals("France",bottomCitiesbyCountry.getCountryOfCity());
        assertEquals("Île-de-France",bottomCitiesbyCountry.getCityDistrict());
        assertEquals(90674,bottomCitiesbyCountry.getCityPopulation());
    }

    @Test
    void testTopGetCitiesByDistrict()
    {
        List<City> CitiesByDistinct = app.getCitiesInDistrict();
        City topCitiesbyDistinct = CitiesByDistinct.get(0);

        assertEquals("La Matanza",topCitiesbyDistinct.getCityName());
        assertEquals("Argentina",topCitiesbyDistinct.getCountryOfCity());
        assertEquals("Buenos Aires",topCitiesbyDistinct.getCityDistrict());
        assertEquals(1266461,topCitiesbyDistinct.getCityPopulation());
    }

    @Test
    void testBottomGetCitiesByDistrict()
    {
        List<City> BottomCitiesByDistinct = app.getCitiesInDistrict();
        City bottomCitiesbyDistinct = BottomCitiesByDistinct.get(BottomCitiesByDistinct.size()-1);

        assertEquals("Tandil",bottomCitiesbyDistinct.getCityName());
        assertEquals("Argentina",bottomCitiesbyDistinct.getCountryOfCity());
        assertEquals("Buenos Aires",bottomCitiesbyDistinct.getCityDistrict());
        assertEquals(91101,bottomCitiesbyDistinct.getCityPopulation());
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
    void testDisplayAllQuery() {
        // Call display all query
        app.displayAllQuery();
        // Assert that each array list is null
        assertNotNull(app.getAllCapitalCitiesByPopulation());
    }
    //app test
    @Test
    public void testMainWithNoArguments() {
        String[] args = {};
        App.main(args);
        assertNotNull(app);
    }
}

