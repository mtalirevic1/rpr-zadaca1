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

        boolean stani=false;
        String prosla;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (sahovnica[i][j].getClass() == type && sahovnica[i][j].getColor() == color) {
                    try{
                        prosla=sahovnica[i][j].getPosition();
                        sahovnica[i][j].move(position);
                        sahovnica[i][j].setPosition(prosla);
                    }
                    catch (IllegalChessMoveException e){
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

        String lastPosition=figura.getPosition();
        String posljednja=lastPosition.toUpperCase();
        figura.move(position);
        figura.setPosition(lastPosition);

        String pozicija=position.toUpperCase();
        int nova0=pozicija.charAt(0)-17-'0';
        int nova1=pozicija.charAt(1)-'0';
        int stara0=posljednja.charAt(0)-17-'0';
        int stara1=posljednja.charAt(1)-'0';

        if(sahovnica[nova1][nova0]!=null && sahovnica[nova1][nova0].getColor()==color)
            throw new IllegalChessMoveException("Illegal move");

        figura.move(position);
        sahovnica[nova1][nova0]=figura;
        figura=null;
    }

    void move(String oldPosition, String newPosition) throws IllegalChessMoveException{
        String stara=oldPosition.toUpperCase();
        int stara0=stara.charAt(0)-17-'0'-1;
        int stara1=stara.charAt(1)-'0'-1;
        if(sahovnica[stara0][stara1]==null)
            throw new IllegalArgumentException("No piece on that field");
        ChessPiece figura=sahovnica[stara0][stara1];
        move(figura.getClass(),figura.getColor(),figura.getPosition());
    }

    boolean isCheck(ChessPiece.Color color){
        return false;
    }
}
