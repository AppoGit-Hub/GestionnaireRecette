package controller;

import business.CountryManager;
import exception.AllCountryException;
import exception.CountryException;
import model.Country;

import java.util.ArrayList;

public class CountryController {
    private CountryManager manager;

    public CountryController() {
        setManager(new CountryManager());
    }
    public void setManager(CountryManager manager) {
        this.manager = manager;
    }

    public ArrayList<Country> getAllCountry() throws AllCountryException {
        return this.manager.getAllCountry();
    }

    public Country getCountry(int country) throws CountryException {
        return this.manager.getCountry(country);
    }
}
