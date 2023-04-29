package dataAccess;

import exception.AllOrderException;
import interfaceAccess.OrderDataAccess;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDataBaseAccess implements OrderDataAccess {

    @Override
    public void setOrder(Order order) {

    }

    @Override
    public ArrayList<Order> getAllOrder(int recipeCode) throws AllOrderException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                    "SELECT * " +
                    "FROM order" +
                    "WHERE fromRecipe = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<Order> orders = new ArrayList<Order>();
            while (data.next()) {
                int recipe = data.getInt("fromRecipe");
                int mealCategory = data.getInt("mealCategory");
                Order order = new Order(recipe, mealCategory);
                orders.add(order);
            }
            return orders;
        } catch (SQLException exception) {
            throw new AllOrderException();
        }
    }
}
