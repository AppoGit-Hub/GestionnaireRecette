package dataAccess;

import model.Period;
import model.Recipe;

import java.util.ArrayList;

public interface PeriodDataAccess {
    void setPeriod(Period period);
    ArrayList<Period> getPeriod(Recipe recipe);
}
