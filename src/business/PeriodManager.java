package business;

import exception.AllPeriodException;
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
}
