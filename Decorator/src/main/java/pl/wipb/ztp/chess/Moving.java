package pl.wipb.ztp.chess;

public class Moving extends Decorator{
    // Przy ubraniu figury w dekorator Moving
    public Moving(IPiece piece){
        super(piece);
    }

    // Przesunięcie figury względem ruchu myszy
    public void setTranslation(double x, double y){
        tr.setToTranslation(x,y);
    }
    public IPiece GetPiece(){
        return piece;
    }
}
