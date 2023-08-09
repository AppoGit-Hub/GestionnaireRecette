package userInterface;

import controller.RecipeController;
import controller.RecipeStepController;
import exception.TypeException;
import model.Recipe;
import model.RecipeStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class RecipeStepPanel extends JPanel implements ActionListener {
    private JTextArea recipeStepsTextArea;
    private JButton addRecipeStepsButton;
    private JButton removeRecipeStepsButton;
    private JButton editRecipeStepsButton;
    private JButton saveRecipeStepsButton;
    private JLabel recipeStepErrorLabel;
    private JList<String> recipeStepsList;
    private DefaultListModel<String> recipeStepListModel;

    private JPanel recipeStepsPanel;

    private RecipeStepController recipeStepController;

    public RecipeStepPanel() {
        this.recipeStepController = new RecipeStepController();

        this.recipeStepsTextArea = new JTextArea(10, 20);
        this.addRecipeStepsButton = new JButton("Ajouter");
        this.addRecipeStepsButton.addActionListener(this);
        this.removeRecipeStepsButton = new JButton("Supprimer");
        this.removeRecipeStepsButton.addActionListener(this);
        this.editRecipeStepsButton = new JButton("Editer");
        this.editRecipeStepsButton.addActionListener(this);
        this.saveRecipeStepsButton = new JButton("Sauvegarder");
        this.saveRecipeStepsButton.addActionListener(this);
        this.recipeStepListModel = new DefaultListModel<String>();
        this.recipeStepsList = new JList<String>(recipeStepListModel);
        this.recipeStepErrorLabel = new JLabel();

        this.recipeStepsPanel = new JPanel();
        this.recipeStepsPanel.setLayout(new BorderLayout());

        JPanel recipeStepsNorthPanel = new JPanel();
        recipeStepsNorthPanel.setLayout(new GridLayout());
        recipeStepsNorthPanel.add(addRecipeStepsButton);
        recipeStepsNorthPanel.add(removeRecipeStepsButton);
        recipeStepsNorthPanel.add(editRecipeStepsButton);
        recipeStepsNorthPanel.add(saveRecipeStepsButton);

        this.recipeStepsPanel.add(recipeStepsNorthPanel, BorderLayout.NORTH);

        JPanel recipeStepsCenterPanel = new JPanel();
        recipeStepsCenterPanel.setLayout(new GridLayout());
        recipeStepsCenterPanel.add(recipeStepsList);
        recipeStepsCenterPanel.add(recipeStepsTextArea);

        this.recipeStepsPanel.add(recipeStepsCenterPanel, BorderLayout.CENTER);

        JPanel recipeStepsBottomPanel = new JPanel();
        recipeStepsBottomPanel.add(recipeStepErrorLabel);

        this.recipeStepsPanel.add(recipeStepsBottomPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return recipeStepsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        String textArea = recipeStepsTextArea.getText();
        String selection = recipeStepsList.getSelectedValue();
        if (eventName.equals("Ajouter")) {
            int index = 0;
            while (index < recipeStepListModel.size() && !recipeStepListModel.get(index).equals(textArea)) {
                index++;
            }
            if (index == recipeStepListModel.size()) {
                recipeStepListModel.addElement(textArea);
            }
        }
        else if (selection != null) {
            if (eventName.equals("Supprimer")) {
                recipeStepListModel.removeElement(selection);
            } else if (eventName.equals("Editer")) {
                recipeStepsTextArea.setText(selection);
            }
        }
        int selectionIndex = recipeStepsList.getSelectedIndex();
        if (eventName.equals("Sauvegarder") && selectionIndex != -1) {
            recipeStepListModel.set(selectionIndex, recipeStepsTextArea.getText());
        }
    }

    public void setRecipeStepForRecipe(Recipe selection) {
        try {
            recipeStepListModel.removeAllElements();
            ArrayList<RecipeStep> recipeSteps = this.recipeStepController.readAllRecipeStep(selection.getCode());
            ArrayList<String> recipeStepsDescription = new ArrayList<String>();
            for (RecipeStep recipeStep : recipeSteps) {
                recipeStepsDescription.add(recipeStep.getDescription());
            }
            recipeStepListModel.addAll(recipeStepsDescription);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRecipeSteps(Recipe selection) {
        try {
            // TODO : do a better job at updating recipe steps values
            ArrayList<RecipeStep> recipeSteps = this.recipeStepController.readAllRecipeStep(selection.getCode());
            for (RecipeStep recipeStep : recipeSteps) {
                this.recipeStepController.deleteRecipeStep(selection.getCode(), recipeStep.getNumber());
            }
            Enumeration<String> newRecipeStepsDescription = recipeStepListModel.elements();
            int index = 0;
            while (newRecipeStepsDescription.hasMoreElements()) {
                String recipeStepDescription = newRecipeStepsDescription.nextElement();
                this.recipeStepController.createRecipeStep(new RecipeStep(selection.getCode(), index, recipeStepDescription));
                index++;
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
