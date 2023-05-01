package business;

import dataAccess.UtensilDataBaseAccess;
import exception.AllUtensilException;
import exception.UtensilException;
import interfaceAccess.UtensilDataAccess;
import model.Utensil;

import java.util.ArrayList;

public class UtensilManager {
    private UtensilDataAccess utensilAccess;

    public UtensilManager() {
        setUtensilAccess(new UtensilDataBaseAccess());
    }

    public void setUtensilAccess(UtensilDataAccess utensilAccess) {
        this.utensilAccess = utensilAccess;
    }

    public Utensil getUtensil(String name) throws UtensilException {
        return this.utensilAccess.getUtensil(name);
    }

    public ArrayList<Utensil> getAllUtensil() throws AllUtensilException {
        return this.utensilAccess.getAllUtensil();
    }
}
