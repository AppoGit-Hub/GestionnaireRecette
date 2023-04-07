package dataAccess;

import model.ProductionPeriod;

public interface ProductionPeriodDataAccess {
    ProductionPeriod getProductionPeriod(String name);
}
