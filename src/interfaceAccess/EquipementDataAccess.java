package interfaceAccess;

import exception.AllEquipementException;
import exception.CreateEquipementForException;
import exception.DeleteEquipementException;
import exception.IsEquipementExistException;
import model.Equipment;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws AllEquipementException;
    void createEquipementFor(int recipeCode, String utensilName) throws CreateEquipementForException;
    void deleteEquipementFor(int recipe, String utensilName) throws DeleteEquipementException;
}
