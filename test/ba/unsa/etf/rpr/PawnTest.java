package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @org.junit.jupiter.api.Test
    void move11() {
        Pawn p = new Pawn("A2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void move3() {
        Pawn p = new Pawn("C2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("C5")
        );
    }

    @org.junit.jupiter.api.Test
    void move22() {
        Pawn p = new Pawn("H2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> {
                    p.move("H4");
                    p.move("H6");
                }
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Pawn p = new Pawn("C2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("C1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveSide() {
        Pawn p = new Pawn("C2", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("D2")
        );
    }
}