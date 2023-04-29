package interfaceAccess;

import exception.AllOrderException;
import model.Order;
import java.util.ArrayList;

public interface OrderDataAccess  {
    void setOrder(Order order);
    ArrayList<Order> getAllOrder(int recipeCode) throws AllOrderException;
}
