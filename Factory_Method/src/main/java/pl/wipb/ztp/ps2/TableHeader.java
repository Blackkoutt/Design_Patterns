package pl.wipb.ztp.ps2;

abstract class TableHeader {    // Klasa abstrakcyjna posiadająca metodę wirtualną
    private String type;

    protected TableHeader(String type) {
            this.type = type;
            }

    @Override
    public String toString() {
            return type;
            }
    public abstract TableData createTableData();    // Metoda wirtualna
}