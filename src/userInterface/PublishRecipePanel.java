package userInterface;

import controller.RecipeController;
import model.ComponentGroup;
import model.FormBuilder;

import javax.swing.*;
import java.awt.*;

public class PublishRecipePanel extends GlobalRecipePanel {
    private RecipeController recipeController;
    private JScrollPane jScrollPane;
    public PublishRecipePanel() {
            recipeController = new RecipeController();//comme cela je me 'branche au controller'
    }
}
