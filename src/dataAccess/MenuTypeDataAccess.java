package dataAccess;

import model.MenuType;

import java.util.ArrayList;

public interface MenuTypeDataAccess {
    MenuType getMenuType(String name);
    ArrayList<MenuType> getAllMenuType();
}
