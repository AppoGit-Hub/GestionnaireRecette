package userInterface;

import controller.*;
import model.Recipe;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.OK_OPTION;

public class ListingRecipePanel extends JPanel implements ActionListener {
    private ListingRecipeTableModel listingRecipeTableModel;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private ListSelectionModel listSelectionModelRecipe;
    private JScrollPane jScrollPane;
    public ListingRecipePanel(){
        this.setLayout(new BorderLayout());
        jNorthBottonPanel = new JPanel();
        jNorthBottonPanel.setLayout(new FlowLayout());
        deleteButton = new JButton("Elimination");
        this.deleteButton.addActionListener(this);
        this.deleteButton.setActionCommand("delete recipe");//on donne un string au event
        addButton = new JButton("Ajout");
        changeButton = new JButton("Modifier");
        this.changeButton.addActionListener(this);
        this.changeButton.setActionCommand("change recipe");
        jNorthBottonPanel.add(addButton);
        jNorthBottonPanel.add(changeButton);
        jNorthBottonPanel.add(deleteButton);
        this.add(jNorthBottonPanel, BorderLayout.NORTH);

        this.listingRecipeTableModel = new ListingRecipeTableModel();
        this.jTable = new JTable(listingRecipeTableModel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//je ne suis pas sûr de ce que cela veut dire
        this.listSelectionModelRecipe = jTable.getSelectionModel( );
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane,BorderLayout.CENTER);

    }
    public void actionPerformed (ActionEvent e){
        String source = e.getActionCommand();
        int indexRecipeSelection = this.listSelectionModelRecipe.getMinSelectionIndex();//renvoie le plus petit index selectionner ou -1 si aucun
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
                    // todo : c'est quoi le parentComponent de JOption
                    if(confirmation == OK_OPTION ) {
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
                        //on elimine dabord les trucs qui lui sont liées puis la recette ?j'espère
                        recipeController.deleteRecipe(codeRecipe);
                        this.repaint();
                        this.revalidate();// todo : voir c'est quoi la différence entre les deux repaint et revalidate

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
