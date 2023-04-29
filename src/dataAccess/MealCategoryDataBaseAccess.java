package dataAccess;

import exception.AllMealCategoryException;
import interfaceAccess.MealCategoryDataAccess;
import model.MealCategory;

import java.sql.*;
import java.util.ArrayList;

public class MealCategoryDataBaseAccess implements MealCategoryDataAccess {
    @Override
    public ArrayList<MealCategory> getAllMealCategory()throws AllMealCategoryException {
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
            throw new AllMealCategoryException();
        }
    }
}
