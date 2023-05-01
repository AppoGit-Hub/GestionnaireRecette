package dataAccess;

import exception.MenuTypeException;
import interfaceAccess.MenuTypeDataAccess;
import exception.AllMenuTypeException;
import model.MenuType;

import java.sql.*;
import java.util.ArrayList;

public class MenuTypeDataBaseAccess implements MenuTypeDataAccess {
    @Override
    public ArrayList<MenuType> getAllMenuTypes() throws AllMenuTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM menuType";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ArrayList<MenuType> menuTypes = new ArrayList<MenuType>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                MenuType menuType = new MenuType(id, name);
                menuTypes.add(menuType);
            }
            return menuTypes;
        } catch (SQLException exception) {
            throw new AllMenuTypeException();
        }
    }

    @Override
    public MenuType getMenuType(int menuType) throws MenuTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM menuType WHERE id = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, menuType);
            ResultSet data = statement.executeQuery();
            data.next();
            int id = data.getInt("id");
            String name = data.getString("name");
            return new MenuType(id, name);
        } catch (SQLException exception) {
            throw new MenuTypeException();
        }
    }
}
