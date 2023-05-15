package dataAccess;

import exception.AllPeriodException;
import exception.CreatePeriodException;
import exception.DeletePeriodException;
import interfaceAccess.PeriodDataAccess;
import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodDataBaseAccess implements PeriodDataAccess {
    @Override
    public void createPeriod(int periodRecipe, int menuType) throws CreatePeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO period VALUES (?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.setInt(2, menuType);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CreatePeriodException();
        }
    }

    @Override
    public void deletePeriod(int periodRecipe, int menuType) throws DeletePeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM period WHERE periodRecipe = ? AND menuType = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.setInt(2, menuType);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeletePeriodException();
        }
    }
    public void deleteRecipeAllPeriod(int periodRecipe) throws DeletePeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM period WHERE periodRecipe = ? ;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeletePeriodException();
        }
    }//todo : changer l'interface et l'exception

    @Override
    public ArrayList<Period> getAllPeriod(int recipeCode) throws AllPeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM period WHERE periodRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<Period> periods = new ArrayList<>();
            while (data.next()) {
                int recipe = data.getInt("periodRecipe");
                int menuType = data.getInt("menuType");
                Period period = new Period(recipe, menuType);
                periods.add(period);
            }
            return periods;
        } catch (SQLException exception) {
            throw new AllPeriodException(exception.getMessage());
        }
    }
}
