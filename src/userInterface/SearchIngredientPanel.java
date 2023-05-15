package userInterface;

import business.SearchManager;
import controller.IngredientController;
import exception.AllIngredientException;
import exception.SearchIngredientException;
import model.Ingredient;
import model.SearchIngredientResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchIngredientPanel extends JPanel implements ActionListener {
    // display ingredients of recipes publish between 2 dates
    private JSpinner startDate;
    private JSpinner endDate;
    private JComboBox<Ingredient> ingredientComboBox;
    private DefaultComboBoxModel<Ingredient> ingredientComboBoxModel;
    private JLabel ingredientErrorLabel;
    private JButton ingredientSubmitButton;
    private JTable ingredientTable;
    private IngredientController ingredientController;
    private SearchManager searchManager;
    private static final int DATE_YEAR_MIN = 1950;
    private static final int DATE_YEAR_MAX = 2023;
    public SearchIngredientPanel() {
        this.ingredientController = new IngredientController();
        this.searchManager = new SearchManager();

        SpinnerNumberModel startDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.startDate = new JSpinner(startDateSpinnerNumber);
        SpinnerNumberModel endDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.endDate = new JSpinner(endDateSpinnerNumber);
        this.ingredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.ingredientComboBox = new JComboBox<Ingredient>(ingredientComboBoxModel);
        this.ingredientErrorLabel = new JLabel();
        this.ingredientTable = new JTable();
        this.ingredientSubmitButton = new JButton("Submit");
        this.ingredientSubmitButton.addActionListener(this);

        this.setAllIngredient();

        this.setLayout(new BorderLayout());

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new FlowLayout());
        ingredientNorthPanel.add(new JLabel("Start Date:"));
        ingredientNorthPanel.add(startDate);
        ingredientNorthPanel.add(new JLabel("End Date:"));
        ingredientNorthPanel.add(endDate);
        ingredientNorthPanel.add(new JLabel("Ingredients:"));
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
            JOptionPane.showMessageDialog(null, "Failed to load ingredients", "Failed to Load ingredients", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void setIngredientRecipe(Ingredient ingredient, LocalDate dateBeginning, LocalDate dateEnding) {
        try {
            ArrayList<SearchIngredientResult> searchIngredientResults = this.searchManager.searchIngredient(ingredient.getName(), dateBeginning, dateEnding);
            this.ingredientTable.setModel(new SearchIngredientTableModel(searchIngredientResults));
        } catch (SearchIngredientException exception) {
            JOptionPane.showMessageDialog(null, "Failed to display ingredients", "Failed to Display Ingredients", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Submit")) {
            if (isStartBeforeEnd()) {
                Ingredient ingredient = (Ingredient) this.ingredientComboBox.getSelectedItem();
                if (ingredient != null) {
                    LocalDate dateBeginning = LocalDate.of((int) this.startDate.getValue(), 1, 1);
                    LocalDate dateEnding = LocalDate.of((int) this.endDate.getValue(), 12, 31);
                    this.setIngredientRecipe(ingredient, dateBeginning, dateEnding);
                } else {
                    JOptionPane.showMessageDialog(null, "You must select an ingredient", "Select an ingredient", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The start year must be before the end year", "Correct The Years", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
