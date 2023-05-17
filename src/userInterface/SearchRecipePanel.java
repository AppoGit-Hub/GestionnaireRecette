package userInterface;

import controller.IngredientController;
import controller.MenuTypeController;
import controller.SearchController;
import exception.SearchRecipeException;
import exception.TypeException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchRecipePanel extends JPanel implements ActionListener {
    // display the recipes from a specific menu that is hot/cold with a known ingredient
    private JComboBox<MenuType> menuTypeComboBox;
    private DefaultComboBoxModel<MenuType> menuTypeComboBoxModel;
    private JRadioButton isHotButton;
    private JComboBox<Ingredient> ingredientComboBox;
    private DefaultComboBoxModel<Ingredient> ingredientComboBoxModel;
    private JButton recipeSumbitButton;
    private JLabel recipeErrorLabel;
    private JTable recipeTable;

    private SearchController searchController;
    private MenuTypeController menuTypeController;
    private IngredientController ingredientController;

    public SearchRecipePanel() {
        this.searchController = new SearchController();
        this.menuTypeController = new MenuTypeController();
        this.ingredientController = new IngredientController();

        this.menuTypeComboBoxModel = new DefaultComboBoxModel<MenuType>();
        this.menuTypeComboBox = new JComboBox<MenuType>(menuTypeComboBoxModel);
        this.isHotButton = new JRadioButton("isHot");
        this.ingredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.ingredientComboBox = new JComboBox<Ingredient>(ingredientComboBoxModel);

        this.recipeTable = new JTable();
        this.recipeSumbitButton = new JButton("Submit");
        this.recipeSumbitButton.addActionListener(this);
        this.recipeErrorLabel = new JLabel();

        this.setAllMenuType();
        this.setAllIngredient();

        this.setLayout(new BorderLayout());

        JPanel recipeNorthPanel = new JPanel();
        recipeNorthPanel.setLayout(new FlowLayout());
        recipeNorthPanel.add(isHotButton);
        recipeNorthPanel.add(new JLabel("Menu Types:"));
        recipeNorthPanel.add(menuTypeComboBox);
        recipeNorthPanel.add(new JLabel("Ingredients:"));
        recipeNorthPanel.add(ingredientComboBox);
        recipeNorthPanel.add(recipeSumbitButton);

        this.add(recipeNorthPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(recipeTable), BorderLayout.CENTER);
        this.add(recipeErrorLabel, BorderLayout.SOUTH);
    }

    public void setAllMenuType() {
        try {
            ArrayList<MenuType> menuTypes = this.menuTypeController.getAllMenuTypes();
            this.menuTypeComboBoxModel.addAll(menuTypes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.readAllIngredient();
            this.ingredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setRecipe(MenuType menuType, Ingredient ingredient, boolean isHot) {
        try {
            ArrayList<SearchRecipeResult> searchRecipeResults = this.searchController.searchRecipe(ingredient.getName(), isHot, menuType.getId());
            this.recipeTable.setModel(new SearchRecipeTableModel(searchRecipeResults));
        } catch (SearchRecipeException exception) {
            JOptionPane.showMessageDialog(null, "Failed to display recipes", "Failed to Display Recipes", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Submit")) {
            MenuType menuTypeSelected = (MenuType) this.menuTypeComboBox.getSelectedItem();
            Ingredient ingredientSelected = (Ingredient) this.ingredientComboBox.getSelectedItem();
            boolean isHot = this.isHotButton.isSelected();
            if (menuTypeSelected != null) {
                if (ingredientSelected != null) {
                    this.setRecipe(menuTypeSelected, ingredientSelected, isHot);
                } else {
                    JOptionPane.showMessageDialog(null, "You must select an ingredient", "Select an Ingredient", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must select an menu type", "Select a Menu Type", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
