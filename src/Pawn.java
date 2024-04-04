import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {

    // when moves = 0, pawn can move 2 squares
    private int moves = 0;
    public static final int value = 1;

    public Pawn(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whitePawn.png"), new ImageIcon("Pieces/blackPawn.png"));

    }

    public int getValue(){

        return value;

    }

    public void move(){

        moves++;

    }

}