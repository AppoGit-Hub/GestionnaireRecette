package controller;

import business.EquipementManager;
import exception.*;
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

    public ArrayList<Equipment> getAllEquipementOf(int recipeCode) throws EquipementException {
        return this.manager.getAllEquipementOf(recipeCode);
    }

    public void createEquipementFor(int recipeCode, String utensilName) throws EquipementException {
        this.manager.createEquipementFor(recipeCode, utensilName);
    }

    public void deleteEquipementFor(int recipeCode, String utensilName) throws EquipementException {
        this.manager.deleteEquipementFor(recipeCode, utensilName);
    }
    public void deleteAllEquipement(int recipeCode) throws EquipementException {
        this.manager.deleteAllEquipement(recipeCode);
    }
}
