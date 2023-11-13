package pl.wipb.ztp.ps4;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

// baza danych - kolekcja Data
class Baza extends AbstractListModel<Data>{
    private List<Data> ar = new ArrayList<Data>();

    public void add(Data tab){
    	ar.add(tab);
        fireIntervalAdded(this, ar.size()-1, ar.size()-1);
    }

    public void remove(int idx){
    	ar.remove(idx);
        fireIntervalAdded(this, ar.size(), ar.size());
    }


    public int getSize() {
    	return ar.size();
    }

    public Data getElementAt(int index) {
    	return ar.get(index);
    }
}