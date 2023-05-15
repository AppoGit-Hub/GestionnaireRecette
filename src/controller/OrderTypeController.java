package controller;

import business.OrderTypeManager;
import exception.AllOrderTypeException;
import exception.CreateOrderTypeException;
import exception.DeleteAllOrderTypeException;
import exception.DeleteOrderTypeException;
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

    public void createOrderType(int recipeCode, int mealCategory) throws CreateOrderTypeException {
        this.manager.createOrderType(recipeCode, mealCategory);
    }

    public void deleteOrderType(int recipeCode, int mealCategory) throws DeleteOrderTypeException {
        this.manager.deleteOrderType(recipeCode, mealCategory);
    }
    public void deleteAllOrder(int recipeCode) throws DeleteAllOrderTypeException {
        this.manager.deleteAllOrder(recipeCode);
    }
}
