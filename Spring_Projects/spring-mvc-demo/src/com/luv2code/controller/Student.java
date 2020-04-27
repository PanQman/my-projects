package com.luv2code.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String[] systemsList;
    private String favouriteLanguage;
    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> systemsOptions;

    public Student(){
        systemsOptions = new LinkedHashMap<>();
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("PL", "Poland");
        countryOptions.put("DE", "Germany");
        systemsOptions.put("Linux", "Linux");
        systemsOptions.put("MAC", "MAC OS");
        systemsOptions.put("MS", "MS Windows");

    }

    public LinkedHashMap<String, String> getSystemsOptions() {
        return systemsOptions;
    }
    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }
    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }
    public String[] getSystemsList() {
        return systemsList;
    }
    public void setSystemsList(String[] systemsList) {
        this.systemsList = systemsList;
    }
}
