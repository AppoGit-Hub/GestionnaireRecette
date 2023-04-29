package dataAccess;

import exception.EquipementException;
import interfaceAccess.EquipementDataAccess;
import model.Equipment;
import model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipementDataBaseAccess implements EquipementDataAccess {
    @Override
    public ArrayList<Equipment> getEquipementOf(Recipe recipe) throws EquipementException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                    "SELECT * " +
                    "FROM equipment" +
                    "WHERE inRecipe = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipe.getCode());
            ResultSet data = statement.executeQuery();
            ArrayList<Equipment> equipments = new ArrayList<Equipment>();
            while (data.next()) {
                String utensilName = data.getString("utensil");
                int inRecipe = data.getInt("inRecipe");
                Equipment equipment = new Equipment(utensilName, inRecipe);
                equipments.add(equipment);
            }
            return equipments;
        } catch (SQLException exception) {
            throw new EquipementException();
        }
    }
}
