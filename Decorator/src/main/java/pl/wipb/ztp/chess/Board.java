package pl.wipb.ztp.chess;

import java.awt.*;

public class Board extends Decorator{
    // Przy ubraniu obieku Piece w dekorator OnBoard
    public Board(IPiece piece){
        super(piece);
        // Ustawienie figury względem początku układu współrzędnych
        tr.translate(Chessboard.ZEROX, Chessboard.ZEROY);
        tr.scale(Piece.TILESIZE, Piece.TILESIZE);   // Skalowanie obiektu
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
    }
}
