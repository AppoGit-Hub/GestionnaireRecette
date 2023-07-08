package userInterface;

import controller.*;
import exception.*;
import model.*;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private DefaultComboBoxModel<Person> authorComboBoxModel;
    private JLabel countryLabel;
    private JComboBox<Country> countryComboBox;
    private DefaultComboBoxModel<Country> countryComboBoxModel;
    private JLabel publicationDateLabel;
    private JSpinner publicationDateSpinner;
    private JLabel complexityLabel;
    private JComboBox<Complexity> complexityComboBox;
    private DefaultComboBoxModel<Complexity> complexityComboBoxModel;
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
    private DefaultComboBoxModel<Utensil> utensilComboBoxModel;
    private JList<Utensil> utensilList;
    private DefaultListModel<Utensil> utensilListModel;
    private JButton addMenuTypeButton;
    private JButton removeMenuTypeButton;
    private JComboBox<MenuType> menuTypeComboBox;
    private DefaultComboBoxModel<MenuType> menuTypeComboBoxModel;
    private JList<MenuType> menuTypeList;
    private DefaultListModel<MenuType> menuTypeListModel;
    private JLabel menuTypeAccessErrorLabel;
    private JButton addMealCategoryButton;
    private JButton removeMealCategoryButton;
    private JComboBox<MealCategory> mealCategoryComboBox;
    private DefaultComboBoxModel<MealCategory> mealCategoryComboBoxModel;
    private JList<MealCategory> mealCategoryList;
    private DefaultListModel<MealCategory> mealCategoryListModel;
    private JLabel mealCategoryAccessErrorLabel;
    private JTextArea recipeStepsTextArea;
    private JButton addRecipeStepsButton;
    private JButton removeRecipeStepsButton;
    private JButton editRecipeStepsButton;
    private JButton saveRecipeStepsButton;
    private JLabel recipeStepErrorLabel;
    private JList<String> recipeStepsList;
    private DefaultListModel<String> recipeStepListModel;
    private JList<LineRecipeDisplay> lineRecipeList;
    private DefaultListModel<LineRecipeDisplay> lineRecipeModel;
    private JButton addIngredientButton;
    private JButton removeIngredientButton;
    private JButton editIngredientButton;
    private JButton saveIngredientButton;
    private JComboBox<Ingredient> nameIngredientComboBox;
    private DefaultComboBoxModel<Ingredient> nameIngredientComboBoxModel;
    private JSpinner quantityIngredientSpinner;
    private JComboBox<Unit> unitIngredientComboBox;
    private DefaultComboBoxModel<Unit> unitIngredientComboBoxModel;
    private JTabbedPane tabs;
    private MenuTypeController menuTypeController;
    private MealCategoryController mealCategoryController;
    private EquipementController equipementController;
    private RecipeStepController recipeStepController;
    private UtensilController utensilController;
    private IngredientController ingredientController;
    private OrderTypeController orderTypeController;
    private CountryController countryController;
    private PersonController personController;
    private PeriodController periodController;
    private LineRecipeController lineRecipeController;
    private RecipeController recipeController;
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
        this.mealCategoryController = new MealCategoryController();
        this.recipeStepController = new RecipeStepController();
        this.utensilController = new UtensilController();
        this.ingredientController = new IngredientController();
        this.countryController = new CountryController();
        this.personController = new PersonController();
        this.equipementController = new EquipementController();
        this.periodController = new PeriodController();
        this.orderTypeController = new OrderTypeController();
        this.lineRecipeController = new LineRecipeController();
        this.recipeController = new RecipeController();

        this.titleLabel = new JLabel("Title");
        this.titleField = new JTextField();

        this.isHot = new JRadioButton("Hot");
        this.isCold = new JRadioButton("Cold");

        this.temperatureGroup = new ButtonGroup();
        temperatureGroup.add(isHot);
        temperatureGroup.add(isCold);
        this.temperatureGroup.setSelected(this.isHot.getModel(), true);

        this.isSalty = new JRadioButton("Salty");
        this.isSweet = new JRadioButton("Sweet");
        this.spiceGroup = new ButtonGroup();
        spiceGroup.add(isSalty);
        spiceGroup.add(isSweet);
        this.spiceGroup.setSelected(this.isSalty.getModel(), true);

        this.authorLabel = new JLabel("Author");
        this.authorComboBoxModel = new DefaultComboBoxModel<Person>();
        this.authorComboBox = new JComboBox<Person>(authorComboBoxModel);

        this.countryLabel = new JLabel("Country");
        this.countryComboBoxModel = new DefaultComboBoxModel<Country>();
        this.countryComboBox = new JComboBox<Country>(countryComboBoxModel);

        this.publicationDateLabel = new JLabel("Publication Date");
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();
        SpinnerDateModel publicationDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        this.publicationDateSpinner = new JSpinner(publicationDateModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(publicationDateSpinner, "dd/MM/yyyy");
        this.publicationDateSpinner.setEditor(editor);

        this.complexityLabel = new JLabel("Complexity");
        this.complexityComboBoxModel = new DefaultComboBoxModel<Complexity>();
        this.complexityComboBox = new JComboBox<Complexity>(complexityComboBoxModel);
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
        this.descriptionTextArea.setLineWrap(true);

        UtensilActionListener utensilActionListener = new UtensilActionListener();
        this.addUtensilButton = new JButton("Add");
        this.addUtensilButton.addActionListener(utensilActionListener);
        this.removeUtensilButton = new JButton("Remove");
        this.removeUtensilButton.addActionListener(utensilActionListener);
        this.utensilComboBoxModel = new DefaultComboBoxModel<Utensil>();
        this.utensilComboBox = new JComboBox<Utensil>(utensilComboBoxModel);
        this.utensilListModel = new DefaultListModel<Utensil>();
        this.utensilList = new JList<Utensil>(utensilListModel);
        utensilActionListener.setUtensilComboBox(utensilComboBoxModel);
        utensilActionListener.setUtensilListModel(utensilListModel);
        utensilActionListener.setUtensilList(utensilList);

        MenuTypeActionListener menuTypeActionListener = new MenuTypeActionListener();
        this.addMenuTypeButton = new JButton("Add");
        this.addMenuTypeButton.addActionListener(menuTypeActionListener);
        this.removeMenuTypeButton = new JButton("Remove");
        this.removeMenuTypeButton.addActionListener(menuTypeActionListener);
        this.menuTypeListModel = new DefaultListModel<MenuType>();
        this.menuTypeList = new JList<MenuType>(menuTypeListModel);
        this.menuTypeAccessErrorLabel = new JLabel();
        this.menuTypeComboBoxModel = new DefaultComboBoxModel<MenuType>();
        this.menuTypeComboBox = new JComboBox<MenuType>(menuTypeComboBoxModel);
        menuTypeActionListener.setMenuTypeComboBoxModel(menuTypeComboBoxModel);
        menuTypeActionListener.setMenuTypeListModel(menuTypeListModel);
        menuTypeActionListener.setMenuTypeList(menuTypeList);

        MealCategoryActionListener mealCategoryActionListener = new MealCategoryActionListener();
        this.addMealCategoryButton = new JButton("Add");
        this.addMealCategoryButton.addActionListener(mealCategoryActionListener);
        this.removeMealCategoryButton = new JButton("Remove");
        this.removeMealCategoryButton.addActionListener(mealCategoryActionListener);
        this.mealCategoryComboBoxModel = new DefaultComboBoxModel<MealCategory>();
        this.mealCategoryComboBox = new JComboBox<MealCategory>(mealCategoryComboBoxModel);
        this.mealCategoryListModel = new DefaultListModel<MealCategory>();
        this.mealCategoryList = new JList<MealCategory>(mealCategoryListModel);
        this.mealCategoryAccessErrorLabel = new JLabel();
        mealCategoryActionListener.setMealCategoryComboxModel(mealCategoryComboBoxModel);
        mealCategoryActionListener.setMealCategoryListModel(mealCategoryListModel);
        mealCategoryActionListener.setMealCategoryList(mealCategoryList);

        RecipeStepActionListener recipeStepActionListener = new RecipeStepActionListener();
        this.recipeStepsTextArea = new JTextArea(10, 20);
        this.addRecipeStepsButton = new JButton("Add");
        addRecipeStepsButton.addActionListener(recipeStepActionListener);
        this.removeRecipeStepsButton = new JButton("Remove");
        removeRecipeStepsButton.addActionListener(recipeStepActionListener);
        this.editRecipeStepsButton = new JButton("Edit");
        editRecipeStepsButton.addActionListener(recipeStepActionListener);
        this.saveRecipeStepsButton = new JButton("Save");
        saveRecipeStepsButton.addActionListener(recipeStepActionListener);
        this.recipeStepListModel = new DefaultListModel<String>();
        this.recipeStepsList = new JList<String>(recipeStepListModel);
        this.recipeStepErrorLabel = new JLabel();
        recipeStepActionListener.setRecipeStepTextArea(recipeStepsTextArea);
        recipeStepActionListener.setRecipeStepListModel(recipeStepListModel);
        recipeStepActionListener.setRecipeStepsList(recipeStepsList);

        IngredientActionListener ingredientActionListener = new IngredientActionListener();
        this.lineRecipeModel = new DefaultListModel<LineRecipeDisplay>();
        this.lineRecipeList = new JList<LineRecipeDisplay>(lineRecipeModel);
        this.recipeStepErrorLabel = new JLabel();
        this.addIngredientButton = new JButton("Add");
        addIngredientButton.addActionListener(ingredientActionListener);
        this.removeIngredientButton = new JButton("Remove");
        removeIngredientButton.addActionListener(ingredientActionListener);
        this.editIngredientButton = new JButton("Edit");
        editIngredientButton.addActionListener(ingredientActionListener);
        this.saveIngredientButton = new JButton("Save");
        saveIngredientButton.addActionListener(ingredientActionListener);
        this.nameIngredientComboBoxModel = new DefaultComboBoxModel<Ingredient>();
        this.nameIngredientComboBox = new JComboBox<Ingredient>(nameIngredientComboBoxModel);
        SpinnerNumberModel quantityIngredientModel = new SpinnerNumberModel(1, QUANTITY_MIN, QUANTITY_MAX, 1);
        this.quantityIngredientSpinner = new JSpinner(quantityIngredientModel);
        this.unitIngredientComboBoxModel = new DefaultComboBoxModel<Unit>();
        this.unitIngredientComboBox = new JComboBox<Unit>(unitIngredientComboBoxModel);
        ingredientActionListener.setNameIngredientComboBoxModel(nameIngredientComboBoxModel);
        ingredientActionListener.setQuantityIngredientSpinner(quantityIngredientSpinner);
        ingredientActionListener.setUnitIngredientComboBox(unitIngredientComboBox);
        ingredientActionListener.setLineRecipeModel(lineRecipeModel);
        ingredientActionListener.setLineRecipeList(lineRecipeList);

        //TODO : Resolve the scaling problem
        JPanel generalPanel = new FormBuilder()
                .addLabelAnd(titleLabel, titleField)
                .addOnSameLine(new ComponentGroup(GridBagConstraints.WEST, isHot, isCold))
                .addOnSameLine(new ComponentGroup(GridBagConstraints.WEST, isSalty, isSweet))
                .addLabelAnd(authorLabel, authorComboBox)
                .addLabelAnd(countryLabel, countryComboBox)
                .addLabelAnd(complexityLabel, complexityComboBox)
                .addLabelAnd(publicationDateLabel, publicationDateSpinner)
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
        mealCategoryPanel.add(mealCategoryList);

        JPanel mealCategoryUpPanel = new JPanel();
        mealCategoryUpPanel.setLayout(new GridLayout());
        mealCategoryUpPanel.add(mealCategoryComboBox);
        mealCategoryUpPanel.add(addMealCategoryButton);
        mealCategoryUpPanel.add(removeMealCategoryButton);

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

        JPanel recipeStepsBottomPanel = new JPanel();
        recipeStepsBottomPanel.add(recipeStepErrorLabel);

        recipeStepsPanel.add(recipeStepsBottomPanel, BorderLayout.SOUTH);

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
        ingredientNorthPanel.add(quantityIngredientSpinner);
        ingredientNorthPanel.add(unitIngredientComboBox);

        ingredientPanel.add(ingredientNorthPanel, BorderLayout.NORTH);
        ingredientPanel.add(ingredientWestPanel, BorderLayout.WEST);
        ingredientPanel.add(lineRecipeList, BorderLayout.CENTER);

        this.setAllMenuType();
        this.setAllMenuCategory();
        this.setAllUtensil();
        this.setAllIngredient();
        this.setAllUnit();
        this.setAllCountry();
        this.setAllComplexity();
        this.setAllAuthor();

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
    public String getTitle() {
        return this.titleField.getText();
    }
    public void setTitle(String title) {
        this.titleField.setText(title);
    }
    public boolean getIsHot() {
        return this.isHot.getModel().isSelected();
    }
    public void setIsHot(boolean isHot) {
        if (isHot) {
            this.temperatureGroup.setSelected(this.isHot.getModel(), true);
        } else {
            this.temperatureGroup.setSelected(this.isCold.getModel(), true);
        }
    }
    public boolean getIsSalty() {
        return this.isSalty.getModel().isSelected();
    }
    public void setIsSalty(boolean isSalty) {
        if (isSalty) {
            this.spiceGroup.setSelected(this.isSalty.getModel(), true);
        } else {
            this.spiceGroup.setSelected(this.isSweet.getModel(), true);
        }
    }
    public Person getAuthor() {
        return (Person) this.authorComboBox.getSelectedItem();
    }
    public void setAuthor(Person person) {
        this.authorComboBox.setSelectedItem(person);
    }
    public void setAuthor(int authorID) {
        // TODO : maybe there is a better way to do this ?
        try {
            ArrayList<Person> persons = this.personController.readAllPerson();
            int index = 0;
            while (index < persons.size() && persons.get(index).getId() != authorID) {
                index++;
            }
            Person person = persons.get(index);
            this.setAuthor(person);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    public Country getCountry() {
        return (Country) this.countryComboBox.getSelectedItem();
    }
    public void setCountry(Country country) {
        this.countryComboBox.setSelectedItem(country);
    }
    public void setCountry(int countryID) {
        // TODO : maybe there is a better way to do this ?
        try {
            ArrayList<Country> countries = this.countryController.readAllCountry();
            int index = 0;
            while (index < countries.size() && countries.get(index).getId() != countryID) {
                index++;
            }
            Country country = countries.get(index);
            this.setCountry(country);
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    public Complexity getComplexity() {
        return (Complexity) this.complexityComboBox.getSelectedItem();
    }
    public void setComplexity(Complexity complexity) {
        this.complexityComboBox.setSelectedItem(complexity);
    }
    public int getPeople() {
        return (int) this.peopleSpinner.getValue();
    }
    public void setPeople(int people) {
        this.peopleSpinner.setValue(people);
    }
    public int getNote() {
        return (int) this.noteSpinner.getValue();
    }
    public void setNote(int note) {
        this.noteSpinner.setValue(note);
    }
    public int getTime() {
        return (int) this.timeSpinner.getValue();
    }
    public void setTime(int time) {
        this.timeSpinner.setValue(time);
    }
    public String getDescription() {
        return this.descriptionTextArea.getText();
    }
    public Date getPublicationDate() {
        return (Date) publicationDateSpinner.getValue();
    }
    public void setDescription(String description) {
        this.descriptionTextArea.setText(description);
    }
    protected Recipe getRecipe(int code) {
        // TODO : do a better job with at this maybe with exceptions ?
        String title = this.getTitle();
        if (title != null && title.length() > 0) {
            Person author = this.getAuthor();
            if (author != null) {
                Complexity complexity = this.getComplexity();
                if (complexity != null) {
                    boolean isHot = this.getIsHot();
                    LocalDate publicationDate = this.getPublicationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    boolean isSalty = this.getIsSalty();
                    int person = this.getPeople();
                    int note = this.getNote();
                    int time = this.getTime();
                    String description = this.getDescription();
                    Country country = this.getCountry();

                    Recipe recipe = new Recipe(
                        code,
                        title,
                        isHot,
                        publicationDate,
                        time,
                        isSalty,
                        person,
                        complexity,
                        author.getId()
                    );

                    if (country == null) {
                        recipe.setSpeciality(null);
                    } else {
                        recipe.setSpeciality(country.getId());
                    }
                    recipe.setNoteAuthor(note);
                    recipe.setDescription(description);

                    return recipe;
                } else {
                    JOptionPane.showMessageDialog(null, "Select an complexity", "Recipe Complexity Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select an author", "Recipe Author Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Recipe title must exist", "Recipe Title Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    protected void setAllMenuCategory() {
        try {
            ArrayList<MealCategory> mealCategories = mealCategoryController.readAllMealCategory();
            this.mealCategoryComboBoxModel.addAll(mealCategories);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllMenuType() {
        try {
            ArrayList<MenuType> menuTypes = menuTypeController.getAllMenuTypes();
            this.menuTypeComboBoxModel.addAll(menuTypes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllUtensil() {
        try {
            ArrayList<Utensil> utensils = utensilController.readAllUtensil();
            this.utensilComboBoxModel.addAll(utensils);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Failed to load utensils", "Failed To Load", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllIngredient() {
        try {
            ArrayList<Ingredient> ingredients = ingredientController.readAllIngredient();
            this.nameIngredientComboBoxModel.addAll(ingredients);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllUnit() {
        List<Unit> units = List.of(Unit.values());
        this.unitIngredientComboBoxModel.addAll(units);
    }
    protected void setAllCountry() {
        try {
            ArrayList<Country> countries = countryController.readAllCountry();
            this.countryComboBoxModel.addAll(countries);
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllComplexity() {
        List<Complexity> complexities = List.of(Complexity.values());
        this.complexityComboBoxModel.addAll(complexities);
    }
    protected void setAllAuthor() {
        try {
            ArrayList<Person> persons = personController.readAllPerson();
            this.authorComboBoxModel.addAll(persons);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    public EquipementController getEquipementController() {
        return this.equipementController;
    }
    public UtensilController getUtensilController() {
        return this.utensilController;
    }
    public RecipeStepController getRecipeStepController() {
        return this.recipeStepController;
    }
    public MenuTypeController getMenuTypeController() {
        return this.menuTypeController;
    }
    public PeriodController getPeriodController() {
        return this.periodController;
    }
    public MealCategoryController getMealCategoryController() {
        return this.mealCategoryController;
    }
    public OrderTypeController getOrderTypeController() {
        return this.orderTypeController;
    }
    public IngredientController getIngredientController() {
        return this.ingredientController;
    }
    public CountryController getCountryController() {
        return this.countryController;
    }
    public RecipeController getRecipeController() { return this.recipeController; }
    public LineRecipeController getLineRecipeController() {
        return this.lineRecipeController;
    }
    public PersonController getPersonController() { return this.personController; }
    public DefaultListModel<Utensil> getUtensilListModel() {
        return this.utensilListModel;
    }
    public DefaultListModel<String> getRecipeStepListModel() {
        return this.recipeStepListModel;
    }
    public DefaultListModel<MenuType> getMenuTypeListModel() {
        return this.menuTypeListModel;
    }
    public DefaultListModel<MealCategory> getMealCategoryListModel() {
        return this.mealCategoryListModel;
    }
    public DefaultListModel<LineRecipeDisplay> getIngredientListModel() {
        return this.lineRecipeModel;
    }
    public DefaultComboBoxModel<Person> getAuthorComboBoxModel() {
        return this.authorComboBoxModel;
    }
    public DefaultComboBoxModel<Country> getCountryComboBoxModel() {
        return this.countryComboBoxModel;
    }
}

