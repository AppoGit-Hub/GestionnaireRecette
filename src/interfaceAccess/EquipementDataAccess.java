package interfaceAccess;

import exception.*;
import model.Equipment;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> readAllEquipementOf(Integer recipeCode) throws EquipementException;
    void deleteAllEquipement(Integer recipeCode) throws EquipementException;

    void createEquipementFor(Integer recipeCode, String utensilName) throws EquipementException;
    void deleteEquipementFor(Integer recipe, String utensilName) throws EquipementException;
}
