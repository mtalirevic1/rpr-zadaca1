package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Queen q = new Queen("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("F3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDijagonal2() {
        Queen q = new Queen("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("B3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        King k = new King("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Queen q = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Queen q = new Queen("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("J1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Queen q = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("")
        );
    }
}