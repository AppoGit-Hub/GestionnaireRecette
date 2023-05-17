package interfaceAccess;

import exception.*;
import model.Equipment;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> readAllEquipementOf(int recipeCode) throws EquipementException;
    void deleteAllEquipement(int recipeCode) throws EquipementException;

    void createEquipementFor(int recipeCode, String utensilName) throws EquipementException;
    void deleteEquipementFor(int recipe, String utensilName) throws EquipementException;
}
