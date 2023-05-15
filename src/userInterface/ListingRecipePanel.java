package userInterface;
import javax.swing.*;
import java.awt.*;

public class ListingRecipePanel extends JPanel {
    private JTable jTable;

    public ListingRecipePanel(){
        this.setLayout(new BorderLayout());

        this.jTable = new JTable(new ListingRecipeTableModel());
        this.jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.add(new JScrollPane(jTable),BorderLayout.CENTER);
    }
}
