package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @org.junit.jupiter.api.Test
    void move() {
        Rook r = new Rook("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("E6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveSide() {
        Rook r = new Rook("A2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("B2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal2() {
        Rook r = new Rook("C2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> r.move("B3")
        );
    }


    @org.junit.jupiter.api.Test
    void moveBack() {
        Rook r = new Rook("C2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("C1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Rook r = new Rook("C2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> r.move("D3")
        );
    }

}