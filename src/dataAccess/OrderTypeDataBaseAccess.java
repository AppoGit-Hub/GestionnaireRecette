package dataAccess;

import exception.AllOrderTypeException;
import interfaceAccess.OrderTypeDataAccess;
import model.OrderType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderTypeDataBaseAccess implements OrderTypeDataAccess {

    @Override
    public void setOrder(OrderType order) {

    }

    @Override
    public ArrayList<OrderType> getAllOrder(int recipeCode) throws AllOrderTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT *  FROM order WHERE fromRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<OrderType> orders = new ArrayList<OrderType>();
            while (data.next()) {
                int recipe = data.getInt("fromRecipe");
                int mealCategory = data.getInt("mealCategory");
                OrderType order = new OrderType(recipe, mealCategory);
                orders.add(order);
            }
            return orders;
        } catch (SQLException exception) {
            throw new AllOrderTypeException();
        }
    }
}
