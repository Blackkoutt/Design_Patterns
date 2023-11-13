package pl.wipb.ztp.ps4;

import java.util.LinkedList;

public class ProxyData extends RealData{
    private int size;
    private LinkedList<CopyOnWriteProxy> kopie = new LinkedList<CopyOnWriteProxy>();
    private RealData realData = null;

    public void removeCopies(){
        for(CopyOnWriteProxy kopia: kopie){
            kopia.kopiuj();
        }
        kopie.clear();
    }

    public CopyOnWriteProxy kopia(){
        //return new CopyOnWriteProxy(this);
        CopyOnWriteProxy data = kopia(this);
        kopie.addLast(data);
        //System.out.println(kopie);
        return data;
    }
    public ProxyData(int size) throws WrongSizeException{
        if(size<0){
            throw new WrongSizeException("Rozmiar tablicy nie może być mniejszy od zera!");
        }
        this.size = size;
    }

    // Proxy wywołuje metody klasy realData
    @Override
    public int get(int idx) {
        // Nie musimy tworzyć obiektu aby wyświetlić pustą tablicę
        if(realData==null) return 0;
        return realData.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if(!kopie.isEmpty()) removeCopies();
        // Wektor jest tworzony w momencie modyfikacji
        if(realData == null){
            realData = new RealData(size);
        }
        realData.set(idx, value);
    }

    @Override
    public int size() {
        return size;
    }

}
