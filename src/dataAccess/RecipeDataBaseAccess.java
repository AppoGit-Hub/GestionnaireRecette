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
    public void createRecipe(Recipe recipe) throws CreateRecipeException {
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
            throw new CreateRecipeException(exception.getMessage());
        }
    }

    @Override
    public Recipe read() {
        return null;
    }

    @Override
    public void update(Recipe recipe) throws UpdateRecipeException {
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
            throw new UpdateRecipeException(exception.getMessage());
        }
    }


    public void delete(int codeRecipe) throws DeleteRecipeException{
        try{
            Connection connection = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipe WHERE code = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,codeRecipe);
            System.out.println("accesdata : recipe : delete : partie 3");
            statement.executeUpdate();

        }catch(SQLException exception){
            throw new DeleteRecipeException(exception.getMessage());
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
    @Override
    public ArrayList<Recipe> getAllRecipe() throws AllRecipeException {
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

                try {
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
                } catch (Exception exception){
                    throw new AllRecipeException(exception.getMessage());
                }
            }
            return recipes;
        } catch (SQLException exception) {
            throw new AllRecipeException(exception.getMessage());
        }
    }
}
