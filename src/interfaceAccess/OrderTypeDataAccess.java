package interfaceAccess;

import exception.*;
import model.OrderType;
import java.util.ArrayList;

public interface OrderTypeDataAccess {
    ArrayList<OrderType> readAllOrderType(Integer recipeCode) throws OrderTypeException;
    void createOrderType(Integer recipeCode, Integer mealCategory) throws OrderTypeException;
    void deleteOrderType(Integer recipeCode, Integer mealCategory) throws OrderTypeException;
    void deleteAllOrderType(Integer recipeCode) throws OrderTypeException;
}
