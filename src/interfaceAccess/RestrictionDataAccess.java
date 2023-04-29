package interfaceAccess;

import model.Diet;
import model.FoodCategory;
import model.Restriction;

public interface RestrictionDataAccess {
    Restriction getRestriction(FoodCategory foodCategory, Diet diet);
}
