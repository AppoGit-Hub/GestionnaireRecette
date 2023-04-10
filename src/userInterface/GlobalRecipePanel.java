package userInterface;

import business.MealCategoryManager;
import controller.MenuTypeController;
import dataAccess.MealCategoryException;
import model.AllMenuTypeException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    private JComboBox<Person> authorComboBox;
    private JLabel countryLabel;
    private JComboBox<Country> countryComboBox;
    private JLabel complexityLabel;
    private JComboBox<Complexity> complexityComboBox;
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
    private JComboBox<Utensil> utensilComboBox;
    private JList<Utensil> utensilList;
    private JButton addMenuTypeButton;
    private JButton removeMenuTypeButton;
    private JComboBox<MenuType> menuTypeComboBox;
    private JList<MenuType> menuTypeList;
    private JLabel menuTypeAccessErrorLabel;
    private JButton addMenuCategoryButton;
    private JButton removeMenuCategoryButton;
    private JComboBox<MealCategory> menuCategoryComboBox;
    private JList<MealCategory> menuCategoryList;
    private JLabel menuCategoryAccessErrorLabel;
    private JTextArea recipeStepsTextArea;
    private JButton addRecipeStepsButton;
    private JButton removeRecipeStepsButton;
    private JButton editRecipeStepsButton;
    private JButton saveRecipeStepsButton;
    private JList<RecipeStep> recipeStepsList;
    private JList<Ingredient> ingredientList;
    private JButton addIngredientButton;
    private JButton removeIngredientButton;
    private JButton editIngredientButton;
    private JButton saveIngredientButton;
    private JComboBox<Ingredient> nameIngredientComboBox;
    private JSpinner quantityIngredientComboBox;
    private JComboBox<Unit> unitIngredientComboBox;
    private JTabbedPane tabs;

    private MenuTypeController menuTypeController;
    private MealCategoryManager mealCategoryManager;

    private static final int TITLE_MIN_LENGTH = 10;
    private static final int DESCRIPTION_MIN_LENGTH = 100;
    private static final int PEOPLE_MIN = 1;
    private static final int PEOPLE_MAX = 100;
    private static final int NOTE_MIN = 0;
    private static final int NOTE_MAX = 10;
    private static final int TIME_MIN = 1;
    private static final int TIME_MAX = 1000;
    private static final int QUANTITY_MIN = 1;
    private static final int QUANTITY_MAX = 1000;

    public GlobalRecipePanel() {
        this.menuTypeController = new MenuTypeController();
        this.mealCategoryManager = new MealCategoryManager();

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

        this.peopleLabel = new JLabel("People For");
        SpinnerNumberModel peopleSpinnerModel = new SpinnerNumberModel(1, PEOPLE_MIN, PEOPLE_MAX, 1);
        this.peopleSpinner = new JSpinner(peopleSpinnerModel);

        this.noteLabel = new JLabel("Note (/10)");
        SpinnerNumberModel noteSpinnerModel = new SpinnerNumberModel(5, NOTE_MIN, NOTE_MAX, 1);
        this.noteSpinner = new JSpinner(noteSpinnerModel);

        this.timeLabel = new JLabel("Time (min)");
        SpinnerNumberModel timeSpinnerModel = new SpinnerNumberModel(1, TIME_MIN, TIME_MAX, 1);
        this.timeSpinner = new JSpinner(timeSpinnerModel);

        this.descriptionLabel = new JLabel("Description");
        this.descriptionTextArea = new JTextArea(10, 10);

        this.addUtensilButton = new JButton("Add");
        this.removeUtensilButton = new JButton("Remove");
        this.utensilComboBox = new JComboBox();
        this.utensilList = new JList();

        this.addMenuTypeButton = new JButton("Add");
        this.removeMenuTypeButton = new JButton("Remove");

        try {
            ArrayList<MenuType> menuTypes = menuTypeController.getAllMenuTypes();
            this.menuTypeComboBox = new JComboBox(menuTypes.toArray());
        } catch (AllMenuTypeException exception) {
            this.menuTypeAccessErrorLabel.setText("Error Loading Menu Types");
        }

        this.menuTypeList = new JList();
        this.menuTypeAccessErrorLabel = new JLabel();

        this.addMenuCategoryButton = new JButton("Add");
        this.removeMenuCategoryButton = new JButton("Remove");
        this.menuCategoryComboBox = new JComboBox();
        this.menuCategoryList = new JList();
        this.menuCategoryAccessErrorLabel = new JLabel();

        this.recipeStepsTextArea = new JTextArea(10, 20);
        this.addRecipeStepsButton = new JButton("Add");
        this.removeRecipeStepsButton = new JButton("Remove");
        this.editRecipeStepsButton = new JButton("Edit");
        this.saveRecipeStepsButton = new JButton("Save");
        this.recipeStepsList = new JList();

        this.ingredientList = new JList();
        this.addIngredientButton = new JButton("Add");
        this.removeIngredientButton = new JButton("Remove");
        this.editIngredientButton = new JButton("Edit");
        this.saveIngredientButton = new JButton("Save");
        this.nameIngredientComboBox = new JComboBox();
        SpinnerNumberModel quantityIngredientModel = new SpinnerNumberModel(1, QUANTITY_MIN, QUANTITY_MAX, 1);
        this.quantityIngredientComboBox = new JSpinner(quantityIngredientModel);
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
        menuTypePanel.add(menuTypeAccessErrorLabel, BorderLayout.SOUTH);


        JPanel mealCategoryPanel = new JPanel();
        mealCategoryPanel.setLayout(new BorderLayout());
        mealCategoryPanel.add(menuCategoryList);

        JPanel mealCategoryUpPanel = new JPanel();
        mealCategoryUpPanel.setLayout(new GridLayout());
        mealCategoryUpPanel.add(menuCategoryComboBox);
        mealCategoryUpPanel.add(addMenuCategoryButton);
        mealCategoryUpPanel.add(removeMenuCategoryButton);

        mealCategoryPanel.add(mealCategoryUpPanel, BorderLayout.NORTH);

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

        this.setAllMenuTypes();
        this.setAllMenuCategories();

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
        return titleText.length() > TITLE_MIN_LENGTH;
    }

    public boolean isTemperatureValid() {
        return this.isHot.isSelected() || this.isCold.isSelected();
    }

    public boolean isSpiceValid() {
        return this.isSalty.isSelected() || this.isSweet.isSelected();
    }

    public boolean isDescriptionValid() {
        String descriptionText = this.descriptionTextArea.getText();
        return descriptionText.length() >= DESCRIPTION_MIN_LENGTH;
    }

    public boolean isUtensilValid() {
        return this.utensilList.getModel().getSize() > 0;
    }

    public boolean isMenuTypeValid() {
        return this.menuTypeList.getModel().getSize() > 0;
    }

    public boolean isMealCategoryValid() {
        return this.menuCategoryList.getModel().getSize() > 0;
    }

    public boolean isRecipeStepsValid() {
        boolean isRecipeStepsListValid = this.recipeStepsList.getModel().getSize() > 0;
        String isRecipeStepsDescription = this.recipeStepsTextArea.getText();
        return isRecipeStepsDescription.length() > DESCRIPTION_MIN_LENGTH && isRecipeStepsListValid;
    }

    public boolean isIngredientValid() {
        return this.ingredientList.getModel().getSize() > 0;
    }

    public Person getAuthor() {
        return (Person) this.authorComboBox.getSelectedItem();
    }

    public void setAuthor(Person... authors) {
        this.authorComboBox.removeAllItems();
        for (Person author : authors) {
            this.authorComboBox.addItem(author);
        }
    }

    public Country getCountry() {
        return (Country) this.countryComboBox.getSelectedItem();
    }

    public void setCountry(Country... countries) {
        this.countryComboBox.removeAllItems();
        for (Country country : countries) {
            this.countryComboBox.addItem(country);
        }
    }

    public Complexity getComplexity() {
        return (Complexity) this.complexityComboBox.getSelectedItem();
    }

    public void setComplexity(Complexity... complexities) {
        this.complexityComboBox.removeAllItems();
        for (Complexity complexity : complexities) {
            this.complexityComboBox.addItem(complexity);
        }
    }

    public int getPeople() {
        return (int) this.peopleSpinner.getValue();
    }

    public void setPeople(int peopleFor) {
        if (peopleFor >= PEOPLE_MIN && peopleFor <= PEOPLE_MAX) {
            this.peopleSpinner.setValue(peopleFor);
        }
    }

    public int getNote() {
        return (int) this.noteSpinner.getValue();
    }

    public void setNote(int note) {
        if (note >= NOTE_MIN && note <= NOTE_MAX) {
            this.noteSpinner.setValue(note);
        }
    }

    public int getTime() {
        return (int) this.timeSpinner.getValue();
    }

    public void setTime(int time) {
        if (time >= TIME_MIN && time <= TIME_MAX) {
            this.timeSpinner.setValue(time);
        }
    }

    public void setAllMenuCategories() {
        try {
            ArrayList<MealCategory> mealCategories = mealCategoryManager.getAllMenuCategories();
            for (MealCategory mealCategory : mealCategories) {
                this.menuCategoryComboBox.addItem(mealCategory);
            }
        } catch (MealCategoryException exception) {
            this.menuCategoryAccessErrorLabel.setText("Error Loading Menu Categories");
        }
    }

}

