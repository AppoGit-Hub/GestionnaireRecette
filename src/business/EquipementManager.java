package business;

import interfaceAccess.EquipementDataAccess;
import dataAccess.EquipementDataBaseAccess;
import exception.EquipementException;
import model.Equipment;
import model.Recipe;

import java.util.ArrayList;

public class EquipementManager {
    private EquipementDataAccess equipementAccess;

    public EquipementManager() {
        setEquipementAccess(new EquipementDataBaseAccess());
    }

    public void setEquipementAccess(EquipementDataAccess equipementAccess) {
        this.equipementAccess = equipementAccess;
    }

    public ArrayList<Equipment> getEquipementOf(Recipe recipe) throws EquipementException {
        return this.equipementAccess.getEquipementOf(recipe);
    }
}
