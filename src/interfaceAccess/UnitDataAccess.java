package interfaceAccess;

import exception.UnitException;
import model.Unit;

import java.util.ArrayList;

public interface UnitDataAccess {
    Unit readUnit(int id) throws UnitException;
    ArrayList<Unit> readAllUnit() throws UnitException;
}
