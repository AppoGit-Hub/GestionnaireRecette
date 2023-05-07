package userInterface;

import controller.EquipementController;
import controller.RecipeController;
import controller.UtensilController;
import exception.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificationRecipePanel extends GlobalRecipePanel implements ActionListener {
    private JComboBox<Recipe> recipeSelectionComboBox;
    private DefaultComboBoxModel<Recipe> recipeSelectionComboBoxModel;
    private JButton recipeModifyButton;
    private RecipeController recipeController;

    public ModificationRecipePanel() {
        super();
        BorderLayout layout = (BorderLayout) this.getLayout();

        this.recipeSelectionComboBoxModel = new DefaultComboBoxModel<Recipe>();
        this.recipeSelectionComboBox = new JComboBox<Recipe>(recipeSelectionComboBoxModel);
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
            this.recipeSelectionComboBoxModel.addAll(recipes);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
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

    public void setUtencilForRecipe() {
        EquipementController equipementController = this.getEquipementController();
        UtensilController utensilController = this.getUtensilController();
        DefaultListModel<Utensil> utensilList = this.getUtensilListModel();
        Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
        try {
            utensilList.removeAllElements();
            ArrayList<Equipment> equipments = equipementController.getAllEquipementOf(selection.getCode());
            ArrayList<Utensil> utensils = new ArrayList<Utensil>();
            for (Equipment equipment : equipments) {
                Utensil utensil = utensilController.getUtensil(equipment.getUtensil());
                utensils.add(utensil);
            }
            utensilList.addAll(utensils);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void setRecipeStepForRecipe() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("comboBoxChanged")) {
            Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
            this.setGeneralRecipeRecipe(selection);
            this.setUtencilForRecipe();
        } else if (source.equals("Modify")) {

        }
    }
}
