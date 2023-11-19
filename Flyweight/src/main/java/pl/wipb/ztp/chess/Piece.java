package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

// Klasa dekorowana
class Piece implements IPiece{
	public static final int TILESIZE = 32;
	private static Image image;
	
	static {
		try {
			image = Chessboard.loadImage("/img/pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int index;
	public static Piece[] pieces;

	// Wczesna inicjalizacja tablicy
	static {
		pieces=new Piece[12];
		for(int i=0;i<12;i++){
			pieces[i]=new Piece(i);
		}
	}
	// Prywatny konstruktor
	private Piece(int i){
		this.index=i;
	}
	// Pobranie figury z tablicy figur
	public static Piece getPiece(int index){
		return pieces[index];
	}

	// Stan zewnętrzny x i y przekazywany jako parametr
	public void draw(Graphics2D g, int x, int y) {
		g.drawImage(image, x, y, x + 1, y + 1, index * Piece.TILESIZE, 0, (index + 1) * Piece.TILESIZE,
				Piece.TILESIZE,null);
	}
	/*public Piece(int idx, int xx, int yy) {
		index = idx;
		x = xx;
		y = yy;
	}*/

	/*public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void moveTo(int xx, int yy) {
		x = xx;
		y = yy;
	}*/
}