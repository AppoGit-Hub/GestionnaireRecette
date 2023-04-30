package interfaceAccess;

import exception.AllOrderTypeException;
import model.OrderType;
import java.util.ArrayList;

public interface OrderTypeDataAccess {
    void setOrder(OrderType order);
    ArrayList<OrderType> getAllOrder(int recipeCode) throws AllOrderTypeException;
}
