package interfaceAccess;

import exception.AllCountryException;
import model.Country;

import java.util.ArrayList;

public interface CountryDataAccess {
    ArrayList<Country> getAllCountry() throws AllCountryException;
}
