package userInterface;

import controller.MenuTypeController;
import exception.TypeException;
import model.MenuType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuTypePanel extends JPanel  {
    private JButton addMenuTypeButton;
    private JButton removeMenuTypeButton;
    private JComboBox<MenuType> menuTypeComboBox;
    private DefaultComboBoxModel<MenuType> menuTypeComboBoxModel;
    private JList<MenuType> menuTypeList;
    private DefaultListModel<MenuType> menuTypeListModel;
    private JLabel menuTypeAccessErrorLabel;
    private MenuTypeController menuTypeController;
    private JPanel menuTypePanel;

    public MenuTypePanel() {
        this.menuTypeController = new MenuTypeController();

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
}
