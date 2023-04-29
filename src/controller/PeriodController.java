package controller;

import business.PeriodManager;
import exception.AllPeriodException;
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
}
