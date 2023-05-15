package controller;

import business.PeriodManager;
import exception.AllPeriodException;
import exception.CreatePeriodException;
import exception.DeletePeriodException;
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

    public ArrayList<Period> getAllPeriod(int recipeCode) throws AllPeriodException {
        return this.manager.getAllPeriod(recipeCode);
    }
    public void createPeriod(int periodRecipe, int menuType) throws CreatePeriodException {
        this.manager.createPeriod(periodRecipe, menuType);
    }
    public void deletePeriod(int periodRecipe, int menuType) throws DeletePeriodException {
        this.manager.deletePeriod(periodRecipe, menuType);
    }
    public void deleteAllPeriod(int periodRecipe) throws DeletePeriodException {
        this.manager.deleteAllPeriod(periodRecipe);
    }
}
