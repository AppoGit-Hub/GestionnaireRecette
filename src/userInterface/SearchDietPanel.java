package userInterface;

import controller.DietController;
import controller.RecipeController;
import controller.SearchController;
import exception.AllDietException;
import exception.SearchDietException;
import model.SearchDietResult;
import model.SearchDietTableModel;
import model.Diet;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchDietPanel extends JPanel implements ActionListener {
    // display recipes from a know diet
    private JComboBox<Diet> dietComboBox;
    private DefaultComboBoxModel<Diet> dietComboBoxModel;
    private JLabel dietError;
    private JTable dietTable;
    private JButton dietSubmit;
    private DietController dietController;
    private SearchController searchController;

    public SearchDietPanel() {
        this.dietController = new DietController();
        this.searchController = new SearchController();
        this.dietComboBoxModel = new DefaultComboBoxModel<Diet>();
        this.dietComboBox = new JComboBox<Diet>(this.dietComboBoxModel);
        this.dietTable = new JTable();
        this.dietError = new JLabel();
        this.dietSubmit = new JButton("Submit");
        this.dietSubmit.addActionListener(this);
        
        this.setAllDiet();

        this.setLayout(new BorderLayout());

        JPanel dietNorthPanel = new JPanel();
        dietNorthPanel.setLayout(new FlowLayout());
        dietNorthPanel.add(new JLabel("Diets:"));
        dietNorthPanel.add(dietComboBox);
        dietNorthPanel.add(dietSubmit);

        this.add(dietNorthPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(dietTable), BorderLayout.CENTER);
        this.add(dietError, BorderLayout.SOUTH);
    }

    public void setAllDiet() {
        try {
            ArrayList<Diet> diets = dietController.getAllDiet();
            this.dietComboBoxModel.addAll(diets);
        } catch (AllDietException exception) {
            JOptionPane.showMessageDialog(null, "Failed to load diets", "Failed to Load Diets", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDietRecipe(Diet diet) {
        try {
            ArrayList<SearchDietResult> searchDietResults = this.searchController.searchDiet(diet.getId());
            this.dietTable.setModel(new SearchDietTableModel(searchDietResults));
        } catch (SearchDietException exception) {
            JOptionPane.showMessageDialog(null, "Failed to display diets", "Failed to Display Diets", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Submit")) {
            Diet dietSelected = (Diet) this.dietComboBox.getSelectedItem();
            if (dietSelected != null) {
                this.setDietRecipe(dietSelected);
            } else {
                JOptionPane.showMessageDialog(null, "You must select a diet", "Select a Diet", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
