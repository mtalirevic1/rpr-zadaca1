package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    private String pozicija;
    private Color boja;

    Queen(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String stara = pozicija.toLowerCase();
        String nova = position.toLowerCase();
        if (!isPositionLegal(position))
            throw new IllegalArgumentException("Illegal position");
        boolean hasMove = false;
        for (int i = -8; i <= 8; i++)
            for (int j = -8; j <= 8; j++) {
                if (i == 0 && j == 0) continue;
                if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + j) {
                    hasMove = true;
                    break;
                }
            }
        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for Queen");
        pozicija = position;
    }
}
