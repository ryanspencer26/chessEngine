import javax.swing.*;
import java.awt.*;

public class King extends Piece {

    public final static int value = -1;
    public int moves = 0;

    public King(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteKing.png"), new ImageIcon("Pieces/blackKing.png"), value);

    }

    public King(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whiteKing.png"), new ImageIcon("Pieces/BlackKing.png"), value);
    }

    public void move(){
        moves++;
    }

    public int getMoves(){
        return moves;
    }

}