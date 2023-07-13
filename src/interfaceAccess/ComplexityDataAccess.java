package interfaceAccess;

import exception.CommentException;
import exception.ComplexityException;
import model.Complexity;

import java.util.ArrayList;

public interface ComplexityDataAccess {
    Complexity readComplexity(int id) throws ComplexityException;
    ArrayList<Complexity> readAllComplexity() throws ComplexityException;
}
