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
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SearchIngredientPanel extends JPanel implements ActionListener {
    // display ingredients of recipes publish between 2 dates
   // private JSpinner startDate;
    //private JSpinner endDate;
    JSpinner endDate, startDate;
    private JComboBox<Ingredient> ingredientComboBox;
    private DefaultComboBoxModel<Ingredient> ingredientComboBoxModel;
    private JLabel ingredientErrorLabel;
    private JButton SubmitButton;
    private JTable ingredientTable;
    private IngredientController ingredientController;
    private SearchController searchController;
    private static final int DATE_YEAR_MIN = 1950;
    private static final int DATE_YEAR_MAX = 2023;
    public SearchIngredientPanel() {
        this.ingredientController = new IngredientController();
        this.searchController = new SearchController();
        //ici qu'il faut faire le truc de date
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();
        SpinnerDateModel earliestDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        SpinnerDateModel latestDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        this.startDate = new JSpinner(earliestDateModel);
        this.endDate =  new JSpinner(latestDateModel);
        JSpinner.DateEditor editorStartDate = new JSpinner.DateEditor(startDate, "dd/MM/yyyy");
        JSpinner.DateEditor editorEndDate = new JSpinner.DateEditor(endDate, "dd/MM/yyyy");
        this.startDate.setEditor(editorStartDate);
        this.endDate.setEditor(editorEndDate);


        //SpinnerNumberModel startDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        //this.startDate = new JSpinner(startDateSpinnerNumber);
        //SpinnerNumberModel endDateSpinnerNumber = new SpinnerNumberModel(2000, DATE_YEAR_MIN, DATE_YEAR_MAX, 1);
        //this.endDate = new JSpinner(endDateSpinnerNumber);
        //this.ingredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        //this.ingredientComboBox = new JComboBox<Ingredient>(ingredientComboBoxModel);
        this.ingredientErrorLabel = new JLabel();
        this.ingredientTable = new JTable();
        this.SubmitButton = new JButton("Soumettre");
        this.SubmitButton.addActionListener(this);

        //this.setAllIngredient();

        this.setLayout(new BorderLayout());

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new FlowLayout());
        ingredientNorthPanel.add(new JLabel("Date de début:"));
        ingredientNorthPanel.add(startDate);
        ingredientNorthPanel.add(new JLabel("Date de fin:"));
        ingredientNorthPanel.add(endDate);
        //ingredientNorthPanel.add(new JLabel("Ingrédients:"));
        //ingredientNorthPanel.add(ingredientComboBox);
        ingredientNorthPanel.add(SubmitButton);

        this.add(ingredientNorthPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(ingredientTable), BorderLayout.CENTER);
        this.add(ingredientErrorLabel, BorderLayout.SOUTH);
    }

    private boolean isStartBeforeEnd() {
        LocalDate startDate =  ((Date)this.startDate.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = ((Date)this.endDate.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return startDate.isBefore(endDate);
    }

    private void setAllIngredient() { // todo : ce truc normalement ne sert plus à rien donc éliminer plus tard au cas où
        try {
            ArrayList<Ingredient> ingredients = this.ingredientController.readAllIngredient();
            this.ingredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);

        }
    }

    private void setIngredientRecipe( LocalDate dateBeginning, LocalDate dateEnding) {
        try {
            ArrayList<SearchIngredientResult> searchIngredientResults = this.searchController.searchIngredient( dateBeginning, dateEnding);
            this.ingredientTable.setModel(new SearchIngredientTableModel(searchIngredientResults));
        } catch (SearchIngredientException exception) {
            JOptionPane.showMessageDialog(null, "Échec de l'affichage des ingrédients", "Échec de l'affichage des ingrédients", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Soumettre")) {
            if (isStartBeforeEnd()) {
                //Ingredient ingredient = (Ingredient) this.ingredientComboBox.getSelectedItem();
                //if (ingredient != null) {
                    LocalDate startDate =  ((Date)this.startDate.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate endDate = ((Date)this.endDate.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    this.setIngredientRecipe( startDate, endDate);
                //} else {
                    //JOptionPane.showMessageDialog(null, "Vous devez sélectionner un ingrédient", "Sélectionner un ingrédient", JOptionPane.ERROR_MESSAGE);
                //}
            } else {
                JOptionPane.showMessageDialog(null, "La date de début doit être antérieure à la date de fin", "Corriger les années", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
