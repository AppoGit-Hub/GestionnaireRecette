package controller;

import business.CountryManager;
import exception.AllCountryException;
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
}
