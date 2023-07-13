package userInterface;

import controller.EquipementController;
import controller.UtensilController;
import exception.TypeException;
import model.Equipment;
import model.Recipe;
import model.Utensil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class UtensilPanel extends JPanel implements ActionListener {
    private JButton addUtensilButton;
    private JButton removeUtensilButton;
    private JComboBox<Utensil> utensilComboBox;
    private DefaultComboBoxModel<Utensil> utensilComboBoxModel;
    private JList<Utensil> utensilList;
    private DefaultListModel<Utensil> utensilListModel;

    private JPanel utensilPanel;

    private UtensilController utensilController;
    private EquipementController equipementController;

    public UtensilPanel() {
        this.utensilController = new UtensilController();
        this.equipementController = new EquipementController();

        this.addUtensilButton = new JButton("Ajouter");
        this.removeUtensilButton = new JButton("Supprimer");
        this.utensilComboBoxModel = new DefaultComboBoxModel<Utensil>();
        this.utensilComboBox = new JComboBox<Utensil>(utensilComboBoxModel);
        this.utensilListModel = new DefaultListModel<Utensil>();
        this.utensilList = new JList<Utensil>(utensilListModel);

        this.utensilPanel = new JPanel();
        this.utensilPanel.setLayout(new BorderLayout());
        this.utensilPanel.add(utensilList, BorderLayout.CENTER);

        JPanel utensilBottomPanel = new JPanel();
        utensilBottomPanel.setLayout(new GridLayout());
        utensilBottomPanel.add(utensilComboBox);
        utensilBottomPanel.add(addUtensilButton);
        utensilBottomPanel.add(removeUtensilButton);

        this.utensilPanel.add(utensilBottomPanel, BorderLayout.NORTH);
        this.setAllUtensil();
    }

    protected void setAllUtensil() {
        try {
            ArrayList<Utensil> utensils = this.utensilController.readAllUtensil();
            this.utensilComboBoxModel.addAll(utensils);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Échec du chargement des ustensiles", "Échec du chargement", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getPanel() {
        return utensilPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO : maybe create a unique function because duplicate code accross ActionListeners ?
        String eventName = event.getActionCommand();
        Utensil selection = (Utensil) utensilComboBox.getSelectedItem();
        if (eventName.equals("Ajouter")) {
            if (selection != null)  {
                int index = 0;
                while (index < utensilListModel.size() && !utensilListModel.get(index).getName().equals(selection.getName())) {
                    index++;
                }
                if (index == utensilListModel.size()) {
                    utensilListModel.addElement(selection);
                }
            }
        } else if (eventName.equals("Supprimer")) {
            Utensil selectionList = utensilList.getSelectedValue();
            if (selectionList != null) {
                utensilListModel.removeElement(selectionList);
            }
        }
    }

    public void setUtencilForRecipe(Recipe selection) {
        try {
            this.utensilListModel.removeAllElements();
            ArrayList<Equipment> equipments = this.equipementController.getAllEquipementOf(selection.getCode());
            ArrayList<Utensil> utensils = new ArrayList<Utensil>();
            for (Equipment equipment : equipments) {
                Utensil utensil = this.utensilController.readUtensil(equipment.getUtensil());
                utensils.add(utensil);
            }
            utensilListModel.addAll(utensils);
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUtensil(Recipe selection) {
        try {
            // TODO : do a better job at updating equipments values
            utensilListModel.removeAllElements();
            ArrayList<Equipment> equipments = this.equipementController.getAllEquipementOf(selection.getCode());
            for (Equipment equipment : equipments) {
                this.equipementController.deleteEquipementFor(selection.getCode(), equipment.getUtensil());
            }
            Enumeration<Utensil> newUtensils =  utensilListModel.elements();
            while (newUtensils.hasMoreElements()) {
                Utensil utensil = newUtensils.nextElement();
                this.equipementController.createEquipementFor(selection.getCode(), utensil.getName());
            }
        } catch (TypeException exception) {
            JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
