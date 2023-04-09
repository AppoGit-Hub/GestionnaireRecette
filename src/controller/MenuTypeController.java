package controller;

import business.MenuTypeManager;
import dataAccess.MenuTypeException;
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

    public ArrayList<MenuType> getAllMenuTypes() throws MenuTypeException {
        return manager.getAllMenuTypes();
    }
}
