package controller;

import business.DietManager;
import exception.DietException;
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

    public ArrayList<Diet> readAllDiet() throws DietException {
        return this.manager.readAllDiet();
    }
}
