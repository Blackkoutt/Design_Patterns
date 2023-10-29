package pl.wipb.ztp.ps2;

public class TableDataChar implements TableData {
    private char data;

    public TableDataChar() {
        data = (char)(rnd.nextInt(126 - 33 + 1) + 32); // Tworzenie obiektu - wartości w tabeli o konkretnym typie
    }

    @Override
    public String toString() {
        return Character.toString(data);
    }

}
