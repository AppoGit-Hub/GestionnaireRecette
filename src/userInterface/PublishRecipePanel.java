package userInterface;

import controller.RecipeController;
import exception.NextCodeRecipeException;
import model.ComponentGroup;
import model.FormBuilder;

import javax.swing.*;
import java.awt.*;

public class PublishRecipePanel extends GlobalRecipePanel {
    private int currentRecipeCode;
    private RecipeController recipeController;
    public PublishRecipePanel() {
        this.recipeController = new RecipeController();
        this.currentRecipeCode = this.getNextRecipeCode();
    }

    public int getNextRecipeCode() {
        try {
            return this.recipeController.getNextCode() + 1;
        }  catch (NextCodeRecipeException exception) {

        }
        return -1;
    }
}
