package controller;

import business.EquipementManager;
import exception.AllEquipementException;
import model.Equipment;

import java.util.ArrayList;

public class EquipementController {
    private EquipementManager manager;

    public EquipementController() {
        setManager(new EquipementManager());
    }

    public void setManager(EquipementManager manager) {
        this.manager = manager;
    }

    public ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws AllEquipementException {
        return this.manager.getAllEquipementOf(recipeCode);
    }
}
