package business;

import dataAccess.OrderTypeDataBaseAccess;
import exception.*;
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

    public ArrayList<OrderType> readAllOrderType(int recipeCode) throws OrderTypeException {
        return this.orderTypeAccess.readAllOrderType(recipeCode);
    }

    public void createOrderType(int recipeCode, int mealCategory) throws OrderTypeException {
        this.orderTypeAccess.createOrderType(recipeCode, mealCategory);
    }

    public void deleteOrderType(int recipeCode, int mealCategory) throws OrderTypeException {
        this.orderTypeAccess.deleteOrderType(recipeCode, mealCategory);
    }
    public void deleteAllOrder(int recipeCode) throws OrderTypeException {
        this.orderTypeAccess.deleteAllOrderType(recipeCode);
    }
}
