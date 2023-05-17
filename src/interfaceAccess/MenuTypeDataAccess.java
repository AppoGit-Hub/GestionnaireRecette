package interfaceAccess;

import exception.MenuTypeException;
import model.MenuType;

import java.util.ArrayList;

public interface MenuTypeDataAccess {
    ArrayList<MenuType> readAllMenuTypes() throws MenuTypeException;
    MenuType readMenuType(int menuType) throws MenuTypeException;
}
