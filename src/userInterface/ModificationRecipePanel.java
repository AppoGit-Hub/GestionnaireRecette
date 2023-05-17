package userInterface;

import controller.*;
import exception.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class ModificationRecipePanel extends GlobalRecipePanel implements ActionListener {
    private JComboBox<Recipe> recipeSelectionComboBox;
    private DefaultComboBoxModel<Recipe> recipeSelectionComboBoxModel;
    private JButton recipeModifyButton;

    public ModificationRecipePanel() {
        super();
        BorderLayout layout = (BorderLayout) this.getLayout();

        this.recipeSelectionComboBoxModel = new DefaultComboBoxModel<Recipe>();
        this.recipeSelectionComboBox = new JComboBox<Recipe>(recipeSelectionComboBoxModel);
        this.recipeModifyButton = new JButton("Modify");
        this.recipeModifyButton.addActionListener(this);
        this.recipeSelectionComboBox.addActionListener(this);

        this.setAllRecipe();

        JPanel recipeModificationNorthPanel = new JPanel();
        recipeModificationNorthPanel.setLayout(new FlowLayout());
        recipeModificationNorthPanel.add(recipeSelectionComboBox);
        recipeModificationNorthPanel.add(recipeModifyButton);

        this.add(recipeModificationNorthPanel, BorderLayout.NORTH);
    }

    private void setAllRecipe() {
        try {
            RecipeController recipeController = this.getRecipeController();
            ArrayList<Recipe> recipes = recipeController.readAllRecipe();
            this.recipeSelectionComboBoxModel.addAll(recipes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setGeneralRecipeRecipe(Recipe recipe) {
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
            JOptionPane.showMessageDialog(null, "Failed to set recipe data", "Failed To Set Recipe Data", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setUtencilForRecipe(Recipe selection) {
        EquipementController equipementController = this.getEquipementController();
        UtensilController utensilController = this.getUtensilController();
        DefaultListModel<Utensil> utensilList = this.getUtensilListModel();
        try {
            utensilList.removeAllElements();
            ArrayList<Equipment> equipments = equipementController.getAllEquipementOf(selection.getCode());
            ArrayList<Utensil> utensils = new ArrayList<Utensil>();
            for (Equipment equipment : equipments) {
                Utensil utensil = utensilController.readUtensil(equipment.getUtensil());
                utensils.add(utensil);
            }
            utensilList.addAll(utensils);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setRecipeStepForRecipe(Recipe selection) {
        RecipeStepController recipeStepController = this.getRecipeStepController();
        DefaultListModel<String> recipeStepListModel = this.getRecipeStepListModel();
        try {
            recipeStepListModel.removeAllElements();
            ArrayList<RecipeStep> recipeSteps = recipeStepController.readAllRecipeStep(selection.getCode());
            ArrayList<String> recipeStepsDescription = new ArrayList<String>();
            for (RecipeStep recipeStep : recipeSteps) {
                recipeStepsDescription.add(recipeStep.getDescription());
            }
            recipeStepListModel.addAll(recipeStepsDescription);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setMenuTypeForRecipe(Recipe selection) {
        MenuTypeController menuTypeController = this.getMenuTypeController();
        PeriodController periodController = this.getPeriodController();
        DefaultListModel<MenuType> menuTypeListModel = this.getMenuTypeListModel();
        try {
            menuTypeListModel.removeAllElements();
            ArrayList<Period> periods = periodController.readAllPeriod(selection.getCode());
            ArrayList<MenuType> menuTypes = new ArrayList<MenuType>();
            for (Period period : periods) {
                menuTypes.add(menuTypeController.readMenuType(period.getMenuType()));
            }
            menuTypeListModel.addAll(menuTypes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setMealCategoryForRecipe(Recipe selection) {
        OrderTypeController orderTypeController = this.getOrderTypeController();
        MealCategoryController mealCategoryController = this.getMealCategoryController();
        DefaultListModel<MealCategory> mealCategoryListModel = this.getMealCategoryListModel();
        try {
            mealCategoryListModel.removeAllElements();
            ArrayList<OrderType> orderTypes = orderTypeController.readAllOrderType(selection.getCode());
            ArrayList<MealCategory> mealCategories = new ArrayList<MealCategory>();
            for (OrderType orderType : orderTypes) {
                mealCategories.add(mealCategoryController.readMealCategory(orderType.getMealCategory()));
            }
            mealCategoryListModel.addAll(mealCategories);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setIngredientForRecipe(Recipe selection) {
        LineRecipeController lineRecipeController = this.getLineRecipeController();
        DefaultListModel<LineRecipeDisplay> ingredientListModel = this.getIngredientListModel();
        try {
            ingredientListModel.removeAllElements();
            ArrayList<LineRecipe> lineRecipes = lineRecipeController.readLineRecipeForRecipe(selection.getCode());
            ArrayList<LineRecipeDisplay> lineRecipeDisplays = new ArrayList<>();
            for (LineRecipe lineRecipe : lineRecipes) {
                lineRecipeDisplays.add(new LineRecipeDisplay(lineRecipe.getIngredient(), lineRecipe.getQuantity(), lineRecipe.getUnit()));
            }
            ingredientListModel.addAll(lineRecipeDisplays);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setAuthorForRecipe(Recipe selection) {
        // TODO : no time left, need further work ...
        PersonController personController = this.getPersonController();
        DefaultComboBoxModel<Person> personComboBoxModel = this.getAuthorComboBoxModel();
        try {
            personComboBoxModel.removeAllElements();;
            Person person = personController.readPerson(selection.getCode());
            int index = 0;
            while (index < personComboBoxModel.getSize() && personComboBoxModel.getElementAt(index).getId() != person.getId()) {
                index++;
            }
            if (index < personComboBoxModel.getSize()) {
                personComboBoxModel.setSelectedItem(personComboBoxModel.getElementAt(index));
            }
        } catch (PersonException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setCountryForRecipe(Recipe selection) {
        // TODO : no time left, need further work ...
        CountryController countryController = this.getCountryController();
        DefaultComboBoxModel<Country> countryComboBoxModel = this.getCountryComboBoxModel();
        try {
            countryComboBoxModel.removeAllElements();;
            Country country = countryController.readCountry(selection.getCode());
            int index = 0;
            while (index < countryComboBoxModel.getSize() && countryComboBoxModel.getElementAt(index).getId() != country.getId()) {
                index++;
            }
            if (index < countryComboBoxModel.getSize()) {
                countryComboBoxModel.setSelectedItem(countryComboBoxModel.getElementAt(index));
            }
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUtensil(Recipe selection) {
        EquipementController equipementController = this.getEquipementController();
        DefaultListModel<Utensil> utensilListModel = this.getUtensilListModel();

        try {
            // TODO : do a better job at updating equipments values
            ArrayList<Equipment> equipments = equipementController.getAllEquipementOf(selection.getCode());
            for (Equipment equipment : equipments) {
                equipementController.deleteEquipementFor(selection.getCode(), equipment.getUtensil());
            }
            Enumeration<Utensil> newUtensils =  utensilListModel.elements();
            while (newUtensils.hasMoreElements()) {
                Utensil utensil = newUtensils.nextElement();
                equipementController.createEquipementFor(selection.getCode(), utensil.getName());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecipe(Recipe selection) {
        RecipeController recipeController = this.getRecipeController();
        try {
            Recipe recipe = this.getRecipe(selection.getCode());
            if (recipe != null) {
                recipeController.updateRecipe(recipe);
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateMenuType(Recipe selection) {
        PeriodController periodController = this.getPeriodController();
        DefaultListModel<MenuType> menuTypeListModel = this.getMenuTypeListModel();
        try {
            // TODO : do a better job at updating menu types values
            ArrayList<Period> periods = periodController.readAllPeriod(selection.getCode());
            for (Period period : periods) {
                periodController.deletePeriod(selection.getCode(), period.getMenuType());
            }
            Enumeration<MenuType> newMenuTypes = menuTypeListModel.elements();
            while (newMenuTypes.hasMoreElements()) {
                MenuType menuType = newMenuTypes.nextElement();
                periodController.createPeriod(selection.getCode(), menuType.getId());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateMealCategory(Recipe selection) {
        OrderTypeController orderTypeController = this.getOrderTypeController();
        DefaultListModel<MealCategory> mealCategoryListModel = this.getMealCategoryListModel();
        try {
            // TODO : do a better job at updating meal categories values
            ArrayList<OrderType> orderTypes = orderTypeController.readAllOrderType(selection.getCode());
            for (OrderType orderType : orderTypes) {
                orderTypeController.deleteOrderType(selection.getCode(), orderType.getMealCategory());
            }
            Enumeration<MealCategory> newMealCategries = mealCategoryListModel.elements();
            while (newMealCategries.hasMoreElements()) {
                MealCategory mealCategory = newMealCategries.nextElement();
                orderTypeController.createOrderType(selection.getCode(), mealCategory.getId());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecipeSteps(Recipe selection) {
        RecipeStepController recipeStepController = this.getRecipeStepController();
        DefaultListModel<String> recipeStepListModel = this.getRecipeStepListModel();
        try {
            // TODO : do a better job at updating recipe steps values
            ArrayList<RecipeStep> recipeSteps = recipeStepController.readAllRecipeStep(selection.getCode());
            for (RecipeStep recipeStep : recipeSteps) {
                recipeStepController.deleteRecipeStep(selection.getCode(), recipeStep.getNumber());
            }
            Enumeration<String> newRecipeStepsDescription = recipeStepListModel.elements();
            int index = 0;
            while (newRecipeStepsDescription.hasMoreElements()) {
                String recipeStepDescription = newRecipeStepsDescription.nextElement();
                recipeStepController.createRecipeStep(new RecipeStep(selection.getCode(), index, recipeStepDescription));
                index++;
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateIngredient(Recipe selection) {
        LineRecipeController lineRecipeController = this.getLineRecipeController();
        DefaultListModel<LineRecipeDisplay> ingredientListModel = this.getIngredientListModel();
        try {
            // TODO : do a better job at ingredient values
            ArrayList<LineRecipe> lineRecipes = lineRecipeController.readLineRecipeForRecipe(selection.getCode());
            for (LineRecipe lineRecipe : lineRecipes) {
                lineRecipeController.deleteLineRecipe(lineRecipe.getIngredient(), selection.getCode());
            }
            Enumeration<LineRecipeDisplay> newLineRecipes = ingredientListModel.elements();
            while (newLineRecipes.hasMoreElements()) {
                LineRecipeDisplay lineRecipeDisplay = newLineRecipes.nextElement();
                lineRecipeController.createLineRecipe(new LineRecipe(lineRecipeDisplay.getIngredient(), selection.getCode(), lineRecipeDisplay.getQuantity(), lineRecipeDisplay.getUnit()));
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
                this.setGeneralRecipeRecipe(selection);
                this.setUtencilForRecipe(selection);
                this.setRecipeStepForRecipe(selection);
                this.setMenuTypeForRecipe(selection);
                this.setMealCategoryForRecipe(selection);
                this.setIngredientForRecipe(selection);
                this.setAuthorForRecipe(selection);
                this.setCountryForRecipe(selection);
            }
        } else if (source.equals("Modify")) {
            if (selection != null) {
                this.updateRecipe(selection);
                this.updateUtensil(selection);
                this.updateMenuType(selection);
                this.updateMealCategory(selection);
                this.updateRecipeSteps(selection);
                this.updateIngredient(selection);
                this.updateAuthor(selection);
                this.updateCountry(selection);

                this.recipeSelectionComboBoxModel.removeAllElements();
                this.setAllRecipe();

            } else {
                JOptionPane.showMessageDialog(null, "You must select an recipe", "Select A Recipe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
