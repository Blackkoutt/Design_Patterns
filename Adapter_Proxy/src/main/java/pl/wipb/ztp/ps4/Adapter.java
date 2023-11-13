package pl.wipb.ztp.ps4;

import javax.swing.table.AbstractTableModel;

public class Adapter extends AbstractTableModel {
    private Data data = null;
    @Override
    public int getRowCount() {
        if(data==null){
            return 0;
        }
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return rowIndex;
            case 1: return data.get(rowIndex);
            default: return null;
        }

    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "index";
            case 1: return "wartość";
            default: return super.getColumnName(column);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==1) return true;
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 1){
            data.set(rowIndex, (int)aValue);
        }
        super.setValueAt(aValue,rowIndex,columnIndex);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }
    public void changeData(Data newData){
        data=newData;
        fireTableStructureChanged();
    }
}
