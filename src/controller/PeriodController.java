package controller;

import business.PeriodManager;
import exception.*;
import model.Period;

import java.util.ArrayList;

public class PeriodController {
    private PeriodManager manager;

    public PeriodController() {
        setManager(new PeriodManager());
    }

    public void setManager(PeriodManager manager) {
        this.manager = manager;
    }

    public ArrayList<Period> readAllPeriod(int recipeCode) throws PeriodException {
        return this.manager.readAllPeriod(recipeCode);
    }
    public void createPeriod(int periodRecipe, int menuType) throws PeriodException {
        this.manager.createPeriod(periodRecipe, menuType);
    }
    public void deletePeriod(int periodRecipe, int menuType) throws PeriodException {
        this.manager.deletePeriod(periodRecipe, menuType);
    }
    public void deleteAllPeriod(int periodRecipe) throws PeriodException {
        this.manager.deleteAllPeriod(periodRecipe);
    }
}
