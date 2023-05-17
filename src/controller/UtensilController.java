package controller;

import business.UtensilManager;
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

    public Utensil readUtensil(String name) throws UtensilException {
        return this.manager.readUtensil(name);
    }
    public ArrayList<Utensil> readAllUtensil() throws UtensilException {
        return this.manager.readAllUtensil();
    }
}
