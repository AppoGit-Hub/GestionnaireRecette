package userInterface;

import controller.DietController;
import controller.RecipeController;
import exception.AllDietException;
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
    private RecipeController recipeController;


    public SearchDietPanel() {
        this.dietController = new DietController();
        this.recipeController = new RecipeController();
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
            this.dietError.setText("Error Loading all diets");
        }
    }

    public void setDietRecipe(Diet diet) {
        // TODO: add search process
        ArrayList<Recipe> recipes = null;
        this.dietTable.setModel(new SearchDietTableModel(recipes));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String selection = event.getActionCommand();
        if (selection.equals("Submit")) {
            Diet dietSelected = (Diet) this.dietComboBox.getSelectedItem();
            this.setDietRecipe(dietSelected);
        }
    }
}
