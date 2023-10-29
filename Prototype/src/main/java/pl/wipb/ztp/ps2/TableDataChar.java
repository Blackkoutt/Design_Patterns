package pl.wipb.ztp.ps2;

public class TableDataChar implements TableData{
    private char data;

    public TableDataChar() { }
    public TableDataChar(TableDataChar TDC) {
        data=TDC.data;
    }

    @Override
    public String toString() {
        return Character.toString(data);
    }

    public TableData copy(){
        /*TableDataChar cp = null;
        try{
            cp=(TableDataChar) super.clone();
        }catch(CloneNotSupportedException e) {}
        cp.data = (char) (rnd.nextInt(126 - 33 + 1) + 33);
        return cp;*/
        TableDataChar TDC = new TableDataChar(this);
        TDC.data = (char) (rnd.nextInt(126 - 33 + 1) + 33);
        return TDC;
    }
}
