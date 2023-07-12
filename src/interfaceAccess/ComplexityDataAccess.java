package interfaceAccess;

import exception.CommentException;
import exception.ComplexityException;
import model.Complexity;

import java.util.ArrayList;

public interface ComplexityDataAccess {
    ArrayList<Complexity> readAllComplexity() throws ComplexityException;
}
