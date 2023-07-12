package dataAccess;

import exception.AllException;
import exception.ComplexityException;
import exception.ReadException;
import exception.UnitException;
import interfaceAccess.ComplexityDataAccess;
import model.Complexity;
import model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComplexityDataBaseAccess implements ComplexityDataAccess {
    @Override
    public ArrayList<Complexity> readAllComplexity() throws ComplexityException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM complexityLevel";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Complexity> units = new ArrayList<Complexity>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                units.add(new Complexity(id, name));
            }
            return units;
        } catch (SQLException exception) {
            throw new ComplexityException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
}
