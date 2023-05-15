package userInterface;

import model.MealCategory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealCategoryActionListener implements ActionListener {
    private DefaultComboBoxModel<MealCategory> mealCategoryComboBoxModel;
    private DefaultListModel<MealCategory> mealCategoryListModel;
    private JList<MealCategory> mealCategoryList;
    public void setMealCategoryComboxModel(DefaultComboBoxModel<MealCategory> mealCategoryComboBoxModel) {
        this.mealCategoryComboBoxModel = mealCategoryComboBoxModel;
    }

    public void setMealCategoryListModel(DefaultListModel<MealCategory> mealCategoryListModel) {
        this.mealCategoryListModel = mealCategoryListModel;
    }

    public void setMealCategoryList(JList<MealCategory> mealCategoryList) {
        this.mealCategoryList = mealCategoryList;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        MealCategory selection = (MealCategory) mealCategoryComboBoxModel.getSelectedItem();
        if (eventName.equals("Add")) {
            if (selection != null) {
                int index = 0;
                while (index < mealCategoryListModel.size() && !mealCategoryListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == mealCategoryListModel.size()) {
                    mealCategoryListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Remove")) {
            MealCategory selectionList = mealCategoryList.getSelectedValue();
            if (selectionList != null) {
                mealCategoryListModel.removeElement(selectionList);
            }
        }
    }
}
