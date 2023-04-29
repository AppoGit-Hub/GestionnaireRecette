package interfaceAccess;

import exception.UtensilException;
import model.Utensil;

public interface UtensilDataAccess {
    Utensil getUtensil(String name) throws UtensilException;
}
