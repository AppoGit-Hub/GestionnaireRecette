package interfaceAccess;

import exception.AllOrderTypeException;
import model.OrderType;
import java.util.ArrayList;

public interface OrderTypeDataAccess {
    void setOrderType(OrderType order);
    ArrayList<OrderType> getAllOrderType(int recipeCode) throws AllOrderTypeException;
}
