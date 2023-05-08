package dataAccess;

import exception.AllPeriodException;
import interfaceAccess.PeriodDataAccess;
import model.Period;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodDataBaseAccess implements PeriodDataAccess {
    @Override
    public void setPeriod(Period period) {

    }
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
