package interfaceAccess;

import exception.CountryException;
import model.Country;

import java.util.ArrayList;

public interface CountryDataAccess {
    ArrayList<Country> readAllCountry() throws CountryException;
    Country readCountry(int country) throws CountryException;
}
