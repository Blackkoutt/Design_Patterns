package pl.wipb.ztp.ps2;

class TableDataInt implements TableData {
    private int data;

    public TableDataInt() { }
    public TableDataInt(TableDataInt TDI){
        data = TDI.data;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

    public TableData copy(){
        /*TableDataInt cp = null;
        try{
            cp=(TableDataInt) super.clone();
        }catch(CloneNotSupportedException e) {}
        cp.data = rnd.nextInt(100);
        return cp;*/
        TableDataInt TDI = new TableDataInt(this);
        TDI.data = rnd.nextInt(100);
        return TDI;
    }

}
/* ... */
