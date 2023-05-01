package controller;

import business.OrderTypeManager;
import exception.AllOrderTypeException;
import model.OrderType;

import java.util.ArrayList;

public class OrderTypeController {
    private OrderTypeManager manager;

    public OrderTypeController() {
        setManager(new OrderTypeManager());
    }

    public void setManager(OrderTypeManager manager) {
        this.manager = manager;
    }

    public ArrayList<OrderType> getAllOrderType(int recipeCode) throws AllOrderTypeException {
        return this.manager.getAllOrderType(recipeCode);
    }
}
