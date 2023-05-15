package dataAccess;

import exception.AllDietException;
import exception.AllEquipementException;
import interfaceAccess.DietDataAccess;
import model.Diet;
import model.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DietDataBaseAcces implements DietDataAccess {
    @Override
    public ArrayList<Diet> getAllDiet() throws AllDietException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM diet;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Diet> diets = new ArrayList<Diet>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                Diet diet = new Diet(id, name);
                diets.add(diet);
            }
            return diets;
        } catch (SQLException exception) {
            throw new AllDietException(exception.getMessage());
        }

    }
}
