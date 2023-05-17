package business;

import dataAccess.CountryDataBaseAccess;
import exception.CountryException;
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

    public ArrayList<Country> readAllCountry() throws CountryException {
        return this.countryAccess.readAllCountry();
    }

    public Country readCountry(int country) throws CountryException {
        return this.countryAccess.readCountry(country);
    }
}
