package userInterface;

import model.MenuType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTypeActionListener implements ActionListener {
    private DefaultComboBoxModel<MenuType> menuTypeComboBoxModel;
    private DefaultListModel<MenuType> menuTypeListModel;
    private JList<MenuType> menuTypeList;

    public void setMenuTypeComboBoxModel(DefaultComboBoxModel<MenuType> menuTypeComboBoxModel) {
        this.menuTypeComboBoxModel = menuTypeComboBoxModel;
    }

    public void setMenuTypeListModel(DefaultListModel<MenuType> menuTypeListModel) {
        this.menuTypeListModel = menuTypeListModel;
    }

    public void setMenuTypeList(JList<MenuType> menuTypeList) {
        this.menuTypeList = menuTypeList;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        MenuType selection = (MenuType) menuTypeComboBoxModel.getSelectedItem();
        if (eventName.equals("Add")) {
            if (selection != null) {
                int index = 0;
                while (index < menuTypeListModel.size() && !menuTypeListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == menuTypeListModel.size()) {
                    menuTypeListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Remove")) {
            MenuType selectionList = menuTypeList.getSelectedValue();
            if (selectionList != null) {
                menuTypeListModel.removeElement(selectionList);
            }
        }
    }
}
