package model;
import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class SearchDietTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchDietResult> searchDietResults;

    public SearchDietTableModel(ArrayList<SearchDietResult> searchDietResults) {
        this.columnNames = new String[] {
                "Title",
                "Publication Date",
                "Number People",
                "Complexity Level",
                "Author"
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
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object;
        SearchDietResult resultDiet = searchDietResults.get(rowIndex);
        switch(columnIndex){
            case 0 :
                object = resultDiet.getTitle();
                break;
            case 1 :
                object = ((resultDiet.getPublicationDate() != null) ?
                         java.util.Date.from(resultDiet.getPublicationDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
                        : null);
                break;
            case 2 :
                object = resultDiet.getNumberPeople();
                break;
            case 3 :
                object = resultDiet.getComplexity();
                break;
            default :
                object = resultDiet.getFirstname() +" "+ resultDiet.getLastname();
                break;
        }
        return object;
    }
    public Class getColumnClass(int column){
        Class aClass;
        switch(column){
            case 0 :
            case 4 :
                aClass = String.class;
                break;
            case 1 :
                aClass = Date.class;
                break;
            default :
                aClass = Integer.class;
        }
        return aClass;
    }

    public void setSearchDietResults(ArrayList<SearchDietResult> searchDietResults) {
        this.searchDietResults = searchDietResults;
    }
}