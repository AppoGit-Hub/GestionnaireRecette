package userInterface;

import controller.*;
import exception.*;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class EliminationRecipePanel extends JPanel implements ActionListener {
    private JTable jTable;
    private JButton deleteButton;
    private ListSelectionModel listSelectionModelRecipe;
    private RecipeController recipeController;
    private RecipeStepController recipeStepController;
    private LineRecipeController lineRecipeController;
    private EquipementController equipementController;
    private CommentController commentController;
    private PeriodController periodController;
    private OrderTypeController orderTypeController;
    public EliminationRecipePanel() {
        this.setLayout(new BorderLayout());

        this.recipeStepController = new RecipeStepController();
        this.lineRecipeController = new LineRecipeController();
        this.equipementController = new EquipementController();
        this.commentController = new CommentController();
        this.periodController = new PeriodController();
        this.orderTypeController = new OrderTypeController();
        this.recipeController = new RecipeController();

        this.deleteButton = new JButton("Delete");
        this.deleteButton.addActionListener(this);

        this.jTable = new JTable(new ListingRecipeTableModel());
        this.jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//je ne suis pas sûr de ce que cela veut dire
        this.listSelectionModelRecipe = this.jTable.getSelectionModel( );

        this.add(new JScrollPane(jTable), BorderLayout.CENTER);
        this.add(deleteButton, BorderLayout.NORTH);
    }
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        if (source.equals("Delete")) {
            int[] selectedIndex = this.listSelectionModelRecipe.getSelectedIndices();
            if (selectedIndex.length > 0) {
                try {
                    int confirmation = JOptionPane.showConfirmDialog(
                            null,
                            "Do you really want to delete this recipe(s) ?",
                            "This is permanent !",
                            JOptionPane.YES_NO_OPTION);
                    if (confirmation == OK_OPTION) {
                        ArrayList<Recipe> recipes = recipeController.getAllRecipe();
                        for (int index = 0; index < selectedIndex.length; index++) {
                            int codeRecipe = recipes.get(index).getCode();
                            this.recipeStepController.deleteAllStepRecipe(codeRecipe);
                            this.lineRecipeController.deleteAllLineRecip(codeRecipe);
                            this.equipementController.deleteAllEquipement(codeRecipe);
                            this.commentController.deleteAllComment(codeRecipe);
                            this.periodController.deleteAllPeriod(codeRecipe);
                            this.orderTypeController.deleteAllOrder(codeRecipe);
                            this.recipeController.deleteRecipe(codeRecipe);
                        }
                        this.listSelectionModelRecipe.clearSelection();// todo : encore besoin ?
                        this.repaint();
                        this.revalidate();
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Failed to delete recipe", "Failed To Delete recipe", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must select recipes", "Select Recipes", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
