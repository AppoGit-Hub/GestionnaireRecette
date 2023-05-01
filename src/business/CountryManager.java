package business;

import dataAccess.CountryDataBaseAccess;
import exception.AllCountryException;
import interfaceAccess.CountryDataAccess;
import model.Country;

import java.util.ArrayList;

public class CountryManager {
    private CountryDataAccess countryAccess;

    public CountryManager() {
        setCountryAccess(new CountryDataBaseAccess());
    }

    public void setCountryAccess(CountryDataAccess countryAccess) {
        this.countryAccess = countryAccess;
    }

    public ArrayList<Country> getAllCountry() throws AllCountryException {
        return this.countryAccess.getAllCountry();
    }
}
