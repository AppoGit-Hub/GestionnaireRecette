package userInterface;

import javax.swing.*;
import java.awt.*;

public class RecipeStepPanel extends JPanel {
    private JTextArea recipeStepsTextArea;
    private JButton addRecipeStepsButton;
    private JButton removeRecipeStepsButton;
    private JButton editRecipeStepsButton;
    private JButton saveRecipeStepsButton;
    private JLabel recipeStepErrorLabel;
    private JList<String> recipeStepsList;
    private DefaultListModel<String> recipeStepListModel;
    private JPanel recipeStepsPanel;

    public RecipeStepPanel() {
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
}
