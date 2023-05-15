package dataAccess;

import exception.AllOrderTypeException;
import exception.CreateOrderTypeException;
import exception.DeleteAllOrderTypeException;
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
            String query = "INSERT INTO orderType VALUES (?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CreateOrderTypeException(exception.getMessage());
        }
    }
    @Override
    public void deleteOrderType(int recipeCode, int mealCategory) throws DeleteOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM orderType WHERE fromRecipe = ? AND mealCategory = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, mealCategory);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteOrderTypeException(exception.getMessage());
        }
    }
    public void deleteAllOrderType(int recipeCode) throws DeleteAllOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM orderType WHERE fromRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteAllOrderTypeException(exception.getMessage());
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
