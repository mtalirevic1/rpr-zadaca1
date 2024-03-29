package ba.unsa.etf.rpr;

public class King extends ChessPiece {


    King(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        super.move(position);
        String stara =super.getPosition().toLowerCase();
        String nova = position.toLowerCase();
        boolean hasMove = false;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + j) {
                    hasMove = true;
                    break;
                }
            }
        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for King");
        super.setPosition(position);
    }

}
