package pl.wipb.ztp.ps2;

class TableHeader {
    private String type;
    private TableData prototype;

    public TableHeader(String type, TableData prototype) {

        this.type = type;
        this.prototype = prototype;
    }

    @Override
    public String toString() {
        return type;
    }

    public TableData createTableData(){
        return prototype.copy();
    }
    
}
