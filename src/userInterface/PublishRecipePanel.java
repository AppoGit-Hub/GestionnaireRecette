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

public class PublishRecipePanel extends JPanel implements ActionListener {
    private GeneralRecipePanel generalPanel;
    private IngredientPanel ingredientPanel;
    private MealCategoryPanel mealCategoryPanel;
    private MenuTypePanel menuTypePanel;
    private RecipeStepPanel recipeStepPanel;
    private UtensilPanel utensilPanel;
    private JButton publishRecipeButton;
    private JTabbedPane tabs;
    private RecipeController recipeController;

    public PublishRecipePanel() {
        this.setLayout(new BorderLayout());

        this.recipeController = new RecipeController();

        this.generalPanel = new GeneralRecipePanel();
        this.ingredientPanel = new IngredientPanel();
        this.mealCategoryPanel = new MealCategoryPanel();
        this.menuTypePanel = new MenuTypePanel();
        this.recipeStepPanel = new RecipeStepPanel();
        this.utensilPanel = new UtensilPanel();

        this.publishRecipeButton = new JButton("Publier");
        this.publishRecipeButton.addActionListener(this);
        this.add(publishRecipeButton, BorderLayout.NORTH);

        this.tabs = new JTabbedPane();
        this.tabs.insertTab("Général", null, generalPanel.getPanel(), "Panneau Général", 0);
        this.tabs.insertTab("Ustensiles", null, utensilPanel.getPanel(), "Panneau des Ustensiles", 1);
        this.tabs.insertTab("Type de Menu", null, menuTypePanel.getPanel(), "Panneau des Types de Menu", 2);
        this.tabs.insertTab("Catégorie de Repas", null, mealCategoryPanel.getPanel(), "Panneau des Catégories de Repas", 3);
        this.tabs.insertTab("Étapes de la Recette", null, recipeStepPanel.getPanel(), "Panneau des Étapes de la Recette", 4);
        this.tabs.insertTab("Ingrédient", null, ingredientPanel.getPanel(), "Panneau des Ingrédients", 5);

        this.add(this.tabs, BorderLayout.CENTER);
    }

    private int getNextRecipeCode() {
        try {
            return this.recipeController.getNextCode() + 1;
        } catch (NextCodeRecipeException exception) {
            JOptionPane.showMessageDialog(null, "Échec du chargement du code de la recette", "Échec du chargement", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        int nextCode = getNextRecipeCode();
        if (source.equals("Publier") && nextCode != 1) {
            try {
                Recipe recipe = this.generalPanel.getRecipe(nextCode);
                if (recipe != null) {
                    this.recipeController.createRecipe(recipe);
                }
            } catch (TypeException exception) {
                JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
