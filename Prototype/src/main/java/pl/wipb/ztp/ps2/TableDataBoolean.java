package pl.wipb.ztp.ps2;

public class TableDataBoolean implements TableData{
    private boolean data;

    public TableDataBoolean() {}
    public TableDataBoolean(TableDataBoolean TDB) {
        data = TDB.data;
    }

    @Override
    public String toString() {
        return Boolean.toString(data);
    }

    public TableData copy() {
        /*TableDataBoolean cp = null;
        try {
            cp = (TableDataBoolean) super.clone();
        } catch(CloneNotSupportedException e) {}
        cp.data = rnd.nextBoolean();
        return cp;*/
        TableDataBoolean TDB = new TableDataBoolean(this);
        TDB.data = rnd.nextBoolean();
        return TDB;
    }
}
