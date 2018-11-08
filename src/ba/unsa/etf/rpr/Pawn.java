package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    private String pozicija;
    private Color boja;
    private boolean firstMove = true;

    Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    public void move(String position) throws IllegalChessMoveException {
        String stara = pozicija.toLowerCase();
        String nova = position.toLowerCase();
        if (!isPositionLegal(position))
            throw new IllegalArgumentException("Illegal position");
        boolean hasMove = false;
        for (int i = -1; i <= 1; i++)
            if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + 1)
                hasMove = true;

        if (firstMove) {
            if (nova.charAt(0) == stara.charAt(0) && nova.charAt(1) == stara.charAt(1) + 2)
                hasMove = true;
        }
        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for Pawn");
        pozicija = position;
        if (firstMove) firstMove = false;
    }
}
