package controller;

import business.CountryManager;
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

    public ArrayList<Country> readAllCountry() throws CountryException {
        return this.manager.readAllCountry();
    }

    public Country readCountry(int country) throws CountryException {
        return this.manager.readCountry(country);
    }
}
