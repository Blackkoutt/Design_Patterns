package pl.wipb.ztp.ps2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class Database extends AbstractTableModel {
    private List<TableHeader> headers;
    private List<List<TableData>> data;

    public Database() {
        headers = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void addRow() {
        List<TableData> row = new ArrayList<>();
        for (TableHeader col : headers) {
            row.add(col.createTableData()); // stworzenie kopii prototypu
        }
        data.add(row);
        fireTableStructureChanged();
    }

    public void addCol(TableHeader type) {
        headers.add(type);
        for (List<TableData> row : data) {
            row.add(type.createTableData()); // stworzenie kopii prototypu
        }
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return headers.size();
    }

    public String getColumnName(int column) {
        return headers.get(column).toString();
    }

    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
    
}
