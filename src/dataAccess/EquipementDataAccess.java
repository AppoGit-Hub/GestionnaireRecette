package dataAccess;

import model.Equipment;
import model.Recipe;

import java.util.ArrayList;

public interface EquipementDataAccess {
    ArrayList<Equipment> getEquipement(Recipe recipe);
    void setEquipement(Recipe recipe, Equipment equipment);

}
