package pl.wipb.ztp.ps2;

class TableDataInt implements TableData {
    private int data;

    public TableDataInt() {
        data = rnd.nextInt(100); // Tworzenie obiektu - wartości w tabeli o konkretnym typie
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }
    
}
/* ... */
