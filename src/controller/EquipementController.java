package controller;

import business.EquipementManager;
import exception.AllEquipementException;
import exception.CreateEquipementForException;
import exception.DeleteAllEquipementException;
import exception.DeleteEquipementException;
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

    public void createEquipementFor(int recipeCode, String utensilName) throws CreateEquipementForException {
        this.manager.createEquipementFor(recipeCode, utensilName);
    }

    public void deleteEquipementFor(int recipeCode, String utensilName) throws DeleteEquipementException {
        this.manager.deleteEquipementFor(recipeCode, utensilName);
    }
    public void deleteAllEquipement(int recipeCode) throws DeleteAllEquipementException {
        this.manager.deleteAllEquipement(recipeCode);
    }
}
