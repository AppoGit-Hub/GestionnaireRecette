package dataAccess;

import exception.AllException;
import exception.ReadException;
import exception.UnitException;
import interfaceAccess.UnitDataAccess;
import model.LineRecipe;
import model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitDataBaseAccess implements UnitDataAccess {
    public ArrayList<Unit> readAllUnit() throws UnitException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM unit";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Unit> units = new ArrayList<Unit>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                units.add(new Unit(id, name));
            }
            return units;
        } catch (SQLException exception) {
            throw new UnitException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
}
