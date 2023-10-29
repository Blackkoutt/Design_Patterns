package pl.wipb.ztp.ps2;

public class TableDataDouble implements TableData {
    private double data;

    public TableDataDouble() {
        data = rnd.nextDouble()*10; // Tworzenie obiektu - wartości w tabeli o konkretnym typie
    }

    @Override
    public String toString() {
        return Double.toString(data);
    }
}
