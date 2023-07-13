package userInterface;

import controller.ComplexityController;
import controller.CountryController;
import controller.PersonController;
import exception.ComplexityException;
import exception.CountryException;
import exception.PersonException;
import exception.TypeException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
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
    private ComplexityController complexityController;

    private static final int PEOPLE_MIN = 1;
    private static final int PEOPLE_MAX = 100;
    private static final int NOTE_MIN = 0;
    private static final int NOTE_MAX = 10;
    private static final int TIME_MIN = 1;
    private static final int TIME_MAX = 1000;

    public GeneralRecipePanel() {
        this.countryController = new CountryController();
        this.personController = new PersonController();
        this.complexityController = new ComplexityController();

        this.titleLabel = new JLabel("Titre");
        this.titleField = new JTextField();

        this.isHot = new JRadioButton("Chaud");
        this.isCold = new JRadioButton("Froid");

        this.temperatureGroup = new ButtonGroup();
        temperatureGroup.add(isHot);
        temperatureGroup.add(isCold);
        this.temperatureGroup.setSelected(this.isHot.getModel(), true);

        this.isSalty = new JRadioButton("Salé");
        this.isSweet = new JRadioButton("Sucré");
        this.spiceGroup = new ButtonGroup();
        spiceGroup.add(isSalty);
        spiceGroup.add(isSweet);
        this.spiceGroup.setSelected(this.isSalty.getModel(), true);

        this.authorLabel = new JLabel("Auteur");
        this.authorComboBoxModel = new DefaultComboBoxModel<Person>();
        this.authorComboBox = new JComboBox<Person>(authorComboBoxModel);

        this.countryLabel = new JLabel("Pays");
        this.countryComboBoxModel = new DefaultComboBoxModel<Country>();
        this.countryComboBox = new JComboBox<Country>(countryComboBoxModel);

        this.publicationDateLabel = new JLabel("Date de publication");
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

        this.complexityLabel = new JLabel("Complexité");
        this.complexityComboBoxModel = new DefaultComboBoxModel<Complexity>();
        this.complexityComboBox = new JComboBox<Complexity>(complexityComboBoxModel);
        this.peopleLabel = new JLabel("Personnes pour");
        SpinnerNumberModel peopleSpinnerModel = new SpinnerNumberModel(1, PEOPLE_MIN, PEOPLE_MAX, 1);
        this.peopleSpinner = new JSpinner(peopleSpinnerModel);

        this.noteLabel = new JLabel("Note (/10)");
        SpinnerNumberModel noteSpinnerModel = new SpinnerNumberModel(5, NOTE_MIN, NOTE_MAX, 1);
        this.noteSpinner = new JSpinner(noteSpinnerModel);

        this.timeLabel = new JLabel("Temps (min)");
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
    public void setAuthor(Integer authorID) {
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
        Country selected = (Country) this.countryComboBox.getSelectedItem();
        return selected.getId() == 0 ? null : selected;
    }
    public void setCountry(Country country) {
        this.countryComboBox.setSelectedItem(country);
    }
    public void setCountry(Integer countryID) {
        // TODO : maybe there is a better way to do this ?
        try {
            ArrayList<Country> countries = this.countryController.readAllCountry();
            int index = 0;
            if (countryID != null) {
                while (index < countries.size() && countries.get(index).getId() != countryID) {
                    index++;
                }
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
    public void setComplexity(Integer complexity) {
        int index = 0;
        while (index < this.complexityComboBox.getItemCount() && this.complexityComboBoxModel.getElementAt(index).getId() == complexity) {
            index++;
        }
        Complexity actualComplexity = this.complexityComboBoxModel.getElementAt(index);
        this.complexityComboBox.setSelectedItem(actualComplexity);
    }
    public Integer getPeople() {
        return (Integer) this.peopleSpinner.getValue();
    }
    public void setPeople(Integer people) {
        this.peopleSpinner.setValue(people);
    }
    public Integer getNote() {
        return (Integer) this.noteSpinner.getValue();
    }
    public void setNote(int note) {
        this.noteSpinner.setValue(note);
    }
    public Integer getTime() {
        return (Integer) this.timeSpinner.getValue();
    }
    public void setTime(Integer time) {
        this.timeSpinner.setValue(time);
    }
    public String getDescription() {
        return this.descriptionTextArea.getText();
    }
    public void setDescription(String description) {
        this.descriptionTextArea.setText(description);
    }
    public Date getPublicationDate() {
        return (Date) publicationDateSpinner.getValue();
    }
    public void setPublicationDate(LocalDate date) {
        this.publicationDateSpinner.setValue(java.sql.Date.valueOf(date));
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
    private void setAllCountry() {
        try {
            ArrayList<Country> countries = this.countryController.readAllCountry();
            this.countryComboBoxModel.addAll(countries);
            this.countryComboBox.setSelectedItem(countries.get(0));
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private void setAllComplexity() {
        try {
            this.complexityComboBoxModel.removeAllElements();
            ArrayList<Complexity> complexities = this.complexityController.readAllComplexity();
            this.complexityComboBoxModel.addAll(complexities);
        } catch (ComplexityException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
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
                    Integer person = this.getPeople();
                    Integer note = this.getNote();
                    Integer time = this.getTime();
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
                        complexity.getId(),
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
                    JOptionPane.showMessageDialog(null, "Sélectionner une complexité", "Erreur de complexité de la recette", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sélectionner un auteur", "Erreur de l'auteur de la recette", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le titre de la recette doit exister", "Erreur dans le titre de la recette", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public void setAuthorForRecipe(Recipe selection) {
        // TODO : no time left, need further work ...
        try {
            Person person = this.personController.readPerson(selection.getPerson());
            int index = 0;
            while (index < authorComboBoxModel.getSize() && authorComboBoxModel.getElementAt(index).getId() != person.getId()) {
                index++;
            }
            if (index < authorComboBoxModel.getSize()) {
                authorComboBoxModel.setSelectedItem(authorComboBoxModel.getElementAt(index));
            }
        } catch (PersonException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setCountryForRecipe(Recipe selection) {
        // TODO : no time left, need further work ...
        try {
            Integer countrySaved = selection.getSpeciality();
            int index = 0;
            if (countrySaved != null) {
                Country country = this.countryController.readCountry(countrySaved);
                while (index < countryComboBoxModel.getSize() && countryComboBoxModel.getElementAt(index).getId() != country.getId()) {
                    index++;
                }
            }
            if (index < countryComboBoxModel.getSize()) {
                countryComboBoxModel.setSelectedItem(countryComboBoxModel.getElementAt(index));
            }
        } catch (CountryException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
