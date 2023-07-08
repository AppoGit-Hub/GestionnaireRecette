package dataAccess;

import exception.SearchDietException;
import exception.SearchIngredientException;
import exception.SearchRecipeException;
import interfaceAccess.SearchDataAcces;
import model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchDataBaseAccess implements SearchDataAcces {
    @Override
    public ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                """
                SELECT DISTINCT recipe.code, recipe.title, recipe.publicationDate, recipe.numberPeople, recipe.complexityLevel, person.firstname, person.lastname
                FROM recipe
                INNER JOIN person ON person.id = recipe.author
                INNER JOIN linerecipe ON recipe.code = linerecipe.recipeOrigin
                INNER JOIN ingredient ON linerecipe.ingredient = ingredient.name
                INNER JOIN foodcategory ON ingredient.type = foodcategory.id
                INNER JOIN restriction ON restriction.foodcategory = foodcategory.id
                INNER JOIN diet ON restriction.diet = diet.id
                WHERE diet.id = ?;
                """;
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, diet);
            ResultSet data = statement.executeQuery();
            ArrayList<SearchDietResult> searchDietResults = new ArrayList<>();

            while (data.next()) {
                int recipeCode = data.getInt("code");
                String title = data.getString("title");
                LocalDate publicationDate = data.getDate("publicationDate").toLocalDate();
                int numberPeople = data.getInt("numberPeople");
                Complexity complexity = Complexity.values()[data.getInt("complexityLevel")];
                String personFirstName = data.getString("firstname");
                String personLastName = data.getString("lastname");

                SearchDietResult result = new SearchDietResult(recipeCode, title, publicationDate, numberPeople, complexity, personFirstName, personLastName);
                searchDietResults.add(result);
            }
            return searchDietResults;
        } catch (SQLException exception) {
            throw new SearchDietException(exception.getMessage());
        }
    }

    @Override
    public ArrayList<SearchRecipeResult> searchRecipe(String ingredient, boolean isHot, int menuType) throws SearchRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                """
                SELECT recipe.code, recipe.title, person.firstname, person.lastname, country.name
                FROM recipe
                INNER JOIN person ON recipe.author = person.id
                INNER JOIN country ON country.id = recipe.speciality
                INNER JOIN period ON period.periodRecipe = recipe.code
                INNER JOIN menuType ON menuType.id = period.menuType
                INNER JOIN linerecipe ON linerecipe.recipeOrigin = recipe.code
                INNER JOIN ingredient ON ingredient.name = linerecipe.ingredient
                WHERE ingredient.name = ? AND recipe.isHot = ? AND menuType.id = ?;
                """;
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, ingredient);
            statement.setBoolean(2, isHot);
            statement.setInt(3, menuType);
            ResultSet data = statement.executeQuery();
            ArrayList<SearchRecipeResult> searchRecipeResults = new ArrayList<>();
            while (data.next()) {
                int code = data.getInt("code");
                String title = data.getString("title");
                String firstname = data.getString("firstname");
                String lastname = data.getString("lastname");
                String country = data.getString("name");
                searchRecipeResults.add(new SearchRecipeResult(code, title, firstname, lastname, country));
            }
            return searchRecipeResults;
        } catch (SQLException exception) {
            throw new SearchRecipeException(exception.getMessage());
        }
    }

    public ArrayList<SearchIngredientResult> searchIngredient(String ingredient, LocalDate dateBeginning, LocalDate dateEnding) throws SearchIngredientException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                """
                SELECT
                    recipe.code,
                    recipe.title,
                    ingredient.name AS "ingredient",
                    foodcategory.name AS "foodcategory",
                    productionperiod.dateBegining,
                    productionperiod.dateEnding,
                    linerecipe.quantity
                FROM recipe
                INNER JOIN linerecipe ON recipe.code = linerecipe.recipeOrigin
                INNER JOIN ingredient ON linerecipe.ingredient = ingredient.name
                INNER JOIN foodcategory ON foodcategory.id = ingredient.type
                INNER JOIN productionperiod ON productionperiod.id = ingredient.season
                WHERE ingredient.name = ? AND recipe.publicationDate BETWEEN ? AND ?
                ORDER BY foodcategory.name;                     
                """;
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, ingredient);
            statement.setDate(2, Date.valueOf(dateBeginning));
            statement.setDate(3, Date.valueOf(dateEnding));
            ResultSet data = statement.executeQuery();
            ArrayList<SearchIngredientResult> searchIngredientResults = new ArrayList<>();
            while (data.next()) {
                int recipeCode = data.getInt("code");
                String recipeTitle = data.getString("title");
                String ingredientName = data.getString("ingredient");
                String foodCategoryName = data.getString("foodcategory");
                LocalDate producitonDateBegining = data.getDate("dateBegining").toLocalDate();
                LocalDate producitonDateEnding = data.getDate("dateEnding").toLocalDate();
                int lineRecipeQuantity =data.getInt("quantity");
                searchIngredientResults.add(new SearchIngredientResult(recipeCode, recipeTitle, ingredientName, foodCategoryName, producitonDateBegining, producitonDateEnding, lineRecipeQuantity));
            }
            return searchIngredientResults;
        } catch (SQLException exception) {
            throw new SearchIngredientException(exception.getMessage());
        }
    }
}
