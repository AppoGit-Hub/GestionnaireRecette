package userInterface;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class ListingRecipePanel extends JPanel {
    private AllRecipePanel allRecipePanel;
    private JScrollPane jScrollPane;
    private JTable jTable;
    public ListingRecipePanel(){
        this.allRecipePanel = new AllRecipePanel();
        this.jTable = new JTable(allRecipePanel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(1000);
        this.jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane);
    }
}
