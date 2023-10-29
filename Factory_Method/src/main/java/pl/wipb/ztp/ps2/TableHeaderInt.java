package pl.wipb.ztp.ps2;

public class TableHeaderInt extends TableHeader{
    public TableHeaderInt(){
        super("INT");   // Wywołanie konstruktora klasy nadrzędnej TableHeader
    }
    @Override
    public TableData createTableData(){
        return new TableDataInt(); // Wywołanie konstruktora obiektu konkretnego typu
    }
}
