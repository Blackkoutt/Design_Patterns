package pl.wipb.ztp.ps2;

public class TableHeaderBoolean extends TableHeader {
        public TableHeaderBoolean(){
            super("BOOLEAN"); // Wywołanie konstruktora klasy nadrzędnej TableHeader
        }
        @Override
        public TableData createTableData(){
            return new TableDataBoolean();  // Wywołanie konstruktora obiektu konkretnego typu
        }
}
