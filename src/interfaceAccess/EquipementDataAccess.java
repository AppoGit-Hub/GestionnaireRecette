package interfaceAccess;

import exception.EquipementException;
import model.Equipment;
import model.Recipe;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> getEquipementOf(Recipe recipe) throws EquipementException;
}
