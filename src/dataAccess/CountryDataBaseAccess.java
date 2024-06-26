package dataAccess;

import exception.*;
import interfaceAccess.CountryDataAccess;
import model.Country;
import model.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDataBaseAccess implements CountryDataAccess {
    @Override
    public ArrayList<Country> readAllCountry() throws CountryException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM country;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Country> countries = new ArrayList<Country>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                Country country = new Country(id, name);
                countries.add(country);
            }
            return countries;
        } catch (SQLException exception) {
            throw new CountryException(exception.getMessage(), new OneException(), new ReadException());
        }
    }

    @Override
    public Country readCountry(int country) throws CountryException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM country WHERE id = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, country);
            ResultSet data = statement.executeQuery();
            data.next();
            int id = data.getInt("id");
            String name = data.getString("name");
            return new Country(id, name);
        } catch (SQLException exception) {
            throw new CountryException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
}
