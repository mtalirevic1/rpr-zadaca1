package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    private boolean firstMove = true;

    Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String stara = super.getPosition().toLowerCase();
        String nova = position.toLowerCase();
        super.move(position);
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
       super.setPosition(position);
        if (firstMove) firstMove = false;
    }
}
