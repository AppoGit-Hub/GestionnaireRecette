package userInterface;

import controller.IngredientController;
import controller.MenuTypeController;
import controller.RecipeController;
import exception.AllIngredientException;
import exception.AllMenuTypeException;
import model.Ingredient;
import model.MenuType;
import model.SearchRecipeTableModel;

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

    private RecipeController recipeController;
    private MenuTypeController menuTypeController;
    private IngredientController ingredientController;

    public SearchRecipePanel() {
        this.recipeController = new RecipeController();
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
        recipeNorthPanel.add(menuTypeComboBox);
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
        } catch (AllMenuTypeException exception) {
            this.recipeErrorLabel.setText("Error loading all menu types");
        }
    }

    public void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.getAllIngredient();
            this.ingredientComboBoxModel.addAll(ingredients);
        } catch (AllIngredientException exception) {
            this.recipeErrorLabel.setText("Error loading all ingredient types");
        }
    }

    public void setRecipe(MenuType menuType, Ingredient ingredient) {
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Submit")) {
            MenuType menuTypeSelected = (MenuType) this.menuTypeComboBox.getSelectedItem();
            Ingredient ingredientSelected = (Ingredient) this.ingredientComboBox.getSelectedItem();
            this.setRecipe(menuTypeSelected, ingredientSelected);
        }
    }
}
