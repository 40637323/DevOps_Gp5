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
     void testTop7PopulatedCountriesInWorld() {
         List<Country> Top7CountriesInWorld = app.getTopSevenCountriesInWorldByPopulation();
         Country top7CountriesInWorld = Top7CountriesInWorld.get(Top7CountriesInWorld.size()-1);
         assertEquals("China",top7CountriesInWorld.getName() );
         assertEquals("Asia", top7CountriesInWorld.getContinent());
         assertEquals("Eastern Asia", top7CountriesInWorld.getRegion());
         assertEquals(Long.valueOf(1277558000),top7CountriesInWorld.getPopulation());
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

