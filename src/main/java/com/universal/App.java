package com.universal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
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
    /**
     * Retrieves a list of cities and orders them by population in descending order.
     * @return a List of City.
     */
    public List<City> getCitiesOrderedByPopulation() {
        List<City> cities = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT ID, name, CountryCode, district, Population FROM city ORDER BY Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                City city = new City();
                city.setID(rs.getInt("ID"));
                city.setName(rs.getString("name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("district"));
                city.setPopulation(rs.getInt("Population"));

                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return cities;
    }


    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Now get all the ALL Countries
        List<Country> countries = a.getCountries();
        System.out.println("All Countries:");
        for (Country country : countries) {
            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-25s Population: %,d Capital: %s\n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital());
        }
        // Now get countries from Africa and print them
        List<Country> africanCountries = a.getCountriesInAfrica(); // Use a different variable for African countries
        System.out.println("\nAfrican Countries:");
        for (Country country : africanCountries) {
            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-25s Population: %,d Capital: %s\n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital());
        }
        // Get countries from Central Africa and print them
        List<Country> centralAfricanCountries = a.getCountriesInCentralAfrica();
        System.out.println("Central African Countries:");
        for (Country country : centralAfricanCountries) {
            System.out.printf("Country Code: %-5s Name: %-40s Continent: %-15s Region: %-25s Population: %,d Capital: %s\n",
                    country.getCode(),
                    country.getName(),
                    country.getContinent(),
                    country.getRegion(),
                    country.getPopulation(),
                    country.getCapital());
        }
        // Retrieve and print cities ordered by population
        List<City> cities = a.getCitiesOrderedByPopulation();
        System.out.println("Cities Ordered by Population:");
        for (City city : cities) {
            System.out.printf("ID: %-5d Name: %-30s Country Code: %-5s District: %-20s Population: %,d\n",
                    city.getID(),
                    city.getName(),
                    city.getCountryCode(),
                    city.getDistrict(),
                    city.getPopulation());
        }

        // Disconnect from database
        a.disconnect();
    }
}
