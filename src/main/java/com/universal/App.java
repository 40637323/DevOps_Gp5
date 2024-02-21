/**
 * This class is the main class where the reports are generated. In this class, there are different public
 * methods where each report is represented. There are four main type of reports in the class. They are related
 * on country, city, capital city and population.
 */

package com.universal;

import java.sql.*;
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

    /**
     * Retrieves a list of countries from the world and orders them by population.
     * @return a List of Country objects
     */
    public List<Country> getCountries() {

        List<Country> countries = new ArrayList<>(); // create a new array list

        // Check connection is not null
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "ORDER BY country.population DESC");

            //use setter method to call the get method from country.java
            while (rs.next()) {
                Country country = new Country(); //create a new object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //set the country name
                country.setContinent(rs.getString("country.continent")); //set the country continent
                country.setRegion(rs.getString("country.region")); //set the country region
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city name

                countries.add(country); //add the country object to the list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }

        return countries; //return the array list which includes necessary information
    }
    /**
     * Retrieves a list of countries from the Asian continent and orders them by population.
     * @return a List of Country objects representing countries in Asia.
     */
    public List<Country> getCountriesInAsia() {
        List<Country> countries = new ArrayList<>(); //create a new array list

        //check to know if there is a connection
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }
        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "WHERE country.continent = 'Asia'\n" +
                    "ORDER BY country.population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //use setter method to call the get method from country.java
                Country country = new Country(); // create a new country object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //set the country name
                country.setContinent(rs.getString("country.continent")); //set the country continent
                country.setRegion(rs.getString("country.region")); //set the country region
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city name of the country

                countries.add(country); //add country object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return countries; //return the array list which includes necessary information
    }

    /** Retrieves a list of countries from the South East Asia region and orders them by population.
     * @return a List of Country for representing countries in South East Asia.
     */
    public List<Country> getCountriesInSouthEastAsia() {
        List<Country> countries = new ArrayList<>(); //create a new array list

        //check to know if there is connection
        if (con == null)
        {
            System.out.println("No connection");
            return countries;
        }

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name " +
                    "FROM city " +
                    "INNER JOIN country " +
                    "ON city.id = country.capital " +
                    "WHERE country.continent = 'Asia' AND country.region = 'Southeast Asia' " +
                    "ORDER BY country.population DESC ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //use setter method to call the get method from country.java
                Country country = new Country(); //create a new country object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //set the country name
                country.setContinent(rs.getString("country.continent")); //set the country continent
                country.setRegion(rs.getString("country.region")); //set the country region
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city name of the country

                countries.add(country); //add country object to the array list "countries"
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return countries;  //return the array list which includes necessary information
    }

    /** report related to all the cities in the world organised by largest population to smallest.
     * */
    public List<City> getCitiesOrderedByPopulation() {
        List<City> allCitiesWorld = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, city.district, city.Population, country.name AS CountryName " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            //use the setter method to get the city data
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("name")); // Set the city name
                city.setCountryOfCity(rs.getString("CountryName")); // Set the country name
                city.setCityDistrict(rs.getString("district")); // Set the district
                city.setCityPopulation(rs.getInt("Population")); // Set the population


                allCitiesWorld.add(city); // Add the city object to the list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesWorld; //return the array list which includes necessary information
    }

    /** report related to all the cities in a continent organised by largest population to smallest.
     * @return a List of City objects.
     */
    public List<City> getCitiesByContinentOrderedByPopulation() {
        List<City> allCitiesContinent = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent = 'Africa' ORDER BY city.Population DESC";

            ResultSet rs = stmt.executeQuery(sql);

            //use setter method to call the get method from city.java
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("Name")); // set the city name
                city.setCountryOfCity(rs.getString("CountryName")); //set the country name of that city
                city.setCityDistrict(rs.getString("District")); //set the city district
                city.setCityPopulation(rs.getInt("Population")); //set the city population

                allCitiesContinent.add(city); //add a city object to the array list
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesContinent;  //return the array list which includes necessary information
    }

    /** report related to all the cities in a region organised by largest population to smallest.
     */
    public List<City> getCitiesByRegionOrderedByPopulation(){
        List<City> allCitiesRegion = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = 'Central Africa' ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            //use setter method to call the get method from city.java
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("Name")); //set the city name
                city.setCountryOfCity(rs.getString("CountryName")); //set the country name of that city
                city.setCityDistrict(rs.getString("District")); //set the city district
                city.setCityPopulation(rs.getInt("Population")); //set the city population

                allCitiesRegion.add(city); //add the city object to the array list
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesRegion; //return the array list which includes necessary information
    }

    /** report related to all the cities in a country organised by largest population to smallest.
     *
     */

    public List<City> getCitiesInCountryOrderedByPopulation() {
        List<City> allCitiesCountry = new ArrayList<>(); //create a new array list
        try (Statement stmt = con.createStatement()) {
            // SQL query to select cities in a specific country ordered by population
            String sql = "SELECT city.Name, city.District, city.Population, country.name AS CountryName " +
                    "FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name = 'France' ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            //use setter method to call the get method from city.java
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("Name")); //set the city name
                city.setCountryOfCity(rs.getString("CountryName")); ///set the country name of that city
                city.setCityDistrict(rs.getString("District")); //set the city district
                city.setCityPopulation(rs.getInt("Population")); //set the city population

                allCitiesCountry.add(city); // Add the city object to the list
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesCountry; //return the array list which includes necessary information
    }

    /** report related to all the cities in a 'Bueno Aires' district organised by largest population to smallest.
     */
    public List<City> getCitiesInDistrict() {
        List<City> allCitiesDistrict = new ArrayList<>(); //create a new array list
        try (Statement stmt = con.createStatement()) {
            // Corrected SQL query to use the district parameter
            String sql = "SELECT city.name AS cityName, country.name AS countryName, city.District, city.population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District = 'Buenos Aires' " +
                    "ORDER BY city.Population DESC";
            ResultSet rs = stmt.executeQuery(sql);

            //use setter method to call the get method from city.java
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("cityName")); //set the city name
                city.setCountryOfCity(rs.getString("countryName")); //set the country name where the city locates
                city.setCityDistrict(rs.getString("District")); // set the city district
                city.setCityPopulation(rs.getInt("population")); //set the city population

                allCitiesDistrict.add(city); //add the city object to the array list
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allCitiesDistrict; //return the array list which includes necessary information
    }


    /** report related to all the capital cities in the world organised by largest population to smallest.
     */
    public List<City> getAllCapitalCitiesByPopulation() {
        List<City> capitalCities = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "ORDER BY city.population DESC\n";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the county name
                city.setCityPopulation(rs.getInt("city.Population")); //set the capital city population

                capitalCities.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalCities; //return the array list which includes necessary information
    }

    /** All the capital cities in a continent organised by largest population to smallest.
     */

    public List<City> getCapitalCitiesByContinentOrderedByPopulation() {
        List<City> capitalInContinent = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n";

            //returns an instance of ResultSet when a select query is executed
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the country name
                city.setCityPopulation(rs.getInt("city.Population")); //set the population of capital city

                capitalInContinent.add(city); //add city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalInContinent; //return the array list which includes necessary information
    }

    /** All the capital cities in a region organised by largest to smallest.
     *
     * @return the list of city object
     */
    public List<City> getCapitalCitiesByRegionOrderedByPopulation() {
        List<City> capitalInRegion = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Central Africa'\n" +
                    "ORDER BY city.population DESC";

            //returns an instance of ResultSet when a select query is executed
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the country name
                city.setCityPopulation(rs.getInt("city.Population")); //set the capital city population

                capitalInRegion.add(city); //add city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return capitalInRegion; //return the array list which includes necessary information
    }


    /**
     * Retrieves a list of Top 7 Countries form world, ordered by population in descending order.
     */
    public List<Country> getTopSevenCountriesInWorldByPopulation() {
        List<Country> topCountries = new ArrayList<>(); //create a new array list

        //check to know if there is connection
        if (con == null)
        {
            System.out.println("No connection");
            return topCountries;
        }

        //execute the query form database
        String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                "FROM city\n" +
                "INNER JOIN country\n" +
                "ON city.id = country.capital\n" +
                "ORDER BY country.population DESC \n"+
                "LIMIT 7";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            //use the setter method to get the output for the top 7 countries in world
            while (rs.next()) {
                Country country = new Country(); //create a new country object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //sett the country name
                country.setContinent(rs.getString("country.continent")); //set the continent of related country
                country.setRegion(rs.getString("country.region")); //set the region of the country
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city name of the country

                topCountries.add(country); //add the country object to the arry list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCountries; //return the array list which includes necessary information
    }
    /**
     * Retrieves a list of Top 7 Countries form 'Asia' continent, ordered by population in descending order.
     */
    public List<Country> getTopSevenCountriesInAsiaByPopulation() {
        List<Country> topCountriesContinent = new ArrayList<>(); //create a new array list

        //check to know if there is connection
        if (con == null)
        {
            System.out.println("No connection");
            return topCountriesContinent;
        }

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "WHERE country.continent = 'Asia'\n" +
                    "ORDER BY country.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);

            //use the setter method to get the output for the top 7 countries in Asia
            while (rs.next()) {
                Country country = new Country(); //create a country object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //set the country name
                country.setContinent(rs.getString("country.continent")); //set the country's continent
                country.setRegion(rs.getString("country.region")); //set the country's region
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city name of the country

                topCountriesContinent.add(country); //add country object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCountriesContinent; //return the array list which includes necessary information
    }

    /**
     * Retrieves a list top 7 countries from the SouthEast Asia region and orders them by population.
     * @return a List of Country for representing countries in Central Africa.
     */
    public List<Country> getTopSevenCountriesInSouthEastAsia() {
        List<Country> topSevenCountriesInRegion = new ArrayList<>(); //create a new array list

        //check to know if there is connection
        if (con == null)
        {
            System.out.println("No connection");
            return topSevenCountriesInRegion;
        }

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "WHERE country.continent = 'Asia' AND country.region = 'Southeast Asia'\n" +
                    "ORDER BY country.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);

            //use the setter method to get the output for the top 7 countries in South East Asia
            while (rs.next()) {
                Country country = new Country(); //create the country object
                country.setCode(rs.getString("country.code")); //set the country code
                country.setName(rs.getString("country.name")); //set the country name
                country.setContinent(rs.getString("country.continent")); //set the country's continent
                country.setRegion(rs.getString("country.region")); //set the country's region
                country.setPopulation(rs.getLong("country.population")); //set the country population
                country.setCapital(rs.getString("city.name")); //set the capital city of the country

                topSevenCountriesInRegion.add(country); //add the country object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topSevenCountriesInRegion; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated cities in the world
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInWorldOrderedByPopulation() {
        List<City> topCitiesInWorld= new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the city name
                city.setCountryOfCity(rs.getString("country.name")); //set the country name
                city.setCityDistrict(rs.getString("city.district")); //set the city's district
                city.setCityPopulation(rs.getInt("city.population")); //set the city population

                topCitiesInWorld.add(city); //add the city object to the array list

            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInWorld; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated cities in the continent africa
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInContinentOrderedByPopulation() {
        List<City> topCitiesInAfricaContinent = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the city name
                city.setCountryOfCity(rs.getString("country.name")); //set the country name
                city.setCityDistrict(rs.getString("city.district")); //set the city's district
                city.setCityPopulation(rs.getInt("city.population")); //set the city population

                topCitiesInAfricaContinent.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInAfricaContinent; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated cities in a region 'western Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInRegionOrderedByPopulation() {
        List<City> topCitiesInWesternAfricaRegion = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the city name
                city.setCountryOfCity(rs.getString("country.name")); //set the country name
                city.setCityDistrict(rs.getString("city.district")); //set the city's district
                city.setCityPopulation(rs.getInt("city.population")); //set the city population

                topCitiesInWesternAfricaRegion.add(city); // add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInWesternAfricaRegion; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated cities in 'Nigeria' country in a region 'Central Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInCountryOrderedByPopulation() {
        List<City> topCitiesInNigeriaCountry = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa' AND country.name = 'Nigeria'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create the city object
                city.setCityName(rs.getString("city.name")); //set the city name
                city.setCountryOfCity(rs.getString("country.name")); //set the country name
                city.setCityDistrict(rs.getString("city.district")); //set the city's district
                city.setCityPopulation(rs.getInt("city.population")); //set the city population

                topCitiesInNigeriaCountry.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInNigeriaCountry; //return the array list which includes necessary information
    }
    /**retrieves a list of top seven populated cities in district 'Oyo & Osun' from 'Nigeria' country in a region 'Central Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInDistrictOrderedByPopulation() {
        List<City> topCitiesInOyoAndOsunDistrict = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa' AND country.name = 'Nigeria' AND city.district = 'Oyo & Osun'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the city name
                city.setCountryOfCity(rs.getString("country.name")); //set the country name
                city.setCityDistrict(rs.getString("city.district")); //set the city's district
                city.setCityPopulation(rs.getInt("city.population")); //set the city population

                topCitiesInOyoAndOsunDistrict.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInOyoAndOsunDistrict; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated capital cities in the world
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesOrderedByPopulation() {
        List<City> topCapitalInWorld = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the country name
                city.setCityPopulation(rs.getInt("city.Population")); //set the capital city's population

                topCapitalInWorld.add(city); // add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInWorld; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated capital cities in the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesByContinentOrderedByPopulation() {
        List<City> topCapitalInContinent = new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the country name
                city.setCityPopulation(rs.getInt("city.Population")); //set the city population

                topCapitalInContinent.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInContinent; //return the array list which includes necessary information
    }

    /**retrieves a list of top seven populated capital cities in the 'Central Africa' Region
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesByRegionOrderedByPopulation() {
        List<City> topCapitalInRegion= new ArrayList<>(); //create a new array list

        //execute the query form database
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Central Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";

            //returns an instance of ResultSet when a select query is executed.
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                City city = new City(); //create a new city object
                city.setCityName(rs.getString("city.name")); //set the capital city name
                city.setCountryCode(rs.getString("country.name")); //set the country name
                city.setCityPopulation(rs.getInt("city.Population")); //set the capital city's population

                topCapitalInRegion.add(city); //add the city object to the array list
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInRegion;
    }

    /** retrieve and print all countries ordered by population in descending
     */
    public void displayCountries(List<Country> list) {

        //check to know if there is connection
        if (con == null) {
            System.out.println("No connection");
            return;
        }

        //table header
        System.out.println("+-------+----------------------------------------+-----------------+-------------------------------+----------------+--------------------------------------+");
        System.out.println("| Code  | Name                                   | Continent       | Region                        | Population     | Capital                              |");
        System.out.println("+-------+----------------------------------------+-----------------+-------------------------------+----------------+--------------------------------------+");

        for (Country country : list) {
            //output the data using getter method
            try {
                System.out.printf("| %-5s | %-38s | %-15s | %-29s | %,14d | %-36s |\n",
                        country.getCode(),
                        country.getName(),
                        country.getContinent(),
                        country.getRegion(),
                        country.getPopulation(),
                        country.getCapital());
            } catch (NullPointerException e) {
                System.out.println("There is a Null value: " + e.getMessage());
            }
        }

        System.out.println("+-------+----------------------------------------+-----------------+-------------------------------+----------------+---------------------------------------+");
    }

    /** retrieve and print all Cities ordered by population in descending
     */

    public void displayCities(List<City> list) {

        //table header
        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");
        System.out.println("| City Name                              | Country Name                           | District                               | Population       |");
        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");

        //output the data using get method
        for (City city : list) {
            System.out.printf("| %-38s | %-38s | %-38s | %,15d |\n",
                    city.getCityName(),
                    city.getCountryOfCity(),
                    city.getCityDistrict(),
                    city.getCityPopulation());
        }

        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");
    }

    /** retrieve and print all capital cities ordered by population in descending
     */
    public void displayCapitalCities(List<City> list) {

        //table header
        System.out.println("+----------------------------------------+----------------------------------------+--------------+");
        System.out.println("| Capital City                           | Country Name                           | Population   |");
        System.out.println("+----------------------------------------+----------------------------------------+--------------+");

        //output the data using getter method
        for (City city : list) {
            System.out.printf("| %-38s | %-38s | %,12d |\n",
                    city.getCityName(),
                    city.getCountryCode(),
                    city.getCityPopulation());
        }

        System.out.println("+----------------------------------------+----------------------------------------+--------------+");
    }


    /** Display The population of people, people living in cities, and people not living in cities in each continent.
     *
     */
    public void printPopulationOfLivingOrNotLivinginContinentReport() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("Print Population Of Living Or Not Living in Continent Report");
            return;
        }
        //implement query for getting output the population of living or not living continent report
        String sql = "SELECT " +
                "country.Continent, " +
                "SUM(DISTINCT country.Population) AS TotalPopulation, " +
                "SUM(city.Population) AS CityPopulation, " +
                "(SUM(DISTINCT country.Population) - SUM(city.Population)) AS NonCityPopulation " +
                "FROM country " +
                "JOIN city ON country.Code = city.CountryCode " +
                "GROUP BY country.Continent;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of people, people living in cities, and people not living in cities in each continent\u001B[0m");
            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Continent            | Total Population    | City Population     | City Population %   | Non-City Population | Non-City Population %|");
            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            //output the data using get method
            while (rs.next()) {
                String continent = rs.getString("Continent"); //get the name of continent
                long totalPopulation = rs.getLong("TotalPopulation"); //get the total population
                long cityPopulation = rs.getLong("CityPopulation"); //get the city population
                long nonCityPopulation = rs.getLong("NonCityPopulation"); //get the population in rural area

                double cityPopulationPercentage = (double) cityPopulation / totalPopulation * 100; //calculate the population of the city
                double nonCityPopulationPercentage = (double) nonCityPopulation / totalPopulation * 100; //calculate the population of people in rural area

                //adding the necessary data to the table
                System.out.printf("| %-20s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        continent, totalPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /**The population of people, people living in cities, and people not living in cities in each region.
     *
     */
    public void printPopulationOfLivingOrNotLivinginRegionReport() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("No database connection.");
            return;
        }
        //implement query for getting output the population of living or not living region report
        String sql = "SELECT " +
                "country.Region, " +
                "SUM(country.Population) AS TotalRegionPopulation, " +
                "COALESCE(SUM(cityPop.CityPopulation), 0) AS CityPopulation, " +
                "(SUM(country.Population) - COALESCE(SUM(cityPop.CityPopulation), 0)) AS NonCityPopulation " +
                "FROM country " +
                "LEFT JOIN (SELECT CountryCode, SUM(Population) AS CityPopulation FROM city GROUP BY CountryCode) cityPop " +
                "ON country.Code = cityPop.CountryCode " +
                "GROUP BY country.Region;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of people, people living in cities, and people not living in cities in each region\u001B[0m");
            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Region                    | Total Population    | City Population     | City Pop. %         | Non-City Population | Non-City Pop. %     |");
            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            while (rs.next()) {
                //output the data using getter method
                String region = rs.getString("Region"); //get the name of the region
                long totalRegionPopulation = rs.getLong("TotalRegionPopulation"); //get the total population
                long cityPopulation = rs.getLong("CityPopulation"); //get the city population
                long nonCityPopulation = rs.getLong("NonCityPopulation"); //get the population in rural area

                double cityPopulationPercentage = totalRegionPopulation > 0 ? (double) cityPopulation / totalRegionPopulation * 100 : 0; //get the population of people in urban area
                double nonCityPopulationPercentage = totalRegionPopulation > 0 ? (double) nonCityPopulation / totalRegionPopulation * 100 : 0; //get the population of people in rural area

                //set information in the table
                System.out.printf("| %-25s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        region, totalRegionPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /**The population of people, people living in cities, and people not living in cities in each country
     *
     */
    public void printPopulationOfLivingOrNotLivinginCountryReport() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("No database connection.");
            return;
        }
        //implement query for getting output the population of living or not living country report
        String sql = "SELECT " +
                "c.Name AS Country, " +
                "c.Population AS TotalPopulation, " +
                "LEAST(c.Population, IFNULL(SUM(ct.Population), 0)) AS CityPopulation, " +
                "(c.Population - LEAST(c.Population, IFNULL(SUM(ct.Population), 0))) AS NonCityPopulation " +
                "FROM country c " +
                "LEFT JOIN city ct ON c.Code = ct.CountryCode " +
                "GROUP BY c.Name, c.Population;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of people, people living in cities, and people not living in cities in each country\u001B[0m");
            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Country                                | Total Population    | City Population     | City Pop. %         | Non-City Population | Non-City Pop. %     |");
            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            while (rs.next()) {
                String country = rs.getString("Country"); //get the country name
                long totalPopulation = rs.getLong("TotalPopulation"); //get the total population of the country
                long cityPopulation = rs.getLong("CityPopulation"); //get the population of people in urban area
                long nonCityPopulation = rs.getLong("NonCityPopulation"); //get the population of people in rural area

                double cityPopulationPercentage = totalPopulation > 0 ? (double) cityPopulation / totalPopulation * 100 : 0; //get the percentage of the population of people in urban area
                double nonCityPopulationPercentage = totalPopulation > 0 ? (double) nonCityPopulation / totalPopulation * 100 : 0; //get the percentage of population of people in rural area

                //set information in the table
                System.out.printf("| %-38s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        country, totalPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /**Display numbers of speakers in Chinese, English, Hindi, Spanish and Arabic
     *
     */
    public void printSelectedLanguageSpeakers() {
        if (con == null) {
            System.out.println("printSelectedLanguageSpeakers");
            return;
        }
        //implement query for getting output the selected language speaker
        String sql = "SELECT " +
                "cl.Language, " +
                "SUM((cl.Percentage / 100) * c.Population) AS NumberOfSpeakers, " +
                "(SUM((cl.Percentage / 100) * c.Population) / (SELECT SUM(Population) FROM country) * 100) AS WorldPopulationPercentage " +
                "FROM countrylanguage cl " +
                "JOIN country c ON cl.CountryCode = c.Code " +
                "WHERE cl.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') " +
                "GROUP BY cl.Language " +
                "ORDER BY NumberOfSpeakers DESC;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mSelected Language Speakers Report\u001B[0m");
            System.out.println("+-------------+------------------------+-------------------------------+");
            System.out.println("| Language    | Number of Speakers     | World Population Percentage   |");
            System.out.println("+-------------+------------------------+-------------------------------+");

            while (rs.next()) {
                //get the data to get the output
                String language = rs.getString("Language"); //get the language name
                long numberOfSpeakers = rs.getLong("NumberOfSpeakers"); //get the number of speakers in each language
                double worldPopulationPercentage = rs.getDouble("WorldPopulationPercentage"); //get the percentage of the speakers when comparing to world population

                //set information in the table
                System.out.printf("| %-11s | %,22d | %,29.2f%% |\n",
                        language, numberOfSpeakers, worldPopulationPercentage);
            }

            System.out.println("+-------------+------------------------+-------------------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /**Display World Population */
    public void printWorldPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printWorldPopulation");
            return;
        }
        //implement query for getting world population
        String sql = "SELECT SUM(Population) AS WorldPopulation FROM country;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of the world\u001B[0m");
            System.out.println("+------------------+");
            System.out.println("| World Population |");
            System.out.println("+------------------+");

            //set the world population in the table
            if (rs.next()) {
                long worldPopulation = rs.getLong("WorldPopulation");
                System.out.printf("| %,16d |\n", worldPopulation);
            }

            System.out.println("+------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /** Display Continent Population */
    public void printContinentPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printContinentPopulation");
            return;
        }
        //implement query for getting continent population
        String sql = "SELECT Continent, SUM(Population) AS ContinentPopulation FROM country GROUP BY Continent;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of a continent\u001B[0m");
            System.out.println("+-------------------+---------------------+");
            System.out.println("| Continent         | Population          |");
            System.out.println("+-------------------+---------------------+");

            while (rs.next()) {
                //use get method to get the data
                String continent = rs.getString("Continent"); //get the name of continent
                long continentPopulation = rs.getLong("ContinentPopulation"); //get the population of continent
                System.out.printf("| %-17s | %,19d |\n", continent, continentPopulation); //set information in the table
            }

            System.out.println("+-------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /** Display Region Population */
    public void printRegionPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printRegionPopulation");
            return;
        }
        //implement query for getting region population
        String sql = "SELECT Region, SUM(Population) AS RegionPopulation FROM country GROUP BY Region;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of a region\u001B[0m");
            System.out.println("+----------------------+---------------------+");
            System.out.println("| Region               | Population          |");
            System.out.println("+----------------------+---------------------+");

            while (rs.next()) {
                String region = rs.getString("Region"); //get the name of region
                long regionPopulation = rs.getLong("RegionPopulation"); //get the population of region
                System.out.printf("| %-20s | %,19d |\n", region, regionPopulation); //set the information in the table
            }

            System.out.println("+----------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /** Display Country Population */
    public void printCountryPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printCountryPopulation");
            return;
        }
        //implement query for getting country population
        String sql = "SELECT Name, Population FROM country ORDER BY Name;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of a country\u001B[0m");
            System.out.println("+----------------------------------------------------+---------------------+");
            System.out.println("| Country                                            | Population          |");
            System.out.println("+----------------------------------------------------+---------------------+");

            while (rs.next()) {
                //use the get method to show the country population
                String countryName = rs.getString("Name"); //get the name of the country
                long population = rs.getLong("Population"); //get the population of the country
                System.out.printf("| %-50s | %,19d |\n", countryName, population); //set information in the table
            }

            System.out.println("+----------------------------------------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /** District Population */
    public void printDistrictPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printDistrictPopulation");
            return;
        }
        //implement query for getting district population
        String sql = "SELECT District, SUM(Population) AS DistrictPopulation FROM city GROUP BY District ORDER BY District;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of a district\u001B[0m");
            System.out.println("+--------------------------------+---------------------+");
            System.out.println("| District                       | Population          |");
            System.out.println("+--------------------------------+---------------------+");

            while (rs.next()) {
                //use the get method to show the output of district population
                String district = rs.getString("District"); //get the district name
                long districtPopulation = rs.getLong("DistrictPopulation"); //get the population of district
                System.out.printf("| %-30s | %,19d |\n", district, districtPopulation); //set information in the table
            }

            System.out.println("+--------------------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    /** Display City Population */
    public void printCityPopulation() {

        //check to know if there is connection
        if (con == null) {
            System.out.println("printCityPopulation");
            return;
        }
        //implement query for getting city population
        String sql = "SELECT Name, Population FROM city ORDER BY Name;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            //table header
            System.out.println("\u001B[1mThe population of a city\u001B[0m");
            System.out.println("+--------------------------------+---------------------+");
            System.out.println("| City                           | Population          |");
            System.out.println("+--------------------------------+---------------------+");

            while (rs.next()) {
                //use the get method to show the output of city population
                String cityName = rs.getString("Name"); //get the name of the city
                long population = rs.getLong("Population"); //get the population of the city
                System.out.printf("| %-30s | %,19d |\n", cityName, population); //set information in the table
            }
            System.out.println("+--------------------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }



    /** collections to display related queries in the output section
     */

    public void displayAllQuery() {
        String ANSI_BOLD1 = "\u001B[1m"; // ANSI escape code for bold
        String ANSI_RESET1 = "\u001B[0m"; // ANSI escape code to reset formatting

        //All the countries in the world organised by largest population to smallest.
        List <Country> countryWorld = getCountries();
        System.out.printf(ANSI_BOLD1 + "All the countries in the world organised by largest population to smallest\n" + ANSI_RESET1);
        displayCountries(countryWorld);

        //All the countries in a 'Asia' continent organised by largest population to smallest.
        List <Country> countryContinent = getCountriesInAsia();
        System.out.println(ANSI_BOLD1 + "All the countries in a 'Asia' continent organised by largest population to smallest\n" + ANSI_RESET1);
        displayCountries(countryContinent);

        //All the countries in a 'SouthEast Asia' region organised by largest population to smallest.
        List <Country> countryRegion = getCountriesInSouthEastAsia();
        System.out.println(ANSI_BOLD1 + "All the countries in a 'South East Asia' region organised by largest population to smallest\n" + ANSI_RESET1);
        displayCountries(countryRegion);

        //All the cities in the world organised by largest population to smallest.
        List <City> citiesWorld = getCitiesOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the cities in the world organised by largest population to smallest" + ANSI_RESET1);
        displayCities(citiesWorld);

        //All the cities in a continent organised by largest population to smallest.
        List <City> citiesContinent = getCitiesByContinentOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the cities in 'Africa' continent organised by largest population to smallest" + ANSI_RESET1);
        displayCities(citiesContinent);

        //All the cities in a region organised by largest population to smallest.
        List <City> citiesRegion = getCitiesByRegionOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the cities in 'Central Africa' region organised by largest population to smallest" + ANSI_RESET1);
        displayCities(citiesRegion);

        //All the cities in a country organised by largest population to smallest.
        List <City> citiesCountry = getCitiesInCountryOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the cities in 'France' country organised by largest population to smallest" + ANSI_RESET1);
        displayCities(citiesCountry);

        //All the cities in a district organised by largest population to smallest.
        List <City> citiesDistrict = getCitiesInDistrict();
        System.out.println(ANSI_BOLD1 + "All the cities in 'Buenos Aires' district organised by largest population to smallest" + ANSI_RESET1);
        displayCities(citiesDistrict);

        //All the capital cities in the world organised by largest population to smallest.
        List <City> capitalCitiesWorld = getAllCapitalCitiesByPopulation();
        System.out.println(ANSI_BOLD1 + "All the capital cities in the world organised by largest population to smallest" + ANSI_RESET1);
        displayCapitalCities(capitalCitiesWorld);

        //All the capital cities in a 'Africa' continent organised by largest population to smallest.
        List <City> capitalCitiesContinent = getCapitalCitiesByContinentOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the capital cities in a 'Africa' continent organised by largest population to smallest" + ANSI_RESET1);
        displayCapitalCities(capitalCitiesContinent);

        //All the capital cities in a 'Central Africa' region organised by largest to smallest.
        List <City> capitalCitiesRegion = getCapitalCitiesByRegionOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "All the capital cities in a 'Central Africa' region organised by largest population to smallest" + ANSI_RESET1);
        displayCapitalCities(capitalCitiesRegion);

        //The top 7 populated countries in the world
        List <Country> topSevenCountriesWorld = getTopSevenCountriesInWorldByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated countries in the world" + ANSI_RESET1);
        displayCountries(topSevenCountriesWorld);

        //The top 7 populated countries in a continent
        List <Country> topSevenCountriesContinent = getTopSevenCountriesInAsiaByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated countries in the 'Asia' continent" + ANSI_RESET1);
        displayCountries(topSevenCountriesContinent);

        //The top 7 populated countries in a region
        List <Country> topSevenCountriesRegion = getTopSevenCountriesInSouthEastAsia();
        System.out.println(ANSI_BOLD1 + "The top 7 populated countries in the 'SouthEast Asia' region" + ANSI_RESET1);
        displayCountries(topSevenCountriesRegion);

        //The top 7 populated cities in the world
        List <City> topSevenCitiesWorld= getTopSevenCitiesInWorldOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated cities in the World" + ANSI_RESET1);
        displayCities(topSevenCitiesWorld);

        //The top 7 populated cities in a continent
        List <City> topSevenCitiesInAfrica = getTopSevenCitiesInContinentOrderedByPopulation() ;
        System.out.println(ANSI_BOLD1 + "The top 7 populated cities in the 'Africa' continent" + ANSI_RESET1);
        displayCities(topSevenCitiesInAfrica);

        //The top 7 populated cities in a region
        List <City> topSevenCitiesInRegion = getTopSevenCitiesInRegionOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated cities in the 'Western Africa' region" + ANSI_RESET1);
        displayCities(topSevenCitiesInRegion);

        //The top 7 populated cities in a country
        List <City> topSevenCitiesInCountry = getTopSevenCitiesInCountryOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated cities in the 'Nigeria' country" + ANSI_RESET1);
        displayCities(topSevenCitiesInCountry);

        //The top 7 populated cities in a district
        List <City> topSevenCitiesInDistrict = getTopSevenCitiesInDistrictOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated cities in the 'Oyo & Osun' District from 'Nigeria' country" + ANSI_RESET1);
        displayCities(topSevenCitiesInDistrict);

        //The top 7 populated capital cities in the world
        List <City> topSevenCapitalCitiesInWorld = getTopSevenCapitalCitiesOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated capital cities in the world" + ANSI_RESET1);
        displayCapitalCities(topSevenCapitalCitiesInWorld);

        //The top 7 populated capital cities in a continent
        List <City> topSevenCapitalCitiesInContinent = getTopSevenCapitalCitiesByContinentOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated capital cities in the 'Africa' continent" + ANSI_RESET1);
        displayCapitalCities(topSevenCapitalCitiesInContinent);

        //The top 7 populated capital cities in a region
        List <City> topSevenCapitalCitiesInRegion = getTopSevenCapitalCitiesByRegionOrderedByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated capital cities in the 'Central Africa' region" + ANSI_RESET1);
        displayCapitalCities(topSevenCapitalCitiesInRegion);

    }

    /** the reports are shown in the output section
     *
     */
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
        a.displayAllQuery();
        a.printPopulationOfLivingOrNotLivinginContinentReport();
        a.printPopulationOfLivingOrNotLivinginRegionReport();
        a.printPopulationOfLivingOrNotLivinginCountryReport();
        a.printSelectedLanguageSpeakers();
        a.printWorldPopulation();
        a.printContinentPopulation();
        a.printRegionPopulation();
        a.printCountryPopulation();
        a.printDistrictPopulation();
        a.printCityPopulation();

        // Disconnect from database
        a.disconnect();

    }
}