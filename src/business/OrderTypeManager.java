package business;

import dataAccess.OrderTypeDataBaseAccess;
import exception.AllOrderTypeException;
import interfaceAccess.OrderTypeDataAccess;
import model.OrderType;

import java.util.ArrayList;

public class OrderTypeManager {
    private OrderTypeDataAccess orderTypeAccess;

    public OrderTypeManager() {
        setOrderTypeAccess(new OrderTypeDataBaseAccess());
    }

    public void setOrderTypeAccess(OrderTypeDataAccess orderTypeAccess) {
        this.orderTypeAccess = orderTypeAccess;
    }

    public ArrayList<OrderType> getAllOrderType(int recipeCode) throws AllOrderTypeException {
        return this.orderTypeAccess.getAllOrderType(recipeCode);
    }
}
