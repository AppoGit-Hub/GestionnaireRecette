package interfaceAccess;

import exception.AllDietException;
import model.Diet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface DietDataAccess {
    ArrayList<Diet> getAllDiet() throws AllDietException;
}
