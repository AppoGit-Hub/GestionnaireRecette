package userInterface;

import controller.MealCategoryController;
import controller.OrderTypeController;
import exception.TypeException;
import model.MealCategory;
import model.OrderType;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class MealCategoryPanel extends JPanel implements ActionListener {
    private JButton addMealCategoryButton;
    private JButton removeMealCategoryButton;
    private JComboBox<MealCategory> mealCategoryComboBox;
    private DefaultComboBoxModel<MealCategory> mealCategoryComboBoxModel;
    private JList<MealCategory> mealCategoryList;
    private DefaultListModel<MealCategory> mealCategoryListModel;
    private JLabel mealCategoryAccessErrorLabel;

    private JPanel mealCategoryPanel;

    private MealCategoryController mealCategoryController;
    private OrderTypeController orderTypeController;

    public MealCategoryPanel() {
        this.mealCategoryController = new MealCategoryController();
        this.orderTypeController = new OrderTypeController();

        this.addMealCategoryButton = new JButton("Ajouter");
        this.addMealCategoryButton.addActionListener(this);
        this.removeMealCategoryButton = new JButton("Retirer");
        this.removeMealCategoryButton.addActionListener(this);
        this.mealCategoryComboBoxModel = new DefaultComboBoxModel<MealCategory>();
        this.mealCategoryComboBox = new JComboBox<MealCategory>(mealCategoryComboBoxModel);
        this.mealCategoryListModel = new DefaultListModel<MealCategory>();
        this.mealCategoryList = new JList<MealCategory>(mealCategoryListModel);
        this.mealCategoryAccessErrorLabel = new JLabel();

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

    private void setAllMenuCategory() {
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
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        MealCategory selection = (MealCategory) mealCategoryComboBoxModel.getSelectedItem();
        if (eventName.equals("Ajouter")) {
            if (selection != null) {
                int index = 0;
                while (index < mealCategoryListModel.size() && !mealCategoryListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == mealCategoryListModel.size()) {
                    mealCategoryListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Retirer")) {
            MealCategory selectionList = mealCategoryList.getSelectedValue();
            if (selectionList != null) {
                mealCategoryListModel.removeElement(selectionList);
            }
        }
    }
    public void setMealCategoryForRecipe(Recipe selection) {
        try {
            mealCategoryListModel.removeAllElements();
            ArrayList<OrderType> orderTypes = this.orderTypeController.readAllOrderType(selection.getCode());
            ArrayList<MealCategory> mealCategories = new ArrayList<MealCategory>();
            for (OrderType orderType : orderTypes) {
                mealCategories.add(this.mealCategoryController.readMealCategory(orderType.getMealCategory()));
            }
            mealCategoryListModel.addAll(mealCategories);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMealCategory(Recipe selection) {
        try {
            // TODO : do a better job at updating meal categories values
            ArrayList<OrderType> orderTypes = this.orderTypeController.readAllOrderType(selection.getCode());
            for (OrderType orderType : orderTypes) {
                this.orderTypeController.deleteOrderType(selection.getCode(), orderType.getMealCategory());
            }
            Enumeration<MealCategory> newMealCategries = mealCategoryListModel.elements();
            while (newMealCategries.hasMoreElements()) {
                MealCategory mealCategory = newMealCategries.nextElement();
                this.orderTypeController.createOrderType(selection.getCode(), mealCategory.getId());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
