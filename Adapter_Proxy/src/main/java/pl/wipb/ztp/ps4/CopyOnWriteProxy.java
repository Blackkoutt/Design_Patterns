package pl.wipb.ztp.ps4;

import javax.swing.table.AbstractTableModel;

public class CopyOnWriteProxy extends RealData{
    private ProxyData oryginal;
    private Data kopia;

    public CopyOnWriteProxy(ProxyData oryginal){
        this.oryginal = oryginal;
        //this.data = new RealData(data.size());
    }
    protected void kopiuj(){
        if(kopia!=null) return; // jeżeli już istnieje kopia
        // Wykonaj kopię głęboką
        kopia=new RealData(oryginal.size());
        for(int i=0;i<oryginal.size();i++){
            kopia.set(i, oryginal.get(i));
        }
        oryginal=null;  // odcięcie się od obiektu oryginału
    }
    @Override
    public int get(int idx) {
        // jeśli nie wykonano kopii głębokiej zwróć oryginalną tablicę
        if(kopia==null){
             return oryginal.get(idx);
        }
        else return kopia.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if(kopia==null){
            //kopiuj();
            oryginal.removeCopies();
        }
        kopia.set(idx,value);
    }

    @Override
    public int size() {
        if(kopia==null) return oryginal.size();
        return kopia.size();
    }
}
