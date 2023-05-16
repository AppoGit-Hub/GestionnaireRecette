package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeStepActionListener implements ActionListener {
    private JTextArea recipeStepsTextArea;
    private DefaultListModel<String> recipeStepListModel;
    private JList<String> recipeStepsList;

    public void setRecipeStepTextArea(JTextArea textArea) {
        this.recipeStepsTextArea = textArea;
    }
    public void setRecipeStepListModel(DefaultListModel<String> listModel) {
        this.recipeStepListModel = listModel;
    }
    public void setRecipeStepsList(JList<String> list) {
        this.recipeStepsList = list;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        String textArea = recipeStepsTextArea.getText();
        String selection = recipeStepsList.getSelectedValue();
        if (eventName.equals("Add")) {
            int index = 0;
            while (index < recipeStepListModel.size() && !recipeStepListModel.get(index).equals(textArea)) {
                index++;
            }
            if (index == recipeStepListModel.size()) {
                recipeStepListModel.addElement(textArea);
            }
        }
        else if (selection != null) {
            if (eventName.equals("Remove")) {
                recipeStepListModel.removeElement(selection);
            } else if (eventName.equals("Edit")) {
                recipeStepsTextArea.setText(selection);
            }
        }
        int selectionIndex = recipeStepsList.getSelectedIndex();
        if (eventName.equals("Save") && selectionIndex != -1) {
            recipeStepListModel.set(selectionIndex, recipeStepsTextArea.getText());
        }
    }
}
