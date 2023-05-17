package business;

import exception.*;
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

    public ArrayList<Period> readAllPeriod(int recipeCode) throws PeriodException {
        return this.periodAccess.readAllPeriod(recipeCode);
    }

    public void createPeriod(int periodRecipe, int menuType) throws PeriodException {
        this.periodAccess.createPeriod(periodRecipe, menuType);
    }
    public void deletePeriod(int periodRecipe, int menuType) throws PeriodException {
        this.periodAccess.deletePeriod(periodRecipe, menuType);
    }
    public void deleteAllPeriod(int periodRecipe) throws PeriodException {
        this.periodAccess.deleteAllPeriod(periodRecipe);
    }
}
