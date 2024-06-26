package dataAccess;

import exception.*;
import interfaceAccess.MealCategoryDataAccess;
import model.MealCategory;

import java.sql.*;
import java.util.ArrayList;

public class MealCategoryDataBaseAccess implements MealCategoryDataAccess {
    @Override
    public ArrayList<MealCategory> readAllMealCategory()throws MealCategoryException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM mealcategory";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<MealCategory> menuCategories = new ArrayList<MealCategory>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                MealCategory mealCategory = new MealCategory(id, name);
                menuCategories.add(mealCategory);
            }
            return menuCategories;
        } catch (SQLException exception) {
            throw new MealCategoryException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
    @Override
    public MealCategory readMealCategory(int mealCategory) throws MealCategoryException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM mealcategory WHERE id = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, mealCategory);
            ResultSet data = statement.executeQuery();
            data.next();
            int id = data.getInt("id");
            String name = data.getString("name");
            return new MealCategory(id, name);
        } catch (Exception exception) {
            throw new MealCategoryException(exception.getMessage(), new OneException(), new ReadException());
        }
    }
}
