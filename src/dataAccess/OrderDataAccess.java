package dataAccess;

import model.Order;
import model.Recipe;

import java.util.ArrayList;

public interface OrderDataAccess {
    void setOrder(Order order);
    ArrayList<Order> getOrder(Recipe recipe);
}
