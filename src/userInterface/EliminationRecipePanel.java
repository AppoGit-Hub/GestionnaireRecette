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

public class EliminationRecipePanel extends JPanel implements ActionListener {
    private ListingRecipeTableModel allRecipePanel;
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

    public EliminationRecipePanel(){
        this.setLayout(new BorderLayout());
        deleteButton = new JButton("Elimination");
        this.deleteButton.addActionListener(this);

        this.add(deleteButton, BorderLayout.NORTH);

        this.allRecipePanel = new ListingRecipeTableModel();
        this.jTable = new JTable(allRecipePanel);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//je ne suis pas sûr de ce que cela veut dire
        this.listSelectionModelRecipe = jTable.getSelectionModel( );
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane,BorderLayout.CENTER);

        JLabel helpMessage = new JLabel("pour celectionner plusieur ligne maintener la touche ctrl enfoncé puis clique sur les éléments souhaités");
        helpMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(helpMessage,BorderLayout.SOUTH);
    }
    public void actionPerformed (ActionEvent e){
        String source = e.getActionCommand();
        int indexRecipeSelection = this.listSelectionModelRecipe.getMinSelectionIndex();
        if(indexRecipeSelection != -1){
            try{
                this.recipeStepController = new RecipeStepController();
                this.lineRecipeController = new LineRecipeController();
                this.equipementController = new EquipementController();
                this.commentController = new CommentController();
                this.periodController = new PeriodController();
                this.orderTypeController = new OrderTypeController();
                this.recipeController = new RecipeController();

                this.setRecipe = recipeController.getAllRecipe();
                int confirmation = JOptionPane.showConfirmDialog(
                        null,
                        "voulez vous vraiment éliminer ces/cette recette(s)",
                        "confirmation : élimination : données lié à une recette déjà éliminé",
                        JOptionPane.YES_NO_OPTION);
                // todo : c'est quoi le parentComponent de JOption
                while(confirmation == OK_OPTION && indexRecipeSelection <= this.listSelectionModelRecipe.getMaxSelectionIndex()) {
                    if (listSelectionModelRecipe.isSelectedIndex(indexRecipeSelection)){
                        System.out.println("index :"+indexRecipeSelection+"code recipe"+"codeRecipe"+"\n");
                        int codeRecipe = setRecipe.get(indexRecipeSelection).getCode();
                        recipeStepController.deleteAllStepRecipe(codeRecipe);
                        lineRecipeController.deleteAllLineRecip(codeRecipe);
                        equipementController.deleteAllEquipement(codeRecipe);
                        commentController.deleteAllComment(codeRecipe);
                        periodController.deleteAllPeriod(codeRecipe);
                        orderTypeController.deleteAllOrder(codeRecipe);
                        recipeController.deleteRecipe(codeRecipe);
                    }
                    indexRecipeSelection++;
                }
                this.repaint();
                this.revalidate();// todo : voir c'est quoi la différence entre les deux repaint et revalidate
                this.listSelectionModelRecipe.clearSelection();//car le truc est à 0 alors et pas à -1 se qu'il fat qu'il continue
                // à permettre l'élimination même s'il n' a rien à eliminer donc cela deconne

            }catch(DeleteRecipeException exception ){
               System.out.println("erreur au niveau de l'elimination d'une recipe");
            } catch(AllRecipeException | DeleteAllEquipementException exception){
                System.out.println("erreur : getAllRecipe");
            } catch (DeleteAllOfOneRecipeException | DeleteAllCommentException | DeleteAllLineRecipeException ex) {
               System.out.println("eliminationRecipePanel : erreur ");
            }  // todo : faire un truc pour les exceptions, un get message peut être ?
            catch (DeleteAllPeriodException ex) {
                ex.printStackTrace();
            } catch (DeleteAllOrderTypeException ex) {
                ex.printStackTrace();
            }

        }
        else{
            System.out.println("il faut selectionner pour changer");
        }
    }
}
