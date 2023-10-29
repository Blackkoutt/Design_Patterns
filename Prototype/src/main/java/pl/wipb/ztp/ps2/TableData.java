package pl.wipb.ztp.ps2;

import java.util.Random;


interface TableData /*extends Cloneable*/{
    static final Random rnd = new Random();
    public TableData copy();
    
}
