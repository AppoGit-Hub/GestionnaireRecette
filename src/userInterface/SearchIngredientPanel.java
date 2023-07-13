package userInterface;

import business.SearchManager;
import controller.IngredientController;
import controller.SearchController;
import exception.SearchIngredientException;
import exception.TypeException;
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
    private SearchController searchController;
    private static final int DATE_YEAR_MIN = 1950;
    private static final int DATE_YEAR_MAX = 2023;
    public SearchIngredientPanel() {
        this.ingredientController = new IngredientController();
        this.searchController = new SearchController();

        SpinnerNumberModel startDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.startDate = new JSpinner(startDateSpinnerNumber);
        SpinnerNumberModel endDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        this.endDate = new JSpinner(endDateSpinnerNumber);
        this.ingredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.ingredientComboBox = new JComboBox<Ingredient>(ingredientComboBoxModel);
        this.ingredientErrorLabel = new JLabel();
        this.ingredientTable = new JTable();
        this.ingredientSubmitButton = new JButton("Soumettre");
        this.ingredientSubmitButton.addActionListener(this);

        this.setAllIngredient();

        this.setLayout(new BorderLayout());

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new FlowLayout());
        ingredientNorthPanel.add(new JLabel("Date de début:"));
        ingredientNorthPanel.add(startDate);
        ingredientNorthPanel.add(new JLabel("Date de fin:"));
        ingredientNorthPanel.add(endDate);
        ingredientNorthPanel.add(new JLabel("Ingrédients:"));
        ingredientNorthPanel.add(ingredientComboBox);
        ingredientNorthPanel.add(ingredientSubmitButton);

        this.add(ingredientNorthPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(ingredientTable), BorderLayout.CENTER);
        this.add(ingredientErrorLabel, BorderLayout.SOUTH);
    }

    private boolean isStartBeforeEnd() {
        int startYear = (int) this.startDate.getValue();
        int endYear = (int) this.endDate.getValue();
        return startYear <= endYear;
    }

    private void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.readAllIngredient();
            this.ingredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);

        }
    }

    private void setIngredientRecipe(Ingredient ingredient, LocalDate dateBeginning, LocalDate dateEnding) {
        try {
            ArrayList<SearchIngredientResult> searchIngredientResults = this.searchController.searchIngredient(ingredient.getName(), dateBeginning, dateEnding);
            this.ingredientTable.setModel(new SearchIngredientTableModel(searchIngredientResults));
        } catch (SearchIngredientException exception) {
            JOptionPane.showMessageDialog(null, "Échec de l'affichage des ingrédients", "Échec de l'affichage des ingrédients", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Vous devez sélectionner un ingrédient", "Sélectionner un ingrédient", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "L'année de début doit être antérieure à l'année de fin", "Corriger les années", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
