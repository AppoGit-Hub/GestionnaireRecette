package dataAccess;

import exception.AllPeriodException;
import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import interfaceAccess.RecipeDataAccess;
import model.Complexity;
import model.Period;
import model.Recipe;

import java.sql.*;
import java.util.ArrayList;

public class RecipeDataBaseAccess implements RecipeDataAccess {
    @Override
    public void create(Recipe recipe) {

    }

    @Override
    public Recipe read() {
        return null;
    }//écrit null just pour éviter de mettre en faute le module

    @Override
    public void update(Recipe recipe) {

    }

    @Override
    public void delete(Recipe recipe) {

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
    }//je pense que c'est pour l'identifiant pour la création d'une nouvelle recette, sinon je ne vois pas

    @Override
    public ArrayList<Recipe> getAllRecipe() throws AllRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM recipe;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Recipe> recipes = new ArrayList<Recipe>();

            while (data.next()) {// le truc commence au 1 puis fait plus 1 jusqu'a ce qu'il n'en reste plus
                int code = data.getInt("code");
                String title = data.getString("title");
                boolean isHot = data.getBoolean("isHot");
                Date publicationDate = data.getDate("publicationDate");
                int timePreparation = data.getInt("timePreparation");
                int noteAuthor = data.getInt("notAuthor");//putain j'ai mis un int là ou c'est un string merde
                boolean isSalted = data.getBoolean("isSalted");// 0 pour faut , 1 pour vrai
                int numberPeopleConcerned = data.getInt("numberPeople");
                Complexity complexity = Complexity.values()[data.getInt("complexityLevel")];
                int person = data.getInt("author"); //todo : il faudra le remplace par un string et faire une requete SQL approprié

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
                System.out.println("niveau acces : recipe");
                recipes.add(recipe);
            }
            return recipes;
        } catch (SQLException exception) {
            throw new AllRecipeException(exception.getMessage());
        }
    }
}
