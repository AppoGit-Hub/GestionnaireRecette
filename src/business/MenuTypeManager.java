package business;

import dataAccess.MenuTypeDataAccess;
import dataAccess.MenuTypeDataBaseAccess;
import dataAccess.MenuTypeException;
import model.MenuType;

import java.util.ArrayList;

public class MenuTypeManager {
    private MenuTypeDataAccess menuTypeAccess;

    public MenuTypeManager() {
        this.setMenuTypeAcces(new MenuTypeDataBaseAccess());
    }

    public void setMenuTypeAcces(MenuTypeDataAccess menuTypeAccess) {
        this.menuTypeAccess = menuTypeAccess;
    }

    public ArrayList<MenuType> getAllMenuTypes() throws MenuTypeException {
        return menuTypeAccess.getAllMenuTypes();
    }
}
