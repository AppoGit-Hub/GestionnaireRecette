package interfaceAccess;

import exception.AllEquipementException;
import model.Equipment;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws AllEquipementException;
}
