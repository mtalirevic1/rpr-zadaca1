package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Board b = new Board();
        ChessPiece.Color boja = ChessPiece.Color.WHITE;
        int brojac = 0;
        for (; ; ) {
            try {

                if(brojac%2==0 && b.isCheck(ChessPiece.Color.WHITE)){ //Da li je check za sljedecu boju
                    System.out.print("\nCHECK!!!");
                }

                if(brojac%2!=0 && b.isCheck(ChessPiece.Color.BLACK)){
                    System.out.print("\nCHECK!!!");
                }

                if (brojac % 2 == 0) {
                    boja = ChessPiece.Color.WHITE;
                    System.out.print("\nWhite move: ");
                } else {
                    boja = ChessPiece.Color.BLACK;
                    System.out.print("\nBlack move: ");
                }


                String izbor;
                Scanner ulaz = new Scanner(System.in);
                izbor = ulaz.nextLine();
                if (izbor.equalsIgnoreCase("X")) {
                    return;
                } else if (izbor.length()==2) {
                    b.move(Pawn.class,boja,izbor);
                } else if (izbor.length()==3){
                    Class figura;
                    String tip=(izbor.charAt(0)+"");
                    if(tip.equals("K")){
                        figura=King.class;
                    }
                    else if(tip.equals("Q")){
                        figura=Queen.class;
                    }
                    else if(tip.equals("R")){
                        figura=Rook.class;
                    }
                    else if(tip.equals("B")){
                        figura=Bishop.class;
                    }
                    else if(tip.equals("N")){
                        figura=Knight.class;
                    }
                    else throw new IllegalArgumentException("Illegal argument");
                    String pozicija=izbor.substring(1);
                    b.move(figura,boja,pozicija);
                }
                else throw new IllegalArgumentException("Illegal argument");
                brojac++;
            }
            catch (IllegalChessMoveException | IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}
