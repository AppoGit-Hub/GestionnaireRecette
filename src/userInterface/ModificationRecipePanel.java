package userInterface;

import controller.*;
import exception.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;

public class ModificationRecipePanel extends JPanel implements ActionListener {
    private GeneralRecipePanel generalPanel;
    private IngredientPanel ingredientPanel;
    private MealCategoryPanel mealCategoryPanel;
    private MenuTypePanel menuTypePanel;
    private RecipeStepPanel recipeStepPanel;
    private UtensilPanel utensilPanel;
    private JTabbedPane tabs;

    private JComboBox<Recipe> recipeSelectionComboBox;
    private DefaultComboBoxModel<Recipe> recipeSelectionComboBoxModel;
    private JButton recipeModifyButton;

    private RecipeController recipeController;
    private EquipementController equipementController;
    private UtensilController utensilController;
    private RecipeStepController recipeStepController;
    private MenuTypeController menuTypeController;
    private PeriodController periodController;
    private OrderTypeController orderTypeController;
    private MealCategoryController mealCategoryController;
    private LineRecipeController lineRecipeController;
    private PersonController personController;
    private CountryController countryController;
    private UnitController unitController;

    public ModificationRecipePanel() {
        this.setLayout(new BorderLayout());

        this.recipeController = new RecipeController();
        this.equipementController = new EquipementController();
        this.utensilController = new UtensilController();
        this.recipeStepController = new RecipeStepController();
        this.menuTypeController = new MenuTypeController();
        this.periodController = new PeriodController();
        this.orderTypeController = new OrderTypeController();
        this.mealCategoryController = new MealCategoryController();
        this.lineRecipeController = new LineRecipeController();
        this.personController = new PersonController();
        this.countryController = new CountryController();
        this.unitController = new UnitController();

        this.generalPanel = new GeneralRecipePanel();
        this.ingredientPanel = new IngredientPanel();
        this.mealCategoryPanel = new MealCategoryPanel();
        this.menuTypePanel = new MenuTypePanel();
        this.recipeStepPanel = new RecipeStepPanel();
        this.utensilPanel = new UtensilPanel();

        this.recipeSelectionComboBoxModel = new DefaultComboBoxModel<Recipe>();
        this.recipeSelectionComboBox = new JComboBox<Recipe>(recipeSelectionComboBoxModel);
        this.recipeModifyButton = new JButton("Modifier");
        this.recipeModifyButton.addActionListener(this);
        this.recipeSelectionComboBox.addActionListener(this);

        JPanel recipeModificationNorthPanel = new JPanel();
        recipeModificationNorthPanel.setLayout(new FlowLayout());
        recipeModificationNorthPanel.add(recipeSelectionComboBox);
        recipeModificationNorthPanel.add(recipeModifyButton);
        this.add(recipeModificationNorthPanel, BorderLayout.NORTH);

        this.tabs = new JTabbedPane();
        this.tabs.insertTab("Général", null, generalPanel.getPanel(), "Panneau Général", 0);
        this.tabs.insertTab("Ustensiles", null, utensilPanel.getPanel(), "Panneau des Ustensiles", 1);
        this.tabs.insertTab("Type de Menu", null, menuTypePanel.getPanel(), "Panneau des Types de Menu", 2);
        this.tabs.insertTab("Catégorie de Repas", null, mealCategoryPanel.getPanel(), "Panneau des Catégories de Repas", 3);
        this.tabs.insertTab("Étapes de la Recette", null, recipeStepPanel.getPanel(), "Panneau des Étapes de la Recette", 4);
        this.tabs.insertTab("Ingrédient", null, ingredientPanel.getPanel(), "Panneau des Ingrédients", 5);

        this.setAllRecipe();

        this.add(this.tabs, BorderLayout.CENTER);
    }

    private void setGeneralRecipe(Recipe recipe) {
        String title = recipe.getTitle();
        boolean isHot = recipe.getIsHot();
        boolean isSalty = recipe.getIsSalted();
        Integer personID = recipe.getPerson();
        Integer specialityID = recipe.getSpeciality();
        Integer complexity = recipe.getComplexity();
        Integer peopleConcerned = recipe.getNumberPeopleConcerned();
        Integer note = recipe.getNoteAuthor();
        Boolean isNote = note != null;
        Integer timePreparation = recipe.getTimePreparation();
        String description = recipe.getDescription();
        LocalDate publicationDate = recipe.getPublicationDate();

        try {
            this.generalPanel.setTitle(title);
            this.generalPanel.setIsHot(isHot);
            this.generalPanel.setIsSalty(isSalty);
            this.generalPanel.setAuthor(personID);
            this.generalPanel.setCountry(specialityID);
            this.generalPanel.setComplexity(complexity);
            this.generalPanel.setPeople(peopleConcerned);
            this.generalPanel.setNote(note);
            this.generalPanel.setPrecenceNote(note);
            this.generalPanel.setTime(timePreparation);
            this.generalPanel.setDescription(description);
            this.generalPanel.setPublicationDate(publicationDate);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Échec de la définition des données de la recette", "Échec de la définition des données de recette", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setAllRecipe() {
        try {
            ArrayList<Recipe> recipes = this.recipeController.readAllRecipe();
            this.recipeSelectionComboBoxModel.addAll(recipes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecipe(Recipe selection) {
        try {
            Recipe recipe = this.generalPanel.getRecipe(selection.getCode());
            if (recipe != null) {
                this.recipeController.updateRecipe(recipe);
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCountry(Recipe selection) {
        // TODO : no time left, need further work
    }

    private void updateAuthor(Recipe selection) {
        // TODO : no time left, need further work ...
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
        if (source.equals("comboBoxChanged")) {
            if (selection != null) {
                this.setGeneralRecipe(selection);
                this.generalPanel.setAuthorForRecipe(selection);
                this.generalPanel.setCountryForRecipe(selection);
                this.utensilPanel.setUtencilForRecipe(selection);
                this.recipeStepPanel.setRecipeStepForRecipe(selection);
                this.menuTypePanel.setMenuTypeForRecipe(selection);
                this.mealCategoryPanel.setMealCategoryForRecipe(selection);
                this.ingredientPanel.setIngredientForRecipe(selection);
            }
        } else if (source.equals("Modifier")) {
            if (selection != null) {
                this.updateRecipe(selection);
                this.updateAuthor(selection);
                this.updateCountry(selection);
                this.utensilPanel.updateUtensil(selection);
                this.menuTypePanel.updateMenuType(selection);
                this.mealCategoryPanel.updateMealCategory(selection);
                this.recipeStepPanel.updateRecipeSteps(selection);
                this.ingredientPanel.updateIngredient(selection);

                this.recipeSelectionComboBoxModel.removeAllElements();
                this.setAllRecipe();
            } else {
                JOptionPane.showMessageDialog(null, "Vous devez sélectionner une recette", "Sélectionner une recette", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
