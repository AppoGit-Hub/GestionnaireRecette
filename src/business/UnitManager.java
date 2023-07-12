package business;

import dataAccess.UnitDataBaseAccess;
import exception.UnitException;
import interfaceAccess.UnitDataAccess;
import model.Unit;

import java.util.ArrayList;

public class UnitManager {
    private UnitDataAccess unitDataAccess;

    public UnitManager() {
        setUnitDataAccess(new UnitDataBaseAccess());
    }

    public void setUnitDataAccess(UnitDataAccess unitDataAccess) {
        this.unitDataAccess = unitDataAccess;
    }

    public ArrayList<Unit> readAllUnit() throws UnitException {
        return this.unitDataAccess.readAllUnit();
    }
}
