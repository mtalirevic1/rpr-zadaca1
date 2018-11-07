package ba.unsa.etf.rpr;

public class King  extends ChessPiece{
    private String pozicija;
    private Color boja;

    King(String pozicija, Color boja){
        super(pozicija,boja);
    }

    public void move(String position) throws IllegalChessMoveException {
        String stara=pozicija.toLowerCase();
        String nova=position.toLowerCase();
        if(!isPositionLegal(position))
            throw new IllegalArgumentException("Illegal position");
        if( !( nova.charAt(0)==stara.charAt(0) && nova.charAt(1)==stara.charAt(1)+1 ) || !( nova.charAt(0)==stara.charAt(0) && nova.charAt(1)==stara.charAt(1)-1 ) ||
                !( nova.charAt(0)==stara.charAt(0)-1 && nova.charAt(1)==stara.charAt(1) ) || !( nova.charAt(0)==stara.charAt(0)+1 && nova.charAt(1)==stara.charAt(1) ) )
            throw new IllegalChessMoveException("Illegal move for King");
        pozicija=position;
    }

}
