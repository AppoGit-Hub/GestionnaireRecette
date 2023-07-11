package userInterface;

import controller.UtensilController;
import model.Utensil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UtensilPanel extends JPanel {
    private JButton addUtensilButton;
    private JButton removeUtensilButton;
    private JComboBox<Utensil> utensilComboBox;
    private DefaultComboBoxModel<Utensil> utensilComboBoxModel;
    private JList<Utensil> utensilList;
    private DefaultListModel<Utensil> utensilListModel;
    private JPanel utensilPanel;
    private UtensilController utensilController;
    public UtensilPanel() {
        this.utensilController = new UtensilController();

        UtensilActionListener utensilActionListener = new UtensilActionListener();
        this.addUtensilButton = new JButton("Add");
        this.addUtensilButton.addActionListener(utensilActionListener);
        this.removeUtensilButton = new JButton("Remove");
        this.removeUtensilButton.addActionListener(utensilActionListener);
        this.utensilComboBoxModel = new DefaultComboBoxModel<Utensil>();
        this.utensilComboBox = new JComboBox<Utensil>(utensilComboBoxModel);
        this.utensilListModel = new DefaultListModel<Utensil>();
        this.utensilList = new JList<Utensil>(utensilListModel);
        utensilActionListener.setUtensilComboBox(utensilComboBoxModel);
        utensilActionListener.setUtensilListModel(utensilListModel);
        utensilActionListener.setUtensilList(utensilList);

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
            JOptionPane.showMessageDialog(null, "Failed to load utensils", "Failed To Load", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JPanel getPanel() {
        return utensilPanel;
    }
}
