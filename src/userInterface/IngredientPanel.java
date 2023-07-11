package userInterface;

import controller.IngredientController;
import exception.TypeException;
import model.Ingredient;
import model.LineRecipeDisplay;
import model.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientPanel extends JPanel {
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
    private static final int QUANTITY_MIN = 1;
    private static final int QUANTITY_MAX = 1000;

    public IngredientPanel() {
        this.ingredientController = new IngredientController();

        IngredientActionListener ingredientActionListener = new IngredientActionListener();
        this.lineRecipeModel = new DefaultListModel<LineRecipeDisplay>();
        this.lineRecipeList = new JList<LineRecipeDisplay>(lineRecipeModel);
        this.addIngredientButton = new JButton("Add");
        addIngredientButton.addActionListener(ingredientActionListener);
        this.removeIngredientButton = new JButton("Remove");
        removeIngredientButton.addActionListener(ingredientActionListener);
        this.editIngredientButton = new JButton("Edit");
        editIngredientButton.addActionListener(ingredientActionListener);
        this.saveIngredientButton = new JButton("Save");
        saveIngredientButton.addActionListener(ingredientActionListener);
        this.nameIngredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.nameIngredientComboBox = new JComboBox<Ingredient>(nameIngredientComboBoxModel);
        SpinnerNumberModel quantityIngredientModel = new SpinnerNumberModel(1, QUANTITY_MIN, QUANTITY_MAX, 1);
        this.quantityIngredientSpinner = new JSpinner(quantityIngredientModel);
        this.unitIngredientComboBoxModel = new DefaultComboBoxModel<Unit>();
        this.unitIngredientComboBox = new JComboBox<Unit>(unitIngredientComboBoxModel);
        ingredientActionListener.setNameIngredientComboBoxModel(nameIngredientComboBoxModel);
        ingredientActionListener.setQuantityIngredientSpinner(quantityIngredientSpinner);
        ingredientActionListener.setUnitIngredientComboBox(unitIngredientComboBox);
        ingredientActionListener.setLineRecipeModel(lineRecipeModel);
        ingredientActionListener.setLineRecipeList(lineRecipeList);

        this.ingredientPanel = new JPanel();
        this.ingredientPanel.setLayout(new BorderLayout());

        JPanel ingredientWestPanel = new JPanel();
        ingredientWestPanel.setLayout(new GridLayout(7, 1));
        ingredientWestPanel.add(addIngredientButton);
        ingredientWestPanel.add(editIngredientButton);
        ingredientWestPanel.add(saveIngredientButton);
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

    protected void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.readAllIngredient();
            this.nameIngredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void setAllUnit() {
        java.util.List<Unit> units = List.of(Unit.values());
        this.unitIngredientComboBoxModel.addAll(units);
    }

    public JPanel getPanel() {
        return ingredientPanel;
    }
}
