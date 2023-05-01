package controller;

import business.UtensilManager;
import exception.AllUtensilException;
import exception.UtensilException;
import model.Utensil;

import java.util.ArrayList;

public class UtensilController {
    private UtensilManager manager;

    public UtensilController() {
        setManager(new UtensilManager());
    }

    public void setManager(UtensilManager manager) {
        this.manager = manager;
    }

    public Utensil getUtensil(String name) throws UtensilException {
        return this.manager.getUtensil(name);
    }

    public ArrayList<Utensil> getAllUtensil() throws AllUtensilException {
        return this.manager.getAllUtensil();
    }
}
