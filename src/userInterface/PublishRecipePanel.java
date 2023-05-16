package userInterface;

import controller.RecipeController;
import exception.*;
import model.ComponentGroup;
import model.FormBuilder;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublishRecipePanel extends GlobalRecipePanel implements ActionListener {
    private RecipeController recipeController;
    private JButton publishRecipeButton;

    public PublishRecipePanel() {
        BorderLayout layout = (BorderLayout) this.getLayout();

        this.recipeController = new RecipeController();
        this.publishRecipeButton = new JButton("Publish");
        this.publishRecipeButton.addActionListener(this);

        this.add(publishRecipeButton, BorderLayout.NORTH);
    }

    public int getNextRecipeCode() {
        try {
            return this.recipeController.getNextCode() + 1;//on a déjà fait plus un pourquoi le refaire
        } catch (NextCodeRecipeException exception) {
            JOptionPane.showMessageDialog(null, "Failed to load recipe code", "Failed To Load", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        int nextCode = getNextRecipeCode();
        if (source.equals("Publish") && nextCode != 1) {
            try {
                Recipe recipe = this.getRecipe(nextCode);
                if (recipe != null) {
                    this.recipeController.createRecipe(recipe);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Recipe Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
