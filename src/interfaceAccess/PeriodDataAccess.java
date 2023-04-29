package interfaceAccess;

import exception.AllPeriodException;
import model.Period;

import java.util.ArrayList;

public interface PeriodDataAccess {
    void setPeriod(Period period);
    ArrayList<Period> getAllPeriod(int recipeCode) throws AllPeriodException;
}
