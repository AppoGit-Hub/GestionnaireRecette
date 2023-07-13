package dataAccess;

import exception.*;
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
    public Complexity readComplexity(int id) throws ComplexityException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM complexityLevel WHERE id = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet data = statement.executeQuery();
            data.next();
            String name = data.getString("name");
            return new Complexity(id, name);
        } catch (SQLException exception) {
            throw new ComplexityException(exception.getMessage(), new OneException(), new ReadException());
        }
    }

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
