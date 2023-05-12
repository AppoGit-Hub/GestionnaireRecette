package userInterface;

import controller.IngredientController;
import exception.AllIngredientException;
import model.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchIngredientPanel extends JPanel {
    // display ingredients of recipes publish between 2 dates
    private JSpinner startDate;
    private JSpinner endDate;
    private JComboBox<Ingredient> ingredientComboBox;
    private DefaultComboBoxModel<Ingredient> ingredientComboBoxModel;
    private JLabel ingredientErrorLabel;
    private JButton ingredientSubmitButton;
    private JTable ingredientTable;
    private IngredientController ingredientController;
    private static final int DATE_YEAR_MIN = 1950;
    private static final int DATE_YEAR_MAX = 2023;
    public SearchIngredientPanel() {
        this.ingredientController = new IngredientController();

        SpinnerNumberModel startDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.startDate = new JSpinner(startDateSpinnerNumber);
        SpinnerNumberModel endDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.endDate = new JSpinner(endDateSpinnerNumber);
        this.ingredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.ingredientComboBox = new JComboBox<Ingredient>(ingredientComboBoxModel);
        this.ingredientErrorLabel = new JLabel();
        this.ingredientTable = new JTable();
        this.ingredientSubmitButton = new JButton("Submit");

        this.setAllIngredient();

        this.setLayout(new BorderLayout());

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new FlowLayout());
        ingredientNorthPanel.add(startDate);
        ingredientNorthPanel.add(endDate);
        ingredientNorthPanel.add(ingredientComboBox);
        ingredientNorthPanel.add(ingredientSubmitButton);

        this.add(ingredientNorthPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(ingredientTable), BorderLayout.CENTER);
        this.add(ingredientErrorLabel, BorderLayout.SOUTH);
    }

    public boolean isStartBeforeEnd() {
        int startYear = (int) this.startDate.getValue();
        int endYear = (int) this.startDate.getValue();
        return startYear <= endYear;
    }

    public void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.getAllIngredient();
            this.ingredientComboBoxModel.addAll(ingredients);
        } catch (AllIngredientException exception) {
            this.ingredientErrorLabel.setText("Error loading ingredients");
        }
    }
}
