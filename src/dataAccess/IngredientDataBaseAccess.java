package dataAccess;

import exception.AllIngredientException;
import exception.AllMealCategoryException;
import exception.IngredientException;
import interfaceAccess.IngredientDataAccess;
import model.Ingredient;
import model.MealCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDataBaseAccess implements IngredientDataAccess {
    @Override
    public Ingredient getIngredient(String ingredient) throws IngredientException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM ingredient WHERE name = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, ingredient);
            ResultSet data = statement.executeQuery();
            data.next();
            String name = data.getString("name");
            Float minTemp = data.getFloat("minPreservationTemperature");
            Float maxTemp = data.getFloat("maxPreservationTemperature");
            Integer season = data.getInt("season");
            Integer type = data.getInt("type");
            return new Ingredient(name, minTemp, maxTemp, season, type);
        } catch (SQLException exception) {
            throw new IngredientException();
        }
    }

    @Override
    public ArrayList<Ingredient> getAllIngredient() throws AllIngredientException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM ingredient";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
            while (data.next()) {
                String name = data.getString("name");
                Float minTemp = data.getFloat("minPreservationTemperature");
                Float maxTemp = data.getFloat("maxPreservationTemperature");
                Integer season = data.getInt("season");
                Integer type = data.getInt("type");
                Ingredient ingredient = new Ingredient(name, minTemp, maxTemp, season, type);
                ingredients.add(ingredient);
            }
            return ingredients;
        } catch (SQLException exception) {
            throw new AllIngredientException();
        }
    }
}
