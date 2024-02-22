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

    //connecting to database
    private static final String DB_LOCATION = "localhost:33060";
    private static final int DB_DELAY = 30000;
    private static App app;


    // set up before making the testing
    @BeforeAll
    public static void setUpBeforeClass() {
        app = new App();
        app.connect(DB_LOCATION, DB_DELAY);
    }
//    static App app;
//
//    @BeforeAll
//    static void init()
//    {
//        app = new App();
//        app.connect("localhost:33060", 30000);
//
//    }

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

    // Test if the bottom Country in the world is suitable with actual result
    @Test
    void testBottomGetCountriesInWorld()
    {
        List<Country> country = app.getCountries();
        Country bottomCountry = country.get(country.size()-1);

        assertEquals("Pitcairn",bottomCountry.getName() );
        assertEquals("Oceania",bottomCountry.getContinent() );
        assertEquals("Polynesia",bottomCountry.getRegion());
        assertEquals(Long.valueOf(50),bottomCountry.getPopulation());
    }

    // Test if the top Country in the Asia is suitable with actual result
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

    // Test if the bottom Country in the Asia is suitable with actual result
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

    // Test if the top Country in the South East Asia is suitable with actual result
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

    // Test if the bottom Country in the South East Asia is suitable with actual result
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

    // Test if the top Capital Cities in World is suitable with actual result
    @Test
    void testTopGetCapitalCitiesInWorld()
    {
        List<City> CapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City topCapitalCities = CapitalCitiesInWorld.get(0);

        assertEquals("Seoul",topCapitalCities.getCityName());
        assertEquals("South Korea",topCapitalCities.getCountryCode());
        assertEquals(9981619,topCapitalCities.getCityPopulation());
    }

    // Test if the bottom Capital Cities in World is suitable with actual result
    @Test
    void testBottomGetCapitalCitiesInWorld()
    {
        List<City> BottomCapitalCitiesInWorld = app.getAllCapitalCitiesByPopulation();
        City BottomCapitalCities = BottomCapitalCitiesInWorld.get(BottomCapitalCitiesInWorld.size()-1);

        assertEquals("Adamstown",BottomCapitalCities.getCityName());
        assertEquals("Pitcairn",BottomCapitalCities.getCountryCode());
        assertEquals(42,BottomCapitalCities.getCityPopulation());
    }

    // Test if the top Capital Cities in Continent is suitable with actual result
    @Test
    void testTopGetCapitalCitiesByContinent()
    {
        List<City> CapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City topCapitalCitiesByContinent = CapitalCitiesByContinent.get(0);

        assertEquals("Cairo",topCapitalCitiesByContinent.getCityName());
        assertEquals("Egypt",topCapitalCitiesByContinent.getCountryCode());
        assertEquals(6789479,topCapitalCitiesByContinent.getCityPopulation());
    }

    // Test if the bottom Capital Cities in Continent is suitable with actual result
    @Test
    void testBottomGetCapitalCitiesByContinent()
    {
        List<City> BottomCapitalCitiesByContinent = app.getCapitalCitiesByContinentOrderedByPopulation();
        City bottomCapitalCitiesByContinent = BottomCapitalCitiesByContinent.get(BottomCapitalCitiesByContinent.size()-1);

        assertEquals("Jamestown",bottomCapitalCitiesByContinent.getCityName());
        assertEquals("Saint Helena",bottomCapitalCitiesByContinent.getCountryCode());
        assertEquals(1500,bottomCapitalCitiesByContinent.getCityPopulation());
    }

    // Test if the top Capital Cities in region is suitable with actual result
    @Test
    void testTopGetCapitalCitiesByRegion()
    {
        List<City> CapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City topCapitalCitiesbyRegion = CapitalCitiesByRegion.get(0);

        assertEquals("Kinshasa",topCapitalCitiesbyRegion.getCityName());
        assertEquals("Congo, The Democratic Republic of the",topCapitalCitiesbyRegion.getCountryCode());
        assertEquals(5064000,topCapitalCitiesbyRegion.getCityPopulation());
    }

    // Test if the bottom Capital Cities in region is suitable with actual result
    @Test
    void testbottomGetCapitalCitiesByRegion()
    {
        List<City> BottomCapitalCitiesByRegion = app.getCapitalCitiesByRegionOrderedByPopulation();
        City bottomCapitalCitiesbyRegion = BottomCapitalCitiesByRegion.get(BottomCapitalCitiesByRegion.size()-1);

        assertEquals("Malabo",bottomCapitalCitiesbyRegion.getCityName());
        assertEquals("Equatorial Guinea",bottomCapitalCitiesbyRegion.getCountryCode());
        assertEquals(40000,bottomCapitalCitiesbyRegion.getCityPopulation());
    }

    // Test if the top Cities in world is suitable with actual result
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

    // Test if the bottom Cities in world is suitable with actual result
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

    // Test if the top Cities in continent is suitable with actual result
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

    // Test if the bottom Cities in continent is suitable with actual result
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

    // Test if the top Cities in Region is suitable with actual result
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

    // Test if the bottom Cities in Region is suitable with actual result
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

    // Test if the top Cities in Country is suitable with actual result
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

    // Test if the bottom Cities in Country is suitable with actual result
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

    // Test if the top Cities in District is suitable with actual result
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

    // Test if the top Cities in District is suitable with actual result
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

    // Test if the bottom Country in the world is suitable with actual result
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

    // Test if the top Country in Asia is suitable with actual result
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

    // Test if the bottom Country in Asia is suitable with actual result
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

    // Test if the top Country in South East Asia is suitable with actual result
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

    // Test if the bottom Country in South East Asia is suitable with actual result
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

    // Test if the top Cities in World is suitable with actual result
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

    // Test if the bottom Cities in World is suitable with actual result
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

    // Test if the top Cities in Continent is suitable with actual result
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

    // Test if the bottom Cities in Continent is suitable with actual result
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

    // Test if the top Cities in Region is suitable with actual result
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

    // Test if the bottom Cities in Region is suitable with actual result
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

    // Test if the top Cities in Country is suitable with actual result
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

    // Test if the bottom Cities in Country is suitable with actual result
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

    // Test if the top Cities in district is suitable with actual result
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

    // Test if the top Cities in district is suitable with actual result
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

    // Test if the top Capital Cities in World is suitable with actual result
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

    // Test if the bottom Capital Cities in World is suitable with actual result
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

    // Test if the top Capital Cities in Continent is suitable with actual result
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

    // Test if the bottom Capital Cities in Continent is suitable with actual result
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

    // Test if the top Capital Cities in Region is suitable with actual result
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

    // Test if the bottom Capital Cities in Region is suitable with actual result
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

    //set the new cities
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

    //set the new capital cities
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

    //set the new country
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

    //test the print functions has database connection, if yes, return the data
    @Test
    void PrintFunctionsConnectionNullTest(){
        app.con = null;
        app.printPopulationOfLivingOrNotLivinginContinentReport();
        app.printPopulationOfLivingOrNotLivinginCountryReport();
        app.printPopulationOfLivingOrNotLivinginRegionReport();
        app.printSelectedLanguageSpeakers();
        app.printWorldPopulation();
        app.printContinentPopulation();
        app.printRegionPopulation();
        app.printCountryPopulation();
        app.printDistrictPopulation();
        app.printCityPopulation();
        System.out.println("No Connection Test Ran Successfully");
        app.connect(DB_LOCATION, DB_DELAY);
        app.printPopulationOfLivingOrNotLivinginContinentReport();
        app.printPopulationOfLivingOrNotLivinginCountryReport();
        app.printPopulationOfLivingOrNotLivinginRegionReport();
        app.printSelectedLanguageSpeakers();
        app.printWorldPopulation();
        app.printContinentPopulation();
        app.printRegionPopulation();
        app.printCountryPopulation();
        app.printDistrictPopulation();
        app.printCityPopulation();
    }

    //test the main method
    @Test
    public void testMainWithNoArguments() {
        String[] args = {};
        App.main(args);
        assertNotNull(app);
    }
}

