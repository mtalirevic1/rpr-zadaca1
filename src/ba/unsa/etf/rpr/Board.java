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
}
