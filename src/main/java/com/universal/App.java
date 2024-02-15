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
                    "FROM city\n" +
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

    /**retrieves a list of top seven populated cities in 'Nigeria' country in a region 'Central Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInCountryOrderedByPopulation() {
        List<City> topCitiesInNigeriaCountry = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa' AND country.name = 'Nigeria'\n" +
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

                topCitiesInNigeriaCountry.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInNigeriaCountry;
    }
    /**retrieves a list of top seven populated cities in district 'Oyo & Osun' from 'Nigeria' country in a region 'Central Africa' from the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCitiesInDistrictOrderedByPopulation() {
        List<City> topCitiesInOyoAndOsunDistrict = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.district, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Western Africa' AND country.name = 'Nigeria' AND city.district = 'Oyo & Osun'\n" +
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

                topCitiesInOyoAndOsunDistrict.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCitiesInOyoAndOsunDistrict;
    }
    /**retrieves a list of top seven populated capital cities in the world
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesOrderedByPopulation() {
        List<City> topCapitalInWorld = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                topCapitalInWorld.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInWorld;
    }

    /**retrieves a list of top seven populated capital cities in the continent 'Africa'
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesByContinentOrderedByPopulation() {
        List<City> topCapitalInContinent = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                topCapitalInContinent.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInContinent;
    }

    /**retrieves a list of top seven populated capital cities in the 'Central Africa' Region
     * @return a list of cities object.
     */
    public List<City> getTopSevenCapitalCitiesByRegionOrderedByPopulation() {
        List<City> topCapitalInRegion= new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String sql = "SELECT city.name, country.name, city.population\n" +
                    "FROM city\n" +
                    "INNER JOIN country\n" +
                    "ON city.countryCode = country.code AND city.id = country.capital\n" +
                    "WHERE country.continent = 'Africa' AND country.region = 'Central Africa'\n" +
                    "ORDER BY city.population DESC\n" +
                    "LIMIT 7";
            ResultSet rs = stmt.executeQuery(sql);
            //executeQuery(): It returns an instance of ResultSet when a select query is executed.
            while (rs.next()) {
                City city = new City();
                city.setCityName(rs.getString("city.name"));
                city.setCountryCode(rs.getString("country.name"));
                city.setCityPopulation(rs.getInt("city.Population"));

                topCapitalInRegion.add(city);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return topCapitalInRegion;
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
    //Display Continent Population Report
    public void printPopulationReport() {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
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

            System.out.println("\u001B[1mPopulation Report by Continent\u001B[0m");
            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Continent            | Total Population    | City Population     | City Population %   | Non-City Population | Non-City Population %|");
            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            while (rs.next()) {
                String continent = rs.getString("Continent");
                long totalPopulation = rs.getLong("TotalPopulation");
                long cityPopulation = rs.getLong("CityPopulation");
                long nonCityPopulation = rs.getLong("NonCityPopulation");

                double cityPopulationPercentage = (double) cityPopulation / totalPopulation * 100;
                double nonCityPopulationPercentage = (double) nonCityPopulation / totalPopulation * 100;

                System.out.printf("| %-20s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        continent, totalPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+----------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
    //Region Population Report
    public void printRegionPopulationReport() {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
        String sql = "SELECT " +
                "country.Region, " +
                "SUM(country.Population) AS TotalRegionPopulation, " +
                "SUM(city.Population) AS CityPopulation, " +
                "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation " +
                "FROM country " +
                "JOIN city ON country.Code = city.CountryCode " +
                "GROUP BY country.Region;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\u001B[1mRegion Population Report\u001B[0m");
            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Region                    | Total Population    | City Population     | City Pop. %         | Non-City Population | Non-City Pop. %     |");
            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            while (rs.next()) {
                String region = rs.getString("Region");
                long totalRegionPopulation = rs.getLong("TotalRegionPopulation");
                long cityPopulation = rs.getLong("CityPopulation");
                long nonCityPopulation = rs.getLong("NonCityPopulation");

                double cityPopulationPercentage = (double) cityPopulation / totalRegionPopulation * 100;
                double nonCityPopulationPercentage = (double) nonCityPopulation / totalRegionPopulation * 100;

                System.out.printf("| %-25s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        region, totalRegionPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+---------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    //Country Population Report
    public void printCountryPopulationReport() {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
        String sql = "SELECT " +
                "c.Name AS Country, " +
                "c.Population AS TotalPopulation, " +
                "IFNULL(SUM(ct.Population), 0) AS CityPopulation, " +
                "(c.Population - IFNULL(SUM(ct.Population), 0)) AS NonCityPopulation " +
                "FROM country c " +
                "LEFT JOIN city ct ON c.Code = ct.CountryCode " +
                "GROUP BY c.Name, c.Population;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\u001B[1mCountry Population Report\u001B[0m");
            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
            System.out.println("| Country                                | Total Population    | City Population     | City Pop. %         | Non-City Population | Non-City Pop. %     |");
            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");

            while (rs.next()) {
                String country = rs.getString("Country");
                long totalPopulation = rs.getLong("TotalPopulation");
                long cityPopulation = rs.getLong("CityPopulation");
                long nonCityPopulation = rs.getLong("NonCityPopulation");

                double cityPopulationPercentage = totalPopulation > 0 ? (double) cityPopulation / totalPopulation * 100 : 0;
                double nonCityPopulationPercentage = totalPopulation > 0 ? (double) nonCityPopulation / totalPopulation * 100 : 0;

                System.out.printf("| %-38s | %,19d | %,19d | %,19.2f%% | %,19d | %,19.2f%% |\n",
                        country, totalPopulation, cityPopulation, cityPopulationPercentage, nonCityPopulation, nonCityPopulationPercentage);
            }

            System.out.println("+----------------------------------------+---------------------+---------------------+---------------------+---------------------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
    //Display World Population
    public void printWorldPopulation() {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
        String sql = "SELECT SUM(Population) AS WorldPopulation FROM country;";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\u001B[1mWorld Population Report\u001B[0m");
            System.out.println("+------------------+");
            System.out.println("| World Population |");
            System.out.println("+------------------+");

            if (rs.next()) {
                long worldPopulation = rs.getLong("WorldPopulation");
                System.out.printf("| %,16d |\n", worldPopulation);
            }

            System.out.println("+------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }




    //Display the select Language
    public void printSelectedLanguageSpeakers() {
        if (con == null) {
            System.out.println("No connection");
            return;
        }
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

            System.out.println("\u001B[1mSelected Language Speakers Report\u001B[0m");
            System.out.println("+-------------+------------------------+-------------------------------+");
            System.out.println("| Language    | Number of Speakers     | World Population Percentage   |");
            System.out.println("+-------------+------------------------+-------------------------------+");

            while (rs.next()) {
                String language = rs.getString("Language");
                long numberOfSpeakers = rs.getLong("NumberOfSpeakers");
                double worldPopulationPercentage = rs.getDouble("WorldPopulationPercentage");

                System.out.printf("| %-11s | %,22d | %,29.2f%% |\n",
                        language, numberOfSpeakers, worldPopulationPercentage);
            }

            System.out.println("+-------------+------------------------+-------------------------------+");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
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
        a.printPopulationReport();
        a.printRegionPopulationReport();
        a.printCountryPopulationReport();
        a.printSelectedLanguageSpeakers();
        a.printWorldPopulation();


        // Disconnect from database
        a.disconnect();

    }
}
