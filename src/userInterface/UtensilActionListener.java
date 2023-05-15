package userInterface;

import model.Utensil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtensilActionListener implements ActionListener {
    private JList<Utensil> utensilList;
    private DefaultListModel<Utensil> utensilListModel;
    private DefaultComboBoxModel<Utensil> utensilComboBox;

    public void setUtensilComboBox(DefaultComboBoxModel<Utensil> utensilComboBox) {
        this.utensilComboBox = utensilComboBox;
    }

    public void setUtensilListModel(DefaultListModel<Utensil> utensilListModel) {
        this.utensilListModel = utensilListModel;
    }

    public void setUtensilList(JList<Utensil> utensilList) {
        this.utensilList = utensilList;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        Utensil selection = (Utensil) utensilComboBox.getSelectedItem();
        if (eventName.equals("Add")) {
            if (selection != null)  {
                int index = 0;
                while (index < utensilListModel.size() && !utensilListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == utensilListModel.size()) {
                    utensilListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Remove")) {
            Utensil selectionList = utensilList.getSelectedValue();
            if (selectionList != null) {
                utensilListModel.removeElement(selectionList);
            }
        }
    }
}
