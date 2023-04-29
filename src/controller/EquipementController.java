package controller;

import business.EquipementManager;
import exception.EquipementException;
import model.Equipment;
import model.Recipe;

import java.util.ArrayList;

public class EquipementController {
    private EquipementManager manager;

    public EquipementController() {
        setManager(new EquipementManager());
    }

    public void setManager(EquipementManager manager) {
        this.manager = manager;
    }

    public ArrayList<Equipment> getEquipementOf(Recipe recipe) throws EquipementException {
        return this.manager.getEquipementOf(recipe);
    }
}
