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

    /** report related to all the capital cities in the world organised by largest population to smallest.
        */

    public List<City> getAllCapitalCitiesByPopulation() {
        List<City> capitalCities = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
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
                    "ON city.countryCode = country.code\n" +
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
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.region = 'Central Africa'\n" +
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
            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-25s Population: %,d Capital: %s\n",
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
            System.out.printf(" City Name: %-30s Country Name: %-15s District: %-20s Population: %,d\n",
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


        // show all countries in the world ordered by population in descending
        List<Country> worldList = a.getCountries();
        List<Country> continentList= a.getCountriesInAfrica();
        List<Country> regionList = a.getCountriesInCentralAfrica();
        System.out.println("All Countries:");
        a.displayCountriesOrderedByPopulation(worldList);
        System.out.println("All Countries In Africa:");
        a.displayCountriesOrderedByPopulation(continentList);
        System.out.println("All Countries In Central Africa Region:");
        a.displayCountriesOrderedByPopulation(regionList);



        // Disconnect from database
        a.disconnect();
    }
}
