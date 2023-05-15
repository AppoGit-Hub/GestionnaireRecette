package business;

import exception.CreateEquipementForException;
import exception.DeleteAllEquipementException;
import exception.DeleteEquipementException;
import interfaceAccess.EquipementDataAccess;
import dataAccess.EquipementDataBaseAccess;
import exception.AllEquipementException;
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

    public ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws AllEquipementException {
        return this.equipementAccess.getAllEquipementOf(recipeCode);
    }

    public void createEquipementFor(int recipeCode, String utensilName) throws CreateEquipementForException {
        this.equipementAccess.createEquipementFor(recipeCode, utensilName);
    }

    public void deleteEquipementFor(int recipeCode, String utensilName) throws DeleteEquipementException {
        this.equipementAccess.deleteEquipementFor(recipeCode, utensilName);
    }
    public void deleteAllEquipement(int recipeCode) throws DeleteAllEquipementException {
        this.equipementAccess.deleteAllEquipement(recipeCode);
    }
}
