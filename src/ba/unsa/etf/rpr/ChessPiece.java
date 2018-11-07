package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static enum Color{BLACK,WHITE}
    public abstract String getPosition();
    public abstract Color getColor();
    public abstract void move(String position);
    private String pozicija;
    private Color boja;

    public boolean isPositionLegal(String position){
        if(position.length()!=2 || !((position.charAt(0)>='A' && position.charAt(0)<='H') || (position.charAt(0)>='a' && position.charAt(0)<='h') ) || !(position.charAt(1)>='1' && position.charAt(1)<='8') ) return false;
        return true;
    }

    ChessPiece(String pozicija, Color boja){
        if(!isPositionLegal(pozicija)) throw new IllegalArgumentException("Ilegalna pozicija");
        this.pozicija=pozicija;
        this.boja=boja;
    }
}
