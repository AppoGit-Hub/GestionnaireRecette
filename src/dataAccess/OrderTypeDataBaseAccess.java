package dataAccess;

import exception.*;
import interfaceAccess.OrderTypeDataAccess;
import model.OrderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderTypeDataBaseAccess implements OrderTypeDataAccess {
    @Override
    public void createOrderType(Integer recipeCode, Integer mealCategory) throws OrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO orderType VALUES (?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new OrderTypeException(exception.getMessage(), new OneException(), new CreateException());
        }
    }
    @Override
    public void deleteOrderType(Integer recipeCode, Integer mealCategory) throws OrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM orderType WHERE fromRecipe = ? AND mealCategory = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new OrderTypeException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    public void deleteAllOrderType(Integer recipeCode) throws OrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM orderType WHERE fromRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new OrderTypeException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }
    @Override
    public ArrayList<OrderType> readAllOrderType(Integer recipeCode) throws OrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM orderType WHERE fromRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<OrderType> orderTypes = new ArrayList<OrderType>();
            while (data.next()) {
                int recipe = data.getInt("fromRecipe");
                int mealCategory = data.getInt("mealCategory");
                OrderType orderType = new OrderType(recipe, mealCategory);
                orderTypes.add(orderType);
            }
            return orderTypes;
        } catch (SQLException exception) {
            throw new OrderTypeException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
}
