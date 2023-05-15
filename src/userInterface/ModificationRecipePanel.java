package userInterface;

import controller.*;
import exception.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
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

        JPanel recipeModificationNorthPanel = new JPanel();
        recipeModificationNorthPanel.setLayout(new FlowLayout());
        recipeModificationNorthPanel.add(recipeSelectionComboBox);
        recipeModificationNorthPanel.add(recipeModifyButton);

        this.setAllRecipe();

        this.add(recipeModificationNorthPanel, BorderLayout.NORTH);
    }

    public void setAllRecipe() {
        try {
            RecipeController recipeController = this.getRecipeController();
            ArrayList<Recipe> recipes = recipeController.getAllRecipe();
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

    public void setUtencilForRecipe(Recipe selection) {
        EquipementController equipementController = this.getEquipementController();
        UtensilController utensilController = this.getUtensilController();
        DefaultListModel<Utensil> utensilList = this.getUtensilListModel();
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

    public void setRecipeStepForRecipe(Recipe selection) {
        RecipeStepController recipeStepController = this.getRecipeStepController();
        DefaultListModel<String> recipeStepListModel = this.getRecipeStepListModel();
        try {
            recipeStepListModel.removeAllElements();
            ArrayList<RecipeStep> recipeSteps = recipeStepController.getAllRecipeStep(selection.getCode());
            ArrayList<String> recipeStepsDescription = new ArrayList<String>();
            for (RecipeStep recipeStep : recipeSteps) {
                recipeStepsDescription.add(recipeStep.getDescription());
            }
            recipeStepListModel.addAll(recipeStepsDescription);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void setMenuTypeForRecipe(Recipe selection) {
        MenuTypeController menuTypeController = this.getMenuTypeController();
        PeriodController periodController = this.getPeriodController();
        DefaultListModel<MenuType> menuTypeListModel = this.getMenuTypeListModel();
        try {
            menuTypeListModel.removeAllElements();
            ArrayList<Period> periods = periodController.getAllPeriod(selection.getCode());
            ArrayList<MenuType> menuTypes = new ArrayList<MenuType>();
            for (Period period : periods) {
                menuTypes.add(menuTypeController.getMenuType(period.getMenuType()));
            }
            menuTypeListModel.addAll(menuTypes);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void setMealCategoryForRecipe(Recipe selection) {
        OrderTypeController orderTypeController = this.getOrderTypeController();
        MealCategoryController mealCategoryController = this.getMealCategoryController();
        DefaultListModel<MealCategory> mealCategoryListModel = this.getMealCategoryListModel();
        try {
            mealCategoryListModel.removeAllElements();
            ArrayList<OrderType> orderTypes = orderTypeController.getAllOrderType(selection.getCode());
            ArrayList<MealCategory> mealCategories = new ArrayList<MealCategory>();
            for (OrderType orderType : orderTypes) {
                mealCategories.add(mealCategoryController.getMealCategory(orderType.getMealCategory()));
            }
            mealCategoryListModel.addAll(mealCategories);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void setIngredientForRecipe(Recipe selection) {
        LineRecipeController lineRecipeController = this.getLineRecipeController();
        DefaultListModel<LineRecipeDisplay> ingredientListModel = this.getIngredientListModel();
        try {
            ingredientListModel.removeAllElements();
            ArrayList<LineRecipe> lineRecipes = lineRecipeController.getLineRecipeForRecipe(selection.getCode());
            ArrayList<LineRecipeDisplay> lineRecipeDisplays = new ArrayList<>();
            for (LineRecipe lineRecipe : lineRecipes) {
                lineRecipeDisplays.add(new LineRecipeDisplay(lineRecipe.getIngredient(), lineRecipe.getQuantity(), lineRecipe.getUnit()));
            }
            ingredientListModel.addAll(lineRecipeDisplays);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateUtensil(Recipe selection) {
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
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateRecipe(Recipe selection) {
        RecipeController recipeController = this.getRecipeController();
        Recipe recipe = this.getRecipe(selection.getCode());
        try {
            recipeController.updateRecipe(recipe);
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateMenuType(Recipe selection) {
        PeriodController periodController = this.getPeriodController();
        DefaultListModel<MenuType> menuTypeListModel = this.getMenuTypeListModel();
        try {
            // TODO : do a better job at updating menu types values
            ArrayList<Period> periods = periodController.getAllPeriod(selection.getCode());
            for (Period period : periods) {
                periodController.deletePeriod(selection.getCode(), period.getMenuType());
            }
            Enumeration<MenuType> newMenuTypes = menuTypeListModel.elements();
            while (newMenuTypes.hasMoreElements()) {
                MenuType menuType = newMenuTypes.nextElement();
                periodController.createPeriod(selection.getCode(), menuType.getId());
            }
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateMealCategory(Recipe selection) {
        OrderTypeController orderTypeController = this.getOrderTypeController();
        DefaultListModel<MealCategory> mealCategoryListModel = this.getMealCategoryListModel();
        try {
            // TODO : do a better job at updating meal categories values
            ArrayList<OrderType> orderTypes = orderTypeController.getAllOrderType(selection.getCode());
            for (OrderType orderType : orderTypes) {
                orderTypeController.deleteOrderType(selection.getCode(), orderType.getMealCategory());
            }
            Enumeration<MealCategory> newMealCategries = mealCategoryListModel.elements();
            while (newMealCategries.hasMoreElements()) {
                MealCategory mealCategory = newMealCategries.nextElement();
                orderTypeController.createOrderType(selection.getCode(), mealCategory.getId());
            }
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateRecipeSteps(Recipe selection) {
        RecipeStepController recipeStepController = this.getRecipeStepController();
        DefaultListModel<String> recipeStepListModel = this.getRecipeStepListModel();
        try {
            // TODO : do a better job at updating recipe steps values
            ArrayList<RecipeStep> recipeSteps = recipeStepController.getAllRecipeStep(selection.getCode());
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
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    public void updateIngredient(Recipe selection) {
        LineRecipeController lineRecipeController = this.getLineRecipeController();
        DefaultListModel<LineRecipeDisplay> ingredientListModel = this.getIngredientListModel();
        try {
            // TODO : do a better job at ingredient values
            ArrayList<LineRecipe> lineRecipes = lineRecipeController.getLineRecipeForRecipe(selection.getCode());
            for (LineRecipe lineRecipe : lineRecipes) {
                lineRecipeController.deleteLineRecipe(lineRecipe.getIngredient(), selection.getCode());
            }
            Enumeration<LineRecipeDisplay> newLineRecipes = ingredientListModel.elements();
            while (newLineRecipes.hasMoreElements()) {
                LineRecipeDisplay lineRecipeDisplay = newLineRecipes.nextElement();
                lineRecipeController.createLineRecipe(new LineRecipe(lineRecipeDisplay.getIngredient(), selection.getCode(), lineRecipeDisplay.getQuantity(), lineRecipeDisplay.getUnit()));
            }
        } catch (Exception exception) {
            System.out.printf(exception.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        Recipe selection = (Recipe) this.recipeSelectionComboBox.getSelectedItem();
        if (selection != null) {
            if (source.equals("comboBoxChanged")) {
                this.setGeneralRecipeRecipe(selection);
                this.setUtencilForRecipe(selection);
                this.setRecipeStepForRecipe(selection);
                this.setMenuTypeForRecipe(selection);
                this.setMealCategoryForRecipe(selection);
                this.setIngredientForRecipe(selection);
            } else if (source.equals("Modify")) {
                this.updateRecipe(selection);
                this.updateUtensil(selection);
                this.updateMenuType(selection);
                this.updateMealCategory(selection);
                this.updateRecipeSteps(selection);
                this.updateIngredient(selection);
            }
        }
    }
}
