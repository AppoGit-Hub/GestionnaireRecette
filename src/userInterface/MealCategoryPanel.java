package userInterface;

import controller.MealCategoryController;
import exception.TypeException;
import model.MealCategory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MealCategoryPanel extends JPanel {
    private JButton addMealCategoryButton;
    private JButton removeMealCategoryButton;
    private JComboBox<MealCategory> mealCategoryComboBox;
    private DefaultComboBoxModel<MealCategory> mealCategoryComboBoxModel;
    private JList<MealCategory> mealCategoryList;
    private DefaultListModel<MealCategory> mealCategoryListModel;
    private JLabel mealCategoryAccessErrorLabel;
    private JPanel mealCategoryPanel;
    private MealCategoryController mealCategoryController;

    public MealCategoryPanel() {
        this.mealCategoryController = new MealCategoryController();

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

        this.mealCategoryPanel = new JPanel();
        this.mealCategoryPanel.setLayout(new BorderLayout());
        this.mealCategoryPanel.add(mealCategoryList);

        JPanel mealCategoryUpPanel = new JPanel();
        mealCategoryUpPanel.setLayout(new GridLayout());
        mealCategoryUpPanel.add(mealCategoryComboBox);
        mealCategoryUpPanel.add(addMealCategoryButton);
        mealCategoryUpPanel.add(removeMealCategoryButton);

        this.mealCategoryPanel.add(mealCategoryUpPanel, BorderLayout.NORTH);

        this.setAllMenuCategory();
    }

    protected void setAllMenuCategory() {
        try {
            ArrayList<MealCategory> mealCategories = this.mealCategoryController.readAllMealCategory();
            this.mealCategoryComboBoxModel.addAll(mealCategories);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getPanel() {
        return mealCategoryPanel;
    }
}
