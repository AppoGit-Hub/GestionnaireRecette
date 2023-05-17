package dataAccess;

import exception.*;
import interfaceAccess.RecipeDataAccess;
import model.Complexity;
import model.Period;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;

public class RecipeDataBaseAccess implements RecipeDataAccess {
    @Override
    public void createRecipe(Recipe recipe) throws RecipeException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query =
                """
                INSERT INTO recipe
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, recipe.getCode());
            statement.setString(2, recipe.getTitle());
            statement.setBoolean(3, recipe.getIsHot());
            statement.setDate(4, Date.valueOf(recipe.getPublicationDate()));
            statement.setString(5, recipe.getDescription());
            statement.setInt(6, recipe.getTimePreparation());
            statement.setInt(7, recipe.getNoteAuthor());
            statement.setBoolean(8, recipe.getIsSalted());
            statement.setInt(9, recipe.getNumberPeopleConcerned());
            statement.setInt(10, recipe.getComplexity().getComplexity());
            statement.setInt(11, recipe.getSpeciality());
            statement.setInt(12, recipe.getPerson());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RecipeException(exception.getMessage(), new OneException(), new CreateException());
        }
    }

    @Override
    public Recipe readRecipe() throws RecipeException {
        try {
            throw new SQLException();
        } catch (SQLException exception) {
            throw new RecipeException(exception.getMessage(), new OneException(), new ReadException());
        }
    }

    @Override
    public void updateRecipe(Recipe recipe) throws RecipeException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query =
                """
                UPDATE recipe 
                SET 
                    title = ?, 
                    isHot = ?, 
                    publicationDate = ?, 
                    description = ?, 
                    timePreparation = ?, 
                    notAuthor = ?, 
                    isSalted = ?, 
                    numberPeople = ?, 
                    complexityLevel = ?, 
                    speciality = ?, 
                    author = ? 
                WHERE code = ?;
                """;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, recipe.getTitle());
            statement.setBoolean(2, recipe.getIsHot());
            statement.setDate(3, java.sql.Date.valueOf(recipe.getPublicationDate()));
            statement.setString(4, recipe.getDescription());
            statement.setInt(5, recipe.getTimePreparation());
            statement.setInt(6, recipe.getNoteAuthor());
            statement.setBoolean(7, recipe.getIsSalted());
            statement.setInt(8, recipe.getNumberPeopleConcerned());
            statement.setInt(9, recipe.getComplexity().getComplexity());
            statement.setInt(10, recipe.getSpeciality());
            statement.setInt(11, recipe.getPerson());
            statement.setInt(12, recipe.getCode());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RecipeException(exception.getMessage(), new OneException(), new UpdateException());
        }
    }
    public void deleteRecipe(int codeRecipe) throws RecipeException {
        try{
            Connection connection = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipe WHERE code = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,codeRecipe);
            statement.executeUpdate();

        } catch(SQLException exception) {
            throw new RecipeException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    @Override
    public ArrayList<Recipe> readAllRecipe() throws RecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM recipe;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Recipe> recipes = new ArrayList<Recipe>();

            while (data.next()) {
                int code = data.getInt("code");
                String title = data.getString("title");
                boolean isHot = data.getBoolean("isHot");
                Date publicationDate = data.getDate("publicationDate");
                int timePreparation = data.getInt("timePreparation");
                boolean isSalted = data.getBoolean("isSalted");
                int numberPeopleConcerned = data.getInt("numberPeople");
                Complexity complexity = Complexity.values()[data.getInt("complexityLevel")];
                int person = data.getInt("author");

                Recipe recipe = new Recipe(
                        code,
                        title,
                        isHot,
                        publicationDate.toLocalDate(),
                        timePreparation,
                        isSalted,
                        numberPeopleConcerned,
                        complexity,
                        person
                );

                String description = data.getString("description");
                if (!data.wasNull()) {
                    recipe.setDescription(description);
                }

                int notAuthor = data.getInt("notAuthor");
                if (!data.wasNull()) {
                    recipe.setNoteAuthor(notAuthor);
                }

                int speciality = data.getInt("speciality");
                if (!data.wasNull()) {
                    recipe.setSpeciality(speciality);
                }
                recipes.add(recipe);
            }
            return recipes;
        } catch (SQLException exception) {
            throw new RecipeException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
    @Override
    public int getNextCode() throws NextCodeRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT MAX(code) AS 'NEXT_CODE' FROM recipe;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            data.next();
            return data.getInt("NEXT_CODE") + 1;
        } catch (SQLException exception) {
            throw new NextCodeRecipeException(exception.getMessage());
        }
    }
    public int getNumberRecipe() throws NumberRecipeException {
        try{
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT COUNT(*) AS 'NUMBER_RECIPE' FROM recipe;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            data.next();
            return data.getInt("NUMBER_RECIPE");
        }catch(SQLException exception){
            throw new NumberRecipeException(exception.getMessage());
        }
    }
}
