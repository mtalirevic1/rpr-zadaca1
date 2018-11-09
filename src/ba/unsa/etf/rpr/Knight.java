package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {

    Knight(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String stara = super.getPosition().toLowerCase();
        String nova = position.toLowerCase();
        super.move(position);
        boolean hasMove = false;
        for (int i = -2; i <= 2; i = i + 4)
            for (int j = -1; j <= 1; j = j + 2) {
                if (nova.charAt(0) == stara.charAt(0) + i && nova.charAt(1) == stara.charAt(1) + j) { //Provjera da li je data pozicija udaljena 2 mjesta horizontalno i jedno vertikalno
                    hasMove = true;
                    break;
                }
                if (nova.charAt(0) == stara.charAt(0) + j && nova.charAt(1) == stara.charAt(1) + i) {
                    hasMove = true;
                    break;
                }
            }
        if (!hasMove)
            throw new IllegalChessMoveException("Illegal move for Knight");
        super.setPosition(position);
    }
}
