package dataAccess;

import exception.AllUtensilException;
import exception.UtensilException;
import interfaceAccess.UtensilDataAccess;
import model.LevelPrice;
import model.Utensil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class    UtensilDataBaseAccess implements UtensilDataAccess {
    @Override
    public Utensil getUtensil(String name) throws UtensilException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM utensil WHERE name = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, name);
            ResultSet data = statement.executeQuery();
            data.next();

            String utensilName = data.getString("name");
            boolean isElectric = data.getInt("isElectric") == 1;
            LevelPrice levelPrice = LevelPrice.values()[data.getInt("levelPrice")];

            return new Utensil(utensilName, isElectric, levelPrice);
        } catch (SQLException exception) {
            throw new UtensilException(exception.getMessage());
        }
    }



    @Override
    public ArrayList<Utensil> getAllUtensil() throws AllUtensilException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM utensil;";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<Utensil> utensils = new ArrayList<>();
            while (data.next()) {
                String utensilName = data.getString("name");
                boolean isElectric = data.getInt("isElectric") == 1;
                LevelPrice levelPrice = LevelPrice.values()[data.getInt("levelPrice")];
                utensils.add(new Utensil(utensilName, isElectric, levelPrice));
            }
            return utensils;
        } catch (SQLException exception) {
            throw new AllUtensilException(exception.getMessage());
        }
    }
}
