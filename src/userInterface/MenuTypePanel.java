package userInterface;

import controller.MenuTypeController;
import controller.PeriodController;
import exception.TypeException;
import model.MenuType;
import model.Period;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class MenuTypePanel extends JPanel implements ActionListener {
    private JButton addMenuTypeButton;
    private JButton removeMenuTypeButton;
    private JComboBox<MenuType> menuTypeComboBox;
    private DefaultComboBoxModel<MenuType> menuTypeComboBoxModel;
    private JList<MenuType> menuTypeList;
    private DefaultListModel<MenuType> menuTypeListModel;
    private JLabel menuTypeAccessErrorLabel;

    private JPanel menuTypePanel;

    private MenuTypeController menuTypeController;
    private PeriodController periodController;

    public MenuTypePanel() {
        this.menuTypeController = new MenuTypeController();
        this.periodController = new PeriodController();

        this.addMenuTypeButton = new JButton("Ajouter");
        this.addMenuTypeButton.addActionListener(this);
        this.removeMenuTypeButton = new JButton("Supprimer");
        this.removeMenuTypeButton.addActionListener(this);
        this.menuTypeListModel = new DefaultListModel<MenuType>();
        this.menuTypeList = new JList<MenuType>(menuTypeListModel);
        this.menuTypeAccessErrorLabel = new JLabel();
        this.menuTypeComboBoxModel = new DefaultComboBoxModel<MenuType>();
        this.menuTypeComboBox = new JComboBox<MenuType>(menuTypeComboBoxModel);

        this.menuTypePanel = new JPanel();
        this.menuTypePanel.setLayout(new BorderLayout());
        this.menuTypePanel.add(menuTypeList);

        JPanel menuTypeBottomPanel = new JPanel();
        menuTypeBottomPanel.setLayout(new GridLayout());
        menuTypeBottomPanel.add(menuTypeComboBox);
        menuTypeBottomPanel.add(addMenuTypeButton);
        menuTypeBottomPanel.add(removeMenuTypeButton);

        this.menuTypePanel.add(menuTypeBottomPanel, BorderLayout.NORTH);
        this.menuTypePanel.add(menuTypeAccessErrorLabel, BorderLayout.SOUTH);

        this.setAllMenuType();
    }

    protected void setAllMenuType() {
        try {
            ArrayList<MenuType> menuTypes = menuTypeController.getAllMenuTypes();
            this.menuTypeComboBoxModel.addAll(menuTypes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getPanel() {
        return menuTypePanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        MenuType selection = (MenuType) menuTypeComboBoxModel.getSelectedItem();
        if (eventName.equals("Ajouter")) {
            if (selection != null) {
                int index = 0;
                while (index < menuTypeListModel.size() && !menuTypeListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == menuTypeListModel.size()) {
                    menuTypeListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Supprimer")) {
            MenuType selectionList = menuTypeList.getSelectedValue();
            if (selectionList != null) {
                menuTypeListModel.removeElement(selectionList);
            }
        }
    }

    public void setMenuTypeForRecipe(Recipe selection) {
        try {
            menuTypeListModel.removeAllElements();
            ArrayList<Period> periods = this.periodController.readAllPeriod(selection.getCode());
            ArrayList<MenuType> menuTypes = new ArrayList<MenuType>();
            for (Period period : periods) {
                menuTypes.add(this.menuTypeController.readMenuType(period.getMenuType()));
            }
            menuTypeListModel.addAll(menuTypes);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMenuType(Recipe selection) {
        try {
            // TODO : do a better job at updating menu types values
            ArrayList<Period> periods = this.periodController.readAllPeriod(selection.getCode());
            for (Period period : periods) {
                this.periodController.deletePeriod(selection.getCode(), period.getMenuType());
            }
            Enumeration<MenuType> newMenuTypes = menuTypeListModel.elements();
            while (newMenuTypes.hasMoreElements()) {
                MenuType menuType = newMenuTypes.nextElement();
                this.periodController.createPeriod(selection.getCode(), menuType.getId());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
