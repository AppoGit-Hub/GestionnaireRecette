package userInterface;

import controller.IngredientController;
import controller.LineRecipeController;
import controller.UnitController;
import exception.TypeException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IngredientPanel extends JPanel implements ActionListener {
    private JList<LineRecipeDisplay> lineRecipeList;
    private DefaultListModel<LineRecipeDisplay> lineRecipeModel;
    private JButton addIngredientButton;
    private JButton removeIngredientButton;
    private JButton editIngredientButton;
    private JButton saveIngredientButton;
    private JComboBox<Ingredient> nameIngredientComboBox;
    private DefaultComboBoxModel<Ingredient> nameIngredientComboBoxModel;
    private JSpinner quantityIngredientSpinner;
    private JComboBox<Unit> unitIngredientComboBox;
    private DefaultComboBoxModel<Unit> unitIngredientComboBoxModel;

    private JPanel ingredientPanel;

    private IngredientController ingredientController;
    private UnitController unitController;
    private LineRecipeController lineRecipeController;

    private static final int QUANTITY_MIN = 1;
    private static final int QUANTITY_MAX = 1000;

    public IngredientPanel() {
        this.ingredientController = new IngredientController();
        this.unitController = new UnitController();
        this.lineRecipeController = new LineRecipeController();

        this.lineRecipeModel = new DefaultListModel<LineRecipeDisplay>();
        this.lineRecipeList = new JList<LineRecipeDisplay>(lineRecipeModel);
        this.addIngredientButton = new JButton("Ajouter");
        this.addIngredientButton.addActionListener(this);
        this.removeIngredientButton = new JButton("Retirer");
        this.removeIngredientButton.addActionListener(this);
        this.nameIngredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.nameIngredientComboBox = new JComboBox<Ingredient>(nameIngredientComboBoxModel);
        SpinnerNumberModel quantityIngredientModel = new SpinnerNumberModel(1, QUANTITY_MIN, QUANTITY_MAX, 1);
        this.quantityIngredientSpinner = new JSpinner(quantityIngredientModel);
        this.unitIngredientComboBoxModel = new DefaultComboBoxModel<Unit>();
        this.unitIngredientComboBox = new JComboBox<Unit>(unitIngredientComboBoxModel);

        this.ingredientPanel = new JPanel();
        this.ingredientPanel.setLayout(new BorderLayout());

        JPanel ingredientWestPanel = new JPanel();
        ingredientWestPanel.setLayout(new GridLayout(7, 1));
        ingredientWestPanel.add(addIngredientButton);
        ingredientWestPanel.add(removeIngredientButton);

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new GridLayout());
        ingredientNorthPanel.add(nameIngredientComboBox);
        ingredientNorthPanel.add(quantityIngredientSpinner);
        ingredientNorthPanel.add(unitIngredientComboBox);

        this.ingredientPanel.add(ingredientNorthPanel, BorderLayout.NORTH);
        this.ingredientPanel.add(ingredientWestPanel, BorderLayout.WEST);
        this.ingredientPanel.add(lineRecipeList, BorderLayout.CENTER);

        this.setAllIngredient();
        this.setAllUnit();
    }

    private void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.readAllIngredient();
            this.nameIngredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setAllUnit() {
        try {
            ArrayList<Unit> units = this.unitController.readAllUnit();
            this.unitIngredientComboBoxModel.addAll(units);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getPanel() {
        return ingredientPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("Ajouter")) {
            if (nameIngredientComboBoxModel.getSelectedItem() != null) {
                Ingredient ingredient = (Ingredient) nameIngredientComboBoxModel.getSelectedItem();
                int ingredientCount = (int) quantityIngredientSpinner.getValue();
                Unit ingredientUnit = (Unit) unitIngredientComboBox.getSelectedItem();
                if (ingredientUnit != null) {
                    int index = 0;
                    while (index < lineRecipeModel.size() && !(lineRecipeModel.get(index).getIngredient().equals(ingredient.getName()))) {
                        index++;
                    }
                    if (index == lineRecipeModel.size()) {
                        LineRecipeDisplay lineRecipeDisplay = new LineRecipeDisplay(ingredient.getName(), ingredientCount, ingredientUnit);
                        lineRecipeModel.addElement(lineRecipeDisplay);
                    } else {
                        JOptionPane.showMessageDialog(null, "La liste contient déjà cette ingrédient", "Selectionnez un autre ingrédient", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vous devez selectionner une unité", "Selectionnez une unité", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vous devez selectionner un ingrédient", "Selectionnez un ingrédient", JOptionPane.ERROR_MESSAGE);
            }
        } else if (eventName.equals("Retirer")) {
            LineRecipeDisplay selection = lineRecipeList.getSelectedValue();
            if (selection != null) {
                lineRecipeModel.removeElement(selection);
            } else {
                JOptionPane.showMessageDialog(null, "Vous devez selectionner un ingrédient", "Selectionnez un ingrédient", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setIngredientForRecipe(Recipe selection) {
        try {
            lineRecipeModel.removeAllElements();
            ArrayList<LineRecipe> lineRecipes = this.lineRecipeController.readLineRecipeForRecipe(selection.getCode());
            ArrayList<LineRecipeDisplay> lineRecipeDisplays = new ArrayList<>();
            for (LineRecipe lineRecipe : lineRecipes) {
                Integer unit = lineRecipe.getUnit();
                LineRecipeDisplay lineRecipeDisplay =
                        new LineRecipeDisplay(
                                lineRecipe.getIngredient(),
                                lineRecipe.getQuantity(),
                                (unit != null) ? this.unitController.readUnit(unit) : null);
                lineRecipeDisplays.add(lineRecipeDisplay);
            }
            lineRecipeModel.addAll(lineRecipeDisplays);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateIngredient(Recipe selection) {
        try {
            // TODO : do a better job at ingredient values
            ArrayList<LineRecipe> lineRecipes = this.lineRecipeController.readLineRecipeForRecipe(selection.getCode());
            for (LineRecipe lineRecipe : lineRecipes) {
                this.lineRecipeController.deleteLineRecipe(lineRecipe.getIngredient(), selection.getCode());
            }
            Enumeration<LineRecipeDisplay> newLineRecipes = lineRecipeModel.elements();
            while (newLineRecipes.hasMoreElements()) {
                LineRecipeDisplay lineRecipeDisplay = newLineRecipes.nextElement();
                Unit unit = lineRecipeDisplay.getUnit();
                this.lineRecipeController.createLineRecipe(new LineRecipe(lineRecipeDisplay.getIngredient(), selection.getCode(), lineRecipeDisplay.getQuantity(), (unit != null)? unit.getId() : null));
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
