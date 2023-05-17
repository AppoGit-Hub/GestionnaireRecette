package interfaceAccess;

import exception.UtensilException;
import model.Utensil;

import java.util.ArrayList;

public interface UtensilDataAccess {
    Utensil readUtensil(String name) throws UtensilException;
    ArrayList<Utensil> readAllUtensil() throws UtensilException;
}
