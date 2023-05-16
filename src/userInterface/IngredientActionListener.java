package userInterface;

import model.Ingredient;
import model.LineRecipeDisplay;
import model.Unit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredientActionListener implements ActionListener {
    private DefaultComboBoxModel<Ingredient> nameIngredientComboBoxModel;
    private JSpinner quantityIngredientSpinner;
    private JComboBox<Unit> unitIngredientComboBox;
    private DefaultListModel<LineRecipeDisplay> lineRecipeModel;
    private JList<LineRecipeDisplay> lineRecipeList;
    public void setNameIngredientComboBoxModel(DefaultComboBoxModel<Ingredient> model) {
        this.nameIngredientComboBoxModel = model;
    }

    public void setQuantityIngredientSpinner(JSpinner spinner) {
        this.quantityIngredientSpinner = spinner;
    }

    public void setUnitIngredientComboBox(JComboBox<Unit> comboBox) {
        this.unitIngredientComboBox = comboBox;
    }

    public void setLineRecipeModel(DefaultListModel<LineRecipeDisplay> list) {
        this.lineRecipeModel = list;
    }

    public void setLineRecipeList(JList<LineRecipeDisplay> list) {
        this.lineRecipeList = list;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("Add") && nameIngredientComboBoxModel.getSelectedItem() != null) {
            Ingredient ingredient = (Ingredient) nameIngredientComboBoxModel.getSelectedItem();
            int ingredientCount = (int) quantityIngredientSpinner.getValue();
            Unit ingredientUnit = (Unit) unitIngredientComboBox.getSelectedItem();
            LineRecipeDisplay lineRecipeDisplay = new LineRecipeDisplay(ingredient.getName(), ingredientCount, ingredientUnit);
            lineRecipeModel.addElement(lineRecipeDisplay);
        } else if (eventName.equals("Remove")) {
            LineRecipeDisplay selection = lineRecipeList.getSelectedValue();
            if (selection != null) {
                lineRecipeModel.removeElement(selection);
            }
        }
        // is edit and save even relevant in the sub menu ???
    }
}
