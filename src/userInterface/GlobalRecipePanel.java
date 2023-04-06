package userInterface;

import model.ComponentGroup;
import model.FormBuilder;

import javax.swing.*;
import java.awt.*;

public class GlobalRecipePanel extends JPanel {
    private JLabel titleLabel;
    private JTextField titleField;
    private JRadioButton isHot;
    private JRadioButton isCold;
    private ButtonGroup temperatureGroup;
    private JRadioButton isSalty;
    private JRadioButton isSweet;
    private ButtonGroup spiceGroup;
    private JLabel authorLabel;
    private JComboBox authorComboBox;
    private JLabel countryLabel;
    private JComboBox countryComboBox;
    private JLabel complexityLabel;
    private JComboBox complexityComboBox;
    private JLabel peopleLabel;
    private JSpinner peopleSpinner;
    private JLabel noteLabel;
    private JSpinner noteSpinner;
    private JLabel timeLabel;
    private JSpinner timeSpinner;
    private JLabel descriptionLabel;
    private JTextArea descriptionTextArea;
    private JButton addUtensilButton;
    private JButton removeUtensilButton;
    private JComboBox utensilComboBox;
    private JList utensilList;
    private JButton addMenuTypeButton;
    private JButton removeMenuTypeButton;
    private JComboBox menuTypeComboBox;
    private JList menuTypeList;
    private JButton addMenuCategoryButton;
    private JButton removeMenuCategoryButton;
    private JComboBox menuCategoryComboBox;
    private JList menuCategoryList;
    private JTextArea recipeStepsTextArea;
    private JButton addRecipeStepsButton;
    private JButton removeRecipeStepsButton;
    private JButton editRecipeStepsButton;
    private JButton saveRecipeStepsButton;
    private JList recipeStepsList;
    private JList ingredientList;
    private JButton addIngredientButton;
    private JButton removeIngredientButton;
    private JButton editIngredientButton;
    private JButton saveIngredientButton;
    private JComboBox nameIngredientComboBox;
    private JSpinner quantityIngredientComboBox;
    private JComboBox unitIngredientComboBox;
    private JTabbedPane tabs;

    private static final int TITLE_MIN_LENGTH = 10;

    public GlobalRecipePanel() {
        this.titleLabel = new JLabel("Title");
        this.titleField = new JTextField();

        this.isHot = new JRadioButton("Hot");
        this.isCold = new JRadioButton("Cold");
        this.temperatureGroup = new ButtonGroup();
        temperatureGroup.add(isHot);
        temperatureGroup.add(isCold);

        this.isSalty = new JRadioButton("Salty");
        this.isSweet = new JRadioButton("Sweet");
        this.spiceGroup = new ButtonGroup();
        spiceGroup.add(isSalty);
        spiceGroup.add(isSweet);

        this.authorLabel = new JLabel("Author");
        this.authorComboBox = new JComboBox();

        this.countryLabel = new JLabel("Country");
        this.countryComboBox = new JComboBox();

        this.complexityLabel = new JLabel("Complexity");
        this.complexityComboBox = new JComboBox();

        this.peopleLabel = new JLabel("People");
        this.peopleSpinner = new JSpinner();

        this.noteLabel = new JLabel("Note");
        this.noteSpinner = new JSpinner();

        this.timeLabel = new JLabel("Time");
        this.timeSpinner = new JSpinner();

        this.descriptionLabel = new JLabel("Description");
        this.descriptionTextArea = new JTextArea(10, 10);

        this.addUtensilButton = new JButton("Add");
        this.removeUtensilButton = new JButton("Remove");
        this.utensilComboBox = new JComboBox();
        this.utensilList = new JList(new String[] {
                "A", "B", "C"
        });

        this.addMenuTypeButton = new JButton("Add");
        this.removeMenuTypeButton = new JButton("Remove");
        this.menuTypeComboBox = new JComboBox();
        this.menuTypeList = new JList(new String[] {
                "D", "E", "F"
        });

        this.addMenuCategoryButton = new JButton("Add");
        this.removeMenuCategoryButton = new JButton("Remove");
        this.menuCategoryComboBox = new JComboBox();
        this.menuCategoryList = new JList(new String[] {
                "G", "H", "I"
        });

        this.recipeStepsTextArea = new JTextArea(10, 20);
        this.addRecipeStepsButton = new JButton("Add");
        this.removeRecipeStepsButton = new JButton("Remove");
        this.editRecipeStepsButton = new JButton("Edit");
        this.saveRecipeStepsButton = new JButton("Save");
        this.recipeStepsList = new JList(new String[] {
                "J", "K", "L"
        });

        this.ingredientList = new JList(new String[] {
                "M", "N", "O"
        });
        this.addIngredientButton = new JButton("Add");
        this.removeIngredientButton = new JButton("Remove");
        this.editIngredientButton = new JButton("Edit");
        this.saveIngredientButton = new JButton("Save");
        this.nameIngredientComboBox = new JComboBox();
        this.quantityIngredientComboBox = new JSpinner();
        this.unitIngredientComboBox = new JComboBox();

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
        ingredientNorthPanel.add(nameIngredientComboBox);
        ingredientNorthPanel.add(quantityIngredientComboBox);
        ingredientNorthPanel.add(unitIngredientComboBox);

        ingredientPanel.add(ingredientNorthPanel, BorderLayout.NORTH);
        ingredientPanel.add(ingredientWestPanel, BorderLayout.WEST);
        ingredientPanel.add(ingredientList, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());

        this.tabs = new JTabbedPane();
        this.tabs.insertTab("General", null, generalPanel, "General Panel", 0);
        this.tabs.insertTab("Utensil", null, utensilPanel, "Utensil Panel", 1);
        this.tabs.insertTab("Menu Type", null, menuTypePanel, "Menu Type Panel", 2);
        this.tabs.insertTab("Meal Category", null, mealCategoryPanel, "Meal Category Panel", 3);
        this.tabs.insertTab("Recipe Steps", null, recipeStepsPanel, "Recipe Steps Panel", 4);
        this.tabs.insertTab("Ingredient", null, ingredientPanel, "Ingredient Panel", 5);

        this.add(this.tabs, BorderLayout.CENTER);
    }

    public boolean isTitleValid() {
        String titleText = titleField.getText();
        return titleText.length() > GlobalRecipePanel.TITLE_MIN_LENGTH;
    }

    public boolean isTemperatureValid() {
        return this.isHot.isSelected() || this.isCold.isSelected();
    }

    public boolean isSpiceValid() {
        return this.isSalty.isSelected() || this.isSweet.isSelected();
    }

    public void setAuthors(String... authors) {

    }
}

