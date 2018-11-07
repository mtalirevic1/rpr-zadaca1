package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static enum Color{BLACK,WHITE}
    public abstract String getPosition();
    public abstract Color getColor();
    public abstract void move(String position);
    ChessPiece(String pozicija, Color boja){}
}
