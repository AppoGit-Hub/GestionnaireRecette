package userInterface;

import controller.CountryController;
import controller.PersonController;
import exception.CountryException;
import exception.TypeException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GeneralRecipePanel extends JPanel {
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
    private JPanel generalPanel;
    private CountryController countryController;
    private PersonController personController;
    private static final int PEOPLE_MIN = 1;
    private static final int PEOPLE_MAX = 100;
    private static final int NOTE_MIN = 0;
    private static final int NOTE_MAX = 10;
    private static final int TIME_MIN = 1;
    private static final int TIME_MAX = 1000;
    public GeneralRecipePanel() {
        this.countryController = new CountryController();
        this.personController = new PersonController();

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

        //TODO : Resolve the scaling problem
        this.generalPanel = new FormBuilder()
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

        this.setAllAuthor();
        this.setAllCountry();
        this.setAllComplexity();
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
    public JPanel getPanel() {
        return generalPanel;
    }
    protected void setAllAuthor() {
        try {
            ArrayList<Person> persons = this.personController.readAllPerson();
            this.authorComboBoxModel.addAll(persons);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllCountry() {
        try {
            ArrayList<Country> countries = this.countryController.readAllCountry();
            this.countryComboBoxModel.addAll(countries);
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void setAllComplexity() {
        java.util.List<Complexity> complexities = List.of(Complexity.values());
        this.complexityComboBoxModel.addAll(complexities);
    }
}
