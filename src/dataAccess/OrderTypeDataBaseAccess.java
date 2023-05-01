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
    public void setOrderType(OrderType order) {

    }

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
            throw new AllOrderTypeException();
        }
    }
}
