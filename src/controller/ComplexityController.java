package controller;

import business.ComplexityManager;
import exception.ComplexityException;
import model.Complexity;

import java.util.ArrayList;

public class ComplexityController {
    private ComplexityManager manager;

    public ComplexityController() {
        setManager(new ComplexityManager());
    }

    public void setManager(ComplexityManager manager) {
        this.manager = manager;
    }

    public Complexity readComplexity(int id) throws ComplexityException {
        return manager.readComplexity(id);
    }

    public ArrayList<Complexity> readAllComplexity() throws ComplexityException {
        return manager.readAllComplexity();
    }
}
