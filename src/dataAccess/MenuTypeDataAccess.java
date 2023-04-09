package dataAccess;

import model.MenuType;

import java.util.ArrayList;

public interface MenuTypeDataAccess {
    ArrayList<MenuType> getAllMenuTypes() throws MenuTypeException;
}
