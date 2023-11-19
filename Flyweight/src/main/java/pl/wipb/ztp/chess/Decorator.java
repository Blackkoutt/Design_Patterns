package pl.wipb.ztp.chess;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Decorator implements IPiece {
    protected IPiece piece;
    protected AffineTransform tr = new AffineTransform();

    public Decorator(IPiece piece){
        this.piece = piece;
    }

    @Override
    public void draw(Graphics2D g, int x, int y){
        AffineTransform transform = g.getTransform();
        g.transform(tr);
        piece.draw(g, x, y);
        g.setTransform(transform);
    }

   /* @Override
    public int getX() {
        return piece.getX();
    }

    @Override
    public int getY() {
        return piece.getY();
    }
    @Override
    public void moveTo(int x, int y){
        piece.moveTo(x,y);
    }*/
}
