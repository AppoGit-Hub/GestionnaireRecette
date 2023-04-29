package dataAccess;

import exception.UtensilException;
import interfaceAccess.UtensilDataAccess;
import model.LevelPrice;
import model.Utensil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtensilDataBaseAccess implements UtensilDataAccess {
    @Override
    public Utensil getUtensil(String name) throws UtensilException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                    "SELECT * " +
                    "FROM utensil" +
                    "WHERE name = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, name);
            ResultSet data = statement.executeQuery();

            String utensilName = data.getString("name");
            boolean isElectric = data.getInt("isElectric") == 1;
            LevelPrice levelPrice = LevelPrice.values()[data.getInt("levePrice")];

            return new Utensil(utensilName, isElectric, levelPrice);
        } catch (SQLException exception) {
            throw new UtensilException();
        }
    }
}
