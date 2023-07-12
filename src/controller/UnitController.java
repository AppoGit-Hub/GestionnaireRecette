package controller;

import business.UnitManager;
import exception.UnitException;
import model.Unit;

import java.util.ArrayList;

public class UnitController {
    private UnitManager manager;

    public UnitController() {
        setManager(new UnitManager());
    }

    public void setManager(UnitManager manager) {
        this.manager = manager;
    }

    public ArrayList<Unit> readAllUnit() throws UnitException {
        return this.manager.readAllUnit();
    }
}
