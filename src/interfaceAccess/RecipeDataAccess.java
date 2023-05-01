package interfaceAccess;

import exception.NextCodeRecipeException;
import model.Recipe;

public interface RecipeDataAccess {
    void create(Recipe recipe);
    Recipe read();
    void update(Recipe recipe);
    void delete(Recipe recipe);

    int getNextCode() throws NextCodeRecipeException;
}
