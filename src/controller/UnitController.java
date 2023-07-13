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

    public Unit readUnit(int id) throws UnitException {
        return this.manager.readUnit(id);
    }

    public ArrayList<Unit> readAllUnit() throws UnitException {
        return this.manager.readAllUnit();
    }
}
