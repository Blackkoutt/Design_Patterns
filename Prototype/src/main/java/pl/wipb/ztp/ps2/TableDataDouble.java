package pl.wipb.ztp.ps2;

import java.awt.datatransfer.SystemFlavorMap;

public class TableDataDouble implements  TableData{
    private double data;

    public TableDataDouble() { }
    public TableDataDouble(TableDataDouble TDD){
        data = TDD.data;
    }

    @Override
    public String toString() {
        return Double.toString(data);
    }

    public TableData copy(){
        /*TableDataDouble cp = null;
        try{
            cp=(TableDataDouble) super.clone();
            System.out.println(cp.data);
        }catch(CloneNotSupportedException e) {}
        cp.data = rnd.nextDouble();
        return cp;*/
        TableDataDouble TDD = new TableDataDouble(this);
        TDD.data = rnd.nextDouble();
        return TDD;
    }
}
