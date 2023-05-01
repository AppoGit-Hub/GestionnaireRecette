package controller;

import business.MenuTypeManager;
import exception.AllMenuTypeException;
import exception.MenuTypeException;
import model.MenuType;

import java.util.ArrayList;

public class MenuTypeController {
    private MenuTypeManager manager;

    public MenuTypeController() {
        setManager(new MenuTypeManager());
    }

    public void setManager(MenuTypeManager manager) {
        this.manager = manager;
    }

    public ArrayList<MenuType> getAllMenuTypes() throws AllMenuTypeException {
        return manager.getAllMenuTypes();
    }

    public MenuType getMenuType(int menuType) throws MenuTypeException {
        return manager.getMenuType(menuType);
    }
}
