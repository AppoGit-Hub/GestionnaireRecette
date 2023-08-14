package userInterface;
import controller.ComplexityController;
import exception.TypeException;
import model.Complexity;
import model.SearchDietResult;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchDietTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchDietResult> searchDietResults;
    private ComplexityController complexityController;

    public SearchDietTableModel(ArrayList<SearchDietResult> searchDietResults) {
        this.complexityController = new ComplexityController();
        this.columnNames = new String[] {
            "Titre",
            "Date de Publication",
            "Nombre de Personnes",
            "Niveau de Complexité",
            "Auteur"
        };
        setSearchDietResults(searchDietResults);
    }

    @Override
    public String getColumnName(int col){
        return this.columnNames[col];
    }
    @Override
    public int getRowCount() {
        return searchDietResults.size();
    }
    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchDietResult resultDiet = searchDietResults.get(rowIndex);
        switch(columnIndex){
            case 0 :
                return resultDiet.getTitle();
            case 1 :
                return resultDiet.getPublicationDate();
            case 2 :
                return resultDiet.getNumberPeople();
            case 3 :
                try {
                    Complexity complexity = complexityController.readComplexity(resultDiet.getComplexity());
                    return complexity.getName();
                } catch (TypeException exception) {
                    JOptionPane.showMessageDialog(null, exception.getDescription(), exception.getTitle(), JOptionPane.ERROR_MESSAGE);
                }
                return "Erreur de chargement";
            default :
                return resultDiet.getName();
        }
    }
    public Class getColumnClass(int column){
        return switch (column) {
            case 0 -> String.class;
            case 1 -> LocalDate.class;
            case 2 -> Integer.class;
            case 3 -> Complexity.class;
            default -> String.class;
        };
    }

    public void setSearchDietResults(ArrayList<SearchDietResult> searchDietResults) {
        this.searchDietResults = searchDietResults;
    }
}