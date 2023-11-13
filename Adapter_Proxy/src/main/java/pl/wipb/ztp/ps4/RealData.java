package pl.wipb.ztp.ps4;

import java.util.ArrayList;
import java.util.LinkedList;

// prosta implementacja danych - tablica
class RealData implements Data {
	private int data[];
	public RealData(int size) {
		data=new int[size];
	}
	public RealData(){}

	@Override
	public CopyOnWriteProxy kopia(ProxyData data){
		//return new CopyOnWriteProxy(this);
		CopyOnWriteProxy copy = new CopyOnWriteProxy(data);
		return copy;
	}
	@Override
	public int get(int idx) {
		return data[idx];
	}

	@Override
	public void set(int idx, int value) {
		data[idx] = value;
	}

	@Override
	public int size() {
		return data.length;
	}
}