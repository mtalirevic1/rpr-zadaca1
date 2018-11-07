package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    private String pozicija;
    private Color boja;
    public static enum Color{BLACK,WHITE}

    public String getPosition(){
        return pozicija;
    }
    public Color getColor(){
        return boja;
    }

    public abstract void move(String position) throws IllegalChessMoveException;

    public boolean isPositionLegal(String position){
        if(position.length()!=2 || !((position.charAt(0)>='A' && position.charAt(0)<='H') || (position.charAt(0)>='a' && position.charAt(0)<='h') ) || !(position.charAt(1)>='1' && position.charAt(1)<='8') ) return false; //Ispituje da li je string duzine 2 i da li su na indeksima stringa 1 i 2 validni karakteri
        return true;
    }

    ChessPiece(String pozicija, Color boja){
        if(!isPositionLegal(pozicija)) throw new IllegalArgumentException("Illegal position");
        this.pozicija=pozicija;
        this.boja=boja;
    }
}
