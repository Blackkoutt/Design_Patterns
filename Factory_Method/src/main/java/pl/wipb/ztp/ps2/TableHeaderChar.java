package pl.wipb.ztp.ps2;

public class TableHeaderChar extends TableHeader {
    public TableHeaderChar(){
        super("CHAR"); // Wywołanie konstruktora klasy nadrzędnej TableHeader
    }
    @Override
    public TableData createTableData(){
        return new TableDataChar(); // Wywołanie konstruktora obiektu konkretnego typu
    }
}
