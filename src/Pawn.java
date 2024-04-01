import javax.swing.*;
import java.awt.*;

public class Pawn extends Piece {

    // when moves = 0, pawn can move 2 squares
    private int moves = 0;
    public final static String possMoves = "forward1";

    public Pawn(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whitePawn.png"), new ImageIcon("Pieces/blackPawn.png"));

    }

    public void move(){

        moves++;

    }

}