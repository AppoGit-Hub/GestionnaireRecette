package userInterface;

import model.ComponentGroup;
import model.FormBuilder;

import javax.swing.*;
import java.awt.*;

public class PublishRecipePanel extends JPanel {
    public PublishRecipePanel() {
        JLabel titleLabel = new JLabel("Title");
        JTextField titleField = new JTextField();

        JRadioButton isHot = new JRadioButton("Hot");
        JRadioButton isCold = new JRadioButton("Cold");
        ButtonGroup temperatureGroup = new ButtonGroup();
        temperatureGroup.add(isHot);
        temperatureGroup.add(isCold);

        JRadioButton isSalty = new JRadioButton("Salty");
        JRadioButton isSweet = new JRadioButton("Sweet");
        ButtonGroup spiceGroup = new ButtonGroup();
        spiceGroup.add(isSalty);
        spiceGroup.add(isSweet);

        JLabel authorLabel = new JLabel("Author");
        JComboBox authorComboBox = new JComboBox();

        JLabel countryLabel = new JLabel("Country");
        JComboBox countryComboBox = new JComboBox();

        JLabel complexityLabel = new JLabel("Complexity");
        JComboBox complexityComboBox = new JComboBox();

        JLabel peopleLabel = new JLabel("People");
        JSpinner peopleSpinner = new JSpinner();

        JLabel noteLabel = new JLabel("Note");
        JSpinner noteSpinner = new JSpinner();

        JLabel timeLabel = new JLabel("Time");
        JSpinner timeSpinner = new JSpinner();

        JLabel descriptionLabel = new JLabel("Description");
        JTextArea descriptionTextArea = new JTextArea(10, 10);

        JButton addUtensilButton = new JButton("Add");
        JButton removeUtensilButton = new JButton("Remove");
        JComboBox utensilComboBox = new JComboBox();
        JList utensilList = new JList(new String[] {
                "A", "B", "C"
        });

        JButton addMenuTypeButton = new JButton("Add");
        JButton removeMenuTypeButton = new JButton("Remove");
        JComboBox menuTypeComboBox = new JComboBox();
        JList menuTypeList = new JList(new String[] {
                "D", "E", "F"
        });

        JButton addMenuCategoryButton = new JButton("Add");
        JButton removeMenuCategoryButton = new JButton("Remove");
        JComboBox menuCategoryComboBox = new JComboBox();
        JList menuCategoryList = new JList(new String[] {
                "G", "H", "I"
        });

        JList recipeStepsList = new JList(new String[] {
                "J", "K", "L"
        });
        JTextArea recipeStepsTextArea = new JTextArea(10, 20);
        JButton addRecipeStepsButton = new JButton("Add");
        JButton removeRecipeStepsButton = new JButton("Remove");
        JButton editRecipeStepsButton = new JButton("Edit");
        JButton saveRecipeStepsButton = new JButton("Save");

        JList ingredientList = new JList(new String[] {
                "M", "N", "O"
        });
        JButton addIngredientButton = new JButton("Add");
        JButton removeIngredientButton = new JButton("Remove");
        JButton editIngredientButton = new JButton("Edit");
        JButton saveIngredientButton = new JButton("Save");
        JComboBox nameIngedientComboBox = new JComboBox();
        JSpinner quantityIngedientComboBox = new JSpinner();
        JComboBox unitIngedientComboBox = new JComboBox();

        //TODO : Resolve the scaling problem
        JPanel generalPanel = new FormBuilder()
                .addLabelAnd(titleLabel, titleField)
                .addOnSameLine(new ComponentGroup(GridBagConstraints.WEST, isHot, isCold))
                .addOnSameLine(new ComponentGroup(GridBagConstraints.WEST, isSalty, isSweet))
                .addLabelAnd(authorLabel, authorComboBox)
                .addLabelAnd(countryLabel, countryComboBox)
                .addLabelAnd(complexityLabel, complexityComboBox)
                .addLabelAnd(peopleLabel, peopleSpinner)
                .addLabelAnd(noteLabel, noteSpinner)
                .addLabelAnd(timeLabel, timeSpinner)
                .addLabelAnd(descriptionLabel, descriptionTextArea)
                .build();


        JPanel utensilPanel = new JPanel();
        utensilPanel.setLayout(new BorderLayout());
        utensilPanel.add(utensilList, BorderLayout.CENTER);

        JPanel utensilBottomPanel = new JPanel();
        utensilBottomPanel.setLayout(new GridLayout());
        utensilBottomPanel.add(utensilComboBox);
        utensilBottomPanel.add(addUtensilButton);
        utensilBottomPanel.add(removeUtensilButton);

        utensilPanel.add(utensilBottomPanel, BorderLayout.NORTH);


        JPanel menuTypePanel = new JPanel();
        menuTypePanel.setLayout(new BorderLayout());
        menuTypePanel.add(menuTypeList);

        JPanel menuTypeBottomPanel = new JPanel();
        menuTypeBottomPanel.setLayout(new GridLayout());
        menuTypeBottomPanel.add(menuTypeComboBox);
        menuTypeBottomPanel.add(addMenuTypeButton);
        menuTypeBottomPanel.add(removeMenuTypeButton);

        menuTypePanel.add(menuTypeBottomPanel, BorderLayout.NORTH);


        JPanel mealCategoryPanel = new JPanel();
        mealCategoryPanel.setLayout(new BorderLayout());
        mealCategoryPanel.add(menuCategoryList);

        JPanel mealCategoryBottomPanel = new JPanel();
        mealCategoryBottomPanel.setLayout(new GridLayout());
        mealCategoryBottomPanel.add(menuCategoryComboBox);
        mealCategoryBottomPanel.add(addMenuCategoryButton);
        mealCategoryBottomPanel.add(removeMenuCategoryButton);

        mealCategoryPanel.add(mealCategoryBottomPanel, BorderLayout.NORTH);


        JPanel recipeStepsPanel = new JPanel();
        recipeStepsPanel.setLayout(new BorderLayout());

        JPanel recipeStepsNorthPanel = new JPanel();
        recipeStepsNorthPanel.setLayout(new GridLayout());
        recipeStepsNorthPanel.add(addRecipeStepsButton);
        recipeStepsNorthPanel.add(removeRecipeStepsButton);
        recipeStepsNorthPanel.add(editRecipeStepsButton);
        recipeStepsNorthPanel.add(saveRecipeStepsButton);

        recipeStepsPanel.add(recipeStepsNorthPanel, BorderLayout.NORTH);

        JPanel recipeStepsCenterPanel = new JPanel();
        recipeStepsCenterPanel.setLayout(new GridLayout());
        recipeStepsCenterPanel.add(recipeStepsList);
        recipeStepsCenterPanel.add(recipeStepsTextArea);

        recipeStepsPanel.add(recipeStepsCenterPanel, BorderLayout.CENTER);


        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BorderLayout());

        JPanel ingredientWestPanel = new JPanel();
        ingredientWestPanel.setLayout(new GridLayout(7, 1));
        ingredientWestPanel.add(addIngredientButton);
        ingredientWestPanel.add(editIngredientButton);
        ingredientWestPanel.add(saveIngredientButton);
        ingredientWestPanel.add(removeIngredientButton);

        JPanel ingredientNorthPanel = new JPanel();
        ingredientNorthPanel.setLayout(new GridLayout());
        ingredientNorthPanel.add(nameIngedientComboBox);
        ingredientNorthPanel.add(quantityIngedientComboBox);
        ingredientNorthPanel.add(unitIngedientComboBox);

        ingredientPanel.add(ingredientNorthPanel, BorderLayout.NORTH);
        ingredientPanel.add(ingredientWestPanel, BorderLayout.WEST);
        ingredientPanel.add(ingredientList, BorderLayout.CENTER);


        this.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.insertTab("General", null, generalPanel, "General Panel", 0);
        tabs.insertTab("Utensil", null, utensilPanel, "Utensil Panel", 1);
        tabs.insertTab("Menu Type", null, menuTypePanel, "Menu Type Panel", 2);
        tabs.insertTab("Meal Category", null, mealCategoryPanel, "Meal Category Panel", 3);
        tabs.insertTab("Recipe Steps", null, recipeStepsPanel, "Recipe Steps Panel", 4);
        tabs.insertTab("Ingredient", null, ingredientPanel, "Ingredient Panel", 5);

        this.add(tabs, BorderLayout.CENTER);
    }
}
