package interfaceAccess;

import exception.*;
import model.OrderType;
import java.util.ArrayList;

public interface OrderTypeDataAccess {
    ArrayList<OrderType> readAllOrderType(int recipeCode) throws OrderTypeException;
    void createOrderType(int recipeCode, int mealCategory) throws OrderTypeException;
    void deleteOrderType(int recipeCode, int mealCategory) throws OrderTypeException;
    void deleteAllOrderType(int recipeCode) throws OrderTypeException;
}
