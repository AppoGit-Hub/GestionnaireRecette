package model;
import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchDietTableModel extends AbstractTableModel {
    private String[] columnNames;
    private ArrayList<SearchDietResult> searchDietResults;

    public SearchDietTableModel(ArrayList<SearchDietResult> searchDietResults) {
        this.columnNames = new String[] {
                "Title",
                "Publication Date",
                "Number People",
                "Complexitu Level",
                "Author"
        };
        setSearchDietResults(searchDietResults);
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
        return null;
    }

    public void setSearchDietResults(ArrayList<SearchDietResult> searchDietResults) {
        this.searchDietResults = searchDietResults;
    }
}