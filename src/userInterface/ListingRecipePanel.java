package userInterface;

import javax.swing.*;
import java.awt.*;

public class ListingRecipePanel extends JPanel {
    private AllRecipePanel allRecipePanel;
    private JTable jTable;
    private ListSelectionModel listSelectionModelRecipe;
    private JScrollPane jScrollPane;
    public ListingRecipePanel(){
        this.setLayout(new BorderLayout());
        this.allRecipePanel = new AllRecipePanel();
        this.jTable = new JTable(allRecipePanel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//je ne suis pas sûr de ce que cela veut dire
        this.listSelectionModelRecipe = jTable.getSelectionModel( );
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane, BorderLayout.CENTER);
    }
}
