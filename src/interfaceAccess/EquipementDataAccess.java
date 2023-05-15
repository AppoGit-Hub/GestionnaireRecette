package interfaceAccess;

import exception.*;
import model.Equipment;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws AllEquipementException;
    void createEquipementFor(int recipeCode, String utensilName) throws CreateEquipementForException;
    void deleteEquipementFor(int recipe, String utensilName) throws DeleteEquipementException;
    void deleteAllEquipement(int recipeCode) throws DeleteAllEquipementException;
}
