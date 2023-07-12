package business;

import dataAccess.ComplexityDataBaseAccess;
import exception.CommentException;
import exception.ComplexityException;
import interfaceAccess.ComplexityDataAccess;
import model.Complexity;

import java.util.ArrayList;

public class ComplexityManager {
    private ComplexityDataAccess complexityDataAccess;

    public ComplexityManager() {
        setComplexityDataAccess(new ComplexityDataBaseAccess());
    }

    public void setComplexityDataAccess(ComplexityDataAccess complexityDataAccess) {
        this.complexityDataAccess = complexityDataAccess;
    }

    public ArrayList<Complexity> readAllComplexity() throws ComplexityException {
        return complexityDataAccess.readAllComplexity();
    }
}
