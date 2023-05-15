package interfaceAccess;

import exception.AllOrderTypeException;
import exception.CreateOrderTypeException;
import exception.DeleteAllOrderTypeException;
import exception.DeleteOrderTypeException;
import model.OrderType;
import java.util.ArrayList;

public interface OrderTypeDataAccess {
    ArrayList<OrderType> getAllOrderType(int recipeCode) throws AllOrderTypeException;
    void createOrderType(int recipeCode, int mealCategory) throws CreateOrderTypeException;
    void deleteOrderType(int recipeCode, int mealCategory) throws DeleteOrderTypeException;
    void deleteAllOrderType(int recipeCode) throws DeleteAllOrderTypeException;
}
