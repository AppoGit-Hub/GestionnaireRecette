package userInterface;

import controller.RecipeController;
import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificationRecipePanel extends GlobalRecipePanel implements ActionListener {
    private JComboBox<Recipe> recipeSelectionComboBox;
    private JButton recipeModifyButton;
    private RecipeController recipeController;

    public ModificationRecipePanel() {
        super();
        BorderLayout layout = (BorderLayout) this.getLayout();

        this.recipeSelectionComboBox = new JComboBox<Recipe>();
        this.recipeModifyButton = new JButton("Modify");
        this.recipeModifyButton.addActionListener(this);
        this.recipeSelectionComboBox.addActionListener(this);

        JPanel recipeModificationNorthPanel = new JPanel();
        recipeModificationNorthPanel.setLayout(new FlowLayout());
        recipeModificationNorthPanel.add(recipeSelectionComboBox);
        recipeModificationNorthPanel.add(recipeModifyButton);

        this.recipeController = new RecipeController();

        this.setAllRecipe();

        this.add(recipeModificationNorthPanel, BorderLayout.NORTH);
    }

    public void setAllRecipe() {
        try {
            ArrayList<Recipe> recipes = this.recipeController.getAllRecipe();
            for (Recipe recipe : recipes) {
                this.recipeSelectionComboBox.addItem(recipe);
            }

        } catch (AllRecipeException exception) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("comboBoxChanged")) {
            try {
                Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
                this.setTitle(selection.getTitle());
                this.setIsHot(selection.getIsHot());
                this.setIsSalty(selection.getIsSalted());
                this.setAuthor(this.personController.getPerson(selection.getPerson()));
                this.setCountry(this.countryController.getCountry(selection.getSpeciality()));
                this.setComplexity(selection.getComplexity());
                this.setPeople(selection.getNumberPeopleConcerned());
                // TODO : Transform author into int
                //this.setNote(selection.get);
                this.setTime(selection.getTimePreparation());
                this.setDescription(selection.getDescription());
            } catch (Exception exception) {
                // add exception ???
            }
        } else if (source.equals("Modify")) {

        }
    }
}
