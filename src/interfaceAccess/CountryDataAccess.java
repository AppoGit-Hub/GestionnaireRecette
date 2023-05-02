package interfaceAccess;

import exception.AllCountryException;
import exception.CountryException;
import model.Country;

import java.util.ArrayList;

public interface CountryDataAccess {
    ArrayList<Country> getAllCountry() throws AllCountryException;
    Country getCountry(int country) throws CountryException;
}
