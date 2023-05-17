package business;

import exception.MenuTypeException;
import interfaceAccess.MenuTypeDataAccess;
import dataAccess.MenuTypeDataBaseAccess;
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

    public ArrayList<MenuType> readAllMenuTypes() throws MenuTypeException {
        return menuTypeAccess.readAllMenuTypes();
    }
    public MenuType readMenuType(int menuType) throws MenuTypeException {
        return menuTypeAccess.readMenuType(menuType);
    }
}
