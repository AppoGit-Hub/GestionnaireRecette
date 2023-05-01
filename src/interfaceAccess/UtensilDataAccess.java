package interfaceAccess;

import exception.AllUtensilException;
import exception.UtensilException;
import model.Utensil;

import java.util.ArrayList;

public interface UtensilDataAccess {
    Utensil getUtensil(String name) throws UtensilException;
    ArrayList<Utensil> getAllUtensil() throws AllUtensilException;
}
