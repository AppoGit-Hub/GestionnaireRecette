package controller;

import business.OrderTypeManager;
import exception.*;
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

    public ArrayList<OrderType> readAllOrderType(int recipeCode) throws OrderTypeException {
        return this.manager.readAllOrderType(recipeCode);
    }

    public void createOrderType(int recipeCode, int mealCategory) throws OrderTypeException {
        this.manager.createOrderType(recipeCode, mealCategory);
    }

    public void deleteOrderType(int recipeCode, int mealCategory) throws OrderTypeException {
        this.manager.deleteOrderType(recipeCode, mealCategory);
    }
    public void deleteAllOrder(int recipeCode) throws OrderTypeException {
        this.manager.deleteAllOrder(recipeCode);
    }
}
