import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {

    // when moves = 0, pawn can move 2 squares
    private int moves = 0;
    public static final int value = 1;

    public Pawn(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whitePawn.png"), new ImageIcon("Pieces/blackPawn.png"), value);

    }

    public Pawn(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whitePawn.png"), new ImageIcon("Pieces/BlackPawn.png"), value);
    }

    public int getValue(){

        return value;

    }

    public int getMoves(){

        return moves;

    }

    public void move(){

        moves++;

    }

}