package business;

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
}
