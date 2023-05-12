package dataAccess;

import exception.AllDietException;
import interfaceAccess.DietDataAccess;
import model.Diet;

import java.sql.SQLException;
import java.util.ArrayList;

public class DietDataBaseAcces implements DietDataAccess {
    @Override
    public ArrayList<Diet> getAllDiet() throws AllDietException {
        try {
            // delete this after
            throw new SQLException();
        } catch (SQLException exception) {
            throw new AllDietException();
        }
    }
}
