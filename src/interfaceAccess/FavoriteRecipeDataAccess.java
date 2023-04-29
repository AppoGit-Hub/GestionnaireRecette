package interfaceAccess;

import model.FavoriteRecipe;
import model.Person;

public interface FavoriteRecipeDataAccess {
    FavoriteRecipe getFavoriteRecipe(Person person);
    void setFavoriteRecipe(Person person, FavoriteRecipe favoriteRecipe);
}
