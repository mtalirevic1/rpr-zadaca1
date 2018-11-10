package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Bishop b = new Bishop("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("F3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDijagonal2() {
        Bishop b = new Bishop("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> b.move("B3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Bishop b = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Bishop b = new Bishop("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("J1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("")
        );
    }

}