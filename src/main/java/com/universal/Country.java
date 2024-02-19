/**
 * This class is a collection of variables related with country class to generate the organization's requests.
 * In this class, getter setter method are used within "country" class.
 */
package com.universal;

/**
 * Represents the world
 */
public class Country
{
    /**
     * Country's code
     */
    private String Code;


    /**
     * Country's capital
     */
    private String Capital;

    /**
     * Country's code2
     */
    private int Code2;

    /**
     * Country's continent
     */
    private String Continent;

    /**
     * Country's Name
     */
    private String Name;

    /**
     * Country's Population
     */
    private Long Population;

    /**
     * Country's Region
     */
    private String Region;

    /**
     * Country's SurfaceArea
     */
    private String SurfaceArea;


    /**
     * The following is getter setter method related to code.
     */
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    /**
     * The following is getter setter method related to capital.
     */
    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    /**
     * The following is getter setter method related to continent.
     */
    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
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
    public Long getPopulation() {
        return Population;
    }

    public void setPopulation(Long population) {
        Population = population;
    }

    /**
     * The following is getter setter method related to region.
     */
    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

}

