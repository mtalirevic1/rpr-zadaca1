package ba.unsa.etf.rpr;


public class Board {
    private ChessPiece[][] sahovnica;

    Board() {
        sahovnica = new ChessPiece[8][8];

        sahovnica[0][0] = new Rook("a1", ChessPiece.Color.WHITE);
        sahovnica[0][1] = new Knight("b1", ChessPiece.Color.WHITE);
        sahovnica[0][2] = new Bishop("c1", ChessPiece.Color.WHITE);
        sahovnica[0][3] = new Queen("d1", ChessPiece.Color.WHITE);
        sahovnica[0][4] = new King("e1", ChessPiece.Color.WHITE);
        sahovnica[0][5] = new Bishop("f1", ChessPiece.Color.WHITE);
        sahovnica[0][6] = new Knight("g1", ChessPiece.Color.WHITE);
        sahovnica[0][7] = new Rook("h1", ChessPiece.Color.WHITE);

        char slovo = 'a';
        for (int i = 0; i < 8; i++) {
            sahovnica[1][i] = new Pawn(slovo + "2", ChessPiece.Color.WHITE);
            slovo++;
        }

        for (int i = 2; i <= 5; i++)
            for (int j = 0; j <= 7; j++)
                sahovnica[i][j] = null;

        slovo = 'a';
        for (int i = 0; i < 8; i++) {
            sahovnica[6][i] = new Pawn(slovo + "7", ChessPiece.Color.BLACK);
            slovo++;
        }

        sahovnica[7][0] = new Rook("a8", ChessPiece.Color.BLACK);
        sahovnica[7][1] = new Knight("b8", ChessPiece.Color.BLACK);
        sahovnica[7][2] = new Bishop("c8", ChessPiece.Color.BLACK);
        sahovnica[7][3] = new Queen("d8", ChessPiece.Color.BLACK);
        sahovnica[7][4] = new King("e8", ChessPiece.Color.BLACK);
        sahovnica[7][5] = new Bishop("f8", ChessPiece.Color.BLACK);
        sahovnica[7][6] = new Knight("g8", ChessPiece.Color.BLACK);
        sahovnica[7][7] = new Rook("h8", ChessPiece.Color.BLACK);
    }

    void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        ChessPiece figura = null;

        boolean stani = false;
        String prosla;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sahovnica[i][j] != null && sahovnica[i][j].getClass() == type && sahovnica[i][j].getColor() == color) {
                    try {
                        prosla = sahovnica[i][j].getPosition();
                        sahovnica[i][j].move(position);
                        sahovnica[i][j].setPosition(prosla);
                    } catch (IllegalChessMoveException e) {
                        continue;
                    }
                    figura = sahovnica[i][j];
                    stani = true;
                    break;
                }

            }
            if (stani) break;
        }

        if (figura == null) throw new IllegalChessMoveException("Such a piece does not exist");

        move(figura.getPosition(), position);
    }

    void move(String oldPosition, String newPosition) throws IllegalChessMoveException {

        String stara = oldPosition.toUpperCase();
        int stara0 = stara.charAt(0) - 17 - '0';
        int stara1 = stara.charAt(1) - '0' - 1;
        if (sahovnica[stara1][stara0] == null)
            throw new IllegalArgumentException("No piece on that field");
        ChessPiece figura = sahovnica[stara1][stara0];


        String lastPosition = figura.getPosition();
        String posljednja = lastPosition.toUpperCase();
        figura.move(newPosition);
        figura.setPosition(lastPosition);

        String pozicija = newPosition.toUpperCase();
        int novaY = pozicija.charAt(0) - 17 - '0';
        int novaX = pozicija.charAt(1) - '0' - 1;
        int staraY = posljednja.charAt(0) - 17 - '0';
        int staraX = posljednja.charAt(1) - '0' - 1;

        /*if (sahovnica[novaX][novaY] != null && sahovnica[novaX][novaY].getColor() == figura.getColor())
            throw new IllegalChessMoveException("Illegal move");

        if (!(figura instanceof Knight)) {

            int dirX = 0, dirY = 0;

            if (figura instanceof Pawn && staraY != novaY && sahovnica[novaX][novaY] == null) {
                throw new IllegalChessMoveException("Illegal move");
            }

            if (novaX > staraX) dirX = 1;
            else if (novaX == staraX) dirX = 0;
            else dirX = -1;

            if (novaY > staraY) dirY = 1;
            else if (novaY == staraY) dirY = 0;
            else dirY = -1;

            int duzina = 0;
            int deltaX = Math.abs(staraX - novaX);
            int deltaY = Math.abs(staraY - novaY);
            if (deltaX > deltaY) duzina = deltaX;
            else duzina = deltaY;

            for (int i = 1; i < duzina; i++) {
                if (sahovnica[staraX + i * dirX][staraY + i * dirY] != null) {
                    throw new IllegalChessMoveException("Illegal move");
                }
            }
        }*/

        if(!isMoveLegal(newPosition,figura)) throw new IllegalChessMoveException("Illegal move");

        if(!(sahovnica[novaX][novaY] instanceof King)) {
            figura.move(newPosition);
            sahovnica[novaX][novaY] = figura;
            sahovnica[staraX][staraY] = null;
        }
        else{

        }
    }

    public boolean isMoveLegal(String newPosition, ChessPiece figura) {


        String lastPosition = figura.getPosition();
        String posljednja = lastPosition.toUpperCase();
        try {
            figura.move(newPosition);
        }
        catch (IllegalChessMoveException e){
            return false;
        }
        figura.setPosition(lastPosition);

        String pozicija = newPosition.toUpperCase();
        int novaY = pozicija.charAt(0) - 17 - '0';
        int novaX = pozicija.charAt(1) - '0' - 1;
        int staraY = posljednja.charAt(0) - 17 - '0';
        int staraX = posljednja.charAt(1) - '0' - 1;

        if (sahovnica[novaX][novaY] != null && sahovnica[novaX][novaY].getColor() == figura.getColor())
            return false;

        if (!(figura instanceof Knight)) {

            int dirX = 0, dirY = 0;

            if (figura instanceof Pawn && staraY != novaY && sahovnica[novaX][novaY] == null) {
                return false;
            }

            if (novaX > staraX) dirX = 1;
            else if (novaX == staraX) dirX = 0;
            else dirX = -1;

            if (novaY > staraY) dirY = 1;
            else if (novaY == staraY) dirY = 0;
            else dirY = -1;

            int duzina = 0;
            int deltaX = Math.abs(staraX - novaX);
            int deltaY = Math.abs(staraY - novaY);
            if (deltaX > deltaY) duzina = deltaX;
            else duzina = deltaY;

            for (int i = 1; i < duzina; i++) {
                if (sahovnica[staraX + i * dirX][staraY + i * dirY] != null) {
                    return false;
                }
            }
        }
        return true;
    }


    boolean isCheck(ChessPiece.Color color) {
        ChessPiece kralj=null;

        boolean stani=false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sahovnica[i][j] != null && (sahovnica[i][j] instanceof King) && sahovnica[i][j].getColor() == color) {
                    kralj = sahovnica[i][j];
                    stani = true;
                    break;
                }

            }
            if (stani) break;
        }

        String kingPosition=kralj.getPosition();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sahovnica[i][j] != null && sahovnica[i][j].getColor() != color && isMoveLegal(kingPosition,sahovnica[i][j])){
                    return true;
                }

            }
        }
        return false;
    }
}
