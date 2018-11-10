package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {

    String pocetnaPozicija;

    Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
        pocetnaPozicija = pozicija.toLowerCase();
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String stara = super.getPosition().toLowerCase();
        String nova = position.toLowerCase();
        super.move(position);
        boolean hasMove = false;
        int k = 0;
        if (this.getColor() == Color.WHITE) {
            k = 1;
        } else {
            k = -1;
        }

        for (int i = -1; i <= 1; i++)
            if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + k)
                hasMove = true;

        if (pocetnaPozicija.equals(stara) && nova.charAt(0) == stara.charAt(0) && nova.charAt(1) == stara.charAt(1) + 2 * k)
            hasMove = true;

        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for Pawn");
        super.setPosition(position);
    }
}
