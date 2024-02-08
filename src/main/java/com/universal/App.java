package com.universal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App
{
    /**
     * Connection to MySQL database.
     */
    Connection con = null;

    /**
     * Connect to the MySQL database.
     */

    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " +                                  Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }

    }
    public List<Country> getCountries() {

        List<Country> countries = new ArrayList<>();
        // Check connection is not null
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT code, name, continent, region, population, capital FROM country ORDER BY population DESC");

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("code"));
                country.setName(rs.getString("name"));
                country.setContinent(rs.getString("continent"));
                country.setRegion(rs.getString("region"));
                country.setPopulation(rs.getInt("population"));
                country.setCapital(rs.getString("capital"));
                // Set other attributes as necessary

                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

        return countries;
    }
    /**
     * Retrieves a list of countries from the African continent and orders them by population.
     * @return a List of Country objects representing countries in Africa.
     */
    public List<Country> getCountriesInAfrica() {
        List<Country> countries = new ArrayList<>();
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT code, name, continent, region, population, capital FROM country WHERE continent = 'Africa' ORDER BY population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("code"));
                country.setName(rs.getString("name"));
                country.setContinent(rs.getString("continent"));
                country.setRegion(rs.getString("region"));
                country.setPopulation(rs.getInt("population"));
                country.setCapital(rs.getString("capital"));
                // Set other attributes as necessary

                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return countries;
    }
    /**
     * Retrieves a list of countries from the Central Africa region and orders them by population.
     * @return a List of Country for representing countries in Central Africa.
     */
    public List<Country> getCountriesInCentralAfrica() {
        List<Country> countries = new ArrayList<>();
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT code, name, continent, region, population, capital FROM country WHERE region = 'Central Africa' ORDER BY population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("code"));
                country.setName(rs.getString("name"));
                country.setContinent(rs.getString("continent"));
                country.setRegion(rs.getString("region"));
                country.setPopulation(rs.getInt("population"));
                country.setCapital(rs.getString("capital"));
                // Set other attributes as necessary

                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return countries;
    }

    /** report related to all the cities in the world organised by largest population to smallest.
     * */
    public List<City> getCitiesOrderedByPopulation() {
        List<City> allCitiesWorld = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            // Adjusted SQL query to exclude city ID
            String sql = "SELECT city.name, city.district, city.Population, country.name AS CountryName " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("name")); // Set the city name
                city.setCountryOfCity(rs.getString("CountryName")); // Set the country name
                city.setCityDistrict(rs.getString("district")); // Set the district
                city.setCityPopulation(rs.getInt("Population")); // Set the population


                allCitiesWorld.add(city); // Add the city object to the list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesWorld;
    }

    /** report related to all the cities in a continent organised by largest population to smallest.
     * @return a List of City objects.
     */
    public List<City> getCitiesByContinentOrderedByPopulation() {
        List<City> allCitiesContinent = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = 'Africa' ORDER BY city.Population DESC";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("Name"));
                city.setCountryOfCity(rs.getString("CountryName"));
                city.setCityDistrict(rs.getString("District"));
                city.setCityPopulation(rs.getInt("Population"));

                allCitiesContinent.add(city);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesContinent;
    }

    /** report related to all the cities in a region organised by largest population to smallest.
     */
    public List<City> getCitiesByRegionOrderedByPopulation(){
        List<City> allCitiesRegion = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = 'Central Africa' ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("Name"));
                city.setCountryOfCity(rs.getString("CountryName"));
                city.setCityDistrict(rs.getString("District"));
                city.setCityPopulation(rs.getInt("Population"));

                allCitiesRegion.add(city);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesRegion;
    }

    /** report related to all the cities in a country organised by largest population to smallest.
     *
     */

    public List<City> getCitiesInCountryOrderedByPopulation() {
        List<City> allCitiesCountry = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            // SQL query to select cities in a specific country ordered by population
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name = 'France' ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("Name"));
                city.setCountryOfCity(rs.getString("CountryName"));
                city.setCityDistrict(rs.getString("District"));
                city.setCityPopulation(rs.getInt("Population"));

                allCitiesCountry.add(city); // Add the city object to the list
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesCountry;
    }

    /** report related to all the cities in a 'Bueno Aires' district organised by largest population to smallest.
     */
    public List<City> getCitiesInDistrict() {
        List<City> allCitiesDistrict = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            // Corrected SQL query to dynamically use the district parameter
            String sql = "SELECT city.name AS cityName, country.name AS countryName, city.District, city.population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = 'Buenos Aires' " +
                    "ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("cityName"));
                city.setCountryOfCity(rs.getString("countryName"));
                city.setCityDistrict(rs.getString("District"));
                city.setCityPopulation(rs.getInt("population"));

                allCitiesDistrict.add(city);
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesDistrict;
    }


/** report related to all the capital cities in the world organised by largest population to smallest.
        */
    public List<City> getAllCapitalCitiesByPopulation() {
        List<City> capitalCities = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "ORDER BY city.population DESC\n";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                capitalCities.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalCities;
    }

    /** All the capital cities in a continent organised by largest population to smallest.
     */

    public List<City> getCapitalCitiesByContinentOrderedByPopulation() {
        List<City> capitalInContinent = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                capitalInContinent.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalInContinent;
    }

    /** All the capital cities in a region organised by largest to smallest.
     *
     * @return
     */
    public List<City> getCapitalCitiesByRegionOrderedByPopulation() {
        List<City> capitalInRegion = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Central Africa'\n" +
                    "ORDER BY city.population DESC\n";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                capitalInRegion.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalInRegion;
    }


    /** retrieve and print all countries from Central Africa ordered by population in descending
     */
    public void displayCountries(List <Country> list){
        for (Country country : list) {
            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-27s Population: %,d Capital: %s\n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital());
        }
    }

    public void displayCities(List <City> list){
        for (City city : list) {
            System.out.printf(" City Name: %-30s Country Name: %-40s District: %-20s Population: %,d\n",
                    city.getCityName(),
                    city.getCountryOfCity(),
                    city.getCityDistrict(),
                    city.getCityPopulation());
        }
    }

    public void displayCapitalCities(List <City> list) {
        for (City city : list) {
            System.out.printf("Capital City in continent: %-25s Country Name: %-40s Population: %,d\n",
                    city.getCityName(),
                    city.getCountryCode(),
                    city.getCityPopulation());

        }
    }

    /** retrieves and print all the countries ordered by population by descending
     */

    public void displayCountriesOrderedByPopulation (List<Country> list){
        if (list == null){
            System.out.println("Country is Null");
        }
        // Now get all the ALL Countries
        //System.out.println("All Countries:");
        for (Country country : list) {

            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-25s Population: %,d Capital: %s\n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital());
        }
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Connect to database
       // a.connect();

        //All the countries in the world organised by largest population to smallest.
        List <Country> countryWorld = a.getCountries();
        System.out.println("All the countries in the world organised by largest population to smallest");
        a.displayCountries(countryWorld);

        //All the countries in a 'Africa' continent organised by largest population to smallest.
        List <Country> countryContinent = a.getCountriesInAfrica();
        System.out.println("All the countries in a 'Africa' continent organised by largest population to smallest.");
        a.displayCountries(countryContinent);

        //All the countries in a 'Central Africa' region organised by largest population to smallest.
        List <Country> countryRegion = a.getCountriesInCentralAfrica();
        System.out.println("All the countries in a 'Central Africa' region organised by largest population to smallest");
        a.displayCountries(countryRegion);

        //All the cities in the world organised by largest population to smallest.
        List <City> citiesWorld = a.getCitiesOrderedByPopulation();
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        a.displayCities(citiesWorld);

        //All the cities in a continent organised by largest population to smallest.
        List <City> citiesContinent = a.getCitiesByContinentOrderedByPopulation();
        System.out.println("All the cities in 'Africa' continent organised by largest population to smallest.");
        a.displayCities(citiesContinent);

        //All the cities in a region organised by largest population to smallest.
        List <City> citiesRegion = a.getCitiesByRegionOrderedByPopulation();
        System.out.println("All the cities in 'Central Africa' region organised by largest population to smallest.");
        a.displayCities(citiesRegion);

        //All the cities in a country organised by largest population to smallest.
        List <City> citiesCountry = a.getCitiesInCountryOrderedByPopulation();
        System.out.println("All the cities in 'France' country organised by largest population to smallest.");
        a.displayCities(citiesCountry);

        //All the cities in a district organised by largest population to smallest.
        List <City> citiesDistrict = a.getCitiesInDistrict();
        System.out.println("All the cities in 'Buenos Aires' district organised by largest population to smallest.");
        a.displayCities(citiesDistrict);

        //All the capital cities in the world organised by largest population to smallest.
        List <City> capitalCitiesWorld = a.getAllCapitalCitiesByPopulation();
        System.out.println("All the capital cities in the world organised by largest population to smallest.");
        a.displayCapitalCities(capitalCitiesWorld);

        //All the capital cities in a 'Africa' continent organised by largest population to smallest.
        List <City> capitalCitiesContinent = a.getCapitalCitiesByContinentOrderedByPopulation();
        System.out.println("All the capital cities in a 'Africa' continent organised by largest population to smallest.");
        a.displayCapitalCities(capitalCitiesContinent);

        //All the capital cities in a 'Central Africa' region organised by largest to smallest.
        List <City> capitalCitiesRegion = a.getCapitalCitiesByRegionOrderedByPopulation();
        System.out.println("All the capital cities in a 'Central Africa' region organised by largest population to smallest");
        a.displayCapitalCities(capitalCitiesRegion);


        // Disconnect from database
        a.disconnect();

    }
}
