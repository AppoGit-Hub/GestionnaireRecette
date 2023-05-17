package dataAccess;

import exception.*;
import interfaceAccess.PeriodDataAccess;
import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodDataBaseAccess implements PeriodDataAccess {
    @Override
    public void createPeriod(int periodRecipe, int menuType) throws PeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO period VALUES (?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.setInt(2, menuType);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new PeriodException(exception.getMessage(), new OneException(), new CreateException());
        }
    }

    @Override
    public void deletePeriod(int periodRecipe, int menuType) throws PeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM period WHERE periodRecipe = ? AND menuType = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.setInt(2, menuType);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new PeriodException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    public void deleteAllPeriod(int periodRecipe) throws PeriodException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM period WHERE periodRecipe = ? ;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, periodRecipe);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new PeriodException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }

    @Override
    public ArrayList<Period> readAllPeriod(int recipeCode) throws PeriodException {
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
            throw new PeriodException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
}
