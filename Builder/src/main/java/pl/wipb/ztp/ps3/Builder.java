package pl.wipb.ztp.ps3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    private final int defaultCol=4, defaultRow=4;
    protected int x= defaultCol, y=defaultRow;
    protected final int TILESIZE=32;
    protected List<Segment> board = new ArrayList<>();

    public abstract void createX(int value);
    public abstract void createSegmentA();
    public abstract void createSegmentB();
    public abstract void createSegmentC();
    public abstract void createSegmentG();

    public void createSegment(char znak, int liczba){
        switch (znak){
            case 'X':
            {
                createX(liczba);
                break;
            }
            case 'A':
                for (int i = 0; i < liczba; ++i) {
                    createSegmentA();
                }
                break;
            case 'B':
                for (int i = 0; i < liczba; ++i) {
                    createSegmentB();
                }
                break;
            case 'C':
                for (int i = 0; i < liczba; ++i) {
                    createSegmentC();
                }
                break;
            case 'G':
                for (int i = 0; i < liczba; ++i) {
                    createSegmentG();
                }
                break;
        }
    }

    public void NextRow(){
        y+=TILESIZE;
        x=defaultCol;
    }

    public List<Segment> GetBoard(){
        return this.board;
    }

}
