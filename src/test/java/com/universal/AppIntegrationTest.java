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
         Country firstCountry = topCountriesBottom.get(topCountriesBottom.size()-1);
         assertEquals("Russian Federation",firstCountry.getName());
         assertEquals("Europe",firstCountry.getContinent());
         assertEquals("Eastern Europe",firstCountry.getRegion());
         assertEquals(Long.valueOf(146934000),firstCountry.getPopulation());
         assertEquals("Moscow",firstCountry.getCapital());
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
     void DisplayAllQuery(){
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