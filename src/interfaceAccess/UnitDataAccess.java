package interfaceAccess;

import exception.UnitException;
import model.Unit;

import java.util.ArrayList;

public interface UnitDataAccess {
    ArrayList<Unit> readAllUnit() throws UnitException;
}
