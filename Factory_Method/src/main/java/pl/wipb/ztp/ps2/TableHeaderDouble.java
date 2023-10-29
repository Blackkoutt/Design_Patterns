package pl.wipb.ztp.ps2;

public class TableHeaderDouble extends TableHeader {
    public TableHeaderDouble(){
        super("DOUBLE"); // Wywołanie konstruktora klasy nadrzędnej TableHeader
    }
    @Override
    public TableData createTableData(){
        return new TableDataDouble(); // Wywołanie konstruktora obiektu konkretnego typu
    }
}
