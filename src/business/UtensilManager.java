package business;

import dataAccess.UtensilDataBaseAccess;
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

    public Utensil readUtensil(String name) throws UtensilException {
        return this.utensilAccess.readUtensil(name);
    }

    public ArrayList<Utensil> readAllUtensil() throws UtensilException {
        return this.utensilAccess.readAllUtensil();
    }
}
