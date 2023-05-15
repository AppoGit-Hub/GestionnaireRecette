package business;

import exception.AllPeriodException;
import exception.CreatePeriodException;
import exception.DeletePeriodException;
import interfaceAccess.PeriodDataAccess;
import dataAccess.PeriodDataBaseAccess;
import model.Period;

import java.util.ArrayList;

public class PeriodManager {
    private PeriodDataAccess periodAccess;

    public PeriodManager() {
        setPeriodAccess(new PeriodDataBaseAccess());
    }

    public void setPeriodAccess(PeriodDataAccess periodAccess) {
        this.periodAccess = periodAccess;
    }

    public ArrayList<Period> getAllPeriod(int recipeCode) throws AllPeriodException {
        return this.periodAccess.getAllPeriod(recipeCode);
    }

    public void createPeriod(int periodRecipe, int menuType) throws CreatePeriodException {
        this.periodAccess.createPeriod(periodRecipe, menuType);
    }
    public void deletePeriod(int periodRecipe, int menuType) throws DeletePeriodException {
        this.periodAccess.deletePeriod(periodRecipe, menuType);
    }
    public void deleteRecipeAllPeriod(int periodRecipe) throws DeletePeriodException  {
        this.periodAccess.deleteRecipeAllPeriod(periodRecipe);
    }
}
