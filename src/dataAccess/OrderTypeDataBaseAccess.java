package dataAccess;

import exception.AllOrderTypeException;
import exception.CreateOrderTypeException;
import exception.DeleteOrderTypeException;
import interfaceAccess.OrderTypeDataAccess;
import model.OrderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderTypeDataBaseAccess implements OrderTypeDataAccess {
    @Override
    public void createOrderType(int recipeCode, int mealCategory) throws CreateOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO ordertype VALUES (?, ?)";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CreateOrderTypeException();
        }
    }
    @Override
    public void deleteOrderType(int recipeCode, int mealCategory) throws DeleteOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM ordertype WHERE fromRecipe = ? AND mealCategory = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteOrderTypeException();
        }
    }
    public void deleteRecipeAllOrderType(int recipeCode) throws DeleteOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM ordertype WHERE fromRecipe = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteOrderTypeException();
        }
    }//todo : changer interface et exception
    @Override
    public ArrayList<OrderType> getAllOrderType(int recipeCode) throws AllOrderTypeException {
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
            throw new AllOrderTypeException(exception.getMessage());
        }
    }
}
