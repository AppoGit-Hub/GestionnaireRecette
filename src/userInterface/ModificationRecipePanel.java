package userInterface;

import controller.RecipeController;
import exception.AllRecipeException;
import exception.CountryException;
import exception.NextCodeRecipeException;
import exception.PersonException;
import model.Complexity;
import model.Country;
import model.Person;
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

    public void setGeneralRecipeRecipe(Recipe recipe) {
        String title = recipe.getTitle();
        boolean isHot = recipe.getIsHot();
        boolean isSalty = recipe.getIsSalted();
        int personID = recipe.getPerson();
        int specialityID = recipe.getSpeciality();
        Complexity complexity = recipe.getComplexity();
        int peopleConcerned = recipe.getNumberPeopleConcerned();
        int note = recipe.getNoteAuthor();
        int timePreparation = recipe.getTimePreparation();
        String description = recipe.getDescription();

        try {
            this.setTitle(title);
            this.setIsHot(isHot);
            this.setIsSalty(isSalty);
            this.setAuthor(personID);
            this.setCountry(specialityID);
            this.setComplexity(complexity);
            this.setPeople(peopleConcerned);
            this.setNote(note);
            this.setTime(timePreparation);
            this.setDescription(description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("comboBoxChanged")) {
            Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
            this.setGeneralRecipeRecipe(selection);
        } else if (source.equals("Modify")) {

        }
    }
}
