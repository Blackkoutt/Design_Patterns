package pl.wipb.ztp.chess;

import java.awt.*;

// Interfejs klasy dekorowanej
public interface IPiece {
    public void draw(Graphics2D g);
    public int getX();
    public int getY();
    public void moveTo(int x, int y);
}
