package dataAccess;

import model.MenuType;

import java.sql.*;
import java.util.ArrayList;

public class MenuTypeDataBaseAccess implements MenuTypeDataAccess {
    @Override
    public ArrayList<MenuType> getAllMenuTypes() throws MenuTypeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM menuType";
            PreparedStatement statement = connexion.prepareStatement(query);
            ResultSet data = statement.executeQuery();
            ResultSetMetaData meta = data.getMetaData();
            ArrayList<MenuType> menuTypes = new ArrayList<MenuType>();
            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                MenuType menuType = new MenuType(id, name);
                menuTypes.add(menuType);
            }
            return menuTypes;
        } catch (SQLException exception) {
            throw new MenuTypeException();
        }
    }
}
