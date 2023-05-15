package business;

import dataAccess.OrderTypeDataBaseAccess;
import exception.AllOrderTypeException;
import exception.CreateOrderTypeException;
import exception.DeleteOrderTypeException;
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

    public void createOrderType(int recipeCode, int mealCategory) throws CreateOrderTypeException {
        this.orderTypeAccess.createOrderType(recipeCode, mealCategory);
    }

    public void deleteOrderType(int recipeCode, int mealCategory) throws DeleteOrderTypeException {
        this.orderTypeAccess.deleteOrderType(recipeCode, mealCategory);
    }
    public void deleteAllOrder(int recipeCode) throws DeleteOrderTypeException {
        this.orderTypeAccess.deleteRecipeAllOrderType(recipeCode);
    }
}
