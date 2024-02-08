/**
 * This class is a collection of variables related with country language class to generate the organization's requests.
 * In this class, getter setter method are used within "country language" class.
 */
package com.universal;

public class Countrylanguage {

    /**
     * Countrylanguage's country code
     */
    private int CountryCode;

    /**
     * Countrylanguage's language
     */
    private String Language;

    /**
     * Countrylanguage's IsOfficial
     */
    private String IsOfficial;

    /**
     * Countrylanguage's percentage
     */
    private String Percentage;


    /**
     * The following is getter setter method related to countrycode.
     */
    public int getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(int countryCode) {
        CountryCode = countryCode;
    }

    /**
     * The following is getter setter method related to language.
     */
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    /**
     * The following is getter setter method related to isofficial.
     */
    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    /**
     * The following is getter setter method related to percentage.
     */
    public String getPercentage() {
        return Percentage;
    }

    public void setPercentage(String percentage) {
        Percentage = percentage;
    }
}

