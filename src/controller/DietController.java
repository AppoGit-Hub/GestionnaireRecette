package controller;

import business.DietManager;
import exception.AllDietException;
import model.Diet;

import java.util.ArrayList;

public class DietController {
    private DietManager manager;

    public DietController() {
        setManager(new DietManager());
    }

    public void setManager(DietManager manager) {
        this.manager = manager;
    }

    public ArrayList<Diet> getAllDiet() throws AllDietException {
        return this.manager.getAllDiet();
    }
}
