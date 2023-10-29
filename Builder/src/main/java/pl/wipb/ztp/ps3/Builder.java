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

    public void NextRow(){
        y+=TILESIZE;
        x=defaultCol;
    }

    public List<Segment> GetBoard(){
        return this.board;
    }

}
