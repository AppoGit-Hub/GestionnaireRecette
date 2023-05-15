package userInterface;

import controller.*;
import exception.*;
import model.Recipe;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.OK_OPTION;

public class ListingRecipePanel extends JPanel implements ActionListener {
    private AllRecipePanel allRecipePanel;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private JPanel jNorthBottonPanel;
    private JButton deleteButton,addButton,changeButton;
    private ListSelectionModel listSelectionModelRecipe;
    private RecipeController recipeController;
    private RecipeStepController recipeStepController;
    private LineRecipeController lineRecipeController;
    private EquipementController equipementController;
    private CommentController commentController;
    private PeriodController periodController;
    private OrderTypeController orderTypeController;
    private ArrayList<Recipe> setRecipe;

    public ListingRecipePanel(){
        this.setLayout(new BorderLayout());
        jNorthBottonPanel = new JPanel();
        jNorthBottonPanel.setLayout(new FlowLayout());
        deleteButton = new JButton("Elimination");
        this.deleteButton.addActionListener(this);
        this.deleteButton.setActionCommand("delete recipe");
        addButton = new JButton("Ajout");
        changeButton = new JButton("Modifier");
        this.changeButton.addActionListener(this);
        this.changeButton.setActionCommand("change recipe");
        jNorthBottonPanel.add(addButton);
        jNorthBottonPanel.add(changeButton);
        jNorthBottonPanel.add(deleteButton);
        this.add(jNorthBottonPanel, BorderLayout.NORTH);

        this.allRecipePanel = new AllRecipePanel();
        this.jTable = new JTable(allRecipePanel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listSelectionModelRecipe = jTable.getSelectionModel( );
        TableColumn column = jTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane,BorderLayout.CENTER);

    }
    public void actionPerformed (ActionEvent e){
        String source = e.getActionCommand();
        int indexRecipeSelection = this.listSelectionModelRecipe.getMinSelectionIndex();
        if(indexRecipeSelection != -1){
            try{
                this.recipeController = new RecipeController();
                if(source.equals("delete recipe")){
                    this.setRecipe = recipeController.getAllRecipe();
                    int codeRecipe = setRecipe.get(indexRecipeSelection).getCode();
                    int confirmation = JOptionPane.showConfirmDialog(
                            null,
                            "voulez vous éliminez les différentes informations lié à cette recette(recommandé)",
                            "confirmation : élimination : données lié à une recette déjà éliminé",
                            JOptionPane.YES_NO_OPTION);
                    if(confirmation == OK_OPTION ){
                        recipeStepController = new RecipeStepController();
                        lineRecipeController = new LineRecipeController();
                        equipementController = new EquipementController();
                        commentController = new CommentController();
                        periodController = new PeriodController();
                        orderTypeController = new OrderTypeController();

                        recipeStepController.deleteAllStepRecipe(codeRecipe);
                        lineRecipeController.deleteAllLineRecip(codeRecipe);
                        equipementController.deleteAllEquipement(codeRecipe);
                        commentController.deleteAllComment(codeRecipe);
                        periodController.deleteAllPeriod(codeRecipe);
                        orderTypeController.deleteAllOrder(codeRecipe);
                        recipeController.deleteRecipe(codeRecipe);
                        this.repaint();
                        this.revalidate();

                    }
                }
            } catch (Exception exception) {
                System.out.printf(exception.getMessage());
            }
        }
        else{
            System.out.println("il faut selectionner pour changer");
        }
    }
}
