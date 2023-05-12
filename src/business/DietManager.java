package business;

import dataAccess.DietDataBaseAcces;
import exception.AllDietException;
import interfaceAccess.DietDataAccess;
import model.Diet;

import java.util.ArrayList;

public class DietManager {
    private DietDataAccess dietAccess;

    public DietManager() {
        setDietAccess(new DietDataBaseAcces());
    }

    public void setDietAccess(DietDataAccess dietAccess) {
        this.dietAccess = dietAccess;
    }

    public ArrayList<Diet> getAllDiet() throws AllDietException {
        return this.dietAccess.getAllDiet();
    }
}
