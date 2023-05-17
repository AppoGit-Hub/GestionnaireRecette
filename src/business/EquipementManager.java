package business;

import exception.*;
import interfaceAccess.EquipementDataAccess;
import dataAccess.EquipementDataBaseAccess;
import model.Equipment;

import java.util.ArrayList;

public class EquipementManager {
    private EquipementDataAccess equipementAccess;

    public EquipementManager() {
        setEquipementAccess(new EquipementDataBaseAccess());
    }

    public void setEquipementAccess(EquipementDataAccess equipementAccess) {
        this.equipementAccess = equipementAccess;
    }

    public ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws EquipementException {
        return this.equipementAccess.readAllEquipementOf(recipeCode);
    }

    public void createEquipementFor(int recipeCode, String utensilName) throws EquipementException {
        this.equipementAccess.createEquipementFor(recipeCode, utensilName);
    }

    public void deleteEquipementFor(int recipeCode, String utensilName) throws EquipementException {
        this.equipementAccess.deleteEquipementFor(recipeCode, utensilName);
    }
    public void deleteAllEquipement(int recipeCode) throws EquipementException {
        this.equipementAccess.deleteAllEquipement(recipeCode);
    }
}
