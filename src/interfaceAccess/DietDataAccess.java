package interfaceAccess;

import exception.DietException;
import model.Diet;

import java.util.ArrayList;

public interface DietDataAccess {
    ArrayList<Diet> readAllDiet() throws DietException;
}
