package userInterface;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class ListingRecipePanel extends JPanel {
    private JScrollPane jScrollPane;
    private AllRecipePanel allRecipePanel;
    private JTable jTable;
    public ListingRecipePanel(){
        allRecipePanel = new AllRecipePanel();
        jTable = new JTable(allRecipePanel);
        TableColumn column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(1000);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane = new JScrollPane(jTable);
        add(jScrollPane);
    }
}
