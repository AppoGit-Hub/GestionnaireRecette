package dataAccess;

import exception.*;
import interfaceAccess.EquipementDataAccess;
import model.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipementDataBaseAccess implements EquipementDataAccess {
    @Override
    public ArrayList<Equipment> readAllEquipementOf(Integer recipeCode) throws EquipementException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM equipment WHERE inRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<Equipment> equipments = new ArrayList<Equipment>();
            while (data.next()) {
                String utensilName = data.getString("ustensil");
                int inRecipe = data.getInt("inRecipe");
                Equipment equipment = new Equipment(utensilName, inRecipe);
                equipments.add(equipment);
            }
            return equipments;
        } catch (SQLException exception) {
            throw new EquipementException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
    @Override
    public void createEquipementFor(Integer recipeCode, String utensilName) throws EquipementException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO equipment VALUES (?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, utensilName);
            statement.setInt(2, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EquipementException(exception.getMessage(), new OneException(), new CreateException());
        }
    }
    @Override
    public void deleteEquipementFor(Integer recipeCode, String utensilName) throws EquipementException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM equipment WHERE ustensil = ? AND inRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, utensilName);
            statement.setInt(2, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EquipementException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    public void deleteAllEquipement(Integer recipeCode) throws EquipementException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM equipment WHERE inRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EquipementException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }
}
