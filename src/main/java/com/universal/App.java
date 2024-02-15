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
     * Retrieves a list of Top 7 Countries form world, ordered by population in descending order.
     */
    public List<Country> getTopSevenCountriesInWorldByPopulation() {
        List<Country> topCountries = new ArrayList<>();
        if (con == null)
        {
            System.out.println("No connection");
            return topCountries;
        }
        String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                "FROM city\n" +
                "INNER JOIN country\n" +
                "ON city.id = country.capital\n" +
                "ORDER BY country.population DESC \n"+
                "LIMIT 7";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("country.code"));
                country.setName(rs.getString("country.name"));
                country.setContinent(rs.getString("country.continent"));
                country.setRegion(rs.getString("country.region"));
                country.setPopulation(rs.getLong("country.population"));
                country.setCapital(rs.getString("city.name"));
                // Set other attributes as necessary

                topCountries.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCountries;
    }
    /**
     * Retrieves a list of Top 7 Countries form 'Asia' continent, ordered by population in descending order.
     */
    public List<Country> getTopSevenCountriesInAsiaByPopulation() {
        List<Country> topCountriesContinent = new ArrayList<>();
        if (con == null)
        {
            System.out.println("No connection");
            return topCountriesContinent;
        }
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "WHERE country.continent = 'Asia'\n" +
                    "ORDER BY country.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("country.code"));
                country.setName(rs.getString("country.name"));
                country.setContinent(rs.getString("country.continent"));
                country.setRegion(rs.getString("country.region"));
                country.setPopulation(rs.getLong("country.population"));
                country.setCapital(rs.getString("city.name"));
                // Set other attributes as necessary

                topCountriesContinent.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCountriesContinent;
    }

    /**
     * Retrieves a list top 7 countries from the SouthEast Asia region and orders them by population.
     * @return a List of Country for representing countries in Central Africa.
     */
    public List<Country> getTopSevenCountriesInSouthEastAsia() {
        List<Country> topSevenCountriesInRegion = new ArrayList<>();
        if (con == null)
        {
            System.out.println("No connection");
            return topSevenCountriesInRegion;
        }
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name\n" +
                    "FROM cit\n" +
                    "INNER JOIN country\n" +
                    "ON city.id = country.capital\n" +
                    "WHERE country.continent = 'Asia' AND country.region = 'Southeast Asia'\n" +
                    "ORDER BY country.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("country.code"));
                country.setName(rs.getString("country.name"));
                country.setContinent(rs.getString("country.continent"));
                country.setRegion(rs.getString("country.region"));
                country.setPopulation(rs.getLong("country.population"));
                country.setCapital(rs.getString("city.name"));
                // Set other attributes as necessary

                topSevenCountriesInRegion.add(country);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topSevenCountriesInRegion;
    }

    /**retrieves a list of top seven populated cities in the world
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInWorldOrderedByPopulation() {
        List<City> topCitiesInWorld= new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryOfCity(rs.getString("country.name"));
                city.setCityDistrict(rs.getString("city.district"));
                city.setCityPopulation(rs.getInt("city.population"));

                topCitiesInWorld.add(city);

            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInWorld;
    }

    /**retrieves a list of top seven populated cities in the continent africa
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInContinentOrderedByPopulation() {
        List<City> topCitiesInAfricaContinent = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryOfCity(rs.getString("country.name"));
                city.setCityDistrict(rs.getString("city.district"));
                city.setCityPopulation(rs.getInt("city.population"));

                topCitiesInAfricaContinent.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInAfricaContinent;
    }

    /**retrieves a list of top seven populated cities in a region 'western Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInRegionOrderedByPopulation() {
        List<City> topCitiesInWesternAfricaRegion = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryOfCity(rs.getString("country.name"));
                city.setCityDistrict(rs.getString("city.district"));
                city.setCityPopulation(rs.getInt("city.population"));

                topCitiesInWesternAfricaRegion.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInWesternAfricaRegion;
    }

    public void displayCountries(List<Country> list) {
        if (con == null) {
            System.out.println("No connection");
            return;
        }

        System.out.println("+-------+----------------------------------------+-----------------+-------------------------------+----------------+--------------------------------------+");
        System.out.println("| Code  | Name                                   | Continent       | Region                        | Population     | Capital                              |");
        System.out.println("+-------+----------------------------------------+-----------------+-------------------------------+----------------+--------------------------------------+");

        for (Country country : list) {
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

    public void displayCities(List<City> list) {
        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");
        System.out.println("| City Name                              | Country Name                           | District                               | Population       |");
        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");

        for (City city : list) {
            System.out.printf("| %-38s | %-38s | %-38s | %,15d |\n",
                    city.getCityName(),
                    city.getCountryOfCity(),
                    city.getCityDistrict(),
                    city.getCityPopulation());
        }

        System.out.println("+----------------------------------------+----------------------------------------+----------------------------------------+------------------+");
    }

    public void displayCapitalCities(List<City> list) {
        System.out.println("+----------------------------------------+----------------------------------------+--------------+");
        System.out.println("| Capital City                           | Country Name                           | Population   |");
        System.out.println("+----------------------------------------+----------------------------------------+--------------+");

        for (City city : list) {
            System.out.printf("| %-38s | %-38s | %,12d |\n",
                    city.getCityName(),
                    city.getCountryCode(),
                    city.getCityPopulation());
        }

        System.out.println("+----------------------------------------+----------------------------------------+--------------+");
    }

    /** retrieves and print all the countries ordered by population by descending
     */

    public void displayAllQuerys() {
        String ANSI_BOLD1 = "\u001B[1m"; // ANSI escape code for bold
        String ANSI_RESET1 = "\u001B[0m"; // ANSI escape code to reset formatting

        //The top 7 populated countries in the world
        List <Country> topSevenCountriesWorld = getTopSevenCountriesInWorldByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated countries in the world" + ANSI_RESET1);
        displayCountries(topSevenCountriesWorld);

        //The top 7 populated countries in a continent
        List <Country> topSevenCountriesContinent = getTopSevenCountriesInAsiaByPopulation();
        System.out.println(ANSI_BOLD1 + "The top 7 populated countries in the 'Asia' continent" + ANSI_RESET1);
        displayCountries(topSevenCountriesContinent);




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
        a.displayAllQuerys();

        // Disconnect from database
        a.disconnect();

    }
}
