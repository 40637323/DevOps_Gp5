/**
 * This class is a collection of variables related with city class to generate the organization's requests.
 * In this class, getter setter method are used within "city" class.
 */
package com.universal;

public class City {
    /**
     * City's ID
     */
    private int ID;

    /**
     * City's Country code
     */
    private String CountryCode;

    /**
     * City's District
     */
    private String District;

    /**
     * City's Name
     */
    private String Name;

    /**
     * City's Population
     */
    private int Population;

    /**
     * The following is getter setter method related to ID.
     */
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * The following is getter setter method related to countrycode.
     */
    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    /**
     * The following is getter setter method related to district.
     */
    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    /**
     * The following is getter setter method related to name.
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    /**
     * The following is getter setter method related to population.
     */
    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }
}

