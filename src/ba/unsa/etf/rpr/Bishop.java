package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    Bishop(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String stara = super.getPosition().toLowerCase();
        String nova = position.toLowerCase();
        super.move(position);
        boolean hasMove = false;
        for (int i = -8; i <= 8; i++)
            for (int j = -8; j <= 8; j++) {
                if ((i == 0 && j == 0) || (Math.abs(i) != Math.abs(j))) continue;
                if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + j) {
                    hasMove = true;
                    break;
                }
            }
        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for Bishop");
        super.setPosition(position);
    }
}
